import java.util.*;
import java.io.*;

public class CountKeyWords {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java Source file: ");
        String fileName = input.nextLine();

        File file = new File(fileName);
        if (file.exists()){
            System.out.println("The number of keywords in " + fileName + " is " + countKeywords(file));
        }else{
            System.out.println("File " + fileName + " does not exist.");
        }
        input.close();
        }
    

    public static int countKeywords(File file)throws Exception{
        //Array of all java keywords
        String[] keyWordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "douible", "else", "enum", "extends", "for", "finally", "final", "float","goto","if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private","protected", "public","return", "short","static","strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};
        
        Set<String> keyWordSet = new HashSet<>(Arrays.asList(keyWordString));
        int count = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String word = input.next();
            //if string stars with // or String dont count
            if (word == "//"){
                input.nextLine();
            }else if(word.contains("\"")){
                do{
                    input.next();
                } while (!word.contains("\""));
            }else if(word.contains("/*")){
                do{
                    input.next();
                } while(!word.contains("*/"));
            }
            else if (keyWordSet.contains(word)){
                    
                    
                count++;
            }
        }
        
        return count;
    }

}