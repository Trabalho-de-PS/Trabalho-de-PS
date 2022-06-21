package ps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) throws IOException {
			
		ArrayList<String> opcode;
		List<Integer> endereco;
		Memoria memoria;
		ULA ula;
		
		ContadorInstrucoes.reset();
		
		opcode = new ArrayList<String>();
		endereco = new ArrayList<>();
		memoria = new Memoria();
		ula = new ULA(memoria);
		
		ProcessadorMacro.executa("arquivos/codigo.asm");
		
		endereco = Montador.executa("arquivos/saidaMacro.asm");
		
		Carregador.executa(memoria, endereco, "arquivos/saidaMontador.asm");
		
		opcode = memoria.getCode();
		
		for (String i : opcode) {
			ula.stepCode(i, memoria.getHexCode());
			ContadorInstrucoes.update();
		}
		
		memoria.getMemoriaTotal();
	}
}
