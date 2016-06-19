package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.ProductCategoryInfo;

import java.util.List;

/**
 * DBProductCategory
 */
public interface DBProductCategory {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(ProductCategoryInfo productCategoryInfo) throws Exception;

	List<ProductCategoryInfo> getAllProductCategoryInfos() throws Exception;

	boolean delete(long productId, long categoryId) throws Exception;

	boolean exist(long productId, long categoryId);

	ProductCategoryInfo getProductCategoryInfo(long productId, long categoryId) throws Exception;
}
