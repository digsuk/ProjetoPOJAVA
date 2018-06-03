/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/04/2018
 *---------------------------------------------
 * Descrição: Classe do vendedor
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package entidades;

public class Vendedor extends Funcionario{
	Produto[] produtos;
	
	public Vendedor(String nome, String cpf, String email, String senha, String funcao, String chave, Produto[] produtos) {
		super(nome, cpf, email, senha, funcao, chave);
		this.produtos = produtos;
	}

}