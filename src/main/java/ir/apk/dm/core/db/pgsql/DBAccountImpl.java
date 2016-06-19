package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.AccountInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls accounts db methods
 */
public class DBAccountImpl implements DBAccount {
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
	public boolean add(AccountInfo accountInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(accountInfo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long accountId) {
		try {
			AccountInfo accountInfo = getAccountInfo(accountId);
			if (accountInfo != null) {
				manager.getTransaction().begin();
				manager.remove(accountInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get accountInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<AccountInfo> getAllAccountInfos() {
		try {
			return manager.createNamedQuery("AccountInfo.findAll", AccountInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long accountId) {
		return getAccountInfo(accountId) != null;
	}

	@Override
	public AccountInfo getAccountInfo(long accountId) {
		try {
			return manager.createNamedQuery("AccountInfo.findByAccountId", AccountInfo.class).setParameter("accountId", accountId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public AccountInfo getAccountInfo(String userName) {
		try {
			return manager.createNamedQuery("AccountInfo.findByUserName", AccountInfo.class).setParameter("userName", userName).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
