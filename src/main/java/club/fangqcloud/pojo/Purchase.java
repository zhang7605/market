package club.fangqcloud.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
    /*进货id*/
    private Integer purchaseId;
    public Integer getPurchaseId(){
        return purchaseId;
    }
    public void setPurchaseId(Integer purchaseId){
        this.purchaseId = purchaseId;
    }

    /*进货商品*/
    private Product productObj;
    public Product getProductObj() {
        return productObj;
    }
    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }

    /*进货单价*/
    @NotNull(message="必须输入进货单价")
    private Float price;
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    /*进货数量*/
    @NotNull(message="必须输入进货数量")
    private Integer purchaseNum;
    public Integer getPurchaseNum() {
        return purchaseNum;
    }
    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    /*进货日期*/
    @NotEmpty(message="进货日期不能为空")
    private String purchaseDate;
    public String getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /*供应商*/
    private Supplier supplierObj;
    public Supplier getSupplierObj() {
        return supplierObj;
    }
    public void setSupplierObj(Supplier supplierObj) {
        this.supplierObj = supplierObj;
    }

    /*进货备注*/
    private String memo;
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

    public JSONObject getJsonObject() throws JSONException {
    	JSONObject jsonPurchase=new JSONObject(); 
		jsonPurchase.accumulate("purchaseId", this.getPurchaseId());
		jsonPurchase.accumulate("productObj", this.getProductObj().getProductName());
		jsonPurchase.accumulate("productObjPri", this.getProductObj().getProductId());
		jsonPurchase.accumulate("price", this.getPrice());
		jsonPurchase.accumulate("purchaseNum", this.getPurchaseNum());
		jsonPurchase.accumulate("purchaseDate", this.getPurchaseDate().length()>19?this.getPurchaseDate().substring(0,19):this.getPurchaseDate());
		jsonPurchase.accumulate("supplierObj", this.getSupplierObj().getSupplierName());
		jsonPurchase.accumulate("supplierObjPri", this.getSupplierObj().getSupplierId());
		jsonPurchase.accumulate("memo", this.getMemo());
		return jsonPurchase;
    }}