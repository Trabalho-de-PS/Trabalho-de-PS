package ps;

public class RegistradorGeral {

	private String[] registrador;
	
	public RegistradorGeral() {
		this.registrador = new String[1024];
	}
	
	public void setRegistrador(String posicao, int valor) {
		int numero = Integer.parseInt(posicao);
		String string = Integer.toString(valor);
		registrador[numero] = string;
	}
	
	public int getValorDoRegistrador(String posicao) {
		int numero = Integer.parseInt(posicao);
		return Integer.parseInt(registrador[numero]);
	}
	
	public void getRegistradorTotal() {
		int i = 0;
		while(i < 1024) {
			System.out.println(registrador[i]);
			i++;
		}
	}
}
