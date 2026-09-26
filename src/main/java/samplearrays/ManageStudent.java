package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student S : students){
            if (S.getAge() > oldest.getAge()){
                oldest = S;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student S : students){
            if (S.getAge() >= 18){
                count += 1;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum = 0;
        for (Student S : students){
            sum += S.getGrade();
        }
        return sum/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students){
            if (s.getName().equals(name) ){
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparingDouble(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students){
            if (s.getGrade() >= 15) System.out.println(s);
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students){
            if (s.getId() == id){
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0 ; i < students.length ; i++){
            for (int j = i + 1 ; j < students.length; j++){
                if (students[i].getName().equals(students[j].getName())) return true;
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = Arrays.copyOf(students, students.length + 1);
        newStudents[students.length] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Youssef");
        arr[1] = new Student(2, "Anass");
        arr[2] = new Student(3, "Wissal");
        arr[3] = new Student(4, "Rania");
        arr[4] = new Student(5, "Amina");


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest: " + findOldest(arr));

        // 3) Count adults
        System.out.println("Adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("Youssef: " + findStudentByName(arr, "Youssef"));

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);

        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 17);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("Duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student
        Student newStudent = new Student(6, "Anass");
        arr = appendStudent(arr, newStudent);

        Student[][] classRooms = new Student[2][3];
        classRooms[0][0] = arr[0];
        classRooms[0][1] = arr[1];
        classRooms[0][2] = arr[2];
        classRooms[1][0] = arr[3];
        classRooms[1][1] = arr[4];
        classRooms[1][2] = new Student(6, "Haitam", 19, 16);

        for (int i = 0 ; i < 2 ; i++){
            for (Student s : classRooms[i]){
                System.out.println(s);
            }
        }
        //To find the top student, one must simply just re-write the findOldest with the comparison being on the grade..., then apply it on each row of the matrix.
    }


}

