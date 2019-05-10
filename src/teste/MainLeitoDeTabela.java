package teste;

import java.io.IOException;
import java.util.ArrayList;

public class MainLeitoDeTabela {
	
	public static void main(String[] args) throws IOException {
		LeitorDeTabela tabela = new LeitorDeTabela("C:\\Users\\marco\\Desktop\\consignet.pdf");
		String texto = tabela.obterTexto(tabela.getPdfStripperCustom());
		System.out.println(texto);
		String[] linhas = texto.split("\n");
		System.out.println(linhas.length + " linhas");
		ArrayList<PalavraPdf> palavra = tabela.getPdfStripperCustom().getDados();
		System.out.println("quantidades de palavras "+ palavra.size());
		for(int i = 0; i< palavra.size(); i++) {
			String xInicio = "[" + palavra.get(i).obterXCaracter(0) + "]";
			String xFim = "[" + palavra.get(i).obterXCaracter(palavra.get(i).tamanho()-1) + "]";
			System.out.println(xInicio + palavra.get(i).getPalavra() + xFim);
			//System.out.print(palavra.get(i).getPalavra());
		}
		tabela.close();
	}
	
}
