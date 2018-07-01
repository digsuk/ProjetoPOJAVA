/*---------------------------------------------
 * Autor: Jonathan Moura
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.Vendedor;
import interfaces.IRepositorioPedido;
import telas.TelaEditProd;

public class RepPedidoBD extends RepositorioBD implements IRepositorioPedido{
	
	private static final String INSERIR   = "INSERT INTO pedido ";
	private static final String PROCURAR  = "SELECT * FROM pedido ";
	private static final String CAMPOS    = "(vendedor_cpf, vendedor_nome, cliente_cpf, cliente_cnpj, "
											+ "cliente_nome, produto_nome, quantidade, valor_total, data, id) ";
	
	public RepPedidoBD() {
		super();
	}
	
	public void inserir(Pedido pedido) {
		
		String valores =  "values (\'" + pedido.getVendedor().getCpf() + "\',\'" 
				           + pedido.getVendedor().getNome() + "\',\'" 
						   + pedido.getCliente().getCpf() + "\',\'"
						   + pedido.getCliente().getCnpj() + "\',\'"
						   + pedido.getCliente().getNome() + "\',\'"
						   + pedido.getItemPedido().getProduto() + "\',"
						   + pedido.getItemPedido().getQuantidade() + ","
						   + pedido.getItemPedido().getValorTotal() + ",\'"
						   + pedido.getData() + "\'," 
				   		   + "default )";
		
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
		
	public List procurar(String cpf) {
		
		String where = "WHERE vendedor_cpf = " + "\'"+cpf+"\'";
		String comando = PROCURAR + where;
		List pedidos = new ArrayList();
		try {
			Statement stm = con.createStatement(1, 0);
			ResultSet rs = stm.executeQuery(comando);
			while(rs.next()){
				Pedido pedido = new Pedido();
				Vendedor vendedor = new Vendedor();
				Cliente cliente = new Cliente();
				ItemPedido itemPedido = new ItemPedido();
				String data;
								
				vendedor.setNome(rs.getString("vendedor_nome"));
				vendedor.setCpf(rs.getString("vendedor_cpf"));
				
				cliente.setNome(rs.getString("cliente_nome"));
				cliente.setCpf(rs.getString("cliente_cpf"));
				cliente.setCnpj(rs.getString("cliente_cnpj"));
			
				itemPedido.setProduto(rs.getString("produto_nome"));
				itemPedido.setQuantidade(rs.getInt("quantidade"));
				itemPedido.setValorTotal(rs.getDouble("valor_total"));
				
				data = rs.getString("data");
				
				pedido.setCliente(cliente);
				pedido.setVendedor(vendedor);
				pedido.setItemPedido(itemPedido);
				pedido.setData(data);
					
				pedidos.add(pedido);
			}
			if(!pedidos.isEmpty()){
				return pedidos;
			} else {
				System.err.println("Pedido não encontrado");
				return new ArrayList();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList();
		}
	}
}
