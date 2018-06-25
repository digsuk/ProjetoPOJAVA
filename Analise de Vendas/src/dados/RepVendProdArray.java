/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:03/06/2018
 *---------------------------------------------
 * Descri��o: Classe de reposit�rio de 
 * 			  produtos do vendedor.
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    		Autor 		   Descri��o
 *  | | 
 *-------------------------------------------*/
package dados;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;
import entidades.Produto;
import entidades.Vendedor;
import interfaces.IRepositorioVendProd;

public class RepVendProdArray implements IRepositorioVendProd{
	public static final int TAMANHO = 1000000;
	private int indice;
	private int i;
	private Produto[] repositorio;
	
	public RepVendProdArray() {
		this.repositorio = new Produto[TAMANHO];
		indice = 0;
	}
	
	public int getIndice(String nome,String cpf) {
		i = 0;
		if (indice != 0) {
			while (!nome.equals(repositorio[i].getNome()) & !cpf.equals(repositorio[i].getDistribuido())) {
				if (i == indice - 1) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}
	
	public boolean existe(String nome, String cpf) {
		i = getIndice(nome,cpf);
		if (i == -1)
			return false;
		else
			return true;
	}
	
	public void inserir(Vendedor vendedor, Produto produto){
		if (!existe(produto.getNome(),vendedor.getCpf())) {
			produto.setDistribuido(vendedor.getCpf());
			repositorio[indice] = produto;
			indice++;
		}
	}
	public List listar(String cpf){
		i = 0;
		List produtos = new ArrayList();
		while(i < indice){
			if(repositorio[i].getDistribuido().equals(cpf))
				produtos.add(repositorio[i]);
			i++;
		}
		return produtos;
	}
	public Produto procurar(String nome, String cpf){
		if(!existe(nome,cpf)){
			return null;
		}
		return repositorio[i];
	}
	public void atualizar(Produto produto, String cpf){
		if (!existe(produto.getNome(),cpf)) {
			System.err.println("Erro!");
		}else{
			repositorio[i] = produto;
		}
	}
	public void remover(String nome, String cpf){
		if (!existe(nome,cpf)) {
			System.err.println("Erro!");
		}else{
		repositorio[i] = null;
		repositorio[i] = repositorio[indice - 1];
		repositorio[indice - 1] = null;
		indice--;
		}
	}
}
