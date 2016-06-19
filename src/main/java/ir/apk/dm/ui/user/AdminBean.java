package ir.apk.dm.ui.user;

import ir.apk.dm.core.CoreServer;
import ir.apk.dm.core.model.ProductCategoryInfo;
import ir.apk.dm.core.model.ProductInfo;
import ir.apk.dm.ui.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shahin on 5/13/2016 AD.
 */
@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean extends BaseBean {

	private Logger              logger          = LoggerFactory.getLogger(AdminBean.class);
	private ProductCategoryInfo info            = new ProductCategoryInfo();
	private List<ProductInfo>   productInfoList = new ArrayList<>();
	private List<Long>          Ids             = new ArrayList<>();
	private long    productId;
	private Date    arrivalDate;
	private boolean isExisted;
	private long    price;
	private int     quantity;
	private String  color;
	private String  brand;
	private int     displaySize;
	private String  dimension;
	private int     weight;
	private String  graphicalProcessor;
	private String  mainProcessor;
	private int     processorSpeed;
	private int     RAM;
	private String  OS;
	private String  model;
	private String  type;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int RAM) {
		this.RAM = RAM;
	}

	public int getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(int processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public String getMainProcessor() {
		return mainProcessor;
	}

	public void setMainProcessor(String mainProcessor) {
		this.mainProcessor = mainProcessor;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public boolean isExisted() {
		return isExisted;
	}

	public void setExisted(boolean existed) {
		isExisted = existed;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGraphicalProcessor() {
		return graphicalProcessor;
	}

	public void setGraphicalProcessor(String graphicalProcessor) {
		this.graphicalProcessor = graphicalProcessor;
	}

	public List<ProductInfo> getProductInfoList() {
		return productInfoList;
	}

	public void setProductInfoList(List<ProductInfo> productInfoList) {
		this.productInfoList = productInfoList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProductCategoryInfo getInfo() {
		return info;
	}

	public void setInfo(ProductCategoryInfo info) {
		this.info = info;
	}

	@Override
	protected void init() {
		productInfoList = CoreServer.INSTANCE.getAllProductInfos();
		for (ProductInfo productInfo : productInfoList) {
			Ids.add(productInfo.getProductId());
		}
	}

	public void saveNewProduct() {
		if (!Ids.contains(productId)) {
			ProductInfo productInfo = new ProductInfo(productId, arrivalDate, isExisted, price, quantity, color, brand, displaySize, weight, dimension, graphicalProcessor, mainProcessor, processorSpeed, RAM, OS, model);
			boolean isAdded = CoreServer.INSTANCE.addNewProduct(productInfo);
			switch (type) {
				case "laptops":
					info.setCategoryId(1L);
					info.setProductId(productId);
					break;
				case "cellphones":
					info.setCategoryId(2L);
					info.setProductId(productId);
					break;
				case "tablets":
					info.setCategoryId(3L);
					info.setProductId(productId);
					break;
			}
			if (isAdded)
				showMessage("", getMessage("Product successfully added"), FacesMessage.SEVERITY_INFO);
			else
				showMessage("", getMessage("Product failed to add"), FacesMessage.SEVERITY_ERROR);
		} else {
			showMessage("", getMessage("Choose another Id"), FacesMessage.SEVERITY_ERROR);
		}
	}

}
