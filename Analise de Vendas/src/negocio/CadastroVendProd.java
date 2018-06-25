package negocio;

import entidades.Produto;
import entidades.Vendedor;

import java.sql.ResultSet;
import java.util.List;

import entidades.Funcionario;
import interfaces.IRepositorioVendProd;

public class CadastroVendProd {
private IRepositorioVendProd repositorio;
	
	public CadastroVendProd(IRepositorioVendProd repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Vendedor vendedor,Produto produto){
		repositorio.inserir(vendedor,produto);
	}
	public List listar(String cpf){
		return repositorio.listar(cpf);
	}
	public Produto procurar(String produto_nome, String cpf){
		return repositorio.procurar(produto_nome, cpf);
	}
	public void atualizar(Produto produto, String vendedor_cpf){
		repositorio.atualizar(produto, vendedor_cpf);
	}
	public void remover(String produto_nome, String vendedor_cpf) {
		repositorio.remover(produto_nome, vendedor_cpf);
	}

}
