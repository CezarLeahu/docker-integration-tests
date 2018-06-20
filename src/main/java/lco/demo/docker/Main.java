package lco.demo.docker;

public class Main
{
    public static void main(String[] args)
    {
        while (true)
        {
            try
            {
                System.out.println("[Heartbeat!]");
                Thread.sleep(5 * 1000);
            }
            catch (InterruptedException e)
            {
                System.err.println("Interrupted!");
            }
        }
    }
}
