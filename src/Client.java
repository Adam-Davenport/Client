import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
	private static DataInputStream in;
	private static DataOutputStream out;
	private static Socket socket;

    public static void main(String [] args)
    {
        //Try Catch to handle any exceptions from sockets
        try
        {
            //Creating a socket on the local host with port 8189
            socket = new Socket("127.0.0.1", 8189);
            //Implementing a way to output text to the server
            out = new DataOutputStream(socket.getOutputStream());
            //Input to the client
            in = new DataInputStream(socket.getInputStream());
            //After the connection is initiate the first message is sent.
            out.writeUTF("Connection Initiated");
			System.out.println("Message Sent");
            //Prints the input to the console
            System.out.println(in.readUTF());
            Scanner textInput = new Scanner(System.in);
            //Keeps looking for input
            boolean done = false;
            //Infinite loop currently not able to be closed without specifically entering the exit command
            //Will cause errors
            while (!done)
            {
                //The client waits for the next line from the server
                String lineIn = in.readUTF();
                System.out.println(lineIn);
                //Sending text to the server
                String text = textInput.nextLine();
                out.writeUTF(text);

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