package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.OrderInfo;

import java.util.List;

/**
 * DBOrder
 */
public interface DBOrder {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(OrderInfo accountInfo) throws Exception;

	List<OrderInfo> getAllOrderInfos() throws Exception;

	boolean delete(long orderId) throws Exception;

	boolean exist(long orderId);

	OrderInfo getOrderInfo(long orderId) throws Exception;
}
