package club.fangqcloud.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import org.json.JSONException;
import org.json.JSONObject;

public class Supplier {
    /*记录id*/
    private Integer supplierId;
    public Integer getSupplierId(){
        return supplierId;
    }
    public void setSupplierId(Integer supplierId){
        this.supplierId = supplierId;
    }

    /*单位全称*/
    @NotEmpty(message="单位全称不能为空")
    private String supplierName;
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /*法定代表人*/
    @NotEmpty(message="法定代表人不能为空")
    private String fddbr;
    public String getFddbr() {
        return fddbr;
    }
    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    /*联系方式*/
    @NotEmpty(message="联系方式不能为空")
    private String lxfs;
    public String getLxfs() {
        return lxfs;
    }
    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    /*单位地址*/
    @NotEmpty(message="单位地址不能为空")
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public JSONObject getJsonObject() throws JSONException {
    	JSONObject jsonSupplier=new JSONObject(); 
		jsonSupplier.accumulate("supplierId", this.getSupplierId());
		jsonSupplier.accumulate("supplierName", this.getSupplierName());
		jsonSupplier.accumulate("fddbr", this.getFddbr());
		jsonSupplier.accumulate("lxfs", this.getLxfs());
		jsonSupplier.accumulate("address", this.getAddress());
		return jsonSupplier;
    }}