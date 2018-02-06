import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) throws Exception {
        // write your code here
        ServerSocket ss = new ServerSocket(9800);
        Socket soc = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        //read data from socket input stream
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        //auto prints to output stream
        while(true){
            String str[] = in.readLine().split(":");

            int operation = Integer.parseInt(str[0]);
            int num1 = Integer.parseInt(str[1]);
            int num2 = Integer.parseInt(str[2]);
            String result = "";

            switch(operation){
                case 1: result = "Addition is: "+(num1+num2);break;
                case 2: result = "Subtraction is: "+(num1-num2);break;
                case 3: result = "Multiplication is: "+(num1*num2);break;
                case 4: result = "Division is: "+(num1/num2);break;
                default:break;
            }
            out.println(result);

        }
    }
}

