package ir.apk.dm.core.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * This class contains all AccountInfos
 */
@NamedQueries({
		@NamedQuery(name = "AccountInfo.findAll"
				, query = "SELECT e FROM AccountInfo e"),
		@NamedQuery(name = "AccountInfo.findByAccountId"
				, query = "SELECT e FROM AccountInfo e WHERE e.accountId=:accountId"),
		@NamedQuery(name = "AccountInfo.findByUserName"
				, query = "SELECT e FROM AccountInfo e WHERE e.userName=:userName")
})
@Entity
@Table(name = "accounts")
public class AccountInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq")
	private long   accountId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String tel;
	@Column
	private String address;
	@Column
	private long   discount;
	@Column(unique = true)
	private String userName;
	@Column
	private byte[] password;
	@Column
	private byte[] salt;
	@Column
	private boolean isAdmin;

	public AccountInfo() {
	}

	public AccountInfo(String firstName, String lastName, String tel, String address, long discount, String userName, byte[] password, byte[] salt, boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.address = address;
		this.discount = discount;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.isAdmin = isAdmin;
	}

	public AccountInfo(String firstName, String lastName, String tel, String address, String userName, byte[] password, byte[] salt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}
}