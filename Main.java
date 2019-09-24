public class Main {

    public static void main(String[] args) {

        int port = 8000;
        String name;
        int age;

        Server server = new Server(port);


        server.run();
    }
}