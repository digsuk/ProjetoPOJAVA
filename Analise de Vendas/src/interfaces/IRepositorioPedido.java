/*---------------------------------------------
 * Autor: Diogo Souza
 * Data:15/06/2018
 *---------------------------------------------
 * Descrição: Interface para repositorio de
 * 			  pedidos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package interfaces;

import java.sql.ResultSet;

import entidades.Pedido;

public interface IRepositorioPedido {
	
	public void inserir(Pedido pedido);
	public Pedido procurar(String identificador);
	public void remover(String identificador);
	public void atualizar(Pedido pedido);

}
