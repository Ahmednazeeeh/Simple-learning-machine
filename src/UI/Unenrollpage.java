package UI;

import Json_file.Enrolling;
import Json_file.Jsonsearch;

import java.util.Scanner;

public class Unenrollpage {
    Enrolling e=new Enrolling();
    Homepage h=new Homepage();
    Jsonsearch j=new Jsonsearch();
    public void unenroll(){
        System.out.print("Please enter course id: ");
        Scanner input=new Scanner(System.in);
        while (!input.hasNextInt())          //validate non integer inputs
        {
            System.out.println("Wrong choice! please enter a valid choice");
            char b=input.next().charAt(0);
        }

         int x=input.nextInt();
        e.unenroll(h.z,x);
        j.search(h.z);
        System.out.println("\nPlease choose from the following:\n" +
                "a - Enroll in a course\n" +
                "d - Unenrollfrom an existing course\n" +
                "r - Replacing an existing course\n" +
                "b - Back to the main page\n" +
                "please select the required action:\n");

    }
}
