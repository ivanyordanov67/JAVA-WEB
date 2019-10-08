import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {

    private int port;
    private ServerSocket server;

    public Server(int port) {
        this.port = port;
    }

    private void readStream(Socket socket) {

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.isEmpty()) {
                    break;
                }
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private byte[] getResponse() {

        StringBuilder builder = new StringBuilder();

        builder.append("HTTP/1.1 200 OK").append(System.lineSeparator())
                .append("Host: localhost:8000").append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("<h1>Hello Ivan!</h1>").append(System.lineSeparator())
                .append("<h1>This is Javache server!</h1>").append(System.lineSeparator());

        return builder.toString().getBytes();

    }

    @Override
    public void run() {

        try {
            this.server = new ServerSocket(port);
            System.out.println("Server is listening on:" + port);

            // Socket clientSocket = null;


            while (true) {
                try {

                    Socket clientSocket = this.server.accept();


                    this.readStream(clientSocket);
                    this.writeStream(clientSocket, getResponse());
                    //this.server.setSoTimeout(3000);

                    clientSocket.close();


                } catch (SocketTimeoutException ignored) {

                }

                //break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeStream(Socket clientSocket, byte[] response) {
        try {
            DataOutputStream dataOutputStream =
                    new DataOutputStream(clientSocket.getOutputStream());

            dataOutputStream.write(response);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}