package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main{
	
	public static String removerCaracterIniFim(String string, char caracter) {
		if(string.length() > 0) {
			int i = 0;//primeiro indice
			int j = string.length() - 1;//ultimo indice
			int d = 0;//desconto no fim da string
			while((string.charAt(i) == caracter) || (string.charAt(j) == caracter)) {
				if(string.charAt(i) == caracter) {
					i++;//incrementado para percorrer a string
				}
				if(string.charAt(j) == caracter) {
					j--;//descrementado para voltar pela string
					d++;//quantidade espacos no fim da string
				}
			}
			string = string.substring(i, string.length() - d);
		} else {
			string = null;
		}
		return string;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println(Colaborador.Campo.SEXO.getOrdem());
		Colaborador colabor1 = new Colaborador("marcos", "0001", 'm', "agente", 1800);
		Colaborador colabor2 = new Colaborador(Colaborador.Campo.FUNCAO, "assessor");
		
		System.out.println(colabor1);
		System.out.println(colabor2);
		
		
		
		
		
		File file = new File("fmas.txt");		
		Scanner in = new Scanner(new FileReader(file.getAbsolutePath()));
		
		//Separacao e tratamento dos dados de cada consignado
		while (in.hasNextLine()) {
		    String linha = in.nextLine();
		    String dados[] = linha.split(",");
		    System.out.println(dados[0]);//matricula
		    System.out.println(removerCaracterIniFim(dados[1], '"'));//nome
		    System.out.println(removerCaracterIniFim(dados[2], '"'));//cargo
		    System.out.println(dados[3]);//dataAdmissao
		    System.out.println(dados[4]);//parcelas
		    String valorParcela = dados[5]+'.'+dados[6];
		    System.out.println(removerCaracterIniFim(valorParcela, '"'));//valorParcela
		}
		in.close();
	}
}
