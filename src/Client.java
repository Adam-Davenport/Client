import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
    public static void main(String [] args)
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 8189);
            OutputStream outStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outStream,true);
            InputStream in = socket.getInputStream();
            Scanner message = new Scanner(in);
            out.println("Connection Initiated");
            System.out.println(message.nextLine());
            Scanner textInput = new Scanner(System.in);
            //Keeps looking for input
            boolean done = false;
            while (!done)
            {

                String lineIn = message.nextLine();
                System.out.println(lineIn);
                String text = textInput.nextLine();
                out.println(text);
            }
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}