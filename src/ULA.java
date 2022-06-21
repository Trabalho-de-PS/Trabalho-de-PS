package ps;

import java.util.ArrayList;

public class ULA {

	private ArrayList<String> binCode;
	private ArrayList<String> binInstructions;
	private Registrador A;
	private Registrador X;
	private Registrador L;
	private Registrador B;
	private Registrador S;
	private Registrador T;
	private Registrador SW;
	private Memoria memoria;
	private int address;

	public ULA(Memoria memoria) {
		this.binCode = new ArrayList<String>();
		this.binInstructions = new ArrayList<String>();
		this.A = new Registrador();
		this.X = new Registrador();
		this.L = new Registrador();
		this.B = new Registrador();
		this.S = new Registrador();
		this.T = new Registrador();
		this.SW = new Registrador();
		this.memoria = memoria;

		Ferramentas.abrirArquivoEm(binInstructions, "arquivos/opcodes.txt");
		binInstructions = Ferramentas.traduzirOp(binInstructions);
	}

	public void adressing(String r1, String key) {
		switch (key) {
		//Enderecamento Direto
			case "110010":
				address = ContadorInstrucoes.getContador() + (address + 1);
				break;
			case "110100":
				address = B.getConteudo() + address;
				break;
			case "111000":
				address = X.getConteudo() + address;
				break;
			case "111001":
				address = X.getConteudo() + address;
				break;
			case "111010":
				address = X.getConteudo() + ContadorInstrucoes.getContador();
				break;
			case "111100":
				address = X.getConteudo() + B.getConteudo();
				break;
			case "001000":
				address = X.getConteudo() + address;
				break;
		//Enderecamento indireto
			case "100000":
				address = Integer.parseInt(r1);
				break;
			case "100001":
				address = Integer.parseInt(r1);
				break;
			case "100010":
				address = Integer.parseInt(r1);
				break;
			case "100100":
				address = Integer.parseInt(r1);
				break;
		}
 	}

	public void stepCode(String key, ArrayList<String> code) {
		String r1, r2;
		switch (key) {
			case "00011000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				add(r1);
				break;

			case "10010000":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				addr(r1, r2);
				break;

			case "01000000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				and(r1);
				break;

			case "10110100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				clear(r1);
				break;

			case "00101000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				comp(r1);
				break;

			case "10100000":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				compr(r1, r2);
				break;

			case "00100100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				div(r1);
				break;

			case "10011100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				divr(r1, r2);
				break;

			case "00111100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				j(r1);
				break;

			case "00110000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				jeq(r1);
				break;

			case "00110100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				jgt(r1);
				break;

			case "00111000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				jlt(r1);
				break;

			case "01001000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				jsub(r1);
				break;

			case "00000000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				lda(r1);
				break;

			case "01101000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				ldb(r1);
				break;

			case "01010000":
				ldch();
				break;

			case "00001000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				ldl(r1);
				break;

			case "01101100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				lds(r1);
				break;

			case "01110100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				ldt(r1);
				break;

			case "00000100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				ldx(r1);
				break;

			case "00100000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				mul(r1);
				break;

			case "10011000":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				mulr(r1, r2);
				break;

			case "01000100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				or(r1);
				break;

			case "10101100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				rmo(r1, r2);
				break;

			case "01001100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				rsub(r1);
				break;

			case "10100100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				shiftl(r1, r2);
				break;

			case "10101000":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				shiftr(r1, r2);
				break;

			case "00001100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				sta(r1);
				break;

			case "01111000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				stb(r1);
				break;

			case "01010100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				stch(r1);
				break;

			case "00010100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                stl(r1);
				break;

			case "01111100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                sts(r1);
				break;

			case "10000100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                stt(r1);
				break;

			case "00010000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                stx(r1);
				break;

			case "00011100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				sub(r1);
				break;

			case "10010100":
				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				r2 = binCode.get(1);
				subr(r1, r2);
				break;

			case "00101100":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                tix(r1);
				break;

			case "10111000":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
                r1 = binCode.get(0);
                tixr(r1);
				break;
		}
	}

	public ArrayList<String> getInstructions() {
		return this.binInstructions;
	}

	public void add(String r1) { // A <-- (A) + (m..m+2)
		int soma = 0;
		soma = A.getConteudo() + Integer.parseInt(r1);
		A.setConteudo(soma);
	}

	public void addr(String r1, String r2) { // r2 <-- (r2) + (r1)
		int soma = 0;
		soma += memoria.getMemoria(r1);
		soma += memoria.getMemoria(r2);
		memoria.setMemoria(r2, soma);
	}

	public void and(String r1) { // A <-- (A) & (m..m+2)
		A.setConteudo(A.getConteudo() & Integer.parseInt(r1));
	}

	public void clear(String r1) { // r1 <-- 0
		int zero = 0;
		memoria.setMemoria(r1, zero);
	}

	// 0 se forem iguais, -1 se o primeiro for maior, 1 se o segundo for maior
	public void comp(String r1) { // A : (m..m+2)
		SW.setConteudo(Integer.compare(A.getConteudo(), Integer.parseInt(r1)));
	}

	public void compr(String r1, String r2) { // (r1) : (r2)
		SW.setConteudo(Integer.compare(memoria.getMemoria(r1), memoria.getMemoria(r2)));
	}

	public void div(String r1) { // A : (A) / (m..m+2)
		A.setConteudo(A.getConteudo() / Integer.parseInt(r1));
	}

	public void divr(String r1, String r2) { // (r2) <-- (r2) / (r1)
		int divisao = 0;
		divisao = memoria.getMemoria(r1) / memoria.getMemoria(r2);
		memoria.setMemoria(r2, divisao);
	}

	public void j(String r1) { // PC <-- m
		ContadorInstrucoes.setContador(Integer.parseInt(r1));
	}

	public void jeq(String r1) { // PC <-- m if CC set to =
		if (SW.getConteudo() == 00) {
			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
		}
	}

	public void jgt(String r1) { // PC <-- m if CC set to >
		if (SW.getConteudo() == 01) {
			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
		}
	}

	public void jlt(String r1) { // PC <-- m if CC set to <
		if (SW.getConteudo() == 11) {
			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
		}
	}

	public void jsub(String r1) { // L <-- (PC); PC <-- m
		L.setConteudo(ContadorInstrucoes.getContador());
		ContadorInstrucoes.setContador(memoria.getMemoria(r1));
	}

	public void lda(String r1) { // A <-- (m..m+2)
		A.setConteudo(Integer.parseInt(r1));
	}

	public void ldb(String r1) { // B <-- (m..m+2)
		B.setConteudo(Integer.parseInt(r1));
	}

	public void ldch() { // A [byte mais a direita] <-- (m)
		A.setConteudo(A.getConteudo()&0xFF);
	}

	public void ldl(String r1) { // L <-- (m..m+2)
		L.setConteudo(Integer.parseInt(r1));
	}

	public void lds(String r1) { // S <-- (m..m+2)
		S.setConteudo(Integer.parseInt(r1));
	}

	public void ldt(String r1) { // T <-- (m..m+2)
		T.setConteudo(memoria.getMemoria(r1));
	}

	public void ldx(String r1) { // X <-- (m..m+2)
		X.setConteudo(Integer.parseInt(r1));
	}

	public void mul(String r1) { // A <-- (A) * (m..m+2)
		int multiplicacao = 0;
		multiplicacao = A.getConteudo() * Integer.parseInt(r1);
		A.setConteudo(multiplicacao);
	}

	public void mulr(String r1, String r2) { // r2 <-- (r2) * (r1)
		int multiplicacao = 0;
		multiplicacao = memoria.getMemoria(r1) * memoria.getMemoria(r2);
		memoria.setMemoria(r2, multiplicacao);
	}

	public void or(String r1) { // A <-- (A) | (m..m+2)
		A.setConteudo(A.getConteudo() | Integer.parseInt(r1));
	}

	public void rmo(String r1, String r2) { // r2 <-- (r1)
		memoria.setMemoria(r2, memoria.getMemoria(r1));
	}

	public void rsub(String r1) { // PC <-- (L)
		L.setConteudo(Integer.parseInt(r1));
		ContadorInstrucoes.setContador(memoria.getMemoria(r1));
	}

	public void shiftl(String r1, String r2) { // r1 <-- (r1)
		int deslocamento = memoria.getMemoria(r2);
		memoria.setMemoria(r1, memoria.getMemoria(r1) << deslocamento);
	}

	public void shiftr(String r1, String r2) { // r1 <-- (r1)
		int deslocamento = memoria.getMemoria(r2);
		memoria.setMemoria(r1, memoria.getMemoria(r1) >> deslocamento);
	}

	public void sta(String r1) { // m..m+2 <-- (A)
		memoria.setMemoria(r1, A.getConteudo());
	}

	public void stb(String r1) { // m..m+2 <-- (B)
		memoria.setMemoria(r1, B.getConteudo());
	}

	public void stch(String r1) { // m <-- (A)
		memoria.setMemoria(r1, A.getConteudo());
	}

	public void stl(String r1) { // m..m+2 <-- (L)
		memoria.setMemoria(r1, L.getConteudo());
	}

	public void sts(String r1) { // m..m+2 <-- (S)
		memoria.setMemoria(r1, S.getConteudo());
	}

	public void stt(String r1) { // m..m+2 <-- (T)
		memoria.setMemoria(r1, T.getConteudo());
	}

	public void stx(String r1) { // m..m+2 <-- (X)
		memoria.setMemoria(r1, X.getConteudo());
	}

	public void sub(String r1) { // A <-- (A) - (m..m+2)
		int subtracao = 0;
		subtracao = A.getConteudo() - Integer.parseInt(r1);
		A.setConteudo(subtracao);
	}

	public void subr(String r1, String r2) { // r2 <-- (r2) - (r1)
		int subtracao = 0;
		subtracao = memoria.getMemoria(r2) - memoria.getMemoria(r1);
		memoria.setMemoria(r2, subtracao);
	}

	public void tix(String r1) { // X <-- (X) + 1; (X) : (m..m+2)
		ContadorInstrucoes.setContador(X.getConteudo() + 1);
		comp(r1);
	}

	public void tixr(String r1) { // X <-- (X) + 1; (X) : (r1)
		X.setConteudo(X.getConteudo() + 1);
        compr(Integer.toString(X.getConteudo()), r1);
	}
}
