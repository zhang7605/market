package club.fangqcloud.service;

import club.fangqcloud.pojo.Product;
import club.fangqcloud.pojo.Sell;

import java.util.ArrayList;

public interface SellService {
    int getRows();

    void setRows(int rows);

    void setTotalPage(int totalPage);

    int getTotalPage();

    void setRecordNumber(int recordNumber);

    int getRecordNumber();

    /*添加销售记录*/
    void addSell(Sell sell) throws Exception;

    /*按照查询条件分页查询销售记录*/
    ArrayList<Sell> querySell(Product productObj, /*Customer customerObj,*/ String sellDate, String payWay, String logistics, String wayNumber, int currentPage) throws Exception;

    /*按照查询条件查询所有记录*/
    ArrayList<Sell> querySell(Product productObj,/* Customer customerObj,*/ String sellDate, String payWay, String logistics, String wayNumber) throws Exception;

    /*查询所有销售记录*/
    ArrayList<Sell> queryAllSell()  throws Exception;

    /*当前查询条件下计算总的页数和记录数*/
    void queryTotalPageAndRecordNumber(Product productObj, /*Customer customerObj,*/ String sellDate, String payWay, String logistics, String wayNumber) throws Exception;

    /*根据主键获取销售记录*/
    Sell getSell(int sellId) throws Exception;

    /*更新销售记录*/
    void updateSell(Sell sell) throws Exception;

    /*删除一条销售记录*/
    void deleteSell(int sellId) throws Exception;

    /*删除多条销售信息*/
    int deleteSells(String sellIds) throws Exception;
}
