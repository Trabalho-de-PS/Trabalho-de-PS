package ps;

import java.util.ArrayList;

public class ULA {

	private ArrayList<String> binCode;
	private ArrayList<String> binInstructions;
	private RegistradorGeral T;
	private Acumulador A;
	
	public ULA() {
		this.binCode = new ArrayList<String>();
		this.binInstructions = new ArrayList<String>();
		this.T = new RegistradorGeral();
		this.A = new Acumulador();
		
		Ferramentas.abrirArquivoEm(binInstructions, "C:\\Users\\felip\\Documents\\instrucoes.txt");
		binInstructions = Ferramentas.traduzirOp(binInstructions);
		
		T.setRegistrador("0", 10);
		T.setRegistrador("1", 10);
	}
	
	public void getRegistradorGeral() {
		T.getRegistradorTotal();
	}
	
	public void stepCode(String key, ArrayList<String> code) {
		switch(key) {
			case "00011000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r4 = binCode.get(0);
				add(r4);
				break;
				
			case "10010000":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContator());
				String r1 = binCode.get(0);
				String r2 = binCode.get(1);
				addr(r1, r2);
				break;
				
			case "01000000":
				and();
				break;
				
			case "10110100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContator());
				String r3 = binCode.get(0);
				clear(r3);
				break;
				
			case "00101000":
				comp();
				break;
				
			case "10100000":
				compr();
				break;
				
			case "00100100":
				div();
				break;
				
			case "10011100":
				divr();
				break;
				
			case "00111100":
				j();
				break;
				
			case "00110000":
				jeq();
				break;
				
			case "00110100":
				jgt();
				break;
				
			case "00111000":
				jlt();
				break;
				
			case "01001000":
				jsub();
				break;
				
			case "00000000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r6 = binCode.get(0);
				lda(r6);
				break;
				
			case "01101000":
				ldb();
				break;
				
			case "01010000":
				ldch();
				break;
				
			case "00001000":
				ldl();
				break;
				
			case "01101100":
				lds();
				break;
				
			case "01110100":
				ldt();
				break;
				
			case "00000100":
				ldx();
				break;
				
			case "00100000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r8 = binCode.get(0);
				mul(r8);
				break;
				
			case "10011000":
				mulr();
				break;
				
			case "01000100":
				or();
				break;
				
			case "10101100":
				rmo();
				break;
				
			case "01001100":
				rsub();
				break;
				
			case "10100100":
				shiftl();
				break;
				
			case "10101000":
				shiftr();
				break;
				
			case "00001100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r5 = binCode.get(0);
				sta(r5);
				break;
				
			case "01111000":
				stb();
				break;
				
			case "01010100":
				stch();
				break;
				
			case "00010100":
				stl();
				break;
				
			case "01111100":
				sts();
				break;
				
			case "10000100":
				stt();
				break;
				
			case "00010000":
				stx();
				break;
				
			case "00011100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r7 = binCode.get(0);
				sub(r7);
				break;
				
			case "10010100":
				subr();
				break;
				
			case "00101100":
				tix();
				break;
				
			case "10111000":
				tixr();
				break;
				
			case "11111111":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContator());
				String r9 = binCode.get(0);
				write(r9);
				break;
		}
	}
	
	public ArrayList<String> getInstructions() {
		return this.binInstructions;
	}
	
	public void add(String r1) {
		int soma = 0;
		soma = A.getAcumulador() + Integer.parseInt(r1);
		A.setAcumulador(soma);
	}
	public void addr(String r1, String r2) {
		int soma = 0;
		soma = T.getValorDoRegistrador(r1) + T.getValorDoRegistrador(r2);
		T.setRegistrador(r2, soma);
	}
	public void and() {
		
	}
	public void clear(String r1) {
		int zero = 0;
		T.setRegistrador(r1, zero);
	}
	public void comp() {
	
	}
	public void compr() {
	
	}
	public void div() {
	
	}
	public void divr() {
	
	}
	public void j() {
	
	}
	public void jeq() {
	
	}
	public void jgt() {
	
	}
	public void jlt() {
	
	}
	public void jsub() {
	
	}
	public void lda(String r1) {
		A.setAcumulador(Integer.parseInt(r1));
	}
	public void ldb() {
	
	}
	public void ldch() {
	
	}
	public void ldl() {
	
	}
	public void lds() {
	
	}
	public void ldt() {
	
	}
	public void ldx() {
	
	}
	public void mul(String r1) {
		int multiplicacao = 0;
		multiplicacao = A.getAcumulador() * Integer.parseInt(r1);
		A.setAcumulador(multiplicacao);
	}
	public void mulr() {
	
	}
	public void or() {
	
	}
	public void rmo() {
	
	}
	public void rsub() {
	
	}
	public void shiftl() {
	
	}
	public void shiftr() {
	
	}
	public void sta(String r1) {
		T.setRegistrador(r1, A.getAcumulador());
	}
	public void stb() {
	
	}
	public void stch() {
	
	}
	public void stl() {
	
	}
	public void sts() {
	
	}
	public void stt() {
	
	}
	public void stx() {
	
	}
	public void sub(String r1) {
		int subtracao = 0;
		subtracao = A.getAcumulador() - Integer.parseInt(r1);
		A.setAcumulador(subtracao);
	}
	public void subr() {
	
	}
	public void tix() {
	
	}
	public void tixr() {
	
	}
	public void write(String r1) {
		A.setAcumulador(T.getValorDoRegistrador(r1));
	}
}
