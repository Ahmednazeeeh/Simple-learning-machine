package Fileoperation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Fileoperation {
    String str="";
    String str2="";
   public void readtxt(){
    try
    {
        File f1 = new File("student-data.txt");
        Scanner input = new Scanner(f1);
        while (input.hasNext()){
            String data=input.nextLine().replace("#",",");
            data=data.replace("$","\n");
            String[]newdata=data.split("\n");
            for (int i=0;i<newdata.length;i++)
            {
                if (i==0){
                    str+="id,"+newdata[0]+"\n";
                }
                else {
                    str+=i+","+newdata[i]+"\n";
                }
            }
            System.out.print(str);

        }

    }
    catch(Exception e){
        System.out.print("file not found !");
    }
}
public void writecsvoftxt(){
       try {
           FileWriter file=new FileWriter("student-data.csv");
          file.write(str);
          file.close();
       }
   catch (Exception e){
           System.out.print("error");
   }
}
public void readxml(){
       try {
           File xml = new File("coursedata.xml");
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db = dbf.newDocumentBuilder();
           Document doc = db.parse(xml);
           NodeList list = doc.getElementsByTagName("row");
           System.out.println("id,Course Name,Instructor,Course duration,Course time,Location");   // header row
           for (int i = 0; i < list.getLength(); i++) {
               Node n = list.item(i);
               if (n.getNodeType() == Node.ELEMENT_NODE) {
                   Element element = (Element) n;
                   str2+=(element.getElementsByTagName("id").item(0).getTextContent()+","+
                   element.getElementsByTagName("CourseName").item(0).getTextContent()+","+
                   element.getElementsByTagName("Instructor").item(0).getTextContent()+","+
                  element.getElementsByTagName("CourseDuration").item(0).getTextContent()+","+
                  element.getElementsByTagName("CourseTime").item(0).getTextContent()+","+
                   element.getElementsByTagName("Location").item(0).getTextContent()+"\n");
               }
           }
           System.out.print(str2);
       }

       catch (Exception e){
           System.out.print("error");
       }
}
    public void writecsvofxml(){
        try {
            FileWriter file=new FileWriter("coursedata.csv");
            file.write(str2);
            file.close();
        }
        catch (Exception e){
            System.out.print("error");
        }
    }

}
