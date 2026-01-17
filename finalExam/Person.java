//package cmp168final;

public class Person {
	
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;
	
	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean hasDriverLicense() {
		return hasDriverLicense;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Person clone() {
		Person myPerson = new Person(this.name, this.hasDriverLicense, this.age, this.height);
		return myPerson;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (o instanceof Person) {
			Person myPerson = (Person) o;
				if (this.name == myPerson.name) {
					if (this.hasDriverLicense == myPerson.hasDriverLicense) {
						if (this.age == myPerson.age) {
							if (this.height == myPerson.height) {
								return true;
							}
						}
					}
				}
			}
		return false;
	}
	
	public String toString() {
		String myStr = String.format("Person [name= %10s | age= %02d | height= %02d | ", this.name, this.age, this.height);
		if (this.hasDriverLicense) {
			myStr += "has license]";
		}
		else {
			myStr += "no license]";
		}
		
		return myStr;
	}
	
	
	
	
	
	

}
