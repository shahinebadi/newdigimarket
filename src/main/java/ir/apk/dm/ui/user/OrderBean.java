package ir.apk.dm.ui.user;

import ir.apk.dm.core.model.OrderInfo;
import ir.apk.dm.ui.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahin on 4/19/2016 AD.
 */
@ManagedBean(name = "orderBean")
@ViewScoped
public class OrderBean extends BaseBean {
	private Logger          logger       = LoggerFactory.getLogger(OrderBean.class);
	private OrderInfo       orderWrapper = new OrderInfo();
	private List<OrderInfo> orders       = new ArrayList<>();

	@Override
	protected void init() {
	}
}
