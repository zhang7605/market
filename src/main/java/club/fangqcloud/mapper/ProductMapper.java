package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductMapper {
    /*添加商品信息*/
    void addProduct(Product product) throws Exception;

    /*按照查询条件分页查询商品记录*/
    ArrayList<Product> queryProduct(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

    /*按照查询条件查询所有商品记录*/
    ArrayList<Product> queryProductList(@Param("where") String where) throws Exception;

    /*按照查询条件的商品记录数*/
    int queryProductCount(@Param("where") String where) throws Exception;

    /*根据主键查询某条商品记录*/
    Product getProduct(int productId) throws Exception;

    /*更新商品记录*/
    void updateProduct(Product product) throws Exception;

    /*删除商品记录*/
    void deleteProduct(int productId) throws Exception;
}
