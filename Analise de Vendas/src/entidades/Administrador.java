/* Autor: Jonathan Moura
 * Data:16/05/2018
 *---------------------------------------------
 * Descrição: Classe de administrador.
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 * 14/05/18 |Jonathan Moura | CRUD funcionário
 *-------------------------------------------*/
package entidades;

public class Administrador extends Funcionario{

	public Administrador(String nome, String cpf, String email, String senha, String funcao) {
		super(nome, cpf, email, senha, funcao);
	}

}
