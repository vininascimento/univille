package PilhaEstatica;

public interface PilhaInterface {
	public void push(Object o) throws Exception;
	public Object pop() throws Exception;

	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	
}