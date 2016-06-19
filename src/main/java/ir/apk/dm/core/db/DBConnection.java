package ir.apk.dm.core.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * DBConnection
 */
public class DBConnection {
	private static String PERSISTENCE_UNIT_NAME = "DB_CONNECTION";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		try {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			}
			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
