package ps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ferramentas {	
	
	public static void abrirArquivoEm(ArrayList<String> aux, String path) {
		Scanner sc;
		
		try {
			sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				aux.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static ArrayList<String> traduzirOp(ArrayList<String> code) {
		ArrayList<String> opcodeBin = new ArrayList<String>();
		ArrayList<String> opcode = new ArrayList<String>();
		int i = code.size();
		int j = 0;
		
		while(i != 0) {
			String aux1 = code.get(j);
			opcode.add(aux1.substring(0,2));
			
			String aux = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(opcode.get(j), 16))));		
			opcodeBin.add(aux);
			i--;
			j++;
		}
		return opcodeBin;
	}
	
	public static ArrayList<String> format2(ArrayList<String> code, int lugar) {
		ArrayList<String> array = new ArrayList<String>();
		array.add(code.get(lugar).substring(2, 4));
		array.add(code.get(lugar).substring(4, 6));
		
		return array;
	}
	
	public static ArrayList<String> format34(ArrayList<String> code, int lugar) {
		ArrayList<String> array = new ArrayList<String>();
		array.add(code.get(lugar).substring(2, 4));
		return array;
	}
}
