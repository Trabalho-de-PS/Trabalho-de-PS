package ps;

import java.util.ArrayList;

public class Processador {

	private ArrayList<String> opcode;
	private Memoria memoria;
	private ULA ula;
	
	public Processador() {
		ContadorInstrucoes.reset();
		
		this.opcode = new ArrayList<String>();
		this.memoria = new Memoria();
		this.ula = new ULA();
		
		this.opcode = memoria.getCode();
		
		for (String i : this.opcode) {
			ula.stepCode(i, memoria.getHexCode());

			
			
			ContadorInstrucoes.update();
		}
		ula.getRegistradorGeral();
	}	
}
