
public class Geladeira implements FonteDeEnergia {
	
	private int tensao;
	private String padraoDaPlug;
	private boolean ligada;
	private boolean queimada;
	
	public String status(){
		StringBuilder builder = new StringBuilder();
		builder.append("Geladeira ")
		.append(ligada ? "Ligada " : "Desligada ")
		.append(queimada ? "queimada" : "Normal ")
		.append(" Tensao ").append(tensao)
		.append(" Plug da Tomada ").append(padraoDaPlug);
		return builder.toString();
	}
	
	public int getTensao() {
		return tensao;
	}
	public void setTensao(int tensao) {
		this.tensao = tensao;
	}
	public String getPadraoDaPlug() {
		return padraoDaPlug;
	}
	public void setPadraoDaPlug(String padraoDaPlug) {
		this.padraoDaPlug = padraoDaPlug;
	}
	public boolean isLigada() {
		return ligada;
	}

	@Override
	public void plugarNaTomada(Tomada tomada) {
		// TODO Auto-generated method stub
		if (tomada != null && !queimada){
			if(tomada.getTensao() != tensao){
				queimada = true;
			}
			else{
				ligada = true;
			}
		}
		
	}

	@Override
	public void desplugarDaTomada() {
		// TODO Auto-generated method stub
		ligada = false;
		
	}
	

}
