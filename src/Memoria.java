package ps;

import java.util.ArrayList;

public class Memoria {

	private String[] memoria;
	private ArrayList<String> binCodeOp;
	private ArrayList<String> hexCodeOriginal;
	
	public Memoria() {
		this.memoria = new String[1024];
		this.binCodeOp = new ArrayList<String>();
		
		Ferramentas.abrirArquivoEm(binCodeOp, "arquivos/saidaMontador.asm");
		hexCodeOriginal = binCodeOp;
		binCodeOp = Ferramentas.traduzirOp(binCodeOp);
	}
		
	public ArrayList<String> getCode() {
		return binCodeOp;
	}
	
	public ArrayList<String> getHexCode() {
		return hexCodeOriginal;
	}
	
	public void setMemoria(String posicao, int valor) {
		int numero = Integer.parseInt(posicao);
		String string = Integer.toString(valor);
		memoria[numero] = string;
	}
	
	public int getMemoria(String posicao) {
		int numero = Integer.parseInt(posicao);
		return Integer.parseInt(memoria[numero]);
	}
	
	public void getMemoriaTotal() {
		int i = 0;
		while(i < memoria.length) {
			System.out.println(memoria[i]);
			i++;
		}
	}
}
