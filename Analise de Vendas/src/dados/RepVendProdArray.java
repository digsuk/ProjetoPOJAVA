/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:03/06/2018
 *---------------------------------------------
 * Descrição: Classe de repositório de 
 * 			  produtos do vendedor.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 *  | | 
 *-------------------------------------------*/
package dados;

import java.sql.ResultSet;

import entidades.Funcionario;
import entidades.Produto;
import entidades.Vendedor;
import interfaces.IRepositorioVendProd;

public class RepVendProdArray implements IRepositorioVendProd{
	public static final int TAMANHO = 1000000;
	private int indice;
	private int i;
	private Vendedor[] repositorio;
	
	public RepVendProdArray() {
		this.repositorio = new Vendedor[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String cpf) {
		i = 0;
		if (indice != 0) {
			while (!cpf.equals(repositorio[i].getCpf())) {
				if (i == indice - 1) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}
	
	public void inserir(Funcionario vendedor, Produto produto){
		
	}
	public ResultSet listar(String cpf){
		ResultSet rs = null;
		return rs;
	}
	public Produto procurar(String produto_nome, String cpf){
		Produto produto = null;
		return produto;
	}
	public void atualizar(Produto produto, String cpf){
		
	}
	public void remover(String produto_nome, String vendedor_cpf){
		
	}
}
