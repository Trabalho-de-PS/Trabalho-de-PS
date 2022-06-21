package br.com.sicxe.aplicacao;

import java.util.ArrayList;

import br.com.sicxe.processamento.ULA;

public class Main {

	public static void main(String[] args) {

		ULA ula = new ULA();

		ArrayList<String> code = ula.getBinCode();

		for (String i : code) {
			ula.stepCode(i);
		}

		// ProcessadorMacro.executa("arquivos/codigo.asm");

		// Montador.executa("arquivos/saidaMacro.asm");
	}

}
