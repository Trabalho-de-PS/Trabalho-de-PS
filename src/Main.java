package ps;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws IOException {
			
		ArrayList<String> opcode;
		Memoria memoria;
		ULA ula;
		
		ContadorInstrucoes.reset();
		
		opcode = new ArrayList<String>();
		memoria = new Memoria();
		ula = new ULA(memoria);
		
		opcode = memoria.getCode();
		
		for (String i : opcode) {
			ula.stepCode(i, memoria.getHexCode());
			ContadorInstrucoes.update();
		}
		
		memoria.getMemoriaTotal();
		
		ProcessadorMacro.executa("arquivos/testeMacro.asm");
	}
}
