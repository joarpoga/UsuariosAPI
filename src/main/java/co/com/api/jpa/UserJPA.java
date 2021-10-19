package co.com.api.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="users")
public class UserJPA implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id_user", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	private String name;
	@Column(name = "email", unique = true)
	private String email;
	private String password;
	private Date create_date;
	private Date update_date;
	private Date last_login;
	private String tokend;
	private Integer isactive;
	
	
	@OneToMany(mappedBy="user")	
	private List<PhoneJPA> listPhones;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Date getLast_Login() {
		return last_login;
	}
	public void setLast_Login(Date last_login) {
		this.last_login = last_login;
	}
	public String getTokend() {
		return tokend;
	}
	public void setTokend(String tokend) {
		this.tokend = tokend;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public List<PhoneJPA> getListPhones() {
		return listPhones;
	}
	public void setListPhones(List<PhoneJPA> listPhones) {
		this.listPhones = listPhones;
	}
	@Override
	public String toString() {
		return "UserJPA [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", create_date="
				+ create_date + ", update_date=" + update_date + ", lastLogin=" + last_login + ", tokend=" + tokend
				+ ", isactive=" + isactive + ", listPhones=" + listPhones + "]";
	}
	
	
	
}
