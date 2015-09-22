public class Student extends Person {
	private String course;
	
	public Student() {
		course = "blanks";
	}
	
	public Student(String forename, String surname, int age, String job) {
		super(forename, surname, age, job);
		course = "blanks";
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String toString() {
		String returnString = "";
		returnString = super.toString() + "-" + course;
		return returnString;
	}
}