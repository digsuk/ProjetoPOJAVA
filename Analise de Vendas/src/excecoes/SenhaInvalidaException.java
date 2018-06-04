/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Exceção para senha inválida.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package excecoes;

import negocio.Mensagem;

public class SenhaInvalidaException extends Exception{
	public String getMessage(){
		return Mensagem.SENHAINVALIDA;
	}
}
