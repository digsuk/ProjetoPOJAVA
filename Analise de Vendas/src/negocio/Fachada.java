/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe fachada para cadastro
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 * 14/05/18 |Jonathan Moura | CRUD funcionário
 *-------------------------------------------*/
package negocio;
import java.sql.ResultSet;

import dados.*;
import entidades.Funcionario;
import entidades.Produto;
import entidades.Vendedor;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioFuncionario;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioVendProd;
public class Fachada {
	private static Fachada instance;
	private CadastroProduto produto;
	private CadastroFuncionario funcionario;
	private CadastroVendProd vendProd;
	public Fachada(){
		IRepositorioProduto repProd = new RepProdBD();
		IRepositorioFuncionario repFunc = new RepFuncBD();
		IRepositorioVendProd repVendProd = new RepVendProdBD();
		
		vendProd = new CadastroVendProd(repVendProd);
		produto = new CadastroProduto(repProd);
		funcionario = new CadastroFuncionario(repFunc);
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		return instance;
	}
	//INICIO CRUD de produto
	public void cadastrar(Produto produto){
		this.produto.inserir(produto);
	}
	public Produto procurarProd(String identificador){
		return (Produto) produto.procurar(identificador);
	}
	public void removerProd(String identificador)  {
		produto.remover(identificador);
	}	
	public void atualizar(Produto produto)  {
		this.produto.atualizar(produto);
	}
	public ResultSet listarProd(){
		return this.produto.listar();
	}
	//FIM CRUD de produto
	
	//INICIO CRUD de funcionário
	public void cadastrar(Funcionario funcionario){
		this.funcionario.inserir(funcionario);
	}
	public Funcionario procurarFunc(String identificador)throws CPFNaoEncontradoException{
		return (Funcionario) funcionario.procurar(identificador);
	}
	public void removerFunc(String identificador)  {
		funcionario.remover(identificador);
	}	
	public void atualizar(Funcionario funcionario)  {
		this.funcionario.atualizar(funcionario);
	}
	public ResultSet listarFunc(){
		return this.funcionario.listar();
	}
	public ResultSet listarSubordinados(String chave){
		return this.funcionario.listar(chave);
	}
	//FIM CRUD de funcionário
	
	//INICIO CRUD de vendedor_produto
	public void cadastrar(Funcionario vendedor, Produto produto){
		this.vendProd.inserir(vendedor,produto);
	}
	public ResultSet listarVendProd(String cpf){
		return this.vendProd.listar(cpf);
	}
	public Produto procurar(String produto_nome, String cpf){
		return this.vendProd.procurar(produto_nome, cpf);
	}
	public void atualizar(Produto produto, String vendedor_cpf){
		this.vendProd.atualizar(produto, vendedor_cpf);
	}
	public void remover(String produto_nome, String vendedor_cpf) {
		this.vendProd.remover(produto_nome, vendedor_cpf);
	}
	//FIM CRUD de vendedor_produto
}