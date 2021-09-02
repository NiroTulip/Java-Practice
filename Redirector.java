
/**
 * Write a description of class Redirector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.csv.*;
import edu.duke.*;

public class Redirector {
    public static void main(String[] args){
        Redirector rd = new Redirector();
        rd.Redirect();
    }   
    
    public void Redirect(){
        String source = "input.csv";
        FileResource fr = new FileResource(source);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
           
        
        String link1 = record.get("From");
        String link2 = record.get("To");
         
        link1 = link1.trim();
        link2 = link2.trim();
        
        String[] sl1 = link1.split("/");
        String[] sl2 = link2.split("/");

        int start = 3;

        String from = "";
        for (int i = start; i<sl1.length; i++)
            from = from + "/" + sl1[i];

        String to = "";
        for (int i = start; i<sl2.length; i++)
            to = to + "/" + sl2[i];

        String result = "if ($uri ~* ^"+ from +"$) {"+ '\n' + "return 301 " + to + ";" + '\n' + "}";
        System.out.println(result);
        }        
    }

}

