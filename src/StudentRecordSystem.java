/*
 * Mutable StudentRecordSystem class holds 
 * a Record System in which we can save a 
 * student's name, their ID, their gender 
 * and their GPA.
 * Remember to add your name and User ID.
 * Name: LastNames, First Name
 * User ID: ap_
 */
import java.util.ArrayList;

public class StudentRecordSystem {

	private static StudentRecordSystem studentRecordSystem;
	private StudentRecord[] studentRecords;
	private int totalStudentRecords;	// Actual number of student records currently in the system.
	
	static {
		studentRecordSystem = new StudentRecordSystem();
	}
	
	private StudentRecordSystem() {}
	
	public static StudentRecordSystem initializeInstance(int maxNumberOfStudentRecords){
		studentRecordSystem.studentRecords = new StudentRecord[maxNumberOfStudentRecords];
		studentRecordSystem.totalStudentRecords = 0;
        return studentRecordSystem;
    }
	
	// Getters
	public StudentRecord[] getStudentRecords() {
		return studentRecords;
	}
	
	public int getTotalStudentRecords() {
		return totalStudentRecords;
	}
	
	/*                       **IMPORTANT**
	 * Method for testers, Other methods should be done using Arrays.
	 * The use of Lists or any of it's functions is forbidden.
	 */
	
	public void addAllStudents(StudentRecord[] sr) {
		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
		for(int i = 0; i<totalStudentRecords; i++) {
			list.add(studentRecords[i]);
		}
		for(StudentRecord s: sr) {
			list.add(s);
		}
		studentRecords = list.toArray(new StudentRecord[0]);
		totalStudentRecords += sr.length;
	}
	
    /*
     * EXERCISE: #1
     * 
	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
	 * 
	 * Adds a new student record with the given parameters.
	 * 
	 * HINT: Create a new array twice the size of the original array and move 
	 * all the elements to this mew array if the totalStudentRecords exceeds 
	 * the capacity of the current array.
	 */
	public void addStudentRecord(String id, String name, Gender gender, double gpa) {
		//Write your code here	
	}
	
	/* 
	 * EXERCISE: #2A
     * 
	 * IMPLEMENT USING A REGULAR FOR LOOP.
	 * 
	 * Returns an array of Strings where each entry represents a student record.
	 * 
	 * HINT: Use the toString method in the Student Record inner class.
	 */
	public String[] recordsToString() {
		// YOUR CODE GOES HERE.
		return null;
	}
	
	/* 
	 * EXERCISE: #2B
     * 
	 * IMPLEMENT USING A WHILE LOOP.
	 * 
	 * Returns true if this list contains the specified student. More 
	 * formally, returns true if and only if this list contains at 
	 * least one element e such that (o==null ? e==null : o.equals(e)).
	 * 
	 * 
	 */
	public boolean contains(StudentRecord s) {
		// YOUR CODE GOES HERE.
		return false;
	}
	
	/* 
	 * EXERCISE: #3A
     *
	 * IMPLEMENT WITH ANY LOOP.
	 * 
	 * Returns the mean of the GPA's in student record system
	 * 
	 */
	public double getMean() {
		// YOUR CODE GOES HERE.
		return 0;
	}
	
	/* 
	 * EXERCISE: #3B
     *
	 * IMPLEMENT WITH ANY LOOP.
	 * 
	 * Returns the standard deviation of the GPA's in student record system.
	 */
	public double getStandardDeviation() {
		// YOUR CODE GOES HERE.
		return 0;
	}
	
	/* 
	 * BONUS
	 * 
	 * IMPLEMENT WITH NESTED LOOPS.
	 * 
	 * Returns true if two instances of StudentRecord have the same name, false otherwise.
	 * HINT: Use the Equals method.
	 */
	public boolean repeatedStudentNames() {
		// YOUR CODE GOES HERE.
		return false;
	}
	
	/*
	 * Enum of type Gender representing male or female.
	 */
	public enum Gender {
		MALE('M'), FEMALE('F');
		private final char letter;
		Gender(char letter) { this.letter = letter; }
		public char genderLetter() { return letter; }
	}
	
	/*
	 * Inner class representing student records in the student record system.
	 */
	public static class StudentRecord {
		
		private String id;
		private String name;
		private Gender gender;
		private double gpa;
		
		public StudentRecord(String id, String name, Gender gender, double gpa) {
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.gpa = gpa;
		}

		public String toString() {
			return String.format("ID: " + id + ", Name: " + name + ", Gender: " + gender.genderLetter() + ", GPA: %.2f", gpa);
		}
		
		// Getters
		public String getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public Gender getGender() {
			return gender;
		}
		
		public double getGPA() {
			return gpa;
		}
	}
}
