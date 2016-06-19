package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.db.DBConnection;
import ir.apk.dm.core.model.OrderInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * This class controls orders db methods
 */
public class DBOrderImpl implements DBOrder{
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
	public boolean add(OrderInfo orderInfo) {
		try {
			manager.getTransaction().begin();
			manager.persist(orderInfo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(long orderId) {
		try {
			OrderInfo orderInfo = getOrderInfo(orderId);
			if (orderInfo != null) {
				manager.getTransaction().begin();
				manager.remove(orderInfo);
				manager.getTransaction().commit();
				return true;
			} else {
				System.out.println("Could not get orderInfo");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<OrderInfo> getAllOrderInfos() {
		try {
			return manager.createNamedQuery("OrderInfo.findAll", OrderInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean exist(long orderId) {
		return getOrderInfo(orderId) != null;
	}

	@Override
	public OrderInfo getOrderInfo(long orderId) {
		try {
			return manager.createNamedQuery("OrderInfo.findByOrderId", OrderInfo.class).setParameter("orderId", orderId).getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
