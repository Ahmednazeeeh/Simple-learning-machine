package Json_file;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Courses {

    public String course(int x)
    {
        Map<Integer, String> m = new HashMap<>();                  //mapping courses info with id (return course info)
        try {
        Path filePath = Path.of("coursedata.csv");
        String content = Files.readString(filePath);
        String[] data = content.split("\n");
        for (int i = 0; i < data.length; i++) {
            m.put(i+1,data[i]);
        }

    }
    catch (Exception e){
        System.out.print("File not found !");
    }
        return(m.get(x));}

public String coursename(int x) {
    Map<Integer, String> m = new HashMap<>();                  //mapping courses names with id (return course name)
    try {
        Path filePath = Path.of("coursedata.csv");
        String content = Files.readString(filePath);
        String[] data = content.split("\n");
        for (int i = 0; i < data.length; i++) {
            m.put(i + 1, data[i]);
        }
    }
    catch (Exception e) {
        System.out.print("File not found !");
    }
    String[]s = m.get(x).split(",");
    return s[1];

}
public boolean duplicate (int z,int x){
    JSONObject obj = new JSONObject();
    int d=0;
        try {
            String y=String.valueOf(z);
            String b=String.valueOf(x);
            Path filePath = Path.of("Student course details.json");
            String content = Files.readString(filePath);
            obj = new JSONObject(content);

            for (int i=0;i<obj.getJSONArray(y).length();i++){
                if ((obj.getJSONArray(y).getInt(i) == x)){
                     d=1;
                }
            }


        }
        catch (Exception e){System.out.print("File not found");}
        if (d==1){return true;}
    else {return false;}
}

}
