package ps;

import static java.lang.Thread.sleep;

public class ContadorInstrucoes extends GUI {

	private static int contador;
	
	public static void reset() {
		contador = 0;
	}
	
	public static void update() throws InterruptedException {
            //sleep(slider.getValue());
            contador++;
	}
	
	public static int getContador() {
		return contador;
	}
	
	public static void setContador(int valor) {
		contador = valor;
    }
}
