/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:26/05/2018
 *---------------------------------------------
 * Descrição: Interface para repositorio de
 * 			  produtos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package interfaces;

import java.sql.ResultSet;

import entidades.Produto;

public interface IRepositorioProduto {
	public void inserir(Produto produto);
	public Produto procurar(String identificador);
	public void remover(String identificador);
	public void atualizar(Produto produto);
	public ResultSet listar();
}
