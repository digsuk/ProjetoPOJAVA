package entidades;

public class Relatorio {
	private String vendedor;
	private String cliente;
	private String itemPedido;
	private int quantidade;
	private double valor_total;
	private String data;
	
	public Relatorio(){
		
	}
	
	public Relatorio(String vendedor, String cliente, String itemPedido, int quantidade, double valor_total, String data) {
		super();
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.itemPedido = itemPedido;
		this.quantidade = quantidade;
		this.valor_total = valor_total;
		this.data = data;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(String itemPedido) {
		this.itemPedido = itemPedido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
