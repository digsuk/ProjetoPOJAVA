package interfaces;

import entidades.Produto;
import entidades.Vendedor;

import java.sql.ResultSet;
import java.util.List;

public interface IRepositorioVendProd {

	public void inserir(Vendedor vendedor, Produto produto);
	public List listar(String cpf);
	public Produto procurar(String produto_nome, String cpf);
	public void atualizar(Produto produto, String cpf);
	public void remover(String produto_nome, String vendedor_cpf);
}
