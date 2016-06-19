package ir.apk.dm.ui.user;

import ir.apk.dm.core.model.CellphoneInfo;
import ir.apk.dm.ui.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by shahin on 4/19/2016 AD.
 */
@ManagedBean(name = "cellphoneBean")
@ViewScoped
public class CellphoneBean extends BaseBean {
	private Logger        logger           = LoggerFactory.getLogger(CellphoneBean.class);
	private CellphoneInfo cellphoneWrapper = new CellphoneInfo();

	@Override
	protected void init() {
	}
}
