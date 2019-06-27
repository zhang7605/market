package club.fangqcloud.service.impl;

import java.util.ArrayList;
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import club.fangqcloud.pojo.ProductClass;

import club.fangqcloud.mapper.ProductClassMapper;
@Service
public class ProductClassServiceImpl implements club.fangqcloud.service.ProductClassService {

	@Resource ProductClassMapper productClassMapper;
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

    /*添加商品类别记录*/
    @Override
    public void addProductClass(ProductClass productClass) throws Exception {
    	productClassMapper.addProductClass(productClass);
    }

    /*按照查询条件分页查询商品类别记录*/
    @Override
    public ArrayList<ProductClass> queryProductClass(int currentPage) throws Exception {
     	String where = "where 1=1";
    	int startIndex = (currentPage-1) * this.rows;
    	return productClassMapper.queryProductClass(where, startIndex, this.rows);
    }

    /*按照查询条件查询所有记录*/
    @Override
    public ArrayList<ProductClass> queryProductClass() throws Exception  {
     	String where = "where 1=1";
    	return productClassMapper.queryProductClassList(where);
    }

    /*查询所有商品类别记录*/
    @Override
    public ArrayList<ProductClass> queryAllProductClass()  throws Exception {
        return productClassMapper.queryProductClassList("where 1=1");
    }

    /*当前查询条件下计算总的页数和记录数*/
    @Override
    public void queryTotalPageAndRecordNumber() throws Exception {
     	String where = "where 1=1";
        recordNumber = productClassMapper.queryProductClassCount(where);
        int mod = recordNumber % this.rows;
        totalPage = recordNumber / this.rows;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取商品类别记录*/
    @Override
    public ProductClass getProductClass(int classId) throws Exception  {
        ProductClass productClass = productClassMapper.getProductClass(classId);
        return productClass;
    }

    /*更新商品类别记录*/
    @Override
    public void updateProductClass(ProductClass productClass) throws Exception {
        productClassMapper.updateProductClass(productClass);
    }

    /*删除一条商品类别记录*/
    @Override
    public void deleteProductClass(int classId) throws Exception {
        productClassMapper.deleteProductClass(classId);
    }

    /*删除多条商品类别信息*/
    @Override
    public int deleteProductClasss(String classIds) throws Exception {
    	String _classIds[] = classIds.split(",");
    	for(String _classId: _classIds) {
    		productClassMapper.deleteProductClass(Integer.parseInt(_classId));
    	}
    	return _classIds.length;
    }
}
