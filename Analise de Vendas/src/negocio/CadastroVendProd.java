package negocio;

import entidades.Produto;

import java.sql.ResultSet;

import entidades.Funcionario;
import interfaces.IRepositorioVendProd;

public class CadastroVendProd {
private IRepositorioVendProd repositorio;
	
	public CadastroVendProd(IRepositorioVendProd repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Funcionario vendedor,Produto produto){
		repositorio.inserir(vendedor,produto);
	}
	public ResultSet listar(String cpf){
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
