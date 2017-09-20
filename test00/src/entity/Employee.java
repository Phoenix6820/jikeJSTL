package entity;

public class Employee {

	private int id;
	private String name;
	private String gender;
	private int age;
	private Department bj;

	public Department getBj() {
		return bj;
	}

	public void setBj(Department bj) {
		this.bj = bj;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
