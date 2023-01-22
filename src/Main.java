import Fileoperation.Listview;
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
        // Fileoperation.Fileoperation f1=new Fileoperation.Fileoperation();
        // f1.readtxt();                          //File handling from txt to csv
        // f1.writecsvoftxt();
        //  f1.readxml();                          //File handling from xml to csv
        //   f1.writecsvofxml();*/
        //  Jsonfile j=new Jsonfile();             //create Json file
        // j.json();

char y;
        Homepage h=new Homepage();
        h.homepage();
        Scanner input=new Scanner(System.in);
        do {   y=input.next().charAt(0);
            switch (y) {
                case 'a' -> {
                    Enrollmentpage e = new Enrollmentpage();
                    e.enroll();
                }
                case 'd' -> {
                    Unenrollpage u = new Unenrollpage();
                    u.unenroll();
                }
                case 'r' -> {
                    Replacementpage r = new Replacementpage();
                    r.replace();
                }
                case 'b' -> h.homepage();
                default -> {
                    System.out.print("invalid input\n");
                    h.homepage();
                }
            }
        } while (input.hasNext());                          //keep program running

    }}

