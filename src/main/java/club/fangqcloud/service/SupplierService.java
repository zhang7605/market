package club.fangqcloud.service;

import club.fangqcloud.pojo.Supplier;

import java.util.ArrayList;

public interface SupplierService {
    int getRows();

    void setRows(int rows);

    void setTotalPage(int totalPage);

    int getTotalPage();

    void setRecordNumber(int recordNumber);

    int getRecordNumber();

    /*添加制造商记录*/
    void addSupplier(Supplier supplier) throws Exception;

    /*按照查询条件分页查询制造商记录*/
    ArrayList<Supplier> querySupplier(String supplierName, String fddbr, String lxfs, int currentPage) throws Exception;

    /*按照查询条件查询所有记录*/
    ArrayList<Supplier> querySupplier(String supplierName, String fddbr, String lxfs) throws Exception;

    /*查询所有制造商记录*/
    ArrayList<Supplier> queryAllSupplier()  throws Exception;

    /*当前查询条件下计算总的页数和记录数*/
    void queryTotalPageAndRecordNumber(String supplierName, String fddbr, String lxfs) throws Exception;

    /*根据主键获取制造商记录*/
    Supplier getSupplier(int supplierId) throws Exception;

    /*更新制造商记录*/
    void updateSupplier(Supplier supplier) throws Exception;

    /*删除一条制造商记录*/
    void deleteSupplier(int supplierId) throws Exception;

    /*删除多条制造商信息*/
    int deleteSuppliers(String supplierIds) throws Exception;
}
