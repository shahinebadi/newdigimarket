package ir.apk.dm.ui.user;

import ir.apk.dm.core.CoreServer;
import ir.apk.dm.core.model.LaptopInfo;
import ir.apk.dm.core.model.ProductInfo;
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
@ManagedBean(name = "laptopBean")
@ViewScoped
public class LaptopBean extends BaseBean {
	private Logger            logger         = LoggerFactory.getLogger(LaptopBean.class);
	private LaptopInfo        laptopWrapper  = new LaptopInfo();
	private List<ProductInfo> laptopInfoList = new ArrayList<>();

	@Override
	protected void init() {
		laptopInfoList = CoreServer.INSTANCE.getAllProductInfos();
		for (ProductInfo productInfo : laptopInfoList) {
			if (!productInfo.getBrand().equals("apple")) {
				laptopInfoList.remove(productInfo);
			}
		}
	}

	public List<ProductInfo> getLaptopInfoList() {
		return laptopInfoList;
	}

	public void setLaptopInfoList(List<ProductInfo> laptopInfoList) {
		this.laptopInfoList = laptopInfoList;
	}
}
