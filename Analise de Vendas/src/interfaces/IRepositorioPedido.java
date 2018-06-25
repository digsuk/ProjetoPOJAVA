/*---------------------------------------------
 * Autor: Diogo Souza
 * Data:15/06/2018
 *---------------------------------------------
 * Descri��o: Interface para repositorio de
 * 			  pedidos.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/

package interfaces;

import java.sql.ResultSet;

import entidades.Pedido;
import excecoes.CPFNaoEncontradoException;

public interface IRepositorioPedido {
	
	public void inserir(Pedido pedido);
	public Pedido procurar(String identificador)throws CPFNaoEncontradoException;
}
