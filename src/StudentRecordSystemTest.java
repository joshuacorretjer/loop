import static org.junit.Assert.*;

import org.junit.Test;

public class StudentRecordSystemTest {

	@Test
	public void addStudentRecordTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		studentRecordSystem.addStudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00);
		StudentRecordSystem.StudentRecord[] studentRecords1 = studentRecordSystem.getStudentRecords();
		assertEquals("The totalStudentRecords variable is not being updated.", 1, studentRecordSystem.getTotalStudentRecords());
		assertEquals("Student record ID is incorrect.", "802113679", studentRecords1[0].getID());
		assertEquals("Student record name is incorrect.", "Pedro", studentRecords1[0].getName());
		assertEquals("Student record gender is incorrect.", StudentRecordSystem.Gender.MALE, studentRecords1[0].getGender());
		assertEquals("Student record GPA is incorrect.",  3.00, studentRecords1[0].getGPA(), 1e-10);
		studentRecordSystem.addStudentRecord("802174579", "Juan", StudentRecordSystem.Gender.MALE, 3.40);
		assertEquals("The totalStudentRecords variable is not being updated.", 2, studentRecordSystem.getTotalStudentRecords());
		assertTrue("The arrays are different instances.", studentRecords1 == studentRecordSystem.getStudentRecords());
		studentRecordSystem.addStudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
		studentRecordSystem.addStudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
		StudentRecordSystem.StudentRecord[] studentRecords2 = studentRecordSystem.getStudentRecords();
		assertEquals("Student record name is incorrect.", "Pedro", studentRecords2[0].getName());
		assertEquals("Student record name is incorrect.", "Juan", studentRecords2[1].getName());
		assertEquals("Student record name is incorrect.", "Julia", studentRecords2[2].getName());
		assertEquals("Student record name is incorrect.", "Eliezer", studentRecords2[3].getName());
		assertFalse("The arrays are the same instance.", studentRecords1 == studentRecordSystem.getStudentRecords());
		assertEquals("The size of student records is not twice the size.", 6, studentRecordSystem.getStudentRecords().length);
	}
	
	 @Test
	 public void recordsToStringTest() {
	  String[] expectedStrings = new String[3];
	  expectedStrings[0] = "ID: 802174579, Name: Juan, Gender: M, GPA: 3.40";
	  expectedStrings[1] = "ID: 802122423, Name: Julia, Gender: F, GPA: 3.35";
	  expectedStrings[2] = "ID: 802113349, Name: Eliezer, Gender: M, GPA: 3.90";
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(6);
	  String[] actualStrings = studentRecordSystem.recordsToString();
	  assertEquals("The size of array of Strings doesn't have the right length.", 0, actualStrings.length);
	  
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

	  sr[0] = new StudentRecordSystem.StudentRecord("802174579", "Juan", StudentRecordSystem.Gender.MALE, 3.40);
	  sr[1] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  studentRecordSystem.addAllStudents(sr);

	  actualStrings = studentRecordSystem.recordsToString();
	  assertEquals("The size of array of Strings doesn't have the right length.", 3, actualStrings.length);
	  assertEquals("Student Juan has incorrect record.", expectedStrings[0], actualStrings[0]);
	  assertEquals("Student Julia has incorrect record.", expectedStrings[1], actualStrings[1]);
	  assertEquals("Student Eliezer has incorrect record.", expectedStrings[2], actualStrings[2]);
	 }

	 @Test
	 public void containsTest() {
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(2);
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

	  sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
	  sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00); 
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  studentRecordSystem.addAllStudents(sr);

	  assertFalse(studentRecordSystem.contains(new StudentRecordSystem.StudentRecord("802121234", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00)));
	  
	  sr = new StudentRecordSystem.StudentRecord[1];
	  sr[0] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 2.50);
	  studentRecordSystem.addAllStudents(sr);
	  StudentRecordSystem.StudentRecord studentRecord = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
	  
	  assertTrue(studentRecordSystem.contains(studentRecord));
	 }
	 
	 @Test
	 public void meanTest() {
	 
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];
	 
	  assertEquals("Mean student record GPA is incorrect.", 0.0000000000, studentRecordSystem.getMean(), 1E-3);
	 
	  sr = new StudentRecordSystem.StudentRecord[4];
	  sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
	  sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00);
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 2.00);
	  sr[3] = new StudentRecordSystem.StudentRecord("802131831", "Zhoe", StudentRecordSystem.Gender.FEMALE, 1.00);
	  studentRecordSystem.addAllStudents(sr);
	 
	  assertEquals("Mean student record GPA is incorrect.", 2.5000000000, studentRecordSystem.getMean(), 1E-3);
	 
	  sr = new StudentRecordSystem.StudentRecord[2];
	  sr[0] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 2.50);
	  sr[1] = new StudentRecordSystem.StudentRecord("802145672", "Rye", StudentRecordSystem.Gender.FEMALE, 3.50);
	  studentRecordSystem.addAllStudents(sr);
	 
	  assertEquals("Mean student record GPA is incorrect.", 2.6666666666, studentRecordSystem.getMean(), 1E-3);
	 }
	 
	 @Test
	 public void standardDeviationTest() {
	 
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];
	 
	  assertEquals("Standard Deviation student record GPA is incorrect.", 0.0000000000, studentRecordSystem.getStandardDeviation(), 1E-3);
	 
	  sr = new StudentRecordSystem.StudentRecord[4];
	  sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
	  sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00);
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 2.00);
	  sr[3] = new StudentRecordSystem.StudentRecord("802131831", "Zhoe", StudentRecordSystem.Gender.FEMALE, 1.00);
	  studentRecordSystem.addAllStudents(sr);
	 
	  assertEquals("Standard Deviation student record GPA is incorrect.",  1.2909944487358056, studentRecordSystem.getStandardDeviation(), 1E-3);
	 
	  sr = new StudentRecordSystem.StudentRecord[4];
	  sr[0] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 1.50);
	  sr[1] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 4.75);
	  sr[2] = new StudentRecordSystem.StudentRecord("802145672", "Rye", StudentRecordSystem.Gender.FEMALE, 3.20);
	  sr[3] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 2.25);
	  studentRecordSystem.addAllStudents(sr);
	 
	  assertEquals("Standard Deviation student record GPA is incorrect.", 1.2679426530520106, studentRecordSystem.getStandardDeviation(), 1E-3);
	 }
	 
	 @Test
	 public void repeatedStudentNamesTest() {
	  StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
	  StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

	  sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.04);
	  sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.32); 
	  sr[2] = new StudentRecordSystem.StudentRecord("802113349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.87);
	  studentRecordSystem.addAllStudents(sr);
	  
	  assertFalse("There are no repeated names", studentRecordSystem.repeatedStudentNames());
	  
	  sr = new StudentRecordSystem.StudentRecord[2];
	  sr[0] = new StudentRecordSystem.StudentRecord("802152268", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
	  sr[1] = new StudentRecordSystem.StudentRecord("802143852", "Pedro", StudentRecordSystem.Gender.MALE, 2.42);
	  studentRecordSystem.addAllStudents(sr);
	  
	  assertTrue("There is a repeated name", studentRecordSystem.repeatedStudentNames());
	 }

}