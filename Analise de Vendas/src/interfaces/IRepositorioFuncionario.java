/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data: 26/05/2018
 *---------------------------------------------
 * Descri��o: Interface para reposit�rio de 
 * 			  funcion�rio.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/
package interfaces;

import java.sql.ResultSet;
import java.util.List;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;

public interface IRepositorioFuncionario {
	public void inserir(Funcionario funcionario);
	public Funcionario procurar(String cpf) throws CPFNaoEncontradoException;
	public void remover(String cpf);
	public void atualizar(Funcionario funcionario);
	public ResultSet listar();
	public List listar(String cpf);
}
