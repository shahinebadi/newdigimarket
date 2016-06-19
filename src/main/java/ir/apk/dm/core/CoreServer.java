package ir.apk.dm.core;

import ir.apk.dm.core.db.pgsql.*;
import ir.apk.dm.core.model.AccountInfo;
import ir.apk.dm.core.model.LaptopInfo;
import ir.apk.dm.core.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Implementation of all methods
 */
public enum CoreServer {
	// implement singleton by enum
	INSTANCE;

	DBAccountImpl   dbAccountImpl;
	DBOrderImpl     dbOrderImpl;
	DBProductImpl   dbProductImpl;
	DBCellphoneImpl dbCellphoneImpl;
	DBTabletImpl    dbTabletImpl;
	DBLaptopImpl    dbLaptopImpl;

	private Logger logger = LoggerFactory.getLogger(CoreServer.class);

	public List<LaptopInfo> getAllLaptopInfos() {
		logger.info("getAllLaptopInfos is called");
		List<LaptopInfo> laptopInfos;
		dbLaptopImpl = (dbLaptopImpl != null) ? dbLaptopImpl : new DBLaptopImpl();
		dbLaptopImpl.startConnection();
		laptopInfos = dbLaptopImpl.getAllLaptopInfos();
		dbLaptopImpl.closeConnection();
		return laptopInfos;
	}

	public List<ProductInfo> getAllProductInfos() {
		logger.info("getAllProductInfos is called");
		List<ProductInfo> productInfos;
		dbProductImpl = (dbProductImpl != null) ? dbProductImpl : new DBProductImpl();
		dbProductImpl.startConnection();
		productInfos = dbProductImpl.getAllProductInfos();
		dbProductImpl.closeConnection();
		return productInfos;
	}

	public List<AccountInfo> getAllAccountInfos() {
		logger.info("getAllAccountInfos is called");
		List<AccountInfo> accountInfos;
		dbAccountImpl = (dbAccountImpl != null) ? dbAccountImpl : new DBAccountImpl();
		dbProductImpl.startConnection();
		accountInfos = dbAccountImpl.getAllAccountInfos();
		dbProductImpl.closeConnection();
		return accountInfos;
	}

	public AccountInfo getAccountInfo(String userName) {
		logger.info("getAccountInfo is called");
		AccountInfo accountInfo;
		dbAccountImpl = (dbAccountImpl != null) ? dbAccountImpl : new DBAccountImpl();
		dbAccountImpl.startConnection();
		accountInfo = dbAccountImpl.getAccountInfo(userName);
		dbAccountImpl.closeConnection();
		return accountInfo;
	}

	public boolean addNewAccount(AccountInfo accountInfo) {
		logger.info("addNewAccount is called");
		boolean isCreated;
		dbAccountImpl = (dbAccountImpl != null) ? dbAccountImpl : new DBAccountImpl();
		dbAccountImpl.startConnection();
		isCreated = dbAccountImpl.add(accountInfo);
		dbAccountImpl.closeConnection();
		return isCreated;
	}

	public boolean addNewProduct(ProductInfo productInfo) {
		logger.info("addNewProduct is called");
		boolean isCreated;
		dbProductImpl = (dbProductImpl != null) ? dbProductImpl : new DBProductImpl();
		dbProductImpl.startConnection();
		isCreated = dbProductImpl.add(productInfo);
		dbProductImpl.closeConnection();
		return isCreated;
	}
}
