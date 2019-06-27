package club.fangqcloud.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import club.fangqcloud.pojo.Supplier;

public interface SupplierMapper {
	/*添加制造商信息*/
	void addSupplier(Supplier supplier) throws Exception;

	/*按照查询条件分页查询制造商记录*/
	ArrayList<Supplier> querySupplier(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有制造商记录*/
	ArrayList<Supplier> querySupplierList(@Param("where") String where) throws Exception;

	/*按照查询条件的制造商记录数*/
	int querySupplierCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条制造商记录*/
	Supplier getSupplier(int supplierId) throws Exception;

	/*更新制造商记录*/
	void updateSupplier(Supplier supplier) throws Exception;

	/*删除制造商记录*/
	void deleteSupplier(int supplierId) throws Exception;

}
