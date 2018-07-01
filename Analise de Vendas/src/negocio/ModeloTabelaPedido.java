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

import entidades.Relatorio;

public class ModeloTabelaPedido extends AbstractTableModel{
	private ArrayList<Relatorio> dataList = new ArrayList();
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

	public void addPedido(Relatorio r) {
		dataList.add(r);
		fireTableDataChanged();
	}

	public void addPedidoList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public Relatorio getPedidoAt(int row) {
		return dataList.get(row);
	} 
	
	public int getPedidoAt(Relatorio pedido){
		return dataList.lastIndexOf(pedido);
	}

	public Relatorio removePedidoAt(int row) {
		Relatorio r;
		r = dataList.remove(row);
		fireTableDataChanged();
		return r;
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
		Relatorio r = dataList.get(row);
		switch (col) {
		case 0:
			return r.getVendedor();
		case 1:
			return r.getCliente();
		case 2:
			return r.getItemPedido();
		case 3:
			return r.getQuantidade();
		case 4:
			return r.getValor_total();
		case 5:
			return r.getData();
		default:
			return null;
		}
	}
}
