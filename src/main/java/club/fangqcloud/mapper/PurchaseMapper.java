package club.fangqcloud.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import club.fangqcloud.pojo.Purchase;

public interface PurchaseMapper {
	/*添加进货信息*/
	void addPurchase(Purchase purchase) throws Exception;

	/*按照查询条件分页查询进货记录*/
	ArrayList<Purchase> queryPurchase(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有进货记录*/
	ArrayList<Purchase> queryPurchaseList(@Param("where") String where) throws Exception;

	/*按照查询条件的进货记录数*/
	int queryPurchaseCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条进货记录*/
	Purchase getPurchase(int purchaseId) throws Exception;

	/*更新进货记录*/
	void updatePurchase(Purchase purchase) throws Exception;

	/*删除进货记录*/
	void deletePurchase(int purchaseId) throws Exception;

}
