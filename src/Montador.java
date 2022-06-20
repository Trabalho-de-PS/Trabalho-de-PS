package ps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Montador {
	public static File executa(String path) throws IOException {
		List<String> codigo = new ArrayList<>();
		List<Integer> endereco = new ArrayList<>();
		ArrayList<String> instrucoes = new ArrayList<>();
		ArrayList<String> opcodes = new ArrayList<String>();
		HashMap<String, Integer> tabelaSimbolos = new HashMap<>();
		int i, j, k, cont=0;
		String[] aux;
		FileWriter saida = new FileWriter("arquivos/saidaMontador.asm");
		
		try {
			// leitura do arquivo
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				codigo.add(sc.nextLine());
			}
			
			Ferramentas.abrirArquivoEm(instrucoes, "arquivos/instrucoes.txt");
			Ferramentas.abrirArquivoEm(opcodes, "arquivos/opcodes.txt");

			
			// ####### Primeiro Passo #######
			
			// determinando os enderecos iniciais do codigo
			endereco.add(cont);
			for(i = 0; i < codigo.size(); i++) {
				aux = codigo.get(i).replace(",", "").split(" ");
				if(aux.length == 2) {
					cont += 2;
					endereco.add(cont);
				}
				else if(aux[1].equals("WORD")){
					cont += 1;
					endereco.add(cont);
				}
				else {
					cont += 3;
					endereco.add(cont);
				}
			}
			endereco.remove(endereco.size()-1);
			
			// inserindo na tabela de simbolos
			for(i = 0; i < codigo.size(); i++) {
				aux = codigo.get(i).replace(",", "").split(" ");
				for(j = 1; j < aux.length; j++) {
					if(aux[1].equals("WORD")) {
						j++;
						
						// inserindo endereco do simbolo na tabela
						if(tabelaSimbolos.containsKey(aux[0])) {
							tabelaSimbolos.put(aux[0], endereco.get(i));
						}
					}
					else if(!tabelaSimbolos.containsKey(aux[j])){
						tabelaSimbolos.put(aux[j], -1);
					}
				}
			}
			
			
			// ####### Segundo Passo #######
			
			for(i = 0; i < codigo.size(); i++) {
				aux = codigo.get(i).replace(",", "").split(" ");
				for(j = 0; j < aux.length; j++) {
					// remove labels
					if(aux[1].equals("WORD")) {
						codigo.set(i, codigo.get(i).replace(aux[0] + " ", ""));
					}
					
					// substitui mnemonicos por opcodes
					for(k = 0; k < instrucoes.size(); k++) {
						if(instrucoes.get(k).equals(aux[j])) {
							codigo.set(i, codigo.get(i).replace(aux[j], opcodes.get(k)));
						}
					}
					
					// substitui labels por enderecos
					for(k = 0; k < tabelaSimbolos.size(); k++) {
						if(tabelaSimbolos.containsKey(aux[j])) {
							codigo.set(i, codigo.get(i).replace(aux[j], tabelaSimbolos.get(aux[j]).toString()));
						}
					}
				}
			}
			
			// escreve o codigo final no arquivo de saida
            for(i = 0; i < codigo.size(); i++) {
            	if(i != codigo.size()-1) {
            		saida.write(endereco.get(i) + " ");
            		saida.write(codigo.get(i) + "\n");
            	}
            	else {
            		saida.write(endereco.get(i) + " ");
            		saida.write(codigo.get(i));
            	}
            }
            
            saida.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}