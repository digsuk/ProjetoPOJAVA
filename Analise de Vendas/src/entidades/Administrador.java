/* Autor: Jonathan Moura
 * Data:16/05/2018
 *---------------------------------------------
 * Descri��o: Classe de administrador.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    		Autor 		   Descri��o
 * 14/05/18 |Jonathan Moura | CRUD funcion�rio
 *-------------------------------------------*/
package entidades;

public class Administrador extends Funcionario{

	public Administrador(String nome, String cpf, String email, String senha, String funcao) {
		super(nome, cpf, email, senha, funcao);
	}

}
