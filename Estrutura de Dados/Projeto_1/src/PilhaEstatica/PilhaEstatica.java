package PilhaEstatica;

public class PilhaEstatica implements PilhaInterface{
	
	private Object[] pilha;
	private int topo;
	
	public PilhaEstatica (int Capacidade){
		pilha = new Object[Capacidade];
		topo = 0;
	}

	@Override
	public boolean isEmpty() {
		return topo == 0;
	}

	@Override
	public boolean isFull() {
		return topo == pilha.length;
	}
	
	@Override
	public void push(Object o) throws Exception {
		if (this.isFull()) {
			throw new Exception("Pilha cheia");
		}
		System.out.println("Adicionando " + o);
		pilha[topo++] = o; //insere na pr�xima posi��o livre
		
	}
	
	@Override
	public Object pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Pilha vazia");
			}
			Object o = pilha[--topo]; //remove elemento
			pilha[topo] = null;
			System.out.println("Removendo " + o);
			return o;
	}

	@Override
	public void clear() {
		while (!this.isEmpty()){
			try {
				this.pop();
			} 
			catch (Exception e) { 
				e.printStackTrace();
			}
		}
		
	}
	
	public void percorrer() {
		for (int i = 0; i < topo; i++) {
			System.out.println("Valor: " + pilha[i]);
		}
	}

}
