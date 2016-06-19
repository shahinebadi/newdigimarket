package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.ProductInfo;

import java.util.List;

/**
 * DBProduct
 */
public interface DBProduct {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(ProductInfo productInfo) throws Exception;

	List<ProductInfo> getAllProductInfos() throws Exception;

	boolean delete(long productId) throws Exception;

	boolean exist(long productId);

	ProductInfo getProductInfo(long productId) throws Exception;
}
