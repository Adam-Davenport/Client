import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
    public static void main(String [] args)
    {
        //Try Catch to handle any exceptions from sockets
        try
        {
            //Creating a socket on the local host with port 8189
            Socket socket = new Socket("127.0.0.1", 8189);
            //Implementing a way to output text to the server
            OutputStream outStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outStream,true);
            //Input to the client
            InputStream in = socket.getInputStream();
            Scanner message = new Scanner(in);
            //After the connection is initiate the first message is sent.
            out.println("Connection Initiated");
            //Prints the input to the console
            System.out.println(message.nextLine());
            Scanner textInput = new Scanner(System.in);
            //Keeps looking for input
            boolean done = false;
            //Infinite loop currently not able to be closed without specifically entering the exit command
            //Will cause errors
            while (!done)
            {
                //The client waits for the next line from the server
                String lineIn = message.nextLine();
                System.out.println(lineIn);
                //Sending text to the server
                String text = textInput.nextLine();
                out.println(text);

                if(text.equals("exit"))
                {
                    done = true;
                }
            }
            //Closes the client
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}