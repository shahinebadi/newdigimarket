package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.AccountInfo;

import java.util.List;

/**
 * DBAccount
 */
public interface DBAccount {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(AccountInfo accountInfo) throws Exception;

	List<AccountInfo> getAllAccountInfos() throws Exception;

	boolean delete(long accountId) throws Exception;

	boolean exist(long accountId);

	AccountInfo getAccountInfo(long accountId) throws Exception;

	AccountInfo getAccountInfo(String userName) throws Exception;
}
