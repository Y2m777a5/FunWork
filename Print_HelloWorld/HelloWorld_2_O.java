import java.util.Scanner;
import java.lang.Thread;
public class HelloWorld_2_O{
    public static void main(String [] arg) throws Exception{
        //throws Exception used in method declarations to specify that the method can throw one or more exceptions. 
        //It provides a way for methods to signal that they may encounter exceptional conditions that they are not equipped to handle.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String (like \"HelloWorld\")");
        String str = sc.nextLine();
        String concat = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String temp = ""+ch;
            if(ch == ' '){
                concat+=temp;
                continue;
            }
            System.out.print(concat);
            if((int)ch>=(int)'1' && (int)ch<=(int)'9'){
                for(int j = (int)'1'; j<((int)ch)+1; j++){
                    Thread.sleep(100);
                    //Thread class contains the sleep() method. Thread.sleep() pauses the current thread’s execution.
                    //For more:-[ https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/ ]
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            else if((int)ch>=(int)'A' && (int)ch<=(int)'Z'){
                for(int j = (int)'A'; j<((int)ch)+1; j++){
                    Thread.sleep(100);
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            else{
                for(int j = (int)'a'; j<((int)ch)+1; j++){
                    Thread.sleep(100);
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            concat+=temp;
            System.out.println();
            sc.close();
        }
    }
}