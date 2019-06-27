package club.fangqcloud.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import club.fangqcloud.pojo.ProductClass;

public interface ProductClassMapper {
	/*添加商品类别信息*/
	void addProductClass(ProductClass productClass) throws Exception;

	/*按照查询条件分页查询商品类别记录*/
	ArrayList<ProductClass> queryProductClass(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有商品类别记录*/
	ArrayList<ProductClass> queryProductClassList(@Param("where") String where) throws Exception;

	/*按照查询条件的商品类别记录数*/
	int queryProductClassCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条商品类别记录*/
	ProductClass getProductClass(int classId) throws Exception;

	/*更新商品类别记录*/
	void updateProductClass(ProductClass productClass) throws Exception;

	/*删除商品类别记录*/
	void deleteProductClass(int classId) throws Exception;

}
