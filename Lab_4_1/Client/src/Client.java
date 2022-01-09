import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String clientMessage = "next";

            System.out.println("подключение к серверу...");
            Socket clientSocket = new Socket("127.0.0.1",2525);
            System.out.println("соединение установлено...");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos=new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());

            while (clientMessage.equals("next")){
                //логика взаимодействия
                String number=new String();
                System.out.println("Введите 10 чисел для отправки на сервер (Обязательное условие: в билете не может быть двух одинаковых чисел).");
                for(int i=0;i<10;i++){
                    System.out.print("Введите "+(i+1) + " число: ");
                    number=number + sc.nextLine()+" ";
                }
                System.out.print("Вы ввели числа: "+number);
                coos.writeObject(number);

                System.out.println();
                System.out.println(cois.readObject());


                System.out.print("Чтобы продолжить испытывать удачу введите next: ");
                clientMessage = stdin.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
