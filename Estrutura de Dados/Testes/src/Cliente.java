

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {

    private Socket con;

    public Cliente(Socket socket) {
        this.con = socket;
    }

    
    public void run(){
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
            String msg;
            while (true){
                msg = entrada.readLine();
                if (msg.equals("/Sair")) {
                    System.out.println("Saiu com sucesso!");
                    System.exit(0);
                }
                System.out.println();
                System.out.println(msg);

            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    	Scanner entrada = new Scanner(System.in);
    	try {
        	Socket socket = new Socket("localhost", 2222);
            PrintStream saida = new PrintStream(socket.getOutputStream());
            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine();
            System.out.println("Para sair do chat, digite '/Sair'");
            saida.println(nome.toUpperCase());
            Thread thread = new Cliente(socket);
            thread.start();
            String msg;
            while (true){
                System.out.print("Mensagem --> ");
                msg = entrada.nextLine();
                saida.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	entrada.close();
    }
}
