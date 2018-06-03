/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data: 14/05/2018
 *---------------------------------------------
 * Descrição: Classe de cadastro de 
 * 			  funcionário.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package negocio;

import java.sql.ResultSet;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioFuncionario;

public class CadastroFuncionario {
	private IRepositorioFuncionario repositorio;
	
	public CadastroFuncionario(IRepositorioFuncionario repositorio){
		this.repositorio = repositorio;
	}
	
	public void inserir(Funcionario funcionario){
		repositorio.inserir(funcionario);
	}
	public Funcionario procurar(String identificador) throws CPFNaoEncontradoException{
		return repositorio.procurar(identificador);
	}
	public void remover(String identificador){
		repositorio.remover(identificador);
	}
	public void atualizar(Funcionario funcionario){
		repositorio.atualizar(funcionario);
	}
	public ResultSet listar(){
		return repositorio.listar();
	}
	public ResultSet listar(String identificador){
		return repositorio.listar(identificador);
	}
	
}
