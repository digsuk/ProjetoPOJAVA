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
	String subalterno;
	
	public Vendedor(){
		
	}
	
	public Vendedor(String nome, String cpf, String email, String senha, String funcao, String subalterno){
		super(nome, cpf, email, senha, funcao);
		this.subalterno = subalterno;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}
}