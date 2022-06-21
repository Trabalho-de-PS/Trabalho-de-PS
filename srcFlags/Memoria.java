package br.com.sicxe.memoria;

import java.util.ArrayList;

import br.com.sicxe.ferramentas.Ferramentas;

public class Memoria {

	// -> O tamanho de todos os registradores é de 24 bits.
	// -> O registradores e a memória guardam valores em hexadecimal.
	private String AAcumulador;
	private String XRegIndice;
	private String LRegLigacao;
	private String BRegBase;
	private String SRegGeral;
	private String TRegGeral;
	private String PCContador;
	private String SWStatus;
	private ArrayList<String> Memoria;

	public String getAAcumulador() {
		return AAcumulador;
	}

	public void setAAcumulador(String aAcumulador) {
		AAcumulador = aAcumulador;
	}

	public String getXRegIndice() {
		return XRegIndice;
	}

	public void setXRegIndice(String xRegIndice) {
		XRegIndice = xRegIndice;
	}

	public String getLRegLigacao() {
		return LRegLigacao;
	}

	public void setLRegLigacao(String lRegLigacao) {
		LRegLigacao = lRegLigacao;
	}

	public String getBRegBase() {
		return BRegBase;
	}

	public void setBRegBase(String bRegBase) {
		BRegBase = bRegBase;
	}

	public String getSRegGeral() {
		return SRegGeral;
	}

	public void setSRegGeral(String sRegGeral) {
		SRegGeral = sRegGeral;
	}

	public String getTRegGeral() {
		return TRegGeral;
	}

	public void setTRegGeral(String tRegGeral) {
		TRegGeral = tRegGeral;
	}

	public String getPCContador() {
		return PCContador;
	}

	public void setPCContador(String pCContador) {
		PCContador = pCContador;
	}

	public String getSWStatus() {
		return SWStatus;
	}

	public void setSWStatus(String sWStatus) {
		SWStatus = sWStatus;
	}

	public String getMemoria(int endereco) {
		return Memoria.get(endereco);
	}

	public void setMemoria(String valor, int endereco) {
		Memoria.add(endereco, valor);
	}

	// b = 0, p = 1 -> PC relative addressing mode -> TA (Target Address) = [PC] +
	// displacement.
	public int flagOne(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(PCContador) + Integer.parseInt(code.get(8));
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// b = 1, p = 0 -> Base relative addressing mode -> TA (Target Address) = [B] +
	// displacement.
	public int flagTwo(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(BRegBase) + Integer.parseInt(code.get(8));
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// b = 0, p = 0 -> Direct addressing mode -> TA (Target Address) = displacement.
	public int flagThree(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(code.get(8));
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// n = 0, i = 1 -> Immediate addressing mode -> displacement = operador
	public int flagFour(ArrayList<String> code) {
		int operador = Integer.parseInt(code.get(8));

		return operador;
	}

	// n = 1, i = 0 -> Indirect addressing mode -> TA (Target Address) =
	// [displacement].
	public int flagFive(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(code.get(8));
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// b = 0, p = 1, x = 1 -> PC relative addressing mode -> TA (Target Address) =
	// [PC] +
	// displacement + [X].
	public int flagSix(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(PCContador) + Integer.parseInt(code.get(8)) + Integer.parseInt(XRegIndice);
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// b = 1, p = 0, x = 1 -> Base relative addressing mode -> TA (Target Address) =
	// [B] +
	// displacement + [X].
	public int flagSeven(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(BRegBase) + Integer.parseInt(code.get(8)) + Integer.parseInt(XRegIndice);
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}

	// b = 0, p = 0, x = 1 -> Direct addressing mode -> TA (Target Address) =
	// displacement + [X].
	public int flagEight(ArrayList<String> code) {
		int targetAddress = Integer.parseInt(code.get(8)) + Integer.parseInt(XRegIndice);
		String hexTargetAddress = Integer.toString(targetAddress);
		String decTargetAddress = Ferramentas.hexToDec(hexTargetAddress);

		return Integer.parseInt(decTargetAddress);
	}
}
