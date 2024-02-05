package test.com;

public class TestVO {
	
	String name;
	int age;
	String save_name;
	
	public TestVO() {
		// TODO Auto-generated constructor stub
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

	public String getSave_name() {
		return save_name;
	}

	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}

	@Override
	public String toString() {
		return "TestVO [name=" + name + ", age=" + age + ", save_name=" + save_name + "]";
	}

	public TestVO(String name, int age, String save_name) {
		super();
		this.name = name;
		this.age = age;
		this.save_name = save_name;
	}
	
	

}
