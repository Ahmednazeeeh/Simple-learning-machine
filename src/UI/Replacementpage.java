package UI;

import Json_file.Courses;
import Json_file.Enrolling;
import Json_file.Jsonsearch;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Replacementpage {
    public void replace() {
        try {
            Homepage h = new Homepage();
            Enrolling e=new Enrolling();
            Courses c=new Courses();
            Jsonsearch j=new Jsonsearch();
            System.out.print("Please enter the course id to be replaced: ");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            e.unenroll(h.z,x);
            Path filePath = Path.of("Student course details.json");
            String content = Files.readString(filePath);
            JSONObject obj = new JSONObject(content);
            System.out.print("Available courses\n" +
                    "====================================================================================================\n" +
                    "id,     Course Name,                Instructor,         Course duration,  Course time,    Location \n" +
                    "------------------------------------------------------------------------------------------------------\n");
            String y=String.valueOf(h.z);
            JSONArray m=obj.getJSONArray(y);
            for (int i=0;i<m.length();i++) {
                int z = (int) m.get(i);
                    String []ac=c.course(z).split(",");
                    System.out.print(String.format("%-5s %-30s %-25s %-15s %-10s %-10s",ac[0],ac[1],ac[2]+ac[3],ac[4],ac[5],ac[6])+"\n");
            }
            System.out.print("Please enter the required course id to replace: ");
            int a=input.nextInt();
            e.enroll(h.z,a);
            System.out.print("\n");
            j.search(h.z);
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Please choose from the following:\n" +
                    "a - Enroll in a course\n" +
                    "d - Unenrollfrom an existing course\n" +
                    "r - Replacing an existing course\n" +
                    "b - Back to the main page\n" +
                    "please select the required action:\n");


        }catch (Exception e){
            System.out.print("invalid input");
        }
    }
}
