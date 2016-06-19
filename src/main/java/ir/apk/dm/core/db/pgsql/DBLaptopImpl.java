package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.LaptopInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls laptops db methods
 */
public class DBLaptopImpl implements DBLaptop {
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
	public boolean add(LaptopInfo laptopInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(laptopInfo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long categoryId) {
		try {
			LaptopInfo laptopInfo = getLaptopInfo(categoryId);
			if (laptopInfo != null) {
				manager.getTransaction().begin();
				manager.remove(laptopInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get laptopInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<LaptopInfo> getAllLaptopInfos() {
		try {
			return manager.createNamedQuery("LaptopInfo.findAll", LaptopInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long categoryId) {
		return getLaptopInfo(categoryId) != null;
	}

	@Override
	public LaptopInfo getLaptopInfo(long categoryId) {
		try {
			return manager.createNamedQuery("LaptopInfo.findById", LaptopInfo.class).setParameter("categoryId", categoryId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
