package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all TabletInfos.
 */
@NamedQueries({
		@NamedQuery(name = "TabletInfo.findAll"
				, query = "SELECT e FROM TabletInfo e"),
		@NamedQuery(name = "TabletInfo.findById"
				, query = "SELECT e FROM TabletInfo e WHERE e.categoryId=:categoryId"),
})
@Entity
@Table(name = "tablets")
public class TabletInfo implements Serializable {
	@Id
	@Column
	private long categoryId;

	public TabletInfo() {
	}
}
