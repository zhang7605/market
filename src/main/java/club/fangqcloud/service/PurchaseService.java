package club.fangqcloud.service;

import club.fangqcloud.pojo.Product;
import club.fangqcloud.pojo.Purchase;
import club.fangqcloud.pojo.Supplier;

import java.util.ArrayList;

public interface PurchaseService {
    int getRows();

    void setRows(int rows);

    void setTotalPage(int totalPage);

    int getTotalPage();

    void setRecordNumber(int recordNumber);

    int getRecordNumber();

    /*添加进货记录*/
    void addPurchase(Purchase purchase) throws Exception;

    /*按照查询条件分页查询进货记录*/
    ArrayList<Purchase> queryPurchase(Product productObj, String purchaseDate, Supplier supplierObj, int currentPage) throws Exception;

    /*按照查询条件查询所有记录*/
    ArrayList<Purchase> queryPurchase(Product productObj, String purchaseDate, Supplier supplierObj) throws Exception;

    /*查询所有进货记录*/
    ArrayList<Purchase> queryAllPurchase()  throws Exception;

    /*当前查询条件下计算总的页数和记录数*/
    void queryTotalPageAndRecordNumber(Product productObj, String purchaseDate, Supplier supplierObj) throws Exception;

    /*根据主键获取进货记录*/
    Purchase getPurchase(int purchaseId) throws Exception;

    /*更新进货记录*/
    void updatePurchase(Purchase purchase) throws Exception;

    /*删除一条进货记录*/
    void deletePurchase(int purchaseId) throws Exception;

    /*删除多条进货信息*/
    int deletePurchases(String purchaseIds) throws Exception;
}
