package ps;

import java.util.ArrayList;
import java.util.List;

public class Macro {
	private String nome;
	private List<String> definicao = new ArrayList<>();
	private List<String> parametros = new ArrayList<>();
	private List<String> argumentos = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getDefinicao() {
		return definicao;
	}
	
	public void setDefinicao(String definicao) {
		this.definicao.add(definicao);
	}
	
	public List<String> getParametros() {
		return parametros;
	}
	
	public void setParametros(String parametros) {
		this.parametros.add(parametros);
	}
	
	public List<String> getArgumentos() {
		return argumentos;
	}
	
	public void setArgumentos(String argumentos) {
		this.argumentos.add(argumentos);
	}
}