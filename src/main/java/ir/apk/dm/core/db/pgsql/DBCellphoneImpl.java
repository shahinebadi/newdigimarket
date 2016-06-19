package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.CellphoneInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls cellphone db methods
 */
public class DBCellphoneImpl implements DBCellphone {
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
	public boolean add(CellphoneInfo cellphoneInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(cellphoneInfo);
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
			CellphoneInfo cellphoneInfo = getCellphoneInfo(categoryId);
			if (cellphoneInfo != null) {
				manager.getTransaction().begin();
				manager.remove(cellphoneInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get cellphoneInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<CellphoneInfo> getAllCellphoneInfos() {
		try {
			return manager.createNamedQuery("CellphoneInfo.findAll", CellphoneInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long categoryId) {
		return getCellphoneInfo(categoryId) != null;
	}

	@Override
	public CellphoneInfo getCellphoneInfo(long categoryId) {
		try {
			return manager.createNamedQuery("CellphoneInfo.findById", CellphoneInfo.class).setParameter("categoryId", categoryId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
