/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/05/2018
 *---------------------------------------------
 * Descrição: Classe com dados do cliente.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package entidades;

public class Cliente {
	private String cpf, cnpj, nome;
	
	public Cliente(String cpf, String cnpj, String nome) {
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
