package interfaces;

import entidades.Produto;

import java.sql.ResultSet;

import entidades.Funcionario;

public interface IRepositorioVendProd {

	public void inserir(Funcionario vendedor, Produto produto);
	public ResultSet listar(String cpf);
	public Produto procurar(String produto_nome, String cpf);
	public void atualizar(Produto produto, String cpf);
	public void remover(String produto_nome, String vendedor_cpf);
}
