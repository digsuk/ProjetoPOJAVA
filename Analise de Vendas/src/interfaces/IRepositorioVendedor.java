/*---------------------------------------------
 * Autor: Diogo Souza
 * Data: 30/06/2018
 *---------------------------------------------
 * Descrição: Interface para repositório de 
 * 			  vendedor.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package interfaces;

import entidades.Vendedor;
import excecoes.CPFNaoEncontradoException;

public interface IRepositorioVendedor {
	
	public void inserir(Vendedor vendedor);
	public Vendedor procurar(String cpf) throws CPFNaoEncontradoException;
	public void remover(String cpf);
	public void atualizar(Vendedor vendedor);

}
