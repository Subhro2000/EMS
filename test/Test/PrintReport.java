/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Subhro Ghosh
 */
public class PrintReport
{

    public PrintReport() throws FileNotFoundException
    {
        
        StringBuilder sb = readHtmlFile("html&css/index.html");
//        System.out.println(sb.toString());
        
         record NameValue(String name, String value){}
         NameValue ar[] = new NameValue[8];
         ar[0] = new NameValue("name1","Subhro Ghosh");
         ar[1] = new NameValue("name2","Puja Porel");
         ar[2] = new NameValue("age1","24");
         ar[3] = new NameValue("age2","22");
         ar[4] = new NameValue("avg1","90");
         ar[5] = new NameValue("avg2","80");
         ar[6] = new NameValue("sub1","Java");
         ar[7] = new NameValue("sub2","History");
        
         for (NameValue nv : ar)
        {
            replaceAll(sb, "%"+nv.name+"%", nv.value);
        }
         
         createHtmlFile("html&css/report1.html", sb);
        
        System.out.println(sb.toString());
    }
    

    
    private StringBuilder readHtmlFile(String inputFileName) throws FileNotFoundException
    {
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(new FileInputStream(inputFileName));
        while(sc.hasNextLine())
        {
            sb.append(sc.nextLine());
            sb.append("\n");
        }
        sc.close();
        return sb;
    }
    
    private void replaceAll(StringBuilder sb, String what, String with)
    {
        int p =0;
        while(true)
        {
            p = sb.indexOf(what,p);
            if(p<0)
                break;
            sb.replace(p, p+what.length(), with);
            
            p+= with.length();
            
        }
        
    }
    
    
//    private void replaceAll(StringBuilder sb, String what, String with)
//    {
//        
//        Pattern p = Pattern.compile("("+what+")");
//        Matcher m = p.matcher(sb);
//        while(m.find())
//        {
//            int start = m.start();
//            int end = m.end();
//            String s = sb.substring(start, end);
//            sb.replace(start, end, with);
//        }
//    }
    
    
    private void createHtmlFile(String outputFileName, StringBuilder sb) throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new File(outputFileName));
        String content = sb.toString();
        pw.println(content);
        pw.close();
        
    }
    
    
    public static void main(String[] args) throws FileNotFoundException
    {
        new PrintReport();
    }
}
