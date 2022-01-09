import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos = null;

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for (int i=0;i<3;i++){
            tickets.add(new Ticket());
        }
        for (int i=0;i<tickets.size();i++){
            tickets.get(i).printNumbers(i+1);
        }

        try {
            System.out.println("сервер запущен...");
            serverSocket = new ServerSocket(2525);
            clientAccepted= serverSocket.accept();
            System.out.println("соединение установлено...");
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());
            //логика взаимодействия с данными клиента
            while (true) {
                Task task=new Task();
                String clientMessageRecieved = (String) sois.readObject();

                task.findCoincidences(tickets, task.parsing(clientMessageRecieved));
                soos.writeObject(task.getInfoCoincidences());
            }
        } catch (Exception e) {
        } finally {
            try {
                sois.close();
                soos.close();
                clientAccepted.close();
                serverSocket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
