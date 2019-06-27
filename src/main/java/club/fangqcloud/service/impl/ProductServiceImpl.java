package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.ProductMapper;
import club.fangqcloud.pojo.Product;
import club.fangqcloud.pojo.ProductClass;
import club.fangqcloud.pojo.Supplier;
import club.fangqcloud.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {

    @Autowired
    ProductMapper productMapper;


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

    /*添加商品记录*/
    @Override
    public void addProduct(Product product) throws Exception {
        productMapper.addProduct(product);
    }

    /*按照查询条件分页查询商品记录*/
    @Override
    public ArrayList<Product> queryProduct(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime, int currentPage) throws Exception {
        String where = "where 1=1";
        if(null != productClassObj && productClassObj.getClassId()!= null && productClassObj.getClassId()!= 0)  where += " and t_product.productClassObj=" + productClassObj.getClassId();
        if(!productName.equals("")) where = where + " and t_product.productName like '%" + productName + "%'";
        if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_product.supplierObj=" + supplierObj.getSupplierId();
        if(!addTime.equals("")) where = where + " and t_product.addTime like '%" + addTime + "%'";
        int startIndex = (currentPage-1) * this.rows;
        return productMapper.queryProduct(where, startIndex, this.rows);
    }

    /*按照查询条件查询所有记录*/
    @Override
    public ArrayList<Product> queryProduct(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime) throws Exception  {
        String where = "where 1=1";
        if(null != productClassObj && productClassObj.getClassId()!= null && productClassObj.getClassId()!= 0)  where += " and t_product.productClassObj=" + productClassObj.getClassId();
        if(!productName.equals("")) where = where + " and t_product.productName like '%" + productName + "%'";
        if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_product.supplierObj=" + supplierObj.getSupplierId();
        if(!addTime.equals("")) where = where + " and t_product.addTime like '%" + addTime + "%'";
        return productMapper.queryProductList(where);
    }

    /*查询所有商品记录*/
    @Override
    public ArrayList<Product> queryAllProduct()  throws Exception {
        return productMapper.queryProductList("where 1=1");
    }

    /*当前查询条件下计算总的页数和记录数*/
    @Override
    public void queryTotalPageAndRecordNumber(ProductClass productClassObj, String productName, Supplier supplierObj, String addTime) throws Exception {
        String where = "where 1=1";
        if(null != productClassObj && productClassObj.getClassId()!= null && productClassObj.getClassId()!= 0)  where += " and t_product.productClassObj=" + productClassObj.getClassId();
        if(!productName.equals("")) where = where + " and t_product.productName like '%" + productName + "%'";
        if(null != supplierObj && supplierObj.getSupplierId()!= null && supplierObj.getSupplierId()!= 0)  where += " and t_product.supplierObj=" + supplierObj.getSupplierId();
        if(!addTime.equals("")) where = where + " and t_product.addTime like '%" + addTime + "%'";
        recordNumber = productMapper.queryProductCount(where);
        int mod = recordNumber % this.rows;
        totalPage = recordNumber / this.rows;
        if(mod != 0) totalPage++;
    }

    /*根据主键获取商品记录*/
    @Override
    public Product getProduct(int productId) throws Exception  {
        Product product = productMapper.getProduct(productId);
        return product;
    }

    /*更新商品记录*/
    @Override
    public void updateProduct(Product product) throws Exception {
        productMapper.updateProduct(product);
    }

    /*删除一条商品记录*/
    @Override
    public void deleteProduct(int productId) throws Exception {
        productMapper.deleteProduct(productId);
    }

    /*删除多条商品信息*/
    @Override
    public int deleteProducts(String productIds) throws Exception {
        String _productIds[] = productIds.split(",");
        for(String _productId: _productIds) {
            productMapper.deleteProduct(Integer.parseInt(_productId));
        }
        return _productIds.length;
    }

/*
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }


    @Override
    public List<Product> select(Product product){
        return productMapper.select(product);
    }
    @Override
    public int add(Product product){
        return productMapper.add(product);
    }

    @Override
    public void delete(Long goodId) {
        productMapper.delete(goodId);
    }
    @Override
    public int edit(Product product) {
        return productMapper.edit(product);
    }
*/
}
