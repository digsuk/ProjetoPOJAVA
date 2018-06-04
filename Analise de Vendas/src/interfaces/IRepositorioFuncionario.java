/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data: 26/05/2018
 *---------------------------------------------
 * Descrição: Interface para repositório de 
 * 			  funcionário.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package interfaces;

import java.sql.ResultSet;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;

public interface IRepositorioFuncionario {
	public void inserir(Funcionario produto);
	public Funcionario procurar(String identificador) throws CPFNaoEncontradoException;
	public void remover(String identificador);
	public void atualizar(Funcionario produto);
	public ResultSet listar();
	public ResultSet listar(String identificador);
}
