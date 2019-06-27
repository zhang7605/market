package club.fangqcloud.pojo;

import org.json.JSONException;
import org.json.JSONObject;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {


    private java.sql.Timestamp createTimestamp;
    private java.sql.Timestamp changeTimestamp;

    /*商品id*/
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /*商品类别*/
    private ProductClass productClassObj;

    public ProductClass getProductClassObj() {
        return productClassObj;
    }

    public void setProductClassObj(ProductClass productClassObj) {
        this.productClassObj = productClassObj;
    }

    /*商品名称*/
    @NotEmpty(message = "商品名称不能为空")
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /*商品主图*/
    private String mainPhoto;

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    /*商品价格*/
    @NotNull(message = "必须输入商品价格")
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    /*商品库存*/
    @NotNull(message = "必须输入商品库存")
    private Integer productNum;

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /*商品描述*/
    @NotEmpty(message = "商品描述不能为空")
    private String productDesc;

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    /*供应商*/
    private Supplier supplierObj;

    public Supplier getSupplierObj() {
        return supplierObj;
    }

    public void setSupplierObj(Supplier supplierObj) {
        this.supplierObj = supplierObj;
    }

    /*发布时间*/
    private String addTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonProduct = new JSONObject();
        jsonProduct.accumulate("productId", this.getProductId());
        jsonProduct.accumulate("productClassObj", this.getProductClassObj().getClassName());
        jsonProduct.accumulate("productClassObjPri", this.getProductClassObj().getClassId());
        jsonProduct.accumulate("productName", this.getProductName());
        jsonProduct.accumulate("mainPhoto", this.getMainPhoto());
        jsonProduct.accumulate("price", this.getPrice());
        jsonProduct.accumulate("productNum", this.getProductNum());
        jsonProduct.accumulate("productDesc", this.getProductDesc());
        jsonProduct.accumulate("supplierObj", this.getSupplierObj().getSupplierName());
        jsonProduct.accumulate("supplierObjPri", this.getSupplierObj().getSupplierId());
        jsonProduct.accumulate("addTime", this.getAddTime().length() > 19 ? this.getAddTime().substring(0, 19) : this.getAddTime());
        return jsonProduct;
    }


    public java.sql.Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(java.sql.Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }


    public java.sql.Timestamp getChangeTimestamp() {
        return changeTimestamp;
    }

    public void setChangeTimestamp(java.sql.Timestamp changeTimestamp) {
        this.changeTimestamp = changeTimestamp;
    }

}
