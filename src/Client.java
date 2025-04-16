import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.print("Shkruaj një mesazh për të dërguar në server: ");
            String message = scanner.nextLine();

        } catch (IOException e) {
            System.out.println("Gabim gjatë lidhjes me serverin: " + e.getMessage());
        }
    }
}