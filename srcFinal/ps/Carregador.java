package ps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carregador {
	public static File executa(Memoria memoria, List<Integer> endereco, String path) throws IOException {
		List<String> codigo = new ArrayList<>();
		int i, j;
		List<String> aux = new ArrayList<String>();
		
		try {
			// leitura do arquivo
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				codigo.add(sc.nextLine());
			}
			
			// carrega os valores conforme seus enderecos
			for(i = 0; i < codigo.size(); i++) {
				for(j = 0; j < codigo.get(i).length(); j += 2) {
					aux.add(codigo.get(i).substring(j, Math.min(j + 2, codigo.get(i).length())));
				}
				
				if(aux.get(0).equals("00")) {
					memoria.setMemoria(endereco.get(i).toString(), Integer.parseInt(aux.get(1)));
        		}
				
				aux.clear();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}