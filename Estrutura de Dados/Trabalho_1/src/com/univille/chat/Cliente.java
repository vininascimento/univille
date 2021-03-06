package com.univille.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Cliente extends Thread {
	
	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private static BufferedWriter bfw;
	private String ip;
	private int porta;
	private String nome;
	private String mensagem;
	private StringBuilder texto;
	
	public Cliente() throws IOException{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe endere�o de IP, porta e nome.");
		/*System.out.print("Informe IP: ");
		ip = entrada.nextLine();
		System.out.print("Informe a Porta: ");
		porta = entrada.nextInt();*/
		ip = "localhost";
		porta = 8080;
		System.out.print("Informe o seu nome: ");
		nome = entrada.nextLine();
		
		entrada.close();
		
	}
	
	public void conectar() throws IOException{
		socket = new Socket(ip, porta);
		ou = socket.getOutputStream();
		ouw = new OutputStreamWriter(ou);
		bfw = new BufferedWriter(ouw);
		bfw.write(nome+"\r\n");
		bfw.flush();
	}
	
	public void enviarMensagem(String msg) throws IOException{
		if(msg.equals("Sair")){
			bfw.write("Desconectado \r\n");
			texto.append("Desconectado \r\n");
		}
		else{
			bfw.write(msg+"\r\n");
			texto.append(nome + " diz --> " + mensagem + "\r\n");
		}
		bfw.flush();
		mensagem = "";
		
	}
	
	public void escutar() throws IOException{
		InputStream in = socket.getInputStream();
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(inr);
		String msg = "";
		System.out.println("1");
		
		while(!"Sair".equalsIgnoreCase(msg)){
			System.out.println("2");
			if(bfr.ready()){
				msg = bfr.readLine();
				
			}
			if(msg.equals("Sair")){
				texto.append("Servidor Saiu! \r\n");
			}
			else{
				System.out.println("3");
				texto.append(msg+"\r\n");
			}
		}
		
	}
	
	public void digitarMensagem() throws IOException{
		Scanner entrada = new Scanner(System.in);
		while(mensagem != "/Sair"){
			System.out.print(": ");
			mensagem = entrada.nextLine().toString();
			try{
				enviarMensagem(mensagem);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		entrada.close();
	}
	
	public void sair() throws IOException{
		
		enviarMensagem("Sair");
		bfw.close();
		ouw.close();
		ou.close();
		socket.close();
	}
	
	public static void main(String[] args) throws IOException{
		
		Cliente app = new Cliente();
		app.conectar();
		app.escutar();
		System.out.println("Executou o escutar");
		app.digitarMensagem();
		
		
	}
}
