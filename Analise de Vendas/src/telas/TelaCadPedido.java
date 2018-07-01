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
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.Vendedor;
import excecoes.ProdutoQuantidadeException;
import negocio.ClasseAssistente;
import negocio.Fachada;
import negocio.ModeloTabelaProduto;
import negocio.ModeloTabelaVendProd;
import negocio.ValidarDados;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class TelaCadPedido extends JFrame {

	private JPanel contentPane;
	private static TelaCadPedido instance;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldCpf;
	private JTextField textFieldCnpj;
	private JLabel lblCpf;
	private JLabel lblCnpj;
	private JTable tableClientProd;
	private JTable tableVendProd;
	private ModeloTabelaVendProd modeloVendProd;	
	private ModeloTabelaProduto modeloProduto;
	private JTextField textFieldQuantidade;
	private JTextField textFieldNome;
	private Cliente cliente;
	private JButton btnSair;
	private JButton btnCadastrar;
	private ArrayList<Produto> produtoVendido = new ArrayList();
	
	public static TelaCadPedido getInstance() {
		if (instance == null)
			instance = new TelaCadPedido();
		return instance;
	}
	
	public void limparCampos() {
		deleteInstance();
		dispose();
		TelaCadPedido.getInstance().setVisible(true);
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
		
		JLabel lblCadastroPedido = new JLabel("Cadastro de Pedido");
		lblCadastroPedido.setForeground(Color.WHITE);
		lblCadastroPedido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroPedido.setBounds(22, 93, 173, 25);
		contentPane.add(lblCadastroPedido);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setLayout(null);
		panelCliente.setBackground(Color.WHITE);
		panelCliente.setBounds(0, 135, 594, 437);
		contentPane.add(panelCliente);
		
		JPanel panelProduto = new JPanel();
		panelProduto.setBounds(0, 0, 594, 437);
		panelCliente.add(panelProduto);
		panelProduto.setVisible(false);
		panelProduto.setBackground(Color.WHITE);
		panelProduto.setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cadastrar produto para cliente
				int i = modeloProduto.getRowCount() - 1;
				while(i > -1){
					Produto produto = modeloProduto.getProdutoAt(i);
					Pedido pedido = new Pedido();
					String data;
					Vendedor vendedor = new Vendedor();
					ItemPedido itemPedido = new ItemPedido();
					
					Date date = new Date(System.currentTimeMillis()); 
					SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
					
					data = formatarDate.format(date);
					vendedor.setNome(ValidarDados.funcionario.getNome());
					vendedor.setCpf(ValidarDados.funcionario.getCpf());
					itemPedido.setProduto(produto.getNome());
					itemPedido.setQuantidade(produto.getQuantidade());
					itemPedido.setValorTotal(itemPedido.getQuantidade()*produto.getValor());
					
					pedido.setData(data);
					pedido.setVendedor(vendedor);
					pedido.setCliente(cliente);
					pedido.setItemPedido(itemPedido);
					Fachada.getInstance().cadastrar(pedido);
					i--;
				}
				//Remover produto cadastrado do vendedor			
				String vendedorCPF = ValidarDados.funcionario.getCpf();
				
				//Remover produto do repositorio Vendedor_produto 
				for(Produto p: produtoVendido){
					if(p.getQuantidade() == 0){
						Fachada.getInstance().remover(p.getNome(), vendedorCPF);
					}else{
																		
						//Atualizar Repositório do produto de vendedor
						Fachada.getInstance().atualizar(p, vendedorCPF);
							
						//Atualizar tabela 
						modeloVendProd.addProduto(p);
					}
				}								
				//TODO Gerar nota	
				limparCampos();
			}
		});
		btnCadastrar.setBounds(485, 356, 99, 23);
		panelProduto.add(btnCadastrar);
		btnCadastrar.setEnabled(false);
		
		modeloVendProd = new ModeloTabelaVendProd();
		tableVendProd = new JTable(modeloVendProd);
		tableVendProd.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableVendProd.setBounds(68, 163, 100, 30);
		tableVendProd.setPreferredScrollableViewportSize(new Dimension(500,100));
		tableVendProd.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneVendProd = new JScrollPane(tableVendProd);
		scrollPaneVendProd.setBounds(20, 44, 455, 130);
		panelProduto.add(scrollPaneVendProd);
				
		modeloProduto = new ModeloTabelaProduto();
		tableClientProd = new JTable(modeloProduto);
		tableClientProd.setBounds(68, 163, 100, 30);
		tableClientProd.setPreferredScrollableViewportSize(new Dimension(500,100));
		tableClientProd.setFillsViewportHeight(true);
		
		JScrollPane scrollPaneClientProd = new JScrollPane(tableClientProd);
		scrollPaneClientProd.setBounds(20, 249, 455, 130);
		panelProduto.add(scrollPaneClientProd);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(20, 183, 86, 21);
		panelProduto.add(lblQuantidade);
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(113, 185, 86, 20);
		panelProduto.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] linhas = tableVendProd.getSelectedRows();
				if(linhas.length == 1){
					try{						
						int quantidade = Integer.parseInt(textFieldQuantidade.getText());
						if(quantidade > 0){
							Produto produto; 
							Produto produtoToClient = new Produto();
							
							//Recupera o produto selecionado na tabela
							produto = modeloVendProd.getProdutoAt(linhas[0]);
							
							//Retirar da tabela do vendedor a quantidade de produto selecionado
							produto.retirarProduto(quantidade);
							produtoVendido.add(produto);
							
							//Inserir o produto para o cliente
							produtoToClient.setNome(produto.getNome());
							produtoToClient.setDescricao(produto.getDescricao());
							produtoToClient.setQuantidade(quantidade);
							produtoToClient.setValor(produto.getValor());
							
							//Atualizar tabelas 
							modeloProduto.addProduto(produtoToClient);
							modeloVendProd.removeProdutoAt(linhas[0]);
							modeloVendProd.addProduto(produto);
							textFieldQuantidade.setText("");
							btnCadastrar.setEnabled(true);
							
						}else{
							Popup.quantProd();
						}
					} catch(NumberFormatException nfe){
						Popup.quantProd();
					} catch (ProdutoQuantidadeException pqe) {
						Popup.prodQuantErro();
					}
				}
			}
		});
		btnInserir.setBounds(485, 47, 99, 23);
		panelProduto.add(btnInserir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 574, 14);
		panelProduto.add(separator);
		
		JLabel lblCliente_1 = new JLabel("Cliente");
		lblCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente_1.setBounds(10, 215, 86, 21);
		panelProduto.add(lblCliente_1);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVendedor.setBounds(10, 11, 86, 21);
		panelProduto.add(lblVendedor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 31, 574, 14);
		panelProduto.add(separator_1);
				
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(108, 72, 86, 21);
		panelCliente.add(lblCliente);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setVisible(false);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(108, 141, 47, 21);
		panelCliente.add(lblCpf);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setVisible(false);
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnpj.setBounds(108, 141, 47, 21);
		panelCliente.add(lblCnpj);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setVisible(false);
		textFieldCpf.setBounds(174, 143, 132, 20);
		panelCliente.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setVisible(false);
		textFieldCnpj.setColumns(10);
		textFieldCnpj.setBounds(174, 143, 132, 20);
		panelCliente.add(textFieldCnpj);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(174, 174, 132, 20);
		textFieldNome.setVisible(false);
		panelCliente.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(108, 175, 46, 14);
		lblNome.setVisible(false);
		panelCliente.add(lblNome);
		
		JButton btnProximo = new JButton("Pr\u00F3ximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!textFieldCnpj.getText().equals("") & !textFieldNome.getText().equals("")){
						cliente = new Cliente("",textFieldCnpj.getText(),textFieldNome.getText());
						panelProduto.setVisible(true);
						btnProximo.setVisible(false);
					}else if(!textFieldCpf.getText().equals("") & !textFieldNome.getText().equals("")){
						cliente = new Cliente(textFieldCpf.getText(),"",textFieldNome.getText());
						panelProduto.setVisible(true);
						btnProximo.setVisible(false);
					}else{
						Exception ex = new Exception();
						throw ex;
					}
					//Listar todos os produtos do vendedor.
					if(modeloVendProd.getRowCount() == 0){
						List produtos;
						
						produtos = Fachada.getInstance().listarVendProd(ValidarDados.funcionario.getCpf());
						if(produtos!=null){
							//Insere resultados da busca na tabela.
							ClasseAssistente.montarTabela(produtos, modeloVendProd);
						}
					}
				} catch(Exception ex) {
					
				}
			}
		});
		btnProximo.setBounds(350, 250, 99, 23);
		panelCliente.add(btnProximo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaCadPedido.class.getResource("/imagem/left-pointing-arrow.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProduto.setVisible(false);
				btnProximo.setVisible(true);
			}
		});
		btnVoltar.setBounds(20, 390, 99, 23);
		panelProduto.add(btnVoltar);
		
		JRadioButton rdbtnPessoaFsica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCnpj.setVisible(false);
				textFieldCnpj.setVisible(false);
				textFieldCnpj.setText("");
				textFieldNome.setText("");
				lblCpf.setVisible(true);
				textFieldCpf.setVisible(true);
				lblNome.setVisible(true);
				textFieldNome.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnPessoaFsica);
		rdbtnPessoaFsica.setBackground(Color.WHITE);
		rdbtnPessoaFsica.setBounds(103, 100, 109, 23);
		panelCliente.add(rdbtnPessoaFsica);
		
		JRadioButton rdbtnPessoaJurdica = new JRadioButton("Pessoa Jur\u00EDdica");
		rdbtnPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCpf.setVisible(false);
				textFieldCpf.setVisible(false);
				textFieldCpf.setText("");
				textFieldNome.setText("");
				lblCnpj.setVisible(true);
				textFieldCnpj.setVisible(true);
				lblNome.setVisible(true);
				textFieldNome.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnPessoaJurdica);
		rdbtnPessoaJurdica.setBackground(Color.WHITE);
		rdbtnPessoaJurdica.setBounds(229, 100, 132, 23);
		panelCliente.add(rdbtnPessoaJurdica);
		
		JButton button = new JButton(" Informa\u00E7\u00F5es de ajuda");
		button.setIcon(new ImageIcon(TelaCadPedido.class.getResource("/imagem/question.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(22, 59, 152, 23);
		contentPane.add(button);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		contentPane.add(menuBar);
		
		btnSair = new JButton("Sair");
		btnSair.setBorderPainted(false);
		btnSair.setBackground(SystemColor.control);
		btnSair.setBorder(UIManager.getBorder("MenuItem.border"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValidarDados.funcionario = null;
				TelaLogin.getInstance().setVisible(true);
				deleteInstance();
				dispose();
			}
		});
		menuBar.add(btnSair);
		
		
	}
	private void deleteInstance(){
		instance = null;
	}
}
