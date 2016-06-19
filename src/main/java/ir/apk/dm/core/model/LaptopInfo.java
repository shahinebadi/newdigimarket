package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all LaptopInfos.
 */
@NamedQueries({
		@NamedQuery(name = "LaptopInfo.findAll"
				, query = "SELECT e FROM LaptopInfo e"),
		@NamedQuery(name = "LaptopInfo.findById"
				, query = "SELECT e FROM LaptopInfo e WHERE e.categoryId=:categoryId"),
})
@Entity
@Table(name = "laptops")
public class LaptopInfo implements Serializable {
	@Id
	@Column
	private long categoryId;

	public LaptopInfo() {
	}

	public LaptopInfo(long categoryId){
		this.categoryId = categoryId;
	}
}
