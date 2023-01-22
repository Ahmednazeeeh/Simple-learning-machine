package Fileoperation;

import java.nio.file.Files;
import java.nio.file.Path;

public class Listview {
    public void studentview(){

        try {
            Path filePath = Path.of("student-data.csv"); String content = Files.readString(filePath);
            String [] data=content.split("\n");
            for (int i=0;i<data.length;i++) {
                String[] d = data[i].split(",");
                if (i == 0) {
                    System.out.print("-------------------------------\n"+
                            "Current Student List\n"+
                            "-------------------------------\n");
                    System.out.println("id      name             Grade          email                                    address" +
                            "                           region                          country");
                }
                else {                          //address must be handled because it can be more than one segment(one,two or three) separated by ","

                    if (d.length==7) {
                        System.out.print(String.format("%-5s %-20s %-5s %-40s %-40s %-30s %-20s",d[0],d[1],d[2],d[3],d[4],d[5],d[6])+"\n");
                    }
                    if (d.length==8) {
                        System.out.print(String.format("%-5s %-20s %-5s %-40s %-40s %-30s %-20s",d[0],d[1],d[2],d[3],d[4]+d[5],d[6],d[7])+"\n");
                    }
                    if (d.length==9) {
                        System.out.print(String.format("%-5s %-20s %-5s %-40s %-40s %-30s %-20s",d[0],d[1],d[2],d[3],d[4]+d[5]+d[6],d[7],d[8])+"\n");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.print("File not found !");
        }
    }

    public void coursesview(){

        try {
            Path filePath = Path.of("coursedata.csv"); String content = Files.readString(filePath);
            String [] data=content.split("\n");
            System.out.print("id,   Course Name,                        Instructor,         Course duration,   Course time,  Location \n" +
                    "----------------------------------------------------------------------------------------------------\n");
            for (int i=0;i<data.length;i++) {
                String[] d = data[i].split(",");
                        System.out.print(String.format("%-5s %-35s %-25s %-15s %-10s %-10s",d[0],d[1],d[2]+d[3],d[4],d[5],d[6])+"\n");
                            }
            }

        catch (Exception e){
            System.out.print("File not found !");
        }
    }
}
