package teste;

import java.util.Arrays;

public class Colaborador {
	public enum Campo {
		NOME(0), MATRICULA(1), SEXO(2), FUNCAO(3), SALARIO(4);
		private int ordem;
		
		Campo(int ordem){
			this.ordem = ordem;
		}
		
		/**
		 * @return the ordem
		 */
		public int getOrdem() {
			return ordem;
		}
	}
	
	private Object[] dados = new Object[5];
	
	public Colaborador(String nome, String matricula, char sexo, String funcao, double salario) {
		dados[Campo.NOME.getOrdem()] = nome;
		dados[Campo.MATRICULA.getOrdem()] = matricula;
		dados[Campo.SEXO.getOrdem()] = sexo;
		dados[Campo.FUNCAO.getOrdem()] = funcao;
		dados[Campo.SALARIO.getOrdem()] = salario;
	}
	
	public Colaborador(Campo campo, Object objeto) {
		dados[campo.getOrdem()] = objeto;
	}

	@Override
	public String toString() {
		return "Colaborador [dados=" + Arrays.toString(dados) + "]";
	}
}