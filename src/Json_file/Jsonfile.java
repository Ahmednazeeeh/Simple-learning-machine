package Json_file;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.HashSet;

public class Jsonfile {
    JSONObject j1 = new JSONObject();
    public void json(){


        JSONArray list1=new JSONArray();
        list1.put(1);
        list1.put(2);
        list1.put(3);
        list1.put(4);
        JSONArray list2=new JSONArray();
        list2.put(2);
        list2.put(4);
        list2.put(6);
        JSONArray list3=new JSONArray();
        list3.put(1);
        list3.put(3);
        list3.put(5);

        j1.put("1",list1);
        j1.put("2",list2);
        j1.put("3",list3);
        try {
            FileWriter file = new FileWriter("Student course details.json");
            file.write(j1.toString());
            file.close();
        }
        catch (Exception e){
            System.out.print("error creating file !");
        }
    }

}
