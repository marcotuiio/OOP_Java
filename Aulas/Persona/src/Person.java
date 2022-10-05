
public class Person {
	private String name;
	private String lastName;
	
	public Person() {
		
	}
	
	public Person(String n, String ln) {
		this.name = n;
		this.lastName = ln;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return name + " " + lastName;
	}
	
	
}
