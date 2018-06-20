package lco.demo.docker;

import static org.junit.Assert.fail;

import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Test;

public class MainIT
{
    @Test
    public void barIntegrationTest()
    {
        System.out.println("[Integration test works!]");
    }

    @Test
    public void testPostgresIsReachable()
    {
        checkSocketListening("localhost", 5432, "Postgres");
    }

    @Test
    public void testAppIsReachable()
    {
        checkSocketListening("localhost", 8080, "App");
    }

    private static void checkSocketListening(final String hostname, final int port, String label)
    {
        final Socket s = new Socket();
        try
        {
            s.connect(new InetSocketAddress(hostname, port), 5 * 1000);
            System.out.println("[" + label + " is reachable]");
        }
        catch (Exception e)
        {
            System.err.println("[" + label + " not reachable: " + e.getMessage());
            fail();
        }
        finally
        {
            if (!s.isClosed())
            {
                try
                {
                    s.close();
                }
                catch (Exception ignore)
                {
                }
            }
        }
    }
}
