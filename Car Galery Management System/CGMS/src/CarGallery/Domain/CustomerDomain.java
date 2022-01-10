package CarGallery.Domain;

import java.sql.Date;

public class CustomerDomain {

	private int id;
	private String name; // define variable for customer info
	private String surname;
	private String gender;
	private Date birthday;
	private String telephone;
	private String address;
	
	
	
	// define set and get methods
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return   name + "  " + surname + "  " + gender
				+ "  " + birthday + "  " + telephone + "  " + address ;
	}
	
	
	
	
	
	
	
	
}