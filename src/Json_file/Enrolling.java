package Json_file;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Enrolling {
    JSONObject obj = new JSONObject();
    Courses c=new Courses();
    public void enroll(int z,int x){
        try {
        Path filePath = Path.of("Student course details.json"); String content = Files.readString(filePath);
         obj = new JSONObject(content);
            JSONArray list=new JSONArray();
            String y=String.valueOf(z);
            String b=String.valueOf(x);
            if ((z<1)||(z>100)){                                    //validate Student ID (z is student id )
                System.out.println("Invalid Student ID");
            }
            if ((x<1)||(x>17)){                                     //validate course ID (x is course id)
                System.out.println("Invalid course ID");
            }
            else {
                if (obj.has(y)) {                                   //existing record

                                                                    //same course validation
                    if (c.duplicate(z, x)){
                        System.out.print("Failed to enroll Student can't enroll in the same course twice");
                        }
                   else {
                      if (obj.getJSONArray(y).length()<6) {
                        obj.append(y,x);
                        System.out.print("Student is Enrolled Successfully in the "+c.coursename(x)+" course");
                           }
                      else {                                            //6 courses validation
                        System.out.print("Failed to enroll Student can't enroll in more than 6 courses");
                           }
                   }

                }
                else {                                                  //new record
                    obj.put(y,list.put(x));
                    System.out.print("Student is Enrolled Successfully in the "+c.coursename(x)+" course");
                }


            }
            FileWriter f = new FileWriter("Student course details.json");
            f.write(obj.toString());
            f.close();
    }

        catch (IOException e){
            System.out.print("File not found !");
        }
    }

public void unenroll(int z,int x){
    try {
        Path filePath = Path.of("Student course details.json"); String content = Files.readString(filePath);
        obj = new JSONObject(content);
        String y=String.valueOf(z);
        String e=String.valueOf(x);
        if ((z<1)||(z>100)){                                 //validate Student id
            System.out.println("Invalid Student ID");
        }
        if ((x<1)||(x>17)){                                  //validate course ID
            System.out.println("Invalid course ID");
        }
        else {
            if (obj.has(y)) {                                                     // valdidate student existence
                if (c.duplicate(z, x)){                                          //validate course existence
                        for(int i=0;i<obj.getJSONArray(y).length();i++){        //get index of course
                            if(obj.getJSONArray(y).getInt(i) == x)
                            {
                               obj.getJSONArray(y).remove(i);
                               System.out.println("Unenrolled successfully from the "+c.coursename(x)+" course");
                            }
                        }

                }
                else {

                    System.out.print("Student isn't enrolled in this course !\n");
                }
            }
            else {
                System.out.print("Student isn't enrolled in this course !\n");
            }
        }
        FileWriter f = new FileWriter("Student course details.json");
        f.write(obj.toString());
        f.close();
    }

    catch (IOException e){
        System.out.print("File not found !");
    }
}
}
