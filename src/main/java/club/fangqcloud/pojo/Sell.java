package club.fangqcloud.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.json.JSONException;
import org.json.JSONObject;

public class Sell {
    /*销售id*/
    private Integer sellId;
    public Integer getSellId(){
        return sellId;
    }
    public void setSellId(Integer sellId){
        this.sellId = sellId;
    }

    /*销售产品*/
    private Product productObj;
    public Product getProductObj() {
        return productObj;
    }
    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }

    /*销售客户*/
    /*
    private Customer customerObj;
    public Customer getCustomerObj() {
        return customerObj;
    }
    public void setCustomerObj(Customer customerObj) {
        this.customerObj = customerObj;
    }
    */
    /*销售单价*/
    @NotNull(message="必须输入销售单价")
    private Float price;
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    /*销售数量*/
    @NotNull(message="必须输入销售数量")
    private Integer sellCount;
    public Integer getSellCount() {
        return sellCount;
    }
    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    /*销售日期*/
    @NotEmpty(message="销售日期不能为空")
    private String sellDate;
    public String getSellDate() {
        return sellDate;
    }
    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    /*支付方式*/
    @NotEmpty(message="支付方式不能为空")
    private String payWay;
    public String getPayWay() {
        return payWay;
    }
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    /*物流公司*/
    @NotEmpty(message="物流公司不能为空")
    private String logistics;
    public String getLogistics() {
        return logistics;
    }
    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    /*运单号*/
    @NotEmpty(message="运单号不能为空")
    private String wayNumber;
    public String getWayNumber() {
        return wayNumber;
    }
    public void setWayNumber(String wayNumber) {
        this.wayNumber = wayNumber;
    }

    /*销售备注*/
    private String sellMemo;
    public String getSellMemo() {
        return sellMemo;
    }
    public void setSellMemo(String sellMemo) {
        this.sellMemo = sellMemo;
    }

    public JSONObject getJsonObject() throws JSONException {
    	JSONObject jsonSell=new JSONObject(); 
		jsonSell.accumulate("sellId", this.getSellId());
		jsonSell.accumulate("productObj", this.getProductObj().getProductName());
		jsonSell.accumulate("productObjPri", this.getProductObj().getProductId());
		/*jsonSell.accumulate("customerObj", this.getCustomerObj().getCustomerName());
		jsonSell.accumulate("customerObjPri", this.getCustomerObj().getCustomerId());*/
		jsonSell.accumulate("price", this.getPrice());
		jsonSell.accumulate("sellCount", this.getSellCount());
		jsonSell.accumulate("sellDate", this.getSellDate().length()>19?this.getSellDate().substring(0,19):this.getSellDate());
		jsonSell.accumulate("payWay", this.getPayWay());
		jsonSell.accumulate("logistics", this.getLogistics());
		jsonSell.accumulate("wayNumber", this.getWayNumber());
		jsonSell.accumulate("sellMemo", this.getSellMemo());
		return jsonSell;
    }}