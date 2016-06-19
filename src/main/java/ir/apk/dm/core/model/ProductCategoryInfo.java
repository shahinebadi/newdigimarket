package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all ProductCategoryInfos
 */
@NamedQueries({
		@NamedQuery(name = "ProductCategoryInfo.findAll"
				, query = "SELECT e FROM ProductCategoryInfo e"),
		@NamedQuery(name = "ProductCategoryInfo.findById"
				, query = "SELECT e FROM ProductCategoryInfo e WHERE e.productId=:productId AND e.categoryId=:categoryId"),
})
@Entity
@Table(name = "product_category")
@IdClass(ProductCategoryId.class)
public class ProductCategoryInfo implements Serializable {
	@Id
	private long productId;
	@Id
	private long categoryId;

	public ProductCategoryInfo() {
	}

	public ProductCategoryInfo(long categoryId, long productId) {
		this.categoryId = categoryId;
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
}
