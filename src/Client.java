import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket soc = new Socket("localhost", 9800);

        BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in));
        //reads data from the console

        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        //reads data from the socket input stream

        PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
        //sends data to the server

        int operation = 0;
        int num1 = 0;
        int num2 = 0;

        do{
            System.out.println("Choose an operation:");
            System.out.println("(1) Addition");
            System.out.println("(2) Subtraction");
            System.out.println("(3) Multiplication");
            System.out.println("(4) Division");
            System.out.println("Enter an option:");

            operation = Integer.parseInt(userInput.readLine());
            //converts user input from string into integer

            System.out.println("Enter first number:");
            num1 = Integer.parseInt(userInput.readLine());

            System.out.println("Enter second number:");
            num2 = Integer.parseInt(userInput.readLine());

            out.println(operation+":"+num1+":"+num2);
            System.out.println("here");

            String answer = in.readLine();
            System.out.println("Answer is:"+ answer);
            System.out.println("");


        }while(true);
    }
}

