import Json_file.*;
import UI.Enrollmentpage;
import UI.Homepage;
import UI.Replacementpage;
import UI.Unenrollpage;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         //Fileoperation.Fileoperation f1=new Fileoperation.Fileoperation();
         //f1.readtxt();                          //File handling from txt to csv
         //f1.writecsvoftxt();
         //f1.readxml();                          //File handling from xml to csv
         //f1.writecsvofxml();
         //Jsonfile j=new Jsonfile();             //create Json file
         //j.json();
       try {
char y;
        Homepage h=new Homepage();
        h.homepage();
        Scanner input=new Scanner(System.in);

        do {   Path filePath = Path.of("Student course details.json");
            String content = Files.readString(filePath);
            JSONObject obj = new JSONObject(content);
            String q=String.valueOf(Homepage.z);
            y=input.next().charAt(0);
            switch (y) {
                case 'a' -> {
                    Enrollmentpage e = new Enrollmentpage();
                    e.enroll();
                }
                case 'd' -> {
                    if ((obj.has(q))&&((obj.getJSONArray(q).length() > 1)))
                    {
                    Unenrollpage u = new Unenrollpage();
                    u.unenroll();}
                    else {
                        System.out.print("""
                                Faild to unenroll: The student has only one or no courses to unenroll from
                                Please choose from the following:
                                a - Enroll in a course
                                d - Unenrollfrom an existing course
                                r - Replacing an existing course
                                b - Back to the main page
                                please select the required action:\s
                                """);
                    }

                }
                case 'r' -> {
                    if ((obj.has(q))&&((obj.getJSONArray(q).length() >= 1))){
                    Replacementpage r = new Replacementpage();
                    r.replace();}
                    else {
                        System.out.print("""
                                Faild to replace as the student hasn't enrolled in any course yet
                                Please choose from the following:
                                a - Enroll in a course
                                d - Unenrollfrom an existing course
                                r - Replacing an existing course
                                b - Back to the main page
                                please select the required action:\s
                                """);
                    }
                }
                case 'b' -> h.homepage();
                default -> {
                    System.out.print("invalid input\n");
                    h.homepage();
                }
            }
        } while (input.hasNext());                          //keep program running

    }catch (Exception e){
        System.out.print("File not found !");
        }
}}

