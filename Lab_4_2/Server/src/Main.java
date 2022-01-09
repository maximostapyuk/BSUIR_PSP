import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {//метод main
        try
        {
            Task.runServer();//вызов метода класса runServer
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
