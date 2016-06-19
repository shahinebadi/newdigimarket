package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.ProductInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls products DB methods
 */
public class DBProductImpl implements DBProduct{
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
	public boolean add(ProductInfo productInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(productInfo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long productId) {
		try {
			ProductInfo productInfo = getProductInfo(productId);
			if (productInfo != null) {
				manager.getTransaction().begin();
				manager.remove(productInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get productInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<ProductInfo> getAllProductInfos() {
		try {
			return manager.createNamedQuery("ProductInfo.findAll", ProductInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long productId) {
		return getProductInfo(productId) != null;
	}

	@Override
	public ProductInfo getProductInfo(long productId) {
		try {
			return manager.createNamedQuery("ProductInfo.findByProductId", ProductInfo.class).setParameter("productId", productId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
