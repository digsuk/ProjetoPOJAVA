/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de excecao para campos
 * 			  vazios.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package excecoes;

import negocio.Mensagem;

public class CampoVazioException extends Exception{
	public String getMessage(){
		return Mensagem.CAMPOVAZIO;
	}
}
