package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all OrderInfos
 */
@NamedQueries({
		@NamedQuery(name = "OrderInfo.findAll"
				, query = "SELECT e FROM OrderInfo e"),
		@NamedQuery(name = "OrderInfo.findByOrderId"
				, query = "SELECT e FROM OrderInfo e WHERE e.orderId=:orderId")
})
@Entity
@Table(name = "orders")
public class OrderInfo implements Serializable {
	@Id
	@Column
	private long    orderId;
	@Column
	private long    accountId;
	@Column
	private long    orderDate;
	@Column
	private long    productId;
	@Column
	private long    deliverDate;
	@Column
	private boolean isDelivered;

	public OrderInfo() {
	}

	public OrderInfo(long orderId, long accountId, long orderDate, long productId, long deliverDate, boolean isDelivered) {
		this.orderId = orderId;
		this.accountId = accountId;
		this.orderDate = orderDate;
		this.productId = productId;
		this.deliverDate = deliverDate;
		this.isDelivered = isDelivered;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(long deliverDate) {
		this.deliverDate = deliverDate;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(long orderDate) {
		this.orderDate = orderDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean delivered) {
		isDelivered = delivered;
	}
}
