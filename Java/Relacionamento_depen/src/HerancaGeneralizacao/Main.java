package HerancaGeneralizacao;

public class Main {
	
	public void main (String[] args){
		Cilindro c = new Cilindro();
		c.setRaio(100);
		c.setId("342");
		//System.out.println(c.toString());
		System.out.println("Volume do Cilindro = "+c.calcularVolume());
		
	}

}
