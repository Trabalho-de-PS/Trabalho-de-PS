package ps;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Memoria extends GUI {

	private String[] memoria;
	private ArrayList<String> binCodeOp;
	private ArrayList<String> hexCodeOriginal;
        GUI gui = new GUI();
	
	public Memoria() {
		this.memoria = new String[1024];
		this.binCodeOp = new ArrayList<String>();
		this.resetMemoria();
		Ferramentas.abrirArquivoEm(binCodeOp, "arquivos/teste.txt");
		hexCodeOriginal = binCodeOp;
		binCodeOp = Ferramentas.traduzirOp(binCodeOp);
                
                
	}
        
        public void resetMemoria(){
            for(int i = 0 ; i < memoria.length ; i++){
                setMemoria(Integer.toString(i), 0);
                }
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
