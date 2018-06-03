/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de cadastro do produto 
 * 			  no repositorio BD ou Array.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package negocio;
import java.sql.ResultSet;

import entidades.Produto;
import interfaces.IRepositorioProduto;
public class CadastroProduto {
	private IRepositorioProduto repositorio;
	
	public CadastroProduto(IRepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Produto produto){
		repositorio.inserir(produto);
	}
	public Produto procurar(String identificador) {
			return repositorio.procurar(identificador);
	}
	public void remover(String identificador){
		repositorio.remover(identificador);
	}
	public void atualizar(Produto produto){
		repositorio.atualizar(produto);
	}
	public ResultSet listar(){
		return repositorio.listar();
	}
}