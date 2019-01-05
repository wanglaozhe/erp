package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.App;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.entities.UserBusiness;
import com.jsh.erp.service.app.AppService;
import com.jsh.erp.service.userBusiness.UserBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ji_sheng_hua 752*718*920
 */
@RestController
@RequestMapping(value = "/app")
public class AppController {
    private Logger logger = LoggerFactory.getLogger(AppController.class);

    @Resource
    private AppService appService;

    @Resource
    private UserBusinessService userBusinessService;

    @GetMapping(value = "/findDesk")
    public JSONObject findDesk(HttpServletRequest request) {
        JSONObject obj = new JSONObject();
        List<App> dockList = appService.findDock();
        JSONArray dockArray = new JSONArray();
        if (null != dockList) {
            for (App app : dockList) {
                JSONObject item = new JSONObject();
                item.put("id", app.getId());
                item.put("title", app.getName());
                item.put("type", app.getType());
                item.put("icon", "../../upload/images/deskIcon/" + app.getIcon());
                item.put("url", app.getUrl());
                item.put("width", app.getWidth());
                item.put("height", app.getHeight());
                item.put("isresize", app.getResize());
                item.put("isopenmax", app.getOpenmax());
                item.put("isflash", app.getFlash());
                dockArray.add(item);
            }
        }
        obj.put("dock",dockArray);
        User user = (User) request.getSession().getAttribute("user");
        //获取角色
        List<UserBusiness> list = userBusinessService.getBasicData(String.valueOf(user.getId()), "UserRole");
        //获取角色的app
        UserBusiness roleApp = null;
        if(list != null && list.size() > 0){
            String values = list.get(0).getValue();
            if(!StringUtils.isEmpty(values)){
                List<UserBusiness> roleApps = userBusinessService.getBasicData(values.replace("[", "").replace("]", ""), "RoleAPP");
                if(roleApps != null && roleApps.size() > 0){
                    roleApp = roleApps.get(0);
                }
            }

        }
        
        List<App> deskList = appService.findDesk();
        JSONArray deskArray = new JSONArray();
        List<String> appsList;
        if (null != deskList) {
            if(!StringUtils.isEmpty(roleApp)){
                String value = roleApp.getValue();
                String values = value.substring(1,value.length() - 1);
                String[] apps = values.split("]\\[");
                appsList = Arrays.asList(apps);
            }else{
                appsList = new ArrayList<>();
            }
            for (App app : deskList) {
                if(!appsList.contains(String.valueOf(app.getId()))){
                    continue;
                }
                JSONObject item = new JSONObject();
                item.put("id", app.getId());
                item.put("title", app.getName());
                item.put("type", app.getType());
                item.put("icon", "../../upload/images/deskIcon/" + app.getIcon());
                item.put("url", "../../pages/common/menu.html?appID=" + app.getNumber() + "&id=" + app.getId());
                item.put("width", app.getWidth());
                item.put("height", app.getHeight());
                item.put("isresize", app.getResize());
                item.put("isopenmax", app.getOpenmax());
                item.put("isflash", app.getFlash());
                deskArray.add(item);
            }
        }
        obj.put("desk",deskArray);
        return obj;
    }

    /**
     * 角色对应应用显示
     * @param request
     * @return
     */
    @PostMapping(value = "/findRoleAPP")
    public JSONArray findRoleAPP(@RequestParam("UBType") String type, @RequestParam("UBKeyId") String keyId,
                                  HttpServletRequest request) {
        JSONArray arr = new JSONArray();
        try {
            List<App> dataList = appService.findRoleAPP();
            //开始拼接json数据
            JSONObject outer = new JSONObject();
            outer.put("id", 1);
            outer.put("text", "应用列表");
            outer.put("state", "open");
            //存放数据json数组
            JSONArray dataArray = new JSONArray();
            if (null != dataList) {
                for (App app : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("id", app.getId());
                    item.put("text", app.getName());
                    //勾选判断1
                    Boolean flag = false;
                    try {
                        flag = userBusinessService.checkIsUserBusinessExist(type, keyId, "[" + app.getId().toString() + "]");
                    } catch (Exception e) {
                        logger.error(">>>>>>>>>>>>>>>>>设置角色对应的应用：类型" + type + " KeyId为： " + keyId + " 存在异常！");
                    }
                    if (flag == true) {
                        item.put("checked", true);
                    }
                    //结束
                    dataArray.add(item);
                }
            }
            outer.put("children", dataArray);
            arr.add(outer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}
