package FilaEstatica;

import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception  {
		FilaEstatica fila = new FilaEstatica(10);
		
		/*
		for(int i = 1; i < 7; i++){
			fila.add(i);
		}
		*/
		
		//exercicio 1
		/*
		fila.add(20);
		fila.add(20.8);
		fila.add(20.3);
		fila.add(44.5);
		fila.add(33.33);
		fila.add(20.9);
		
		fila.show();
		
		fila.remove();
		fila.remove();
		
		fila.show();
		
		fila.clear();
		*/
		
		Scanner entrada = new Scanner(System.in);
		
		boolean rodar = true;
		int senha = 1;
		while(rodar){
			int op;
			System.out.println("Hospital do Crack de Joinville.");
			if(senha < 10){
				System.out.println("1 - Tirar Senha.");
			}
			System.out.println("2 - Chamar Senha.");
			System.out.println("3 - Encerrar Programa.");
			System.out.println("ATEN��O S�O PERMITIDOS 10 ATENDIMENTOS POR DIA.");
			System.out.print(": ");
			op = entrada.nextInt();
			if(op == 1 && senha < 10){
				fila.add(senha);
				senha++;
			}
			else if(op == 2){
				fila.remove();
			}
			else{
				rodar = false;
			}
			
		}
		
		
		

	}

}
