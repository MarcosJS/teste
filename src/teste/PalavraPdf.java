package teste;

import java.util.ArrayList;

public class PalavraPdf {
	private ArrayList<String> palavra = new ArrayList<String>();
	private ArrayList<Float> xCaracter = new ArrayList<Float>();
	private ArrayList<Float> yCaracter = new ArrayList<Float>();
	
	public void adicionar(String caracter, float x, float y) {
		this.palavra.add(caracter);
		this.xCaracter.add(x);
		this.yCaracter.add(y);
	}
	
	public String obterCaracter(int indice) {
		return palavra.get(indice);
	}
	
	public float obterXCaracter(int indice) {
		return xCaracter.get(indice);
	}
	
	public float obterYCaracter(int indice) {
		return yCaracter.get(indice);
	}
	
	public int tamanho() {
		return palavra.size();
	}
	
	public String getPalavra() {
		String resultado = "";
		for(String caracter : this.palavra) {
			resultado += caracter;
		}
		return resultado;
	}
}
