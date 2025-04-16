import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String SECRET_KEY = "12345678";
    private static final String ALGORITHM = "DES";

    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("🔐 Serveri eshte duke pritur ne portin " + port + "...");

            Socket socket = serverSocket.accept();
            System.out.println("✅ Klienti u lidh: " + socket.getInetAddress());


        }
