/* Autor: Jonathan Moura
 * Data:06/05/2018
 *---------------------------------------------
 * Descrição: Classe de repositório para 
 * 			  produtos do vendedor..
 *---------------------------------------------
 * Histórico de modificação
 * Data    		Autor 		   Descrição
 * 14/05/18 |Jonathan Moura | CRUD funcionário
 *-------------------------------------------*/
package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import entidades.Vendedor;
import entidades.Funcionario;
import interfaces.IRepositorioVendProd;
import telas.TelaEditProd;

public class RepVendProdBD extends RepositorioBD implements IRepositorioVendProd{
	private static final String INSERIR   = "INSERT INTO vendedor_produto ";
	private static final String PROCURAR  = "SELECT * FROM vendedor_produto ";
	private static final String ATUALIZAR = "UPDATE vendedor_produto SET quantidade = ? WHERE produto_nome = ? AND vendedor_cpf = ?";
	private static final String REMOVER   = "DELETE FROM vendedor_produto WHERE produto_nome = AND vendedor_cpf = ?";
	private static final String CAMPOS    = "(produto_nome, descricao, quantidade, valor, vendedor_cpf, id) ";	
	
	public void inserir(String vendedorCpf, Produto produto){
		/*Construir comando sql para inserir os valores 
		 *dos atributos do produto e do vendedor 
		 *no repositorio de banco de dados */
		String valores =  "values (\'" + produto.getNome() 		 		 + "\',\'" 
				 							   + produto.getDescricao()  + "\'," 
				 							   + produto.getQuantidade() + "," 
				 							   + produto.getValor() 	 + ",\'" 
											   + vendedorCpf	     	 + "\',"
											   + "default )";
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
	
	public Produto procurar(String produto_nome, String cpf) {
		String where = "WHERE produto_nome = " + "\'"+produto_nome+"\'"
					 + " AND vendedor_cpf = " + "\'"+cpf+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs.next()) {
				Produto produto = new Produto(rs.getString("produto_nome"),
											  rs.getString("descricao"),
											  rs.getInt("quantidade"),
											  rs.getDouble("valor"));
				System.out.println("Produto inserido!");
				return produto;
			} else {
				System.err.println("Produto ainda não inserido!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List listar(String cpf){
		List produtos = new ArrayList();
		String where = "WHERE vendedor_cpf = " + "\'"+cpf+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs != null) {
				while(rs.next()){
					Produto p = new Produto();
					p.setNome(rs.getString("produto_nome"));
					p.setDescricao(rs.getString("descricao"));
					p.setQuantidade(rs.getInt("quantidade"));
					p.setValor(rs.getDouble("valor"));
					produtos.add(p);
				}
				return produtos;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void atualizar(Produto produto, String vendedor_cpf) {
		try {
			PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
			pstm.setInt(1, produto.getQuantidade());
			pstm.setString(2, produto.getNome());
			pstm.setString(3, vendedor_cpf);
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
	
	public void remover(String produto_nome, String vendedor_cpf) {
		try {
			PreparedStatement pstm = con.prepareStatement(REMOVER);
			pstm.setString(1, produto_nome);
			pstm.setString(2, vendedor_cpf);
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
