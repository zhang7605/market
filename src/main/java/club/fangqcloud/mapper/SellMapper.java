package club.fangqcloud.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import club.fangqcloud.pojo.Sell;

public interface SellMapper {
	/*添加销售信息*/
	void addSell(Sell sell) throws Exception;

	/*按照查询条件分页查询销售记录*/
	ArrayList<Sell> querySell(@Param("where") String where, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize) throws Exception;

	/*按照查询条件查询所有销售记录*/
	ArrayList<Sell> querySellList(@Param("where") String where) throws Exception;

	/*按照查询条件的销售记录数*/
	int querySellCount(@Param("where") String where) throws Exception; 

	/*根据主键查询某条销售记录*/
	Sell getSell(int sellId) throws Exception;

	/*更新销售记录*/
	void updateSell(Sell sell) throws Exception;

	/*删除销售记录*/
	void deleteSell(int sellId) throws Exception;

}
