package com.jsh.erp.datasource.entities;

import java.util.Date;

public class AccountHeadVo4ListEx {

    private Long id;

    private String type;

    private Long organid;

    private Long handspersonid;

    private Double changeamount;

    private Double totalprice;

    private Long accountid;

    private String billno;

    private Date billtime;

    private String remark;

    private String organname;

    private String handspersonname;

    private String accountname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getOrganid() {
        return organid;
    }

    public void setOrganid(Long organid) {
        this.organid = organid;
    }

    public Long getHandspersonid() {
        return handspersonid;
    }

    public void setHandspersonid(Long handspersonid) {
        this.handspersonid = handspersonid;
    }

    public Double getChangeamount() {
        return changeamount;
    }

    public void setChangeamount(Double changeamount) {
        this.changeamount = changeamount;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getHandspersonname() {
        return handspersonname;
    }

    public void setHandspersonname(String handspersonname) {
        this.handspersonname = handspersonname;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
}