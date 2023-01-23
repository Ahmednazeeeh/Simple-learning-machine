package UI;

import Fileoperation.Listview;
import Json_file.Courses;
import Json_file.Enrolling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Enrollmentpage {
    Enrolling e=new Enrolling();
    Homepage h=new Homepage();
    public void enroll (){
        Listview l=new Listview();
        System.out.print("""
                Enrollment page
                ====================================================================================================
                """);
l.coursesview();
System.out.print("Please make one of the following:\n" +
        "Enter the course id that you want to enroll the student to\n" +
        "Enter b to go back to the home page\n");
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
       while (input.hasNextInt()){
            int a=input.nextInt();
            e.enroll(h.z,a);                                        //(h.z is the student id )
           System.out.print("\nPlease make one of the following:\n" +
                   "Enter the course id that you want to enroll the student to\n" +
                   "Enter b to go back to the home page\n");
        }
       if (!input.hasNextInt()){
               char b=input.next().charAt(0);
               if (b=='b'){
                   h.homepage();
break;
               }
               else {                             //handle wrong inputs
            System.out.print("Wrong choice! please enter a valid choice \nPlease make one of the following:\n" +
                    "Enter the course id that you want to enroll the student to\n" +
                    "Enter b to go back to the home page\n");}
       }
        }

    }

        }





