/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:24/06/2018
 *---------------------------------------------
 * Descrição: Classe de modelo da tabela 
 * 			  de pedidos.
 *---------------------------------------------
 * Histórico de modificação
 * Data            Autor         Descrição
 *         |               | 
 *----------------------------------------------------*/

package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Pedido;

public class ModeloTabelaPedido extends AbstractTableModel{
	private ArrayList<Pedido> dataList = new ArrayList();
	private String[] columns={"Vendedor", "Cliente","Produto","Quantidade","Valor total","Data"};
	Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};
	boolean[] columnEditables = new boolean[] {false, false, false, false, false, false, false, false, false};
	
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public ModeloTabelaPedido() {

	}

	public ModeloTabelaPedido(List l) {
		dataList.addAll(l);
	}  

	public void addPedido(Pedido p) {
		dataList.add(p);
		fireTableDataChanged();
	}

	public void addPedidoList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public Pedido getPedidoAt(int row) {
		return dataList.get(row);
	} 
	
	public int getPedidoAt(Pedido pedido){
		return dataList.lastIndexOf(pedido);
	}

	public Pedido removeProdutoAt(int row) {
		Pedido p;
		p = dataList.remove(row);
		fireTableDataChanged();
		return p;
	}
	
	public int getRowCount() {
		return dataList.size();
	}
	
	public int getColumnCount() {
		return columns.length;
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	public Object getValueAt(int row, int col) {
		Pedido p = dataList.get(row);
		switch (col) {
		case 3:
			return p.getCliente();
		case 1:
			return p.getVendedor();
		case 6:
			return p.getItemPedido();
		case 9:
			return p.getData();
		default:
			return null;
		}
	}
}
