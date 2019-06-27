package club.fangqcloud.service.impl;

import java.util.ArrayList;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import club.fangqcloud.pojo.Product;
//import club.fangqcloud.pojo.Customer;
import club.fangqcloud.pojo.Sell;

import club.fangqcloud.mapper.SellMapper;
@Service
public class SellServiceImpl implements club.fangqcloud.service.SellService {

	@Resource SellMapper sellMapper;
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

    /*添加销售记录*/
    @Override
    public void addSell(Sell sell) throws Exception {
    	sellMapper.addSell(sell);
    }

    /*按照查询条件分页查询销售记录*/
    @Override
    public ArrayList<Sell> querySell(Product productObj,/* Customer customerObj, */String sellDate, String payWay, String logistics, String wayNumber, int currentPage) throws Exception {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_sell.productObj=" + productObj.getProductId();
    //	if(null != customerObj && customerObj.getCustomerId()!= null && customerObj.getCustomerId()!= 0)  where += " and t_sell.customerObj=" + customerObj.getCustomerId();
    	if(!sellDate.equals("")) where = where + " and t_sell.sellDate like '%" + sellDate + "%'";
    	if(!payWay.equals("")) where = where + " and t_sell.payWay like '%" + payWay + "%'";
    	if(!logistics.equals("")) where = where + " and t_sell.logistics like '%" + logistics + "%'";
    	if(!wayNumber.equals("")) where = where + " and t_sell.wayNumber like '%" + wayNumber + "%'";
    	int startIndex = (currentPage-1) * this.rows;
    	return sellMapper.querySell(where, startIndex, this.rows);
    }

    /*按照查询条件查询所有记录*/
    @Override
    public ArrayList<Sell> querySell(Product productObj, /*Customer customerObj,*/ String sellDate, String payWay, String logistics, String wayNumber) throws Exception  {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_sell.productObj=" + productObj.getProductId();
    //	if(null != customerObj && customerObj.getCustomerId()!= null && customerObj.getCustomerId()!= 0)  where += " and t_sell.customerObj=" + customerObj.getCustomerId();
    	if(!sellDate.equals("")) where = where + " and t_sell.sellDate like '%" + sellDate + "%'";
    	if(!payWay.equals("")) where = where + " and t_sell.payWay like '%" + payWay + "%'";
    	if(!logistics.equals("")) where = where + " and t_sell.logistics like '%" + logistics + "%'";
    	if(!wayNumber.equals("")) where = where + " and t_sell.wayNumber like '%" + wayNumber + "%'";
    	return sellMapper.querySellList(where);
    }

    /*查询所有销售记录*/
    @Override
    public ArrayList<Sell> queryAllSell()  throws Exception {
        return sellMapper.querySellList("where 1=1");
    }

    /*当前查询条件下计算总的页数和记录数*/
    @Override
    public void queryTotalPageAndRecordNumber(Product productObj,/* Customer customerObj, */String sellDate, String payWay, String logistics, String wayNumber) throws Exception {
     	String where = "where 1=1";
    	if(null != productObj && productObj.getProductId()!= null && productObj.getProductId()!= 0)  where += " and t_sell.productObj=" + productObj.getProductId();
    //	if(null != customerObj && customerObj.getCustomerId()!= null && customerObj.getCustomerId()!= 0)  where += " and t_sell.customerObj=" + customerObj.getCustomerId();
    	if(!sellDate.equals("")) where = where + " and t_sell.sellDate like '%" + sellDate + "%'";
    	if(!payWay.equals("")) where = where + " and t_sell.payWay like '%" + payWay + "%'";
    	if(!logistics.equals("")) where = where + " and t_sell.logistics like '%" + logistics + "%'";
    	if(!wayNumber.equals("")) where = where + " and t_sell.wayNumber like '%" + wayNumber + "%'";
        recordNumber = sellMapper.querySellCount(where);
        int mod = recordNumber % this.rows;
        totalPage = recordNumber / this.rows;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取销售记录*/
    @Override
    public Sell getSell(int sellId) throws Exception  {
        Sell sell = sellMapper.getSell(sellId);
        return sell;
    }

    /*更新销售记录*/
    @Override
    public void updateSell(Sell sell) throws Exception {
        sellMapper.updateSell(sell);
    }

    /*删除一条销售记录*/
    @Override
    public void deleteSell(int sellId) throws Exception {
        sellMapper.deleteSell(sellId);
    }

    /*删除多条销售信息*/
    @Override
    public int deleteSells(String sellIds) throws Exception {
    	String _sellIds[] = sellIds.split(",");
    	for(String _sellId: _sellIds) {
    		sellMapper.deleteSell(Integer.parseInt(_sellId));
    	}
    	return _sellIds.length;
    }
}
