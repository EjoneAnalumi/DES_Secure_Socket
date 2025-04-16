import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class Server {
    private static final String SECRET_KEY = "12345678";
    private static final String ALGORITHM = "DES";

    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("🔐 Serveri eshte duke pritur ne portin " + port + "...");

            Socket socket = serverSocket.accept();
            System.out.println("✅ Klienti u lidh: " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            String encryptedLine;
            while ((encryptedLine = reader.readLine()) != null) {
                System.out.println("🔒 Mesazhi i enkriptuar (Base64): " + encryptedLine);

                // dekriptimi
                byte[] decodedBytes = Base64.getDecoder().decode(encryptedLine);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                String decryptedMessage = new String(decryptedBytes);

                System.out.println("📨 Mesazhi i dekriptuar: " + decryptedMessage);
                System.out.println("-------------------------------------------------");
            }

        }
