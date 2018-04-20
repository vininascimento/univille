package com.univille.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	private static final long serialVersionUID = 1L;
	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private BufferedWriter bfw;
	private String ip;
	private int porta;
	private String nome;
	private String texto;
	
	public Cliente() throws IOException{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe endere�o de IP, porta e nome.");
		System.out.print("Informe IP: ");
		ip = entrada.nextLine();
		System.out.print("Informe a Porta: ");
		porta = entrada.nextInt();
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
		bfw.write(msg+"\r\n");
		System.out.println(nome + " diz --> " +);
	}
}