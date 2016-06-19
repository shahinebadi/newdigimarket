package ir.apk.dm.ui.user;

import ir.apk.dm.core.model.TabletInfo;
import ir.apk.dm.ui.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by shahin on 4/19/2016 AD.
 */
@ManagedBean(name = "tabletBean")
@ViewScoped
public class TabletBean extends BaseBean {
	private Logger     logger        = LoggerFactory.getLogger(TabletBean.class);
	private TabletInfo tabletWrapper = new TabletInfo();

	@Override
	protected void init() {
	}
}
