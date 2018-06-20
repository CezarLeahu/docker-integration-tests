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
        final Socket s = new Socket();
        try
        {
            s.connect(new InetSocketAddress("localhost", 5432), 5 * 1000);
            System.out.println("[Postgres is reachable]");
        }
        catch (Exception e)
        {
            System.err.println("Postgres not reachable: " + e.getMessage());
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
