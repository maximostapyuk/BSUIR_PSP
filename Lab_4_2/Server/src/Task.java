import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Task {
    public static File file = new File("D:\\BSUIR\\5_term\\ProgSP\\Lab_4_2\\Server\\src\\data.txt");
    public static StringBuilder sb = new StringBuilder();

    public static int DEFAULT_PORT = 8001;//определение порта
    public static String QUIT_CMD = "quit";//определение команды «выход»


    public static void runServer() throws IOException
    {//метод сервера runServer
        DatagramSocket datagramSocket = null;//создание сокета
        try {
            boolean stopFlag = false;//создание флага stopFlag и его инициализация значением false
            byte[] buf = new byte[512];//буфер для приема/передачи дейтаграммы
            datagramSocket = new DatagramSocket(DEFAULT_PORT);//привязка сокета к реальному объекту с портом DEFAULT_PORT
            System.out.println("UDPServer: Сервер запущен " + datagramSocket.getLocalAddress() + ":" + datagramSocket.getLocalPort());

            while(!stopFlag)
            {
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание объекта дейтаграммы для получения данных
                datagramSocket.receive(recvPacket);//помещение полученного содержимого в объект дейтаграммы
                String receivedString = new String(recvPacket.getData()).trim();//извлечение команды из пакета
                if (receivedString.equals(QUIT_CMD))
                {
                    stopFlag = true;//остановка сервера
                    continue;
                }
                System.out.println("UDPServer: числа: " + receivedString);
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());//формирование пакета для отправки                                                                  // дейтаграммы для отсылки данных

                String [] numbers = receivedString.split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                int z = Integer.parseInt(numbers[2]);

                receivedString = "";

                String str = String.format("%.4f", Task.calculate(x,y,z));
                int n = str.getBytes().length;
                System.arraycopy(str.getBytes(), 0, buf, 0, str.getBytes().length);
                sendPacket.setData(buf);//установить массив посылаемых данных
                sendPacket.setLength(n);//установить длину посылаемых данных
                datagramSocket.send(sendPacket);//послать сами данные
                Task.FileRead();
                Task.FileWrite(str, x, y, z);
                for (int j=0; j<buf.length; j++) buf[j] = ' ';
                Task.sb.delete(0, Task.sb.length());
            } // while(server is not stopped)
            System.out.println("UDPServer: остановлен");
        }
        finally {
            if (datagramSocket != null) {
                datagramSocket.close();//закрытие сокета сервера
            }
        }
    }

    public static double calculate(double x,double y, double z){
        return (1+Math.sqrt(Math.sin(x+y)))*Math.pow(x,Math.abs(y))/Math.abs(Math.exp(x)-(2*y/(1+Math.sqrt(x)*Math.pow(y,3))))+Math.sqrt(Math.cos(Math.atan(1/z)));
    }

    public static void FileWrite(String result, int x, int y, int z)
    {
        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст в файл
                if (sb.toString().equals(""))
                    out.print("При х=" + Integer.toString(x) + " при у=" +Integer.toString(y) + " при z=" +
                            Integer.toString(z) + " Ответ=" + result);
                else out.print(sb.toString() + "При х=" + Integer.toString(x) + " при у=" +Integer.toString(y) + " при z=" +
                        Integer.toString(z) + " Ответ=" + result);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void  FileRead()
    {
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
