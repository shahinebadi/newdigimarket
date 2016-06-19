package ir.apk.dm.ui.user;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * Created by shahin on 4/24/2016 AD.
 */
@ManagedBean(name = "markersBean")
public class MarkersBean {
	private MapModel simpleModel;

	@PostConstruct
	public void init(){
		simpleModel = new DefaultMapModel();
		LatLng coordinate= new LatLng(35.7221707, 51.4649826);
		simpleModel.addOverlay(new Marker(coordinate,"Our Position"));
	}

	public MapModel getSimpleModel(){
		return simpleModel;
	}
}
