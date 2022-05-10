package ps;

import java.util.ArrayList;

public class Memoria {

	private ArrayList<String> binCodeOp;
	private ArrayList<String> hexCodeOriginal;
	
	public Memoria() {
		this.binCodeOp = new ArrayList<String>();
		
		Ferramentas.abrirArquivoEm(binCodeOp, "C:\\Users\\felip\\Documents\\teste.txt");
		hexCodeOriginal = binCodeOp;
		binCodeOp = Ferramentas.traduzirOp(binCodeOp);
	}
		
	public ArrayList<String> getCode() {
		return binCodeOp;
	}
	
	public ArrayList<String> getHexCode() {
		return hexCodeOriginal;
	}
}
