package dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidades.Produto;
import entidades.Funcionario;
import interfaces.IRepositorioVendProd;
import telas.TelaEditProd;

public class RepVendProdBD extends RepositorioBD implements IRepositorioVendProd{
	private static final String INSERIR   = "INSERT INTO vendedor_produto ";
	private static final String PROCURAR  = "SELECT * FROM vendedor_produto ";
	private static final String ATUALIZAR = "UPDATE vendedor_produto SET quantidade = ? WHERE produto_nome = ? AND vendedor_cpf = ?";
	private static final String REMOVER   = "DELETE FROM vendedor_produto WHERE produto_nome = AND vendedor_cpf = ?";
	private static final String CAMPOS    = "(id, produto_nome, descricao, quantidade, valor, vendedor_cpf) ";	
	
	public void inserir(Funcionario vendedor, Produto produto){
		/*Construir comando sql para inserir os valores 
		 *dos atributos do produto e do vendedor 
		 *no repositorio de banco de dados */
		String valores =  "values (default,\'" + produto.getNome() 		 + "\',\'" 
				 							   + produto.getDescricao()  + "\'," 
				 							   + produto.getQuantidade() + "," 
				 							   + produto.getValor() 	 + ",\'" 
											   + vendedor.getCpf()	     + "\')";
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
	
	public ResultSet listar(String cpf){
		String where = "WHERE vendedor_cpf = " + "\'"+cpf+"\'";
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
