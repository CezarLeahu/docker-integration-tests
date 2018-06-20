package lco.demo.docker;

import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Up and running!");
        while (true)
        {
            final Socket s = server.accept();
            System.out.println("[New connection!]");
            s.getOutputStream().write("Bla!".getBytes());
            s.getOutputStream().flush();
            s.close();
            Thread.sleep(5 * 1000);
        }
    }
}
