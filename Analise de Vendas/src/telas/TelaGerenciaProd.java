/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:13/05/2018
 *---------------------------------------------
 * Descrição: Classe de tela da busca de 
 * 			  produtos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Funcionario;
import entidades.Produto;
import entidades.Vendedor;
import excecoes.CPFNaoEncontradoException;
import excecoes.ProdutoQuantidadeException;
import negocio.ClasseAssistente;
import negocio.Fachada;
import negocio.ModeloTabelaProduto;
import negocio.ModeloTabelaVendProd;
import negocio.ValidarDados;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaGerenciaProd extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldQuantidade;
	private JTable tableProdutos;
	private JTable tableVendProd;
	private ModeloTabelaProduto modelo; 
	private ModeloTabelaVendProd modeloVendProd; 
	private JScrollPane scrollPaneProdutos;
	private JScrollPane scrollPaneVendProd;
	public static TelaGerenciaProd instance;
	private JButton btnRemover;
	private JButton btnRemoverProdVend;
	private JButton btnEditar;
	private JButton btnDistribuir;
	private JComboBox comboBox;
	private JLabel lblVendedor;
	private JLabel lblQuantidade;
	private List<String> cpf;
	
	public static TelaGerenciaProd getInstance() {
		if (instance == null)
			instance = new TelaGerenciaProd();
		return instance;
	}
	
	public void limparCampos(){
		textFieldNome.setText("");
		if(tableProdutos.getRowCount() > 0)
			tableProdutos.removeRowSelectionInterval(0, tableProdutos.getRowCount() - 1);
		if(comboBox.getItemCount()>0){
			comboBox.removeAllItems();
		}
	}
	
	public void setVisibilidade(Boolean visivel){
		if(visivel == true){
			scrollPaneProdutos.setVisible(true);
			scrollPaneVendProd.setVisible(true);
			btnEditar.setVisible(true);
			btnRemover.setVisible(true);
			btnRemoverProdVend.setVisible(true);
			textFieldQuantidade.setVisible(true);
			comboBox.setVisible(true);
			lblVendedor.setVisible(true);
			btnDistribuir.setVisible(true);
			lblQuantidade.setVisible(true); 
		}else{
			scrollPaneProdutos.setVisible(false);
			scrollPaneVendProd.setVisible(false);
			btnEditar.setVisible(false);
			btnRemover.setVisible(false);
			btnRemoverProdVend.setVisible(false);
			textFieldQuantidade.setVisible(false);
			comboBox.setVisible(false);
			lblVendedor.setVisible(false);
			btnDistribuir.setVisible(false);
			lblQuantidade.setVisible(false);
		}
	}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciaProd frame = new TelaGerenciaProd();
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
	public TelaGerenciaProd() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 135, 594, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(90, 30, 86, 21);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(150, 31, 203, 20);
		panel.add(textFieldNome);
		
		//Busca por um produto ou todos os produtos. Mostra na tabela os produtos encontrados.
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Caso a tabela esteja preenchida, ela será limpada, para receber novos resultados.
				while(modelo.getRowCount()>0)
					modelo.removeProdutoAt(0);
				
				//Caso o campo de busca esteja vazio, será listado todos os produtos cadastrados.
				if (textFieldNome.getText().equals("")) {
					ResultSet rs;
					rs = Fachada.getInstance().listarProd();
					
					//Insere resultados da busca na tabela.
					ClasseAssistente.montarTabelaProduto(rs, modelo);
					
					//Monta o comboBox com os vendedores supordinados ao gerente logado e devolve o cpf do gerente
					cpf = ClasseAssistente.montaComboBox(comboBox);
				} else{
					Produto produto;
					produto = Fachada.getInstance().procurarProd(textFieldNome.getText());
					ClasseAssistente.montarTabelaProduto(produto, modelo);
				}
				setVisibilidade(true);
			}
		});
		btnBuscar.setBounds(383, 31, 89, 23);
		panel.add(btnBuscar);
		
		modelo = new ModeloTabelaProduto();
		tableProdutos = new JTable(modelo);
		tableProdutos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableProdutos.setBounds(68, 163, 100, 30);
		tableProdutos.setPreferredScrollableViewportSize(new Dimension(500,100));
		tableProdutos.setFillsViewportHeight(true);

		scrollPaneProdutos=new JScrollPane(tableProdutos);
		scrollPaneProdutos.setBounds(20, 118, 452, 157);
		panel.add(scrollPaneProdutos);
		scrollPaneProdutos.setVisible(false);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setBounds(20, 76, 173, 14);
		panel.add(lblResultado);
		
		JSeparator separatorResultado = new JSeparator();
		separatorResultado.setBounds(10, 93, 574, 14);
		panel.add(separatorResultado);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto produto;
				int[] linhas = tableProdutos.getSelectedRows(); 
				if(linhas.length>0){
					for(int i = 0; i < linhas.length; i++){
						produto = modelo.removeProdutoAt(linhas[0]);
						Fachada.getInstance().removerProd(produto.getNome());
					}
				}else{
					Popup.selectRow();
				}
			}
		});
		btnRemover.setBounds(484, 121, 89, 23);
		panel.add(btnRemover);
		btnRemover.setVisible(false);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto;
				int[] linhas = tableProdutos.getSelectedRows();
				if(linhas.length == 1){
					TelaEditProd.getInstance().passProduto(modelo,linhas);
					TelaEditProd.getInstance().setVisible(true);
					dispose();
				}else{
					Popup.select1Row();
				}
			}
		});
		btnEditar.setBounds(484, 166, 89, 23);
		panel.add(btnEditar);
		btnEditar.setVisible(false);
		
		JLabel lblDistribuir = new JLabel("Distribuir:");
		lblDistribuir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDistribuir.setBounds(20, 305, 173, 14);
		panel.add(lblDistribuir);
		
		JSeparator separatorDistribuir = new JSeparator();
		separatorDistribuir.setBounds(10, 322, 574, 14);
		panel.add(separatorDistribuir);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Recupera vendedor selecionado.
				int vendedorSelecionado = comboBox.getSelectedIndex();
				
				//Recupera os dados do vendedor selecionado no dropDown
				if(cpf!=null && vendedorSelecionado!=-1){
					String vendedorCPF = cpf.get(vendedorSelecionado);
					try{
					//Recupera dados do vendedor.
					Funcionario vendedor = Fachada.getInstance().procurarFunc(vendedorCPF);
					}catch(CPFNaoEncontradoException cpfnee){
						
					}
					//Caso a tabela esteja preenchida, ela será limpada, para receber novos resultados.
					while(modeloVendProd.getRowCount()>0)
						modeloVendProd.removeProdutoAt(0);
					
					//Listar todos os produtos do vendedor.
						ResultSet rs;
						
						rs = Fachada.getInstance().listarVendProd(vendedorCPF);
						if(rs!=null){
							//Insere resultados da busca na tabela.
							ClasseAssistente.montarTabelaProduto(rs, modeloVendProd);
						}
				}
			}
		});
		comboBox.setBounds(101, 349, 366, 21);
		comboBox.setVisible(false);
		panel.add(comboBox);
		
		lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendedor.setBounds(20, 347, 86, 21);
		panel.add(lblVendedor);
		lblVendedor.setVisible(false);
		
		/*Distribuição de um tipo de produto para um vendedor
		 * O método verifica o produto selecionado, a quantidade inserida do produto e 
		 * o vendedor selecionado. Em seguida recupera o cpf do vendedor para buscá-lo no 
		 * seu repositorio e inserir o produto para ele.   
		*/
		btnDistribuir = new JButton("Distribuir");
		btnDistribuir.setVisible(false);
		btnDistribuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] linhas = tableProdutos.getSelectedRows();
				if(linhas.length == 1){
					try{						
						int quantidade = Integer.parseInt(textFieldQuantidade.getText());
						if(quantidade > 0){
							int vendedorSelecionado = comboBox.getSelectedIndex();
							if(vendedorSelecionado!=-1){
								Produto produto; 
								Produto produtoToVendedor = new Produto();
								
								//Recupera o produto selecionado na tabela
								produto = modelo.getProdutoAt(linhas[0]);
								//Recupera os dados do vendedor selecionado no dropDown
								String vendedorCPF = cpf.get(vendedorSelecionado);
								Funcionario vendedor = Fachada.getInstance().procurarFunc(vendedorCPF);
								
								//Retirar do repositorio a quantidade de produto selecionado
								produto.retirarProduto(quantidade);
								TelaEditProd.getInstance().produtoEditado = produto;
								Fachada.getInstance().atualizar(produto);
								TelaEditProd.getInstance().sair();
								
								//Verificar se o vendedor já possui o produto
								produtoToVendedor = Fachada.getInstance().procurar(produto.getNome(), vendedorCPF);
								if(produtoToVendedor != null){
									
									//Recupera a posicao do produto na tabela
									int posicao = modeloVendProd.getProdutoAt(produtoToVendedor);
									
									//Remove o produto na tabela 
									modeloVendProd.removeProdutoAt(posicao);
									
									//Atualizar o produto no repositorio
									produtoToVendedor.inserirProduto(quantidade);
									Fachada.getInstance().atualizar(produtoToVendedor, vendedorCPF);
								}else{
									//Inserir o produto para o vendedor
									produtoToVendedor.setNome(produto.getNome());
									produtoToVendedor.setDescricao(produto.getDescricao());
									produtoToVendedor.setQuantidade(quantidade);
									produtoToVendedor.setValor(produto.getValor());
									
									Fachada.getInstance().cadastrar(vendedor,produtoToVendedor);
								}
								
								//Atualizar tabelas 
								modeloVendProd.addProduto(produtoToVendedor);
								modelo.removeProdutoAt(linhas[0]);
								modelo.addProduto(produto);
								textFieldQuantidade.setText("");
								
							}else{
								Popup.selectVendedor();
							}		
						}else{
							Popup.quantProd();
						}
					}catch(NumberFormatException nfe){
						Popup.quantProd();
					}catch(ProdutoQuantidadeException pqe){
						Popup.prodQuantErro();
					}catch(CPFNaoEncontradoException cpfnee) {
						Popup.cpfNaoEncontrado(cpfnee);
					}
				}else{
					Popup.select1Row();
				}
			}
		});
		btnDistribuir.setBounds(484, 348, 89, 23);
		panel.add(btnDistribuir);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(20, 381, 86, 21);
		panel.add(lblQuantidade);
		lblQuantidade.setVisible(false);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(101, 383, 102, 20);
		panel.add(textFieldQuantidade);
		textFieldQuantidade.setVisible(false);
		
		modeloVendProd = new ModeloTabelaVendProd();
		tableVendProd = new JTable(modeloVendProd);
		tableVendProd.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableVendProd.setBounds(68, 163, 100, 30);
		tableVendProd.setPreferredScrollableViewportSize(new Dimension(500,100));
		tableVendProd.setFillsViewportHeight(true);
		
		scrollPaneVendProd = new JScrollPane(tableVendProd);
		scrollPaneVendProd.setBounds(20, 413, 452, 138);
		panel.add(scrollPaneVendProd);
		scrollPaneVendProd.setVisible(false);
		
		btnRemoverProdVend = new JButton("Remover");
		btnRemoverProdVend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] linhas = tableVendProd.getSelectedRows(); 
				if(linhas.length==1){
					try{
						int quantidade = Integer.parseInt(textFieldQuantidade.getText());
						if(quantidade > 0){							
							int vendedorSelecionado = comboBox.getSelectedIndex();
							if(vendedorSelecionado!=-1){

								//Recuperar o cpf do vendedor selecionado
								String vendedorCPF = cpf.get(vendedorSelecionado);
								
								//Retirar da tabela a quantidade de produto selecionado
								Produto produtoToVendedor = modeloVendProd.removeProdutoAt(linhas[0]);
								produtoToVendedor.retirarProduto(quantidade);
								
								if(produtoToVendedor.getQuantidade() == 0){
									
									//Remover produto do BD Vendedor_produto 
									Fachada.getInstance().remover(produtoToVendedor.getNome(), vendedorCPF);
								}else{
																		
									//Atualizar Repositório do produto de vendedor
									Fachada.getInstance().atualizar(produtoToVendedor, vendedorCPF);
									
									//Atualizar tabela 
									modeloVendProd.addProduto(produtoToVendedor);
						
								}
								//Buscar produto no Repositório de Produtos 
								Produto produtoNoRepositorio = Fachada.getInstance().procurarProd(produtoToVendedor.getNome());
								
								//Recuperar a posição do produto na tabela 
								int indice = modelo.getProdutoAt(produtoNoRepositorio);
								
								//Inserir quantidade do produto retirado do vendedor
								produtoNoRepositorio.inserirProduto(quantidade);
								
								//Atualizar repositorio de produtos
								Fachada.getInstance().atualizar(produtoNoRepositorio);
								
								//Atualizar tabela 
								modelo.removeProdutoAt(indice);
								modelo.addProduto(produtoNoRepositorio);
								
								textFieldQuantidade.setText("");
							}							
						}else{
							Popup.quantProd();
						}
					}catch(NumberFormatException nfe){
						Popup.quantProd();
					} catch (ProdutoQuantidadeException e) {
						Popup.prodQuantErro();
					}
				}else{
					Popup.select1Row();
				}
			}
		});
		btnRemoverProdVend.setBounds(484, 416, 89, 23);
		panel.add(btnRemoverProdVend);
		btnRemoverProdVend.setVisible(false);
		
		JLabel lblBuscaDeProduto = new JLabel("Gerenciamento de produto");
		lblBuscaDeProduto.setForeground(SystemColor.window);
		lblBuscaDeProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuscaDeProduto.setBounds(26, 99, 234, 25);
		contentPane.add(lblBuscaDeProduto);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Produto");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Cadastrar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadProd.getInstance().setVisible(true);
				limparCampos();
				setVisibilidade(false);
				dispose();
			}
		});
		menu.add(menuItem);
		
		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		menu.add(mntmGerenciar);
		
		JMenu menu_1 = new JMenu("Vendedor");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("Cadastrar");
		menu_1.add(menuItem_3);
		
		JMenuItem mntmGerenciar_1 = new JMenuItem("Gerenciar");
		menu_1.add(mntmGerenciar_1);
		
		JMenu menu_2 = new JMenu("Vendas");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("Relat\u00F3rio");
		menu_2.add(menuItem_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(26, 60, 152, 23);
		contentPane.add(panel_1);
		
		JButton button = new JButton(" Informa\u00E7\u00F5es de ajuda");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setIcon(new ImageIcon(TelaGerenciaProd.class.getResource("/imagem/question.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(0, 0, 152, 23);
		panel_1.add(button);
	}
}
