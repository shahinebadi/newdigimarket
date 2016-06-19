package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.CellphoneInfo;

import java.util.List;

/**
 * Created by shahin on 4/25/2016 AD.
 */
public interface DBCellphone {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(CellphoneInfo cellphoneInfo) throws Exception;

	List<CellphoneInfo> getAllCellphoneInfos() throws Exception;

	boolean delete(long categoryId) throws Exception;

	boolean exist(long categoryId);

	CellphoneInfo getCellphoneInfo(long categoryId) throws Exception;

}
