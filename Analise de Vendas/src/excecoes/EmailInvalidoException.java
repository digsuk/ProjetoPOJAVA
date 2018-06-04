/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Exceção para email inválido.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package excecoes;

import negocio.Mensagem;

public class EmailInvalidoException extends Exception{
	public String getMessage(){
		return Mensagem.EMAILINVALIDO;
	}
}