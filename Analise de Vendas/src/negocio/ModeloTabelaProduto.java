package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Produto;

public class ModeloTabelaProduto extends AbstractTableModel {
	private ArrayList<Produto> dataList = new ArrayList();
	private String[] columns={"Nome", "Descri\u00E7\u00E3o", "Quantidade", "Valor"};
	Class[] columnTypes = new Class[] {Object.class, Object.class, Object.class, Object.class};
	boolean[] columnEditables = new boolean[] {false, false, false, false};
	
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	public ModeloTabelaProduto() {

	}

	public ModeloTabelaProduto(List l) {
		dataList.addAll(l);
	}  

	public void addProduto(Produto p) {
		dataList.add(p);
		fireTableDataChanged();
	}

	public void addProdutoList(List l) {
		dataList.addAll(l);
		fireTableDataChanged();
	}
	
	public Produto getProdutoAt(int row) {
		return dataList.get(row);
	} 
	
	public int getProdutoAt(Produto produto){
		return dataList.lastIndexOf(produto);
	}

	public Produto removeProdutoAt(int row) {
		Produto p;
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
		Produto p = dataList.get(row);
		switch (col) {
		case 0:
			return p.getNome();
		case 1:
			return p.getDescricao();
		case 2:
			return String.valueOf(p.getQuantidade());
		case 3:
			return String.valueOf(p.getValor());
		default:
			return null;
		}
	}
}
