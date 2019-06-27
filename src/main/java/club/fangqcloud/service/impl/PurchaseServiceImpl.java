package club.fangqcloud.service.impl;

import java.util.ArrayList;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import club.fangqcloud.pojo.Product;
import club.fangqcloud.pojo.Supplier;
import club.fangqcloud.pojo.Purchase;

import club.fangqcloud.mapper.PurchaseMapper;
@Service
public class PurchaseServiceImpl implements club.fangqcloud.service.PurchaseService {

	@Resource PurchaseMapper purchaseMapper;
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

    /*添加进货记录*/
    @Override
    public void addPurchase(Purchase purchase) throws Exception {
    	purchaseMapper.addPurchase(purchase);
    }

    /*按照查询条件分页查询进货记录*/
    @Override
    public ArrayList<Purchase> queryPurchase(Product productObj, String purchaseDate, Supplier supplierObj, int currentPage) throws Exception {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_purchase.productObj=" + productObj.getProductId();
    	if(!purchaseDate.equals("")) where = where + " and t_purchase.purchaseDate like '%" + purchaseDate + "%'";
    	if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_purchase.supplierObj=" + supplierObj.getSupplierId();
    	int startIndex = (currentPage-1) * this.rows;
    	return purchaseMapper.queryPurchase(where, startIndex, this.rows);
    }

    /*按照查询条件查询所有记录*/
    @Override
    public ArrayList<Purchase> queryPurchase(Product productObj, String purchaseDate, Supplier supplierObj) throws Exception  {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_purchase.productObj=" + productObj.getProductId();
    	if(!purchaseDate.equals("")) where = where + " and t_purchase.purchaseDate like '%" + purchaseDate + "%'";
    	if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_purchase.supplierObj=" + supplierObj.getSupplierId();
    	return purchaseMapper.queryPurchaseList(where);
    }

    /*查询所有进货记录*/
    @Override
    public ArrayList<Purchase> queryAllPurchase()  throws Exception {
        return purchaseMapper.queryPurchaseList("where 1=1");
    }

    /*当前查询条件下计算总的页数和记录数*/
    @Override
    public void queryTotalPageAndRecordNumber(Product productObj, String purchaseDate, Supplier supplierObj) throws Exception {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_purchase.productObj=" + productObj.getProductId();
    	if(!purchaseDate.equals("")) where = where + " and t_purchase.purchaseDate like '%" + purchaseDate + "%'";
    	if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_purchase.supplierObj=" + supplierObj.getSupplierId();
        recordNumber = purchaseMapper.queryPurchaseCount(where);
        int mod = recordNumber % this.rows;
        totalPage = recordNumber / this.rows;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取进货记录*/
    @Override
    public Purchase getPurchase(int purchaseId) throws Exception  {
        Purchase purchase = purchaseMapper.getPurchase(purchaseId);
        return purchase;
    }

    /*更新进货记录*/
    @Override
    public void updatePurchase(Purchase purchase) throws Exception {
        purchaseMapper.updatePurchase(purchase);
    }

    /*删除一条进货记录*/
    @Override
    public void deletePurchase(int purchaseId) throws Exception {
        purchaseMapper.deletePurchase(purchaseId);
    }

    /*删除多条进货信息*/
    @Override
    public int deletePurchases(String purchaseIds) throws Exception {
    	String _purchaseIds[] = purchaseIds.split(",");
    	for(String _purchaseId: _purchaseIds) {
    		purchaseMapper.deletePurchase(Integer.parseInt(_purchaseId));
    	}
    	return _purchaseIds.length;
    }
}
