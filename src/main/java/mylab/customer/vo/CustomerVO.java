package mylab.customer.vo;

import java.util.Date;

public class CustomerVO {
	private int id;
	private String email;
	private String name;
	private int age;
	private Date entry_date;
	
	public CustomerVO() {
	}

	public CustomerVO(int id, String email, String name, int age, Date entry_date) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.entry_date = entry_date;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", entry_date="
				+ entry_date + "]";
	}
	
}
