/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:30/04/2018
 *---------------------------------------------
 * Descrição: Repositorio banco de dados para
 * 			  funcionário.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioFuncionario;

public class RepFuncBD extends RepositorioBD implements IRepositorioFuncionario{
	private static final String INSERIR   = "INSERT INTO funcionario ";
	private static final String PROCURAR  = "SELECT * FROM funcionario ";
	private static final String REMOVER   = "DELETE FROM funcionario WHERE cpf = ";
	private static final String ATUALIZAR = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, senha = ?, funcao = ? chave = ? WHERE cpf = ?";
	private static final String CAMPOS    = "(id, nome, cpf, email, senha, funcao, chave) ";	
	
	public RepFuncBD(){
		super();
	}
	
	/*Método que recebe o funcionario, monta o camando sql
	 *de inserção e grava no banco de dados*/
	public void inserir(Funcionario funcionario) {
		/*Construir comando sql para inserir os valores 
		 *dos atributos do funcionario no repositorio de banco de dados */
		String valores =  "values (default,\'" + funcionario.getNome()   + "\',\'" 
				 							   + funcionario.getCpf()    + "\',\'" 
				 							   + funcionario.getEmail()  + "\',\'" 
				 							   + funcionario.getSenha()  + "\',\'"
				 							   + funcionario.getFuncao() + "\',\'"
				 							   + funcionario.getChave()  + "\')";
		String comando = INSERIR + CAMPOS + valores;
		//Grava no banco de dados
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(comando);
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Funcionario procurar(String identificador) throws CPFNaoEncontradoException{
		String where = "WHERE cpf = " + "\'"+identificador+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs.next()) {
				Funcionario funcionario = new Funcionario(rs.getString("nome"),
											  rs.getString("cpf"),
											  rs.getString("email"),
											  rs.getString("senha"),
											  rs.getString("funcao"),
											  rs.getString("chave"));
				return funcionario;
			} else {
				CPFNaoEncontradoException cpfnee = new CPFNaoEncontradoException(identificador);
				throw cpfnee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet listar(){
		String comando = PROCURAR;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs != null) {
				System.out.println("Sucesso!");
				return rs;
			} else {
				System.err.println("Erro!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet listar(String chave){
		String where = "WHERE chave = " + "\'"+chave+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs != null) {
				System.out.println("Sucesso!");
				return rs;
			} else {
				System.err.println("Erro!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void remover(String identificador) {
		String comando = REMOVER + "\'"+identificador+"\'";
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(comando);
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		try {
			PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			pstm.setString(3, funcionario.getEmail());
			pstm.setString(4, funcionario.getSenha());
			pstm.setString(5, funcionario.getFuncao());
			pstm.setString(6, funcionario.getChave());
			pstm.setString(7, funcionario.getCpf());
			int res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("Sucesso!");
			} else {
				System.err.println("Erro!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
