import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 5000;

        try (Socket socket = new Socket(serverIP, port)) {
            System.out.println("I lidhur me serverin në " + serverIP + ":" + port);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Shkruaj mesazhin: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String encryptedMessage = DES_Util.encrypt(message);
                System.out.println("Mesazhi i enkriptuar: " + encryptedMessage);
                writer.write(encryptedMessage);
                writer.newLine();
                writer.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}