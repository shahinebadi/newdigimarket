package ir.apk.dm.core.db.pgsql;

import ir.apk.dm.core.model.TabletInfo;

import java.util.List;

/**
 * Created by shahin on 4/25/2016 AD.
 */
public interface DBTablet {
	boolean startConnection() throws Exception;

	void closeConnection() throws Exception;

	boolean add(TabletInfo tabletInfo) throws Exception;

	List<TabletInfo> getAllTabletInfos() throws Exception;

	boolean delete(long categoryId) throws Exception;

	boolean exist(long categoryId);

	TabletInfo getTabletInfo(long categoryId) throws Exception;
}
