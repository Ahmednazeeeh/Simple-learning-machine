package UI;

import Fileoperation.Listview;
import Json_file.Jsonsearch;

import java.util.Scanner;

public class Homepage {
    public static int z;
    public void homepage(){
        try {
            Listview l = new Listview();
            Jsonsearch j1 = new Jsonsearch();
            System.out.print("Welcome to LMS\n" +
                    "created by {Ahmed Nazih Ahmed}\n" +
                    "====================================================================================\n" +
                    "Home page\n" +
                    "====================================================================================\n");
            l.studentview();
          do{  System.out.println("Please select the required student");
            Scanner input = new Scanner(System.in);
            z = input.nextInt();
              j1.search(z);}
          while ((z>100)||(z<1));
            System.out.println("\n------------------------------------------------------------------------------------");
            System.out.println("Please choose from the following:\n" +
                    "a - Enroll in a course\n" +
                    "d - Unenroll from an existing course\n" +
                    "r - Replacing an existing course\n" +
                    "b - Back to the main page\n" +
                    "please select the required action:\n");
        }catch (Exception e)
        {System.out.print("please enter a valid input !");

        }
    }
}
