package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * This class contains all ProductInfos
 */
@NamedQueries({
		@NamedQuery(name = "ProductInfo.findByProductId"
				, query = "SELECT e FROM ProductInfo e WHERE e.productId=:productId"),
		@NamedQuery(name = "ProductInfo.findAll"
				, query = "SELECT e FROM ProductInfo e")
})
@Entity
@Table(name = "products")
public class ProductInfo implements Serializable {
	@Id
	private long    productId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date    arrivalDate;
	@Column
	private boolean isExisted;
	@Column
	private long    price;
	@Column
	private int     quantity;
	@Column
	private String  color;
	@Column
	private String  brand;
	@Column
	private int     displaySize;
	@Column
	private String  dimension;
	@Column
	private int     weight;
	@Column
	private String  graphicalProcessor;
	@Column
	private String  mainProcessor;
	@Column
	private int     processorSpeed;
	@Column
	private int     RAM;
	@Column
	private String  OS;
	@Column
	private String  model;

	public ProductInfo() {
	}

	public ProductInfo(long productId, Date arrivalDate, boolean isExisted, long price, int quantity, String color, String brand, int displaySize, int weight, String dimension, String graphicalProcessor, String mainProcessor, int processorSpeed, int RAM, String OS, String model) {
		this.productId = productId;
		this.arrivalDate = arrivalDate;
		this.isExisted = isExisted;
		this.price = price;
		this.quantity = quantity;
		this.color = color;
		this.brand = brand;
		this.displaySize = displaySize;
		this.weight = weight;
		this.dimension = dimension;
		this.graphicalProcessor = graphicalProcessor;
		this.mainProcessor = mainProcessor;
		this.processorSpeed = processorSpeed;
		this.RAM = RAM;
		this.OS = OS;
		this.model = model;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
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

	public String getMainProcessor() {
		return mainProcessor;
	}

	public void setMainProcessor(String mainProcessor) {
		this.mainProcessor = mainProcessor;
	}

	public int getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(int processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int RAM) {
		this.RAM = RAM;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
