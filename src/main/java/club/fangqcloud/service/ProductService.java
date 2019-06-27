package club.fangqcloud.service;

import club.fangqcloud.pojo.Product;
import club.fangqcloud.pojo.ProductClass;
import club.fangqcloud.pojo.Supplier;

import java.util.ArrayList;

public interface ProductService {
    int getRows();

    void setRows(int rows);

    void setTotalPage(int totalPage);

    int getTotalPage();

    void setRecordNumber(int recordNumber);

    int getRecordNumber();

    /*添加商品记录*/
    void addProduct(Product product) throws Exception;

    /*按照查询条件分页查询商品记录*/
    ArrayList<Product> queryProduct(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime, int currentPage) throws Exception;

    /*按照查询条件查询所有记录*/
    ArrayList<Product> queryProduct(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime) throws Exception;

    /*查询所有商品记录*/
    ArrayList<Product> queryAllProduct()  throws Exception;

    /*当前查询条件下计算总的页数和记录数*/
    void queryTotalPageAndRecordNumber(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime) throws Exception;

    /*根据主键获取商品记录*/
    Product getProduct(int productId) throws Exception;

    /*更新商品记录*/
    void updateProduct(Product product) throws Exception;

    /*删除一条商品记录*/
    void deleteProduct(int productId) throws Exception;

    /*删除多条商品信息*/
    int deleteProducts(String productIds) throws Exception;
}
