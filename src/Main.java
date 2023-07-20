

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class Hello{
    public static void main(String[] args) {
         System.out.println("Hello World !");
        for (int i = 0; i < 5; i++) {
            System.out.println("gitttt");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int choice = 2;
        System.out.println("I Love my mom");
        Scanner scanner = new Scanner(System.in);
        User a = new User("a", "123");
        User b = new User("b", "456");
        User[] user = new User[2];
        int counter = 0;

        try{
            FileOutputStream file = new FileOutputStream("UserInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(a);
            out.writeObject(b);
            out.close();
            file.close();
            System.out.println("Object saved");
        }catch(IOException Ex){
            System.out.println("File error" + Ex.getMessage());
        }

        try{

            boolean stat = true;
            FileInputStream file = new FileInputStream("UserInfo.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            while (stat){
                User Temp = new User();
                try{
                    Temp = (User) in.readObject();
                }catch(ClassNotFoundException e){

                }

                if(Temp != null){
                    user[counter] = Temp;
                    counter++;
                }else{
                    stat = false;
                }
            }
            in.close();
            file.close();
        }catch(IOException Ex){

        }
        finally {
            for (int i = 0; i < counter; i++){
                System.out.println(user[i]);
            }
        }


        while(choice >= 0){
            System.out.println("Enter your userid:");
            String inputid = scanner.next();
            System.out.println("Enter your password:");
            String inputpwd = scanner.next();
            String combineString = inputid + inputpwd;

            for(int i=0; i < user.length;i++){
                if(user[i].toString().equals(combineString)){
                    System.out.println("Login Succeccfully");
                    choice = -1;
                    break;
                }
            }
            choice--;

        }
    }
}
