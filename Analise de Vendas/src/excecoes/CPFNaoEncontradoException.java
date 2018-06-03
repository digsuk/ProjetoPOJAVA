/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de exceção para funcionário
 * 			  não encontrado.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package excecoes;

import negocio.Mensagem;

public class CPFNaoEncontradoException extends Exception{
	String cpf;
	
	public CPFNaoEncontradoException(String cpf){
		this.cpf = cpf;
	}
	public String getMessage(){
		return cpf + Mensagem.CPFNENCONTRADO;
	}
}