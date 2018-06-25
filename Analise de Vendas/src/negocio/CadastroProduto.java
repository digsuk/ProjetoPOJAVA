/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Classe de cadastro do produto 
 * 			  no repositorio BD ou Array.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package negocio;
import java.sql.ResultSet;
import java.util.List;

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
	public List listar(){
		return repositorio.listar();
	}
}