package Json_file;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Students {

        public String getstudent(int x){                     //mapping student info with id
            Map<Integer, String> s = new HashMap<>();
            try {
                Path filePath = Path.of("student-data.csv"); String content = Files.readString(filePath);
                String[] data1 = content.split("\n");
                for (int i = 1; i < data1.length; i++) {
                    String []data2=data1[i].split(",");
                    s.put(i,"Name: "+data2[1]+"          "+"Grade: "+data2[2]+"               "+"Email: "+data2[3]);
                }
            }
            catch (Exception e){
                System.out.print("File not found !");
            }

            return(s.get(x));
        }
    }
