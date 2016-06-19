package ir.apk.dm.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all CellInfos
 */
@NamedQueries({
		@NamedQuery(name = "CellphoneInfo.findAll"
				, query = "SELECT e FROM CellphoneInfo e"),
		@NamedQuery(name = "CellphoneInfo.findById"
				, query = "SELECT e FROM CellphoneInfo e WHERE e.categoryId=:categoryId")
})
@Entity
@Table(name = "cellphones")
public class CellphoneInfo implements Serializable {
	@Id
	@Column
	private long categoryId;

	public CellphoneInfo() {
	}
}
