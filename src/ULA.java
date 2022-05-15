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
	private RegistradorGeral T;
	private Registrador SW;

	public ULA() {
		this.binCode = new ArrayList<String>();
		this.binInstructions = new ArrayList<String>();
		this.A = new Registrador();
		this.X = new Registrador();
		this.L = new Registrador();
		this.B = new Registrador();
		this.S = new Registrador();
		this.T = new RegistradorGeral();
		this.SW = new Registrador();


		Ferramentas.abrirArquivoEm(binInstructions, "C:\\Users\\LT\\Documents\\instrucoes.txt");
		binInstructions = Ferramentas.traduzirOp(binInstructions);

		T.setRegistrador("0", 10);
		T.setRegistrador("1", 10);
	}

	public void getRegistradorGeral() {
		T.getRegistradorTotal();
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
				tix();
				break;

			case "10111000":
				tixr();
				break;

			case "11111111":
				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
				r1 = binCode.get(0);
				write(r1);
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
		soma += T.getValorDoRegistrador(r1);
		soma += T.getValorDoRegistrador(r2);
		T.setRegistrador(r2, soma);
	}

	public void and(String r1) { // A <-- (A) & (m..m+2)
		A.setConteudo(A.getConteudo() & Integer.parseInt(r1));
	}

	public void clear(String r1) { // r1 <-- 0
		int zero = 0;
		T.setRegistrador(r1, zero);
	}

	// 0 se forem iguais, -1 se o primeiro for maior, 1 se o segundo for maior
	public void comp(String r1) { // A : (m..m+2)
		SW.setConteudo(Integer.compare(A.getConteudo(), Integer.parseInt(r1)));
	}

	public void compr(String r1, String r2) { // (r1) : (r2)
		SW.setConteudo(Integer.compare(T.getValorDoRegistrador(r1), T.getValorDoRegistrador(r2)));
	}

	public void div(String r1) { // A : (A) / (m..m+2)
		A.setConteudo(A.getConteudo() / Integer.parseInt(r1));
	}

	public void divr(String r1, String r2) { // (r2) <-- (r2) / (r1)
		int divisao = 0;
		divisao = T.getValorDoRegistrador(r1) / T.getValorDoRegistrador(r2);
		T.setRegistrador(r2, divisao);
	}

	public void j(String r1) { // PC <-- m
		ContadorInstrucoes.setContador(Integer.parseInt(r1));
	}

	public void jeq(String r1) { // PC <-- m if CC set to =
		if (SW.getConteudo() == 00) {
			ContadorInstrucoes.setContador(T.getValorDoRegistrador(r1));
		}
	}

	public void jgt(String r1) { // PC <-- m if CC set to >
		if (SW.getConteudo() == 01) {
			ContadorInstrucoes.setContador(T.getValorDoRegistrador(r1));
		}
	}

	public void jlt(String r1) { // PC <-- m if CC set to <
		if (SW.getConteudo() == 11) {
			ContadorInstrucoes.setContador(T.getValorDoRegistrador(r1));
		}
	}

	public void jsub(String r1) { // L <-- (PC); PC <-- m
		L.setConteudo(ContadorInstrucoes.getContador());
		ContadorInstrucoes.setContador(T.getValorDoRegistrador(r1));
	}

	public void lda(String r1) { // A <-- (m..m+2)
		A.setConteudo(Integer.parseInt(r1));
	}

	public void ldb(String r1) { // B <-- (m..m+2)
		B.setConteudo(Integer.parseInt(r1));
	}

	public void ldch() { // A [byte mais a direita] <-- (m)

	}

	public void ldl(String r1) { // L <-- (m..m+2)
		L.setConteudo(Integer.parseInt(r1));
	}

	public void lds(String r1) { // S <-- (m..m+2)
		S.setConteudo(Integer.parseInt(r1));
	}

	public void ldt(String r1) { // T <-- (m..m+2)
		//T.setRegistrador(Integer.parseInt(r1));
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
		multiplicacao = T.getValorDoRegistrador(r1) * T.getValorDoRegistrador(r2);
		T.setRegistrador(r2, multiplicacao);
	}

	public void or(String r1) { // A <-- (A) | (m..m+2)
		A.setConteudo(A.getConteudo() | Integer.parseInt(r1));
	}

	public void rmo(String r1, String r2) { // r2 <-- (r1)
		T.setRegistrador(r2, T.getValorDoRegistrador(r1));
	}

	public void rsub(String r1) { // PC <-- (L)
		L.setConteudo(Integer.parseInt(r1));
		ContadorInstrucoes.setContador(T.getValorDoRegistrador(r1));
	}

	public void shiftl(String r1, String r2) { // r1 <-- (r1)
		int deslocamento = T.getValorDoRegistrador(r2);
		T.setRegistrador(r1, T.getValorDoRegistrador(r1) << deslocamento);
	}

	public void shiftr(String r1, String r2) { // r1 <-- (r1)
		int deslocamento = T.getValorDoRegistrador(r2);
		T.setRegistrador(r1, T.getValorDoRegistrador(r1) >> deslocamento);
	}

	public void sta(String r1) { // m..m+2 <-- (A)
		T.setRegistrador(r1, A.getConteudo());
	}

	public void stb(String r1) { // m..m+2 <-- (B)
		T.setRegistrador(r1, B.getConteudo());
	}

	public void stch(String r1) { // m <-- (A)
		T.setRegistrador(r1, A.getConteudo());
	}

	public void stl() { // m..m+2 <-- (L)

	}

	public void sts() { // m..m+2 <-- (S)

	}

	public void stt() { // m..m+2 <-- (T)

	}

	public void stx() { // m..m+2 <-- (X)

	}

	public void sub(String r1) { // A <-- (A) - (m..m+2)
		int subtracao = 0;
		subtracao = A.getConteudo() - Integer.parseInt(r1);
		A.setConteudo(subtracao);
	}

	public void subr(String r1, String r2) { // r2 <-- (r2) - (r1)
		int subtracao = 0;
		subtracao = T.getValorDoRegistrador(r2) - T.getValorDoRegistrador(r1);
		T.setRegistrador(r2, subtracao);
	}

	public void tix() { // X <-- (X) + 1; (X) : (m..m+2)
		ContadorInstrucoes.setContador(X.getConteudo() + 1);
        // funcao compara?
	}

	public void tixr() { // X <-- (X) + 1; (X) : (r1)
		ContadorInstrucoes.setContador(X.getConteudo() + 1);
	}

	public void write(String r1) {
		A.setConteudo(T.getValorDoRegistrador(r1));
	}
}
