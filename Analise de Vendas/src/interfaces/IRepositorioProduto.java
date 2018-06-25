/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:26/05/2018
 *---------------------------------------------
 * Descri��o: Interface para repositorio de
 * 			  produtos.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package interfaces;

import java.sql.ResultSet;
import java.util.List;

import entidades.Produto;

public interface IRepositorioProduto {
	public void inserir(Produto produto);
	public Produto procurar(String identificador);
	public void remover(String identificador);
	public void atualizar(Produto produto);
	public List listar();
}
