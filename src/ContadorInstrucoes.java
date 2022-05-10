package ps;

public class ContadorInstrucoes {

	private static int contador;
	
	public static void reset() {
		contador = 0;
	}
	
	public static void update() {
		contador++;
	}
	
	public static int getContator() {
		return contador;
	}
}
