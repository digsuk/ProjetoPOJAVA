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
import interfaces.IRepositorioPedido;

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
		
		String valores =  "values (default,\'" + pedido.getData() 		  + "\',\'" 
				   + pedido.getItemProduto()   + "\'," 
				   + pedido.getQuantidade()  + "," 
				   + pedido.getCPF() 	  + ")" ;
		
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

}
