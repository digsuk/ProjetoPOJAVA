/*---------------------------------------------
 * Autor: Diogo Souza
 * Data: 30/06/2018
 *---------------------------------------------
 * Descrição: Classe de cadastro de 
 * 			  vendedor.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package negocio;

import entidades.Vendedor;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioVendedor;

public class CadastroVendedor {
	
	private IRepositorioVendedor repositorio;
	
	public CadastroVendedor(IRepositorioVendedor repositorio) {
		this.repositorio = repositorio;
	}
	
	public void inserir(Vendedor vendedor) {
		repositorio.inserir(vendedor);
	}
	
	public Vendedor procurar(String cpf) throws CPFNaoEncontradoException {
		return repositorio.procurar(cpf);
	}
	
	public void remover(String cpf) {
		repositorio.remover(cpf);
	}
	
	public void atualizar(Vendedor vendedor) {
		repositorio.atualizar(vendedor);
	}

}
