public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a Student
        Student student = new Student("1", "Sanskruti Sharma", "O");

        // Create a View
        StudentView view = new StudentView();

        // Create a Controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Sanskruti Sharma");
        controller.setStudentGrade("O");

        // Display updated student details
        controller.updateView();
    }
}
