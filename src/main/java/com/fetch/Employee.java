package com.fetch;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private int age;
	
	@OneToMany(mappedBy = "emp", fetch = FetchType.LAZY)
	private List<Account> accD;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int age, List<Account> accD) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.accD = accD;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Account> getAccD() {
		return accD;
	}
	public void setAccD(List<Account> accD) {
		this.accD = accD;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", accD=" + accD + "]";
	}
	
	
}
