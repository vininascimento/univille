package Depen;

public class CarroView {
	public void exibir(Carro carro){
		System.out.println("Placa: "+ carro.getPlaca());
		System.out.println("Cidade: "+ carro.getCidade());
		System.out.println("Modelo: "+ carro.getModelo());
		System.out.println("Marca: "+ carro.getMarca());
		System.out.println("Ano: "+ carro.getAno());
		System.out.println("Cor: "+ carro.getCor());
		System.out.println("Quilometragem: "+ carro.getQuilometragem());
		System.out.println("Valor R$: "+ carro.getValor());
		
	}

}
