package ps;

public class ContadorInstrucoes {

	private static int contador;
	
	public static void reset() {
		contador = 0;
	}
	
	public static void update() {
		contador++;
	}
	
	public static int getContador() {
		return contador;
	}
	
	public static void setContador(int valor) {
		contador = valor;
    }
}
