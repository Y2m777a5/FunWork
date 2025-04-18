import java.util.Scanner;
import java.lang.Thread;
public class HelloWorld_3_O{
    public static void main(String [] arg) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String (like \"HelloWorld\")");
        String str = sc.nextLine();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ' '){
                System.out.print(ch);
                continue;
            }
            if((int)ch>=(int)'1' && (int)ch<=(int)'9'){
                for(int j = (int)'1'; j<=(int)ch; j++){
                    Thread.sleep(50);
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            else if((int)ch>=(int)'A' && (int)ch<=(int)'Z'){
                for(int j = (int)'A'; j<=(int)ch; j++){
                    Thread.sleep(50);
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            else{
                for(int j = (int)'a'; j<=(int)ch; j++){
                    Thread.sleep(50);
                    System.out.print((char)j);
                    System.out.print('\b');
                }
            }
            System.out.print(ch);
            sc.close();
        }
    }
}