package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.ProductCategoryInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class implements all ProductCategory methods
 */
public class DBProductCategoryImpl implements DBProductCategory {
	private EntityManager manager;

	@Override
	public boolean startConnection() {
		try {
			EntityManagerFactory factory = DBConnection.getEntityManagerFactory();
			manager = factory != null ? factory.createEntityManager() : null;
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public void closeConnection() {
		manager.close();
	}

	@Override
	public boolean add(ProductCategoryInfo productCategoryInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(productCategoryInfo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long productId, long categoryId) {
		try {
			ProductCategoryInfo productCategoryInfo = getProductCategoryInfo(productId, categoryId);
			if (productCategoryInfo != null) {
				manager.getTransaction().begin();
				manager.remove(productCategoryInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get productCategoryInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<ProductCategoryInfo> getAllProductCategoryInfos() {
		try {
			return manager.createNamedQuery("ProductCategoryInfo.findAll", ProductCategoryInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long productId, long categoryId) {
		return getProductCategoryInfo(productId, categoryId) != null;
	}

	@Override
	public ProductCategoryInfo getProductCategoryInfo(long productId, long categoryId) {
		try {
			return manager.createNamedQuery("ProductCategoryInfo.findById", ProductCategoryInfo.class).setParameter("productId", productId).setParameter("categoryId", categoryId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
