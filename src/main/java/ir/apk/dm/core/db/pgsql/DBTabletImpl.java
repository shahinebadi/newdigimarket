package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.TabletInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls tablets db methods
 */
public class DBTabletImpl implements DBTablet {
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
	public boolean add(TabletInfo tabletInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(tabletInfo);
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
			TabletInfo tabletInfo = getTabletInfo(categoryId);
			if (tabletInfo != null) {
				manager.getTransaction().begin();
				manager.remove(tabletInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get tabletInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<TabletInfo> getAllTabletInfos() {
		try {
			return manager.createNamedQuery("TabletInfo.findAll", TabletInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long categoryId) {
		return getTabletInfo(categoryId) != null;
	}

	@Override
	public TabletInfo getTabletInfo(long categoryId) {
		try {
			return manager.createNamedQuery("TabletInfo.findById", TabletInfo.class).setParameter("categoryId", categoryId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
