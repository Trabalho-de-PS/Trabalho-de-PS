package br.com.sicxe.ferramentas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ferramentas {

	// Atualizado.
	public static ArrayList<String> abrirArquivo(String path) {
		Scanner sc;
		ArrayList<String> aux = new ArrayList<String>();

		try {
			sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				aux.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return aux;
	}

	public static ArrayList<String> traduzirOp(ArrayList<String> code) {
		ArrayList<String> opcodeBin = new ArrayList<String>();
		ArrayList<String> opcode = new ArrayList<String>();
		int i = code.size();
		int j = 0;

		while (i != 0) {
			String aux1 = code.get(j);
			opcode.add(aux1.substring(0, 2));

			String aux = String.format("%08d",
					Integer.parseInt(Integer.toBinaryString(Integer.parseInt(opcode.get(j), 16))));
			opcodeBin.add(aux);
			i--;
			j++;
		}
		return opcodeBin;
	}

	// Atualizado.
	public static ArrayList<String> vetorHexToBin(ArrayList<String> code) {
		ArrayList<String> binCode = new ArrayList<String>();

		for (String i : code) {
			binCode.add(Ferramentas.hexToBin(i));
		}
		return binCode;
	}

	// Converte uma string binária para hexadecimal.
	public static String binToHex(String code) {
		int decimal = Integer.parseInt(code, 2);
		String hexa = Integer.toString(decimal, 16);

		return hexa;
	}

	// Converte uma string hexadecimal para binário.
	public static String hexToBin(String code) {
		int decimal = Integer.parseInt(code, 16);
		String Bin = Integer.toString(decimal, 2);

		return Bin;
	}

	// Converte uma string hexadecimal para decimal.
	public static String hexToDec(String code) {
		int decimal = Integer.parseInt(code, 16);
		String dec = Integer.toString(decimal);

		return dec;
	}

	// Converte uma string decimal para hexadecimal.
	public static String decToHex(String code) {
		int decimal = Integer.parseInt(code);
		String hex = Integer.toString(decimal, 16);

		return hex;
	}

	// Atualizado.
	public static String identificadorOpcode(String line) {
		String binLine = Ferramentas.hexToBin(line);

		return binLine.substring(0, 6);
	}

	// Recebe uma string instruction hexadecimal e devolve uma ArrayList binário.
	public static ArrayList<String> formatThree(String instr) {
		String binInst = Ferramentas.hexToBin(instr);
		ArrayList<String> code = new ArrayList<String>();

		String opcode = binInst.substring(0, 6);
		String n = binInst.substring(6);
		String i = binInst.substring(7);
		String x = binInst.substring(8);
		String b = binInst.substring(9);
		String p = binInst.substring(10);
		String e = binInst.substring(11);
		String displacement = binInst.substring(12, 24);

		code.add(opcode);
		code.add(n);
		code.add(i);
		code.add(x);
		code.add(b);
		code.add(p);
		code.add(e);
		code.add(displacement);

		return code;
	}

	// Recebe uma string instruction hexadecimal e devolve uma ArrayList binário.
	public static ArrayList<String> formatFour(String instr) {
		String binInst = Ferramentas.hexToBin(instr);
		ArrayList<String> code = new ArrayList<String>();

		String opcode = binInst.substring(0, 6);
		String n = binInst.substring(6);
		String i = binInst.substring(7);
		String x = binInst.substring(8);
		String b = binInst.substring(9);
		String p = binInst.substring(10);
		String e = binInst.substring(11);
		String displacement = binInst.substring(12, 32);

		code.add(opcode);
		code.add(n);
		code.add(i);
		code.add(x);
		code.add(b);
		code.add(p);
		code.add(e);
		code.add(displacement);

		return code;
	}

}
