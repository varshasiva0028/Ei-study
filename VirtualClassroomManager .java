import java.util.*;

class Classroom {
    String name;
    List<Student> students;
    Map<String, Boolean> assignments; // Assignment details and status

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void scheduleAssignment(String assignmentDetails) {
        assignments.put(assignmentDetails, false);
    }

    public void submitAssignment(String assignmentDetails) {
        if (assignments.containsKey(assignmentDetails)) {
            assignments.put(assignmentDetails, true);
        }
    }

    public boolean isAssignmentSubmitted(String assignmentDetails) {
        return assignments.getOrDefault(assignmentDetails, false);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Student {
    String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}

class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        if (!classrooms.containsKey(name)) {
            classrooms.put(name, new Classroom(name));
            System.out.println("Classroom " + name + " has been created.");
        } else {
            System.out.println("Classroom already exists.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId));
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.scheduleAssignment(assignmentDetails);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.submitAssignment(assignmentDetails);
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
VirtualClassroomManager manager = new VirtualClassroomManager();

while (true) {
    System.out.print("Enter command: ");
    String command = scanner.nextLine();
    String[] parts = command.split(" ", 3);

    if (parts[0].equals("add_classroom")) {
        manager.addClassroom(parts[1]);
    } else if (parts[0].equals("add_student")) {
        manager.addStudent(parts[1], parts[2]);
    } else if (parts[0].equals("schedule_assignment")) {
        manager.scheduleAssignment(parts[1], parts[2]);
    } else if (parts[0].equals("submit_assignment")) {
        manager.submitAssignment(parts[1], parts[2], parts[3]);
    } else {
        System.out.println("Unknown command.");
    }
}

    }
}