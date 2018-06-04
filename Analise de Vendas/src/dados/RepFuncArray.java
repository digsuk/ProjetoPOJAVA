/* Autor: Jonathan Moura
 * Data:26/05/2018
 *---------------------------------------------
 * Descrição: Classe de repositório para 
 * 			  funcionário.
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 * 14/05/18 |Jonathan Moura | CRUD funcionário
 *-------------------------------------------*/
package dados;

import java.sql.ResultSet;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioFuncionario;

public class RepFuncArray implements IRepositorioFuncionario{
	public static final int TAMANHO = 1000000;
	private int indice;
	private int i;
	private Funcionario[] repositorio;
	
	public RepFuncArray() {
		this.repositorio = new Funcionario[TAMANHO];
		indice = 0;
	}

	public int getIndice(String identificador) {
		i = 0;
		if (indice != 0) {
			while (!identificador.equals(repositorio[i].getCpf())) {
				if (i == indice - 1) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}

	public void inserir(Funcionario funcionario) {
		if (!existe(funcionario.getCpf())) {
			repositorio[indice] = funcionario;
			indice++;
		}
	}

	public boolean existe(String identificador) {
		i = getIndice(identificador);
		if (i == -1)
			return false;
		else
			return true;
	}

	public Funcionario procurar(String identificador) throws CPFNaoEncontradoException{
		if (existe(identificador)) {
			return this.repositorio[i];
		} else{
			CPFNaoEncontradoException cpfnee = new CPFNaoEncontradoException(identificador);
			throw cpfnee;
		}
	}

	public void remover(String identificador) {
		if (!existe(identificador)) {
			System.err.println("Erro!");
		}
		repositorio[i] = null;
		repositorio[i] = repositorio[indice - 1];
		repositorio[indice - 1] = null;
		indice--;
	}
	
	public void atualizar(Funcionario funcionario) {
		if (!existe(funcionario.getNome())) {
			System.err.println("Erro!");
		}
		repositorio[i] = funcionario;
	}
	
	public ResultSet listar(){
		ResultSet rs = null;
		return rs;
	}
	
	public ResultSet listar(String identificador){
		ResultSet rs = null;
		return rs;
	}
	
}
