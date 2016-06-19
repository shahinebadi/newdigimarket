package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.LaptopInfo;

import java.util.List;

/**
 * DBLaptop
 */
public interface DBLaptop {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(LaptopInfo laptopInfo) throws Exception;

	List<LaptopInfo> getAllLaptopInfos() throws Exception;

	boolean delete(long categoryId) throws Exception;

	boolean exist(long categoryId);

	LaptopInfo getLaptopInfo(long categoryId) throws Exception;
}
