package club.fangqcloud.service;

import club.fangqcloud.pojo.ProductClass;

import java.util.ArrayList;

public interface ProductClassService {
    int getRows();

    void setRows(int rows);

    void setTotalPage(int totalPage);

    int getTotalPage();

    void setRecordNumber(int recordNumber);

    int getRecordNumber();

    /*添加商品类别记录*/
    void addProductClass(ProductClass productClass) throws Exception;

    /*按照查询条件分页查询商品类别记录*/
    ArrayList<ProductClass> queryProductClass(int currentPage) throws Exception;

    /*按照查询条件查询所有记录*/
    ArrayList<ProductClass> queryProductClass() throws Exception;

    /*查询所有商品类别记录*/
    ArrayList<ProductClass> queryAllProductClass()  throws Exception;

    /*当前查询条件下计算总的页数和记录数*/
    void queryTotalPageAndRecordNumber() throws Exception;

    /*根据主键获取商品类别记录*/
    ProductClass getProductClass(int classId) throws Exception;

    /*更新商品类别记录*/
    void updateProductClass(ProductClass productClass) throws Exception;

    /*删除一条商品类别记录*/
    void deleteProductClass(int classId) throws Exception;

    /*删除多条商品类别信息*/
    int deleteProductClasss(String classIds) throws Exception;
}
