/*---------------------------------------------
 * Autor: Diogo Souza
 * Data:15/06/2018
 *---------------------------------------------
 * Descrição: Repositorio banco de dados
 *  para pedidos.
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

import entidades.Pedido;
import entidades.Produto;
import interfaces.IRepositorioPedido;
import telas.TelaEditProd;

public class RepPedidoBD implements IRepositorioPedido{
	
	private static final String INSERIR   = "INSERT INTO produto ";
	private static final String PROCURAR  = "SELECT * FROM produto ";
	private static final String REMOVER   = "DELETE FROM produto WHERE nome = ";
	private static final String ATUALIZAR = "UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, valor = ? WHERE nome = ?";
	private static final String CAMPOS    = "(id, nome, descricao, quantidade, valor) ";
	
	public RepPedidoBD() {
		super();
	}
	
	public void inserir(Pedido pedido) {
		
		String valores =  "values (default,\'" + pedido.getData().getDay()	  + "\',\'" 
				           + pedido.getData().getMonth()   + "\'," 
						   + pedido.getData().getYear()   + "\',"
						   + pedido.getItemPedido().getValorTotal()   + "\',"
						   + pedido.getItemPedido().getQuantidade()   + "\',"
						   + pedido.getItemPedido().getProduto().getNome()   + "\',"
						   + pedido.getCliente().getCpf()   + "\'," ;
				   
		
		String comando = INSERIR + CAMPOS + valores;
		
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
	
	public Pedido procurar(String identificador) {
		
		String where = "WHERE nome = " + "\'"+identificador+"\'";
		String comando = PROCURAR + where;
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			if (rs.next()) {
			Pedido pedido = new Pedido(rs.getDate("Dia"),
						rs.getDate("Mês"),
						rs.getDate("Ano"),
						rs.getDouble("Valor Total"),
						rs.getInt("Quantidade"),
						rs.getString("Nome"),
						rs.getString("Cpf"));
				System.out.println("Sucesso!");
				return pedido;
			} else {
				System.err.println("Erro!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void atualizar(Pedido pedido) {
		
		try {
			PreparedStatement pstm = con.prepareStatement(ATUALIZAR);
			pstm.setInt(1, pedido.getData().getDay());
			pstm.setInt(2, pedido.getData().getMonth());
			pstm.setInt(3, pedido.getData().getYear());
			pstm.setDouble(4, pedido.getItemPedido().getValorTotal());
			pstm.setInt(5, pedido.getItemPedido().getQuantidade());
			pstm.setString(6, pedido.getItemPedido().getProduto().getNome());
			pstm.setString(7, pedido.getCliente().getCpf());
			pstm.setString(8, TelaEditProd.getInstance().pedidoEditado.getNome());
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
