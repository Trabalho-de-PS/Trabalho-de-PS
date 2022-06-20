package ps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessadorMacro {
	
	public static File executa(String path) throws IOException {
		List<String> codigo = new ArrayList<>();
		List<Macro> listaMacros = new ArrayList<>();
		List<Macro> listaChamadas = new ArrayList<>();
		String[] aux;
		int i, j, k, l, m, cont;
		FileWriter saida = new FileWriter("arquivos/saidaMacro.asm");
		
		try {
			// leitura do arquivo
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				codigo.add(sc.nextLine());
            }
			
			// percorre o codigo armazenando as macros
			for(i = 0; i < codigo.size(); i++) {
				if(codigo.get(i).contains("MACRO") == true) {
					Macro macro = new Macro();
					
					// atribui o nome da macro no codigo para o objeto macro
					aux = codigo.get(i).split(" "); 
					macro.setNome(aux[0]);
					
					// coloca os parametros no objeto macro
					aux = codigo.get(i).replace(",", "").split(" ");
					for(j = 2; j < aux.length; j++) {
						macro.setParametros(aux[j]);
					}
					
					// coloca a definicao no objeto macro
					j = i + 1;
					while(codigo.get(j).compareTo("MEND") != 0) {
						aux = codigo.get(j).replace(",", "").split(" ");
						macro.setDefinicao(codigo.get(j).replace(",", ""));
						for(k = 0; k < macro.getParametros().size(); k++) {
							if(macro.getParametros().get(k).contains(aux[1])) {
								for(l = 0; l < macro.getDefinicao().size(); l++) {
									if(macro.getDefinicao().get(l).contains(" " + aux[1])) {
										macro.setDefinicao(macro.getDefinicao().get(l).replace(" " + aux[1], " #" + (k+1)));
									}
								}
							}
						}
						j++;
					}
					// remove da definicao as parametros sem #
					for(j = 0; j < macro.getDefinicao().size(); j++) {
						if(macro.getDefinicao().get(j).contains("#") == false) {
							macro.getDefinicao().remove(j);
						}
					}
					listaMacros.add(macro);
					
					// remove a definicao da macro do codigo
					j = 0;
					while(codigo.get(0).compareTo("MEND") != 0) {
						codigo.remove(0);
						j++;
					}
					codigo.remove(0); // remove o MEND
				}
			}
			
			// armazena a chamada das macros
			for(i = 0; i < codigo.size(); i++) {
				Macro chamada = new Macro();
				
				// separa a linha do codigo
				aux = codigo.get(0).replace(",", "").split(" ");
				
				// verifica na lista de macros se contem o nome da macro
				for (Macro macro: listaMacros) {
					if(aux[0].equals(macro.getNome())) {
						chamada.setNome(aux[0]);	// atribui o nome para o objeto chamada
						
						// armazena os argumentos
						for(j = 1; j < aux.length; j++) {
							chamada.setArgumentos(aux[j]);
						}
						
						listaChamadas.add(chamada);
						codigo.remove(0);	// remove a linha do codigo
					}
				}
			}
			
			// substitui os parametros da macro pelos argumentos da chamada e coloca no codigo
			cont = 0;
			for(j = 0; j < listaChamadas.size(); j++) {
				for(k = 0; k < listaMacros.size(); k++) {
					if(listaChamadas.get(j).getNome().equals(listaMacros.get(k).getNome())) {
						for(l = 0; l < listaMacros.get(j).getDefinicao().size(); l++) {
							codigo.add(cont, listaMacros.get(k).getDefinicao().get(l));
							cont++;
						}
						for(l = 0; l < listaChamadas.get(j).getArgumentos().size(); l++) {
							for(m = 0; m < codigo.size(); m++) {
								if(codigo.get(m).contains("#" + (l+1))) {
									codigo.set(m, codigo.get(m).replace("#" + (l+1), listaChamadas.get(j).getArgumentos().get(l)));
								}
							}
						}
					}
				}
			}
			
			// escreve o codigo final no arquivo de saida
            for(i = 0; i < codigo.size(); i++) {
            	if(i != codigo.size()-1) {
            		saida.write(codigo.get(i) + "\n");
            	}
            	else {
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