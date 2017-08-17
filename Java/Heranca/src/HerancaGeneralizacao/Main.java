package HerancaGeneralizacao;

public class Main {
	
	public static void main (String[] args){
		//Cilindro
		Cilindro c = new Cilindro();
		c.setRaio(100);
		c.setAltura(100);
		//c.setId("342");
		//System.out.println(c.toString());
		System.out.println("Volume do Cilindro = "+c.calcularVolume());
		
		//Cubo
		Cubo cb = new Cubo();
		cb.setAresta(14);
		//cb.setId("123");
		//System.out.println(c.toString());
		System.out.println("Volume do Cubo = "+cb.calcularVolume());
		
		//Piramide
		Piramide p = new Piramide();
		p.setLado(10);
		p.setAltura(10);
		//p.setId("123");
		//System.out.println(c.toString());
		System.out.println("Volume da Piramide = "+p.calcularVolume());
		
		//Cone
		Cone cn = new Cone();
		cn.setRaio(10);
		cn.setAltura(10);
		//cn.setId("123");
		//System.out.println(c.toString());
		System.out.println("Volume do Cone = "+cn.calcularVolume());
	}

}
