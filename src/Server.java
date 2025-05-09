import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class Server {
    public static void main(String[] args) {
        int port = 4000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveri eshte duke pritur ne portin " + port + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Klienti u lidh: " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String cipherText;
            while ((cipherText = reader.readLine()) != null) {
                System.out.println("Mesazhi i enkriptuar: " + cipherText);
                System.out.println("-------------------------------------------------");

                // dekriptimi
                String decryptedMessage = DES_Util.decrypt(cipherText);
                System.out.println("Mesazhi i dekriptuar: " + decryptedMessage);
                System.out.println("-------------------------------------------------");

                if (decryptedMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Klienti ka kërkuar mbylljen e lidhjes.");

                    // Dërgoni konfirmim përpara se të mbyllni
                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        writer.write(DES_Util.encrypt("exit-confirm"));
                        writer.newLine();
                        writer.flush();
                    } catch (Exception e) {
                        System.err.println("Gabim në dërgimin e konfirmimit: " + e.getMessage());
                    }

                    break;
                }
            }

            socket.close();
            System.out.println("Lidhja u mbyll.");
        } catch (Exception e) {
            System.err.println("Gabim ne server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}