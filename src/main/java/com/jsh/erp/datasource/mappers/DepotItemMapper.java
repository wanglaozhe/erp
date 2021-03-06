package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DepotItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int countByExample(DepotItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int deleteByExample(DepotItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int insert(DepotItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int insertSelective(DepotItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    List<DepotItem> selectByExample(DepotItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    DepotItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DepotItem record, @Param("example") DepotItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DepotItem record, @Param("example") DepotItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DepotItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_depotitem
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DepotItem record);

    List<DepotItem> selectByConditionDepotItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int countsByDepotItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark);

    List<DepotItemVo4HeaderId> getHeaderIdByMaterial(
            @Param("materialParam") String materialParam,
            @Param("depotIds") String depotIds);

    List<DepotItemVo4DetailByTypeAndMId> findDetailByTypeAndMaterialIdList(
            @Param("mId") Long mId,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int findDetailByTypeAndMaterialIdCounts(
            @Param("mId") Long mId);

    List<DepotItemVo4Material> findStockNumByMaterialIdList(
            @Param("mId") Long mId,
            @Param("monthTime") String monthTime,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int findStockNumByMaterialIdCounts(
            @Param("mId") Long mId,
            @Param("monthTime") String monthTime);

    int findByTypeAndMaterialIdIn(
            @Param("mId") Long mId);

    int findByTypeAndMaterialIdOut(
            @Param("mId") Long mId);

    List<DepotItemVo4WithInfoEx> getDetailList(
            @Param("headerId") Long headerId);

    List<DepotItemVo4WithInfoEx> findByAll(
            @Param("headIds") String headIds,
            @Param("materialIds") String materialIds,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    int findByAllCount(
            @Param("headIds") String headIds,
            @Param("materialIds") String materialIds);

    Double findByTypeInIsPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findByTypeInIsNotPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findByTypeOutIsPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findByTypeOutIsNotPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);



    Double findPriceByTypeInIsPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findPriceByTypeInIsNotPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findPriceByTypeOutIsPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double findPriceByTypeOutIsNotPrev(
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime);

    Double buyOrSaleNumber(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime,
            @Param("sumType") String sumType);

    Double buyOrSalePrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("MId") Long MId,
            @Param("MonthTime") String MonthTime,
            @Param("sumType") String sumType);

    Double findGiftByTypeIn(
            @Param("subType") String subType,
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId);

    Double findGiftByTypeOut(
            @Param("subType") String subType,
            @Param("ProjectId") Integer ProjectId,
            @Param("MId") Long MId);

}