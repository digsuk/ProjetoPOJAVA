/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:24/06/2018
 *---------------------------------------------
 * Descrição: Classe de relatório de vendas.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data            Autor         Descrição
 * 		    |   	        | 
 *----------------------------------------------------*/

package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entidades.Pedido;
import entidades.Relatorio;
import negocio.Fachada;
import negocio.ModeloTabelaPedido;
import negocio.ModeloTabelaVendProd;
import negocio.ValidarDados;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class TelaRelatorioVendas extends JFrame {

	private JPanel contentPane;
	public static TelaRelatorioVendas instance;
	private JTextField textFieldVendedorCpf;
	private JTable tablePedidos;
	private ModeloTabelaPedido modeloTabelaPedido;
	private JTextField textFieldDataDe;
	private JTextField textFieldDataAte;
	
	public void limparCampos(){
		
	}
	
	public static TelaRelatorioVendas getInstance() {
		if (instance == null)
			instance = new TelaRelatorioVendas();
		return instance;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioVendas frame = new TelaRelatorioVendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRelatorioVendas() {
		setResizable(false);
		setTitle("An\u00E1lise de Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatorioDeVendas = new JLabel("Relatório de Vendas");
		lblRelatorioDeVendas.setForeground(SystemColor.window);
		lblRelatorioDeVendas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRelatorioDeVendas.setBounds(26, 99, 173, 25);
		contentPane.add(lblRelatorioDeVendas);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 135, 594, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVendedorCpf = new JLabel("Vendedor CPF:");
		lblVendedorCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendedorCpf.setBounds(43, 49, 103, 14);
		panel.add(lblVendedorCpf);
		
		textFieldVendedorCpf = new JTextField();
		textFieldVendedorCpf.setBounds(145, 48, 157, 20);
		panel.add(textFieldVendedorCpf);
		textFieldVendedorCpf.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		contentPane.add(menuBar);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem cadastrarProduto = new JMenuItem("Cadastrar");
		cadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				TelaCadProd.getInstance().setVisible(true);
				dispose();
			}
		});
		mnProduto.add(cadastrarProduto);
		
		JMenuItem gerenciarProduto = new JMenuItem("Gerenciar");
		gerenciarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerenciaProd.getInstance().setVisible(true);
				limparCampos();
				dispose();
			}
		});
		mnProduto.add(gerenciarProduto);
		
		JMenu mnVendedor = new JMenu("Vendedor");
		menuBar.add(mnVendedor);
		
		JMenuItem cadastrarVendedor = new JMenuItem("Cadastrar");
		mnVendedor.add(cadastrarVendedor);
		
		JMenuItem gerenciarVendedor = new JMenuItem("Gerenciar");
		mnVendedor.add(gerenciarVendedor);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem relatorio = new JMenuItem("Relat\u00F3rio");
		mnVendas.add(relatorio);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBorder(UIManager.getBorder("MenuItem.border"));
		btnSair.setBorderPainted(false);
		btnSair.setBackground(SystemColor.control);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValidarDados.funcionario = null;
				TelaLogin.getInstance().setVisible(true);
				dispose();
			}
		});
		menuBar.add(btnSair);
		JButton btnInfoAjuda = new JButton(" Informa\u00E7\u00F5es de ajuda");
		btnInfoAjuda.setBounds(26, 65, 152, 23);
		contentPane.add(btnInfoAjuda);
		btnInfoAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnInfoAjuda.setIcon(new ImageIcon(TelaCadProd.class.getResource("/imagem/question.png")));
		btnInfoAjuda.setForeground(Color.BLACK);
		btnInfoAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInfoAjuda.setBorderPainted(false);
		btnInfoAjuda.setBorder(null);
		btnInfoAjuda.setBackground(Color.WHITE);
		
		modeloTabelaPedido = new ModeloTabelaPedido();
		tablePedidos = new JTable(modeloTabelaPedido);
		tablePedidos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tablePedidos.setBounds(68, 163, 100, 30);
		tablePedidos.setPreferredScrollableViewportSize(new Dimension(500,100));
		tablePedidos.setFillsViewportHeight(true);
		JScrollPane scrollPaneVendProd = new JScrollPane(tablePedidos);
		scrollPaneVendProd.setBounds(10, 194, 574, 130);
		panel.add(scrollPaneVendProd);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(43, 97, 58, 14);
		panel.add(lblData);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDe.setBounds(95, 97, 40, 14);
		panel.add(lblDe);
		
		JLabel lblAte = new JLabel("at\u00E9");
		lblAte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAte.setBounds(247, 97, 40, 14);
		panel.add(lblAte);
		
		textFieldDataDe = new JTextField();
		textFieldDataDe.setBounds(126, 96, 87, 20);
		panel.add(textFieldDataDe);
		textFieldDataDe.setColumns(10);
		
		textFieldDataAte = new JTextField();
		textFieldDataAte.setColumns(10);
		textFieldDataAte.setBounds(285, 96, 87, 20);
		panel.add(textFieldDataAte);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloTabelaPedido.getRowCount()>0)
					modeloTabelaPedido.removePedidoAt(0);
				
				String cpf = textFieldVendedorCpf.getText();
				String dataDe = textFieldDataDe.getText();
				String dataAte = textFieldDataAte.getText();
				ArrayList<Pedido> lista;
				List relatorio = new ArrayList();
				
				if(ValidarDados.validarData(dataDe, dataAte)){
					lista = (ArrayList<Pedido>) Fachada.getInstance().procurarPedido(cpf,dataDe,dataAte);
					
					if(!lista.isEmpty()){
						for(Pedido p: lista){
							Relatorio r = new Relatorio();
							r.setCliente(p.getCliente().getNome());
							r.setData(p.getData());
							r.setItemPedido(p.getItemPedido().getProduto());
							r.setQuantidade(p.getItemPedido().getQuantidade());
							r.setValor_total(p.getItemPedido().getValorTotal());
							r.setVendedor(p.getVendedor().getNome());
							relatorio.add(r);
						}
						modeloTabelaPedido.addPedidoList(relatorio);
					}
				}
			}
		});
		btnNewButton.setBounds(399, 95, 89, 23);
		panel.add(btnNewButton);
		
	}
}
