/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:03/05/2018
 *---------------------------------------------
 * Descrição: Repositorio banco de dados
 *  para produtos.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidades.Produto;
import interfaces.IRepositorioProduto;
import telas.TelaEditProd;

public class RepProdBD extends RepositorioBD implements IRepositorioProduto{
	private static final String INSERIR   = "INSERT INTO produto ";
	private static final String PROCURAR  = "SELECT * FROM produto ";
	private static final String REMOVER   = "DELETE FROM produto WHERE nome = ";
	private static final String ATUALIZAR = "UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, valor = ? WHERE nome = ?";
	private static final String CAMPOS    = "(id, nome, descricao, quantidade, valor) ";	
	
	public RepProdBD(){
		super();
	}
	
	/*Método que recebe o produto, monta o camando sql
	 *de inserção e grava no banco de dados*/
	public void inserir(Produto produto) {
		/*Construir comando sql para inserir os valores 
		 *dos atributos do produto no repositorio de banco de dados */
		String valores =  "values (default,\'" + produto.getNome() 		  + "\',\'" 
				 							   + produto.getDescricao()   + "\'," 
				 							   + produto.getQuantidade()  + "," 
				 							   + produto.getValor() 	  + ")" ;
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

	public Produto procurar(String identificador) {
		String where = "WHERE nome = " + "\'"+identificador+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs.next()) {
				Produto produto = new Produto(rs.getString("nome"),
											  rs.getString("descricao"),
											  rs.getInt("quantidade"),
											  rs.getDouble("valor"));
				System.out.println("Sucesso!");
				return produto;
			} else {
				System.err.println("Erro!");
				return null;
			}
		} catch (Exception e) {
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
	
	public void atualizar(Produto produto) {
		try {
			PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setDouble(4, produto.getValor());
			pstm.setString(5, TelaEditProd.getInstance().produtoEditado.getNome());
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