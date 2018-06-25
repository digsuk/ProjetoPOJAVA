/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:29/05/2018
 *---------------------------------------------
 * Descrição: Classe com dados do Pedido.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package entidades;

import java.util.Date;

public class Pedido {
	private Date data; 
	private ItemPedido itemPedido;
	private Cliente cliente;
	Vendedor vendedor;
	
	public Pedido(Date data, ItemPedido itemPedido, Cliente cliente, Vendedor vendedor) {
		super();
		this.data = data;
		this.itemPedido = itemPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
