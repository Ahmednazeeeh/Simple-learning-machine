package Json_file;
import org.json.*;



import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class Jsonsearch {
    String y;
    String[]m;
    public void search(int x) {
        Students s1=new Students();
        Courses c=new Courses();
        y=String.valueOf(x);
        try {
            Path filePath = Path.of("Student course details.json"); String content = Files.readString(filePath);
            JSONObject obj = new JSONObject(content);
            if ((x<1)||(x>100))
            {
                System.out.println("Invalid Student ID");
            }
            else {
            if(obj.has(y))
            {
                System.out.print("====================================================================================\n" +
                        "Student Details page\n" +
                        "====================================================================================\n");
                System.out.println(s1.getstudent(x));
                JSONArray m=obj.getJSONArray(y);
                for (int i=0;i<m.length();i++){
                    int z=(int)m.get(i);
                    System.out.println(c.course(z));
                }


            }
            else{
                System.out.print("====================================================================================\n" +
                        "Student Details page\n" +
                        "====================================================================================\n");
                System.out.println(s1.getstudent(x));
                System.out.print("------------------------------------------------------------------------------------\n" +
                        "Enrolled courses.\nThis student hasn't enrolled in any courses\n" +
                        "------------------------------------------------------------------------------------");


            }}

        } catch (Exception e) {
            System.out.print("File not found !");
        }
    }
}
