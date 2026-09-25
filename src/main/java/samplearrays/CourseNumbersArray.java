package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = Arrays.copyOf(registeredCourses, 10);
        updatedCourses[6] = 1050;
        updatedCourses[7] = 1111;
        for (int i : updatedCourses){
            System.out.println(i);
        }
        boolean Flag = false;
        int numberToCheck = 1050;
        for (int i = 0 ; i < updatedCourses.length ; i++){
            if (updatedCourses[i] == numberToCheck){
                Flag = true;
                break;
            }
        }
        System.out.println("Update Courses does contain " + numberToCheck + " is : " + Flag);

    }
}
