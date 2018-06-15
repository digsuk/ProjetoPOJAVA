/*------------------------------------------------
 * Autor: Diogo Souza
 * Data:04/05/2018
 *------------------------------------------------
 * Descrição: Tela para cadastro de pedidos.
 *------------------------------------------------
 * Histórico de modificação
 * Data             Autor                   Descrição
 * 09/06/2018 | Diogo Souza  | Criação da tela
 * 11/06/2018 | Diogo Souza  | Implementação da tela
 *-------------------------------------------------------*/          
package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocio.ValidarDados;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaCadPedido extends JFrame {

	private JPanel contentPane;
	private static TelaCadPedido instance;
	private JTextField textFieldData;
	private JTextField textFieldItemProduto;
	private JTextField textFieldItemValorTotal;
	private JTextField textFieldQuantidade;
	private JTextField textFieldCPF;
	
	public static TelaCadPedido getInstance() {
		if (instance == null)
			instance = new TelaCadPedido();
		return instance;
	}
	
	public void limparCampos() {
		textFieldData.setText("");
		textFieldItemProduto.setText("");
		textFieldItemValorTotal.setText("");
		textFieldQuantidade.setText("");
		textFieldCPF.setText("");
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadPedido frame = new TelaCadPedido();
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
	public TelaCadPedido() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(108, 73, 86, 21);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(204, 73, 140, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblItemProduto = new JLabel("Nome do Produto:");
		lblItemProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemProduto.setBounds(108, 135, 86, 21);
		contentPane.add(lblItemProduto);
		
		textFieldItemProduto = new JTextField();
		textFieldItemProduto.setBounds(204, 137, 140, 20);
		contentPane.add(textFieldItemProduto);
		textFieldItemProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(108, 204, 86, 21);
		contentPane.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(204, 206, 140, 20);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JLabel lblItemValorTotal = new JLabel("Valor Total:");
		lblItemValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemValorTotal.setBounds(108, 275, 86, 21);
		contentPane.add(lblItemValorTotal);
		
		textFieldItemValorTotal = new JTextField();
		textFieldItemValorTotal.setBounds(204, 275, 140, 20);
		contentPane.add(textFieldItemValorTotal);
		textFieldItemValorTotal.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(108, 333, 86, 21);
		contentPane.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(204, 334, 140, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ValidarDados.validarCampoVazio(textFieldData.getText(), textFieldItemProduto.getText(), textFieldQuantidade.getText(), 
						textFieldItemValorTotal.getText(), textFieldCPF.getText())) {
					try {
						
						Pedido pedidoCadastrado;
						Pedido pedido = new Pedido(textFieldData.getText(), textFieldItemProduto.getText(), Double.parseDouble(textFieldItemValorTotal.getText()),
								Integer.parseInt(textFieldQuantidade.getText()), textFieldCPF.getText());
						
						pedidoCadastrado = Fachada.getInstance().procurarPedido(textFieldNome.getText());
						if(pedidoCadastrado == null) {
							Fachada.getInstance().cadastrarPedido(pedido);
							JOptionPane.showMessageDialog(null, "mensagemdepedidocadastradocomsucesso");
							limparCampos();
						}else {
							//popup para erro de cadastro de pedido	
							}
						
					}catch() {
						//colocar popup para numberformatexception
					}
				}
			}
		});
		btnCadastrar.setBounds(204, 394, 99, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCadastroPedido = new JLabel("Cadastro de Pedido");
		lblCadastroPedido.setForeground(Color.WHITE);
		lblCadastroPedido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroPedido.setBounds(17, 37, 173, 25);
		contentPane.add(lblCadastroPedido);
		
		JButton btnAjuda = new JButton("Informa\u00E7\u00F5es de Ajuda");
		btnAjuda.setBounds(400, 27, 173, 25);
		contentPane.add(btnAjuda);
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjuda.setIcon(new ImageIcon(TelaCadPedido.class.getResource("/imagem/question.png")));
		btnAjuda.setBackground(Color.WHITE);
		btnAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		contentPane.add(menuBar);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnProduto.add(mntmCadastrar);
		
		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		mnProduto.add(mntmGerenciar);
		
		JMenu mnVendedor = new JMenu("Vendedor");
		menuBar.add(mnVendedor);
		
		JMenuItem mntmCadastrar1 = new JMenuItem("Cadastrar");
		mnVendedor.add(mntmCadastrar1);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnVendedor.add(mntmBuscar);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmRelatorio = new JMenuItem("Relatorio");
		mnVendas.add(mntmRelatorio);
		
		
	}
}
