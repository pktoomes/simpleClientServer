import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) throws Exception {
        // write your code here
        System.out.println("Server Started");
        ServerSocket ss = new ServerSocket(9800);
        System.out.println("Waiting for client...");
        Socket soc = ss.accept();
        System.out.println("Connection established");
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        //read data from socket input stream
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        //auto prints to output stream
        while (true) {
            String[] str = in.readLine().split(":", 0);


            int operation = Integer.parseInt(str[0]);
            int num1 = Integer.parseInt(str[1]);
            int num2 = Integer.parseInt(str[2]);
            String result = "";
            int flag = 0;

            switch (operation) {
                case 1:
                    result = "Addition is: " + (num1 + num2);
                    break;
                case 2:
                    result = "Subtraction is: " + (num1 - num2);
                    break;
                case 3:
                    result = "Multiplication is: " + (num1 * num2);
                    break;
                case 4:
                    result = "Division is: " + (num1 / num2);
                    break;
                case 5:
                    flag = 1;
                    break;
                default:
                    break;
            }

            if (flag == 1) {
                break;
            }

            out.println(result);

        }
        System.out.println("Server Ended");
    }

}

