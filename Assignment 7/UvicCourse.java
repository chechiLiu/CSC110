//Provided

public class UvicCourse {
	
	//INSTANCE VARIABLES
	private String dept = "";
	private int num = 0;
	private String title = "";
		
	//CONSTRUCTORS
	public UvicCourse(String dept, int num) {
		this.dept = dept;
		this.num = num;	
	}
	
	public UvicCourse(String dept, int num, String title) {
		this.dept = dept;
		this.num = num;	
		this.title = title;
	}
	
	public UvicCourse() {
		this.dept = "AAA";
		this.num = 100;
		this.title = "A course";	
	}
	
	//SETTER AND GETTER METHODS
	public void setDept(String dept) {
		this.dept = dept;	
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDept() {
		return this.dept;	
	}
	
	public int getNum() {
		return this.num;	
	}
	
	public String getTitle() {
		return this.title;	
	}
	
	//TOSTRING METHOD
	public String toString() {
		return dept + " " + num + ": "+title;
	}
}
