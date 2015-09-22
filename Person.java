public class Person{
	private String forename;
	private String surname;
	private int age;
	private String job;
	
	public Person() {
		forename="blanks";
		surname="blanks";
		age=0;
		job="blanks";
	}
	
	public Person(String forename, String surname, int age, String job) {
		this.forename=forename;
		this.surname=surname;
		this.age=age;
		this.job=job;
	}
	
	public String getName() {return this.forename + " " + this.surname;}
	public void setForename(String forename) {this.forename = forename;}
	
	public String toString() {
		String returnString = "";
		returnString = forename + "-" + surname + "-" + age + "-" + job;
		return returnString;
	}
}