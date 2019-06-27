package club.fangqcloud.service.impl;

import java.util.ArrayList;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import club.fangqcloud.pojo.Supplier;

import club.fangqcloud.mapper.SupplierMapper;
@Service
public class SupplierServiceImpl implements club.fangqcloud.service.SupplierService {

	@Resource SupplierMapper supplierMapper;
    /*每页显示记录数目*/
    private int rows = 10;;
    @Override
    public int getRows() {
		return rows;
	}
	@Override
    public void setRows(int rows) {
		this.rows = rows;
	}

    /*保存查询后总的页数*/
    private int totalPage;
    @Override
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    @Override
    public int getTotalPage() {
        return totalPage;
    }

    /*保存查询到的总记录数*/
    private int recordNumber;
    @Override
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    @Override
    public int getRecordNumber() {
        return recordNumber;
    }

    /*添加制造商记录*/
    @Override
    public void addSupplier(Supplier supplier) throws Exception {
    	supplierMapper.addSupplier(supplier);
    }

    /*按照查询条件分页查询制造商记录*/
    @Override
    public ArrayList<Supplier> querySupplier(String supplierName, String fddbr, String lxfs, int currentPage) throws Exception {
     	String where = "where 1=1";
    	if(!supplierName.equals("")) where = where + " and t_supplier.supplierName like '%" + supplierName + "%'";
    	if(!fddbr.equals("")) where = where + " and t_supplier.fddbr like '%" + fddbr + "%'";
    	if(!lxfs.equals("")) where = where + " and t_supplier.lxfs like '%" + lxfs + "%'";
    	int startIndex = (currentPage-1) * this.rows;
    	return supplierMapper.querySupplier(where, startIndex, this.rows);
    }

    /*按照查询条件查询所有记录*/
    @Override
    public ArrayList<Supplier> querySupplier(String supplierName, String fddbr, String lxfs) throws Exception  {
     	String where = "where 1=1";
    	if(!supplierName.equals("")) where = where + " and t_supplier.supplierName like '%" + supplierName + "%'";
    	if(!fddbr.equals("")) where = where + " and t_supplier.fddbr like '%" + fddbr + "%'";
    	if(!lxfs.equals("")) where = where + " and t_supplier.lxfs like '%" + lxfs + "%'";
    	return supplierMapper.querySupplierList(where);
    }

    /*查询所有制造商记录*/
    @Override
    public ArrayList<Supplier> queryAllSupplier()  throws Exception {
        return supplierMapper.querySupplierList("where 1=1");
    }

    /*当前查询条件下计算总的页数和记录数*/
    @Override
    public void queryTotalPageAndRecordNumber(String supplierName, String fddbr, String lxfs) throws Exception {
     	String where = "where 1=1";
    	if(!supplierName.equals("")) where = where + " and t_supplier.supplierName like '%" + supplierName + "%'";
    	if(!fddbr.equals("")) where = where + " and t_supplier.fddbr like '%" + fddbr + "%'";
    	if(!lxfs.equals("")) where = where + " and t_supplier.lxfs like '%" + lxfs + "%'";
        recordNumber = supplierMapper.querySupplierCount(where);
        int mod = recordNumber % this.rows;
        totalPage = recordNumber / this.rows;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取制造商记录*/
    @Override
    public Supplier getSupplier(int supplierId) throws Exception  {
        Supplier supplier = supplierMapper.getSupplier(supplierId);
        return supplier;
    }

    /*更新制造商记录*/
    @Override
    public void updateSupplier(Supplier supplier) throws Exception {
        supplierMapper.updateSupplier(supplier);
    }

    /*删除一条制造商记录*/
    @Override
    public void deleteSupplier(int supplierId) throws Exception {
        supplierMapper.deleteSupplier(supplierId);
    }

    /*删除多条制造商信息*/
    @Override
    public int deleteSuppliers(String supplierIds) throws Exception {
    	String _supplierIds[] = supplierIds.split(",");
    	for(String _supplierId: _supplierIds) {
    		supplierMapper.deleteSupplier(Integer.parseInt(_supplierId));
    	}
    	return _supplierIds.length;
    }
}
