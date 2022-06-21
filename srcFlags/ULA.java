package br.com.sicxe.processamento;

import java.util.ArrayList;
import br.com.sicxe.ferramentas.Ferramentas;
import br.com.sicxe.memoria.Memoria;

public class ULA {
	private ArrayList<String> binInstructions;
	private ArrayList<String> hexInstructions;
	private ArrayList<String> binCode;
	private ArrayList<String> hexCode;
	private Memoria mem;

	public ULA() {
		this.binInstructions = new ArrayList<String>();
		this.hexInstructions = new ArrayList<String>();
		this.binCode = new ArrayList<String>();
		this.mem = new Memoria();

		hexInstructions = Ferramentas.abrirArquivo("arquivos/opcodes.txt");
		hexCode = Ferramentas.abrirArquivo("arquivos/teste.txt");
		binInstructions = Ferramentas.vetorHexToBin(hexInstructions);
		binCode = Ferramentas.vetorHexToBin(hexCode);
	}

	public ArrayList<String> getBinCode() {
		return binCode;
	}

	public ArrayList<String> binInstructions() {
		return binInstructions;
	}

	public int flagTest(ArrayList<String> line) {
		int key = 0;

		int n = Integer.parseInt(line.get(1));
		int i = Integer.parseInt(line.get(2));
		int x = Integer.parseInt(line.get(3));
		;
		int b = Integer.parseInt(line.get(4));
		int p = Integer.parseInt(line.get(5));

		if (b == 0 && p == 1 && x == 0) {
			key = 1;
		}
		if (b == 1 && p == 0 && x == 0) {
			key = 2;
		}
		if (b == 0 && p == 0 && x == 0) {
			key = 3;
		}
		if (n == 0 && i == 1) {
			key = 4;
		}
		if (n == 1 && i == 0) {
			key = 5;
		}
		if (b == 0 && p == 1 && x == 1) {
			key = 6;
		}
		if (b == 1 && p == 0 && x == 1) {
			key = 7;
		}
		if (b == 0 && p == 0 && x == 1) {
			key = 8;
		}

		switch (key) {
		case 1:
			return mem.flagOne(line);

		case 2:
			return mem.flagTwo(line);

		case 3:
			return mem.flagThree(line);

		case 4:
			return mem.flagFour(line);

		case 5:
			return mem.flagFive(line);

		case 6:
			return mem.flagSix(line);

		case 7:
			return mem.flagSeven(line);

		default:
			return -1;
		}

	}

	public void stepCode(String line) {
		String key = Ferramentas.identificadorOpcode(line);

		switch (key) {
//			case "00011000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				add(r1);
//				break;
//
//			case "10010000":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				addr(r1, r2);
//				break;
//
//			case "01000000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				and(r1);
//				break;
//
//			case "10110100":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				clear(r1);
//				break;
//
//			case "00101000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				comp(r1);
//				break;
//
//			case "10100000":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				compr(r1, r2);
//				break;
//
//			case "00100100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				div(r1);
//				break;
//
//			case "10011100":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				divr(r1, r2);
//				break;
//
//			case "00111100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				j(r1);
//				break;
//
//			case "00110000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				jeq(r1);
//				break;
//
//			case "00110100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				jgt(r1);
//				break;
//
//			case "00111000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				jlt(r1);
//				break;
//
//			case "01001000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				jsub(r1);
//				break;
		// LDA || A <-- (m..m+2)
		case "00000000":
			ArrayList<String> aux = Ferramentas.formatThree(line);
			int targetAddress = this.flagTest(aux);
			mem.setAAcumulador(mem.getMemoria(targetAddress));
			break;
//
//			case "01101000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				ldb(r1);
//				break;
//
//			case "01010000":
//				ldch();
//				break;
//
//			case "00001000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				ldl(r1);
//				break;
//
//			case "01101100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				lds(r1);
//				break;
//
//			case "01110100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				ldt(r1);
//				break;
//
//			case "00000100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				ldx(r1);
//				break;
//
//			case "00100000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				mul(r1);
//				break;
//
//			case "10011000":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				mulr(r1, r2);
//				break;
//
//			case "01000100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				or(r1);
//				break;
//
//			case "10101100":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				rmo(r1, r2);
//				break;
//
//			case "01001100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				rsub(r1);
//				break;
//
//			case "10100100":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				shiftl(r1, r2);
//				break;
//
//			case "10101000":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				shiftr(r1, r2);
//				break;
//
//			case "00001100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				sta(r1);
//				break;
//
//			case "01111000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				stb(r1);
//				break;
//
//			case "01010100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				stch(r1);
//				break;
//
//			case "00010100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                stl(r1);
//				break;
//
//			case "01111100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                sts(r1);
//				break;
//
//			case "10000100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                stt(r1);
//				break;
//
//			case "00010000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                stx(r1);
//				break;
//
//			case "00011100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				sub(r1);
//				break;
//
//			case "10010100":
//				binCode = Ferramentas.format2(code, ContadorInstrucoes.getContador());
//				r1 = binCode.get(0);
//				r2 = binCode.get(1);
//				subr(r1, r2);
//				break;
//
//			case "00101100":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                tix(r1);
//				break;
//
//			case "10111000":
//				binCode = Ferramentas.format34(code, ContadorInstrucoes.getContador());
//                r1 = binCode.get(0);
//                tixr(r1);
//				break;
		}
	}
//
//	public ArrayList<String> getInstructions() {
//		return this.binInstructions;
//	}
//
//	public void add(String r1) { // A <-- (A) + (m..m+2)
//		int soma = 0;
//		soma = A.getConteudo() + Integer.parseInt(r1);
//		A.setConteudo(soma);
//	}
//
//	public void addr(String r1, String r2) { // r2 <-- (r2) + (r1)
//		int soma = 0;
//		soma += memoria.getMemoria(r1);
//		soma += memoria.getMemoria(r2);
//		memoria.setMemoria(r2, soma);
//	}
//
//	public void and(String r1) { // A <-- (A) & (m..m+2)
//		A.setConteudo(A.getConteudo() & Integer.parseInt(r1));
//	}
//
//	public void clear(String r1) { // r1 <-- 0
//		int zero = 0;
//		memoria.setMemoria(r1, zero);
//	}
//
//	// 0 se forem iguais, -1 se o primeiro for maior, 1 se o segundo for maior
//	public void comp(String r1) { // A : (m..m+2)
//		SW.setConteudo(Integer.compare(A.getConteudo(), Integer.parseInt(r1)));
//	}
//
//	public void compr(String r1, String r2) { // (r1) : (r2)
//		SW.setConteudo(Integer.compare(memoria.getMemoria(r1), memoria.getMemoria(r2)));
//	}
//
//	public void div(String r1) { // A : (A) / (m..m+2)
//		A.setConteudo(A.getConteudo() / Integer.parseInt(r1));
//	}
//
//	public void divr(String r1, String r2) { // (r2) <-- (r2) / (r1)
//		int divisao = 0;
//		divisao = memoria.getMemoria(r1) / memoria.getMemoria(r2);
//		memoria.setMemoria(r2, divisao);
//	}
//
//	public void j(String r1) { // PC <-- m
//		ContadorInstrucoes.setContador(Integer.parseInt(r1));
//	}
//
//	public void jeq(String r1) { // PC <-- m if CC set to =
//		if (SW.getConteudo() == 00) {
//			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
//		}
//	}
//
//	public void jgt(String r1) { // PC <-- m if CC set to >
//		if (SW.getConteudo() == 01) {
//			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
//		}
//	}
//
//	public void jlt(String r1) { // PC <-- m if CC set to <
//		if (SW.getConteudo() == 11) {
//			ContadorInstrucoes.setContador(memoria.getMemoria(r1));
//		}
//	}
//
//	public void jsub(String r1) { // L <-- (PC); PC <-- m
//		L.setConteudo(ContadorInstrucoes.getContador());
//		ContadorInstrucoes.setContador(memoria.getMemoria(r1));
//	}
//
//
//	public void ldb(String r1) { // B <-- (m..m+2)
//		B.setConteudo(Integer.parseInt(r1));
//	}
//
//	public void ldch() { // A [byte mais a direita] <-- (m)
//		A.setConteudo(A.getConteudo()&0xFF);
//	}
//
//	public void ldl(String r1) { // L <-- (m..m+2)
//		L.setConteudo(Integer.parseInt(r1));
//	}
//
//	public void lds(String r1) { // S <-- (m..m+2)
//		S.setConteudo(Integer.parseInt(r1));
//	}
//
//	public void ldt(String r1) { // T <-- (m..m+2)
//		T.setConteudo(memoria.getMemoria(r1));
//	}
//
//	public void ldx(String r1) { // X <-- (m..m+2)
//		X.setConteudo(Integer.parseInt(r1));
//	}
//
//	public void mul(String r1) { // A <-- (A) * (m..m+2)
//		int multiplicacao = 0;
//		multiplicacao = A.getConteudo() * Integer.parseInt(r1);
//		A.setConteudo(multiplicacao);
//	}
//
//	public void mulr(String r1, String r2) { // r2 <-- (r2) * (r1)
//		int multiplicacao = 0;
//		multiplicacao = memoria.getMemoria(r1) * memoria.getMemoria(r2);
//		memoria.setMemoria(r2, multiplicacao);
//	}
//
//	public void or(String r1) { // A <-- (A) | (m..m+2)
//		A.setConteudo(A.getConteudo() | Integer.parseInt(r1));
//	}
//
//	public void rmo(String r1, String r2) { // r2 <-- (r1)
//		memoria.setMemoria(r2, memoria.getMemoria(r1));
//	}
//
//	public void rsub(String r1) { // PC <-- (L)
//		L.setConteudo(Integer.parseInt(r1));
//		ContadorInstrucoes.setContador(memoria.getMemoria(r1));
//	}
//
//	public void shiftl(String r1, String r2) { // r1 <-- (r1)
//		int deslocamento = memoria.getMemoria(r2);
//		memoria.setMemoria(r1, memoria.getMemoria(r1) << deslocamento);
//	}
//
//	public void shiftr(String r1, String r2) { // r1 <-- (r1)
//		int deslocamento = memoria.getMemoria(r2);
//		memoria.setMemoria(r1, memoria.getMemoria(r1) >> deslocamento);
//	}
//
//	public void sta(String r1) { // m..m+2 <-- (A)
//		memoria.setMemoria(r1, A.getConteudo());
//	}
//
//	public void stb(String r1) { // m..m+2 <-- (B)
//		memoria.setMemoria(r1, B.getConteudo());
//	}
//
//	public void stch(String r1) { // m <-- (A)
//		memoria.setMemoria(r1, A.getConteudo());
//	}
//
//	public void stl(String r1) { // m..m+2 <-- (L)
//		memoria.setMemoria(r1, L.getConteudo());
//	}
//
//	public void sts(String r1) { // m..m+2 <-- (S)
//		memoria.setMemoria(r1, S.getConteudo());
//	}
//
//	public void stt(String r1) { // m..m+2 <-- (T)
//		memoria.setMemoria(r1, T.getConteudo());
//	}
//
//	public void stx(String r1) { // m..m+2 <-- (X)
//		memoria.setMemoria(r1, X.getConteudo());
//	}
//
//	public void sub(String r1) { // A <-- (A) - (m..m+2)
//		int subtracao = 0;
//		subtracao = A.getConteudo() - Integer.parseInt(r1);
//		A.setConteudo(subtracao);
//	}
//
//	public void subr(String r1, String r2) { // r2 <-- (r2) - (r1)
//		int subtracao = 0;
//		subtracao = memoria.getMemoria(r2) - memoria.getMemoria(r1);
//		memoria.setMemoria(r2, subtracao);
//	}
//
//	public void tix(String r1) { // X <-- (X) + 1; (X) : (m..m+2)
//		ContadorInstrucoes.setContador(X.getConteudo() + 1);
//		comp(r1);
//	}
//
//	public void tixr(String r1) { // X <-- (X) + 1; (X) : (r1)
//		X.setConteudo(X.getConteudo() + 1);
//        compr(Integer.toString(X.getConteudo()), r1);
//	}
//}
}
