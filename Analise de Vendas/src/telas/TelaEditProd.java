/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:27/05/2018
 *---------------------------------------------
 * Descrição: Classe de tela da edição de 
 * 			  produtos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Produto;
import negocio.Fachada;
import negocio.Mensagem;
import negocio.ModeloTabelaProduto;
import negocio.ValidarDados;

import javax.swing.JTextField;

public class TelaEditProd extends JFrame {

	private JPanel contentPane;
	private static TelaEditProd instance;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	public Produto produtoEditado;
	private ModeloTabelaProduto modelo;
	private int[] linhas;
	
	public static TelaEditProd getInstance(){
		if(instance == null)
			instance = new TelaEditProd();
		return instance;
	}
	public void sair(){
		limparCampos();
		modelo = null;
		linhas = null;
		produtoEditado = null;
		TelaGerenciaProd.getInstance().setVisible(true);
		dispose();
	}
	
	public void atualizarModelo(Produto produto){
		modelo.removeProdutoAt(linhas[0]);
		modelo.addProduto(produto);
	}
	
	public void limparCampos(){
		textFieldNome.setText("");
		textFieldDescricao.setText("");
		textFieldQuantidade.setText("");
		textFieldValor.setText("");
	}
	
	public void passProduto(ModeloTabelaProduto modelo, int[] linhas){
		this.modelo = modelo;
		this.linhas = linhas;
		this.produtoEditado = modelo.getProdutoAt(linhas[0]);
		textFieldNome.setText(produtoEditado.getNome());
		textFieldDescricao.setText(produtoEditado.getDescricao());
		textFieldQuantidade.setText(String.valueOf(produtoEditado.getQuantidade()));
		textFieldValor.setText(String.valueOf(produtoEditado.getValor()));
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditProd frame = new TelaEditProd();
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
	public TelaEditProd() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEdicaoDeProduto = new JLabel("Edi\u00E7\u00E3o de produto");
		lblEdicaoDeProduto.setForeground(SystemColor.window);
		lblEdicaoDeProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdicaoDeProduto.setBounds(26, 70, 173, 25);
		contentPane.add(lblEdicaoDeProduto);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 105, 594, 437);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(108, 73, 86, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(108, 117, 86, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantidade:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(108, 165, 86, 21);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Valor:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(108, 211, 86, 21);
		panel.add(label_3);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ValidarDados.validarCampoVazio(textFieldNome.getText(), textFieldDescricao.getText(),
						textFieldQuantidade.getText(), textFieldValor.getText())){
					try{
						Produto produto = new Produto(textFieldNome.getText(), 
													  textFieldDescricao.getText(),
													  Integer.parseInt(textFieldQuantidade.getText()),
													  Double.parseDouble(textFieldValor.getText()));
						Fachada.getInstance().atualizar(produto);
						JOptionPane.showMessageDialog(null, Mensagem.ATTPRODSUC);
						atualizarModelo(produto);
						sair();
					}catch(NumberFormatException nfe){
						Popup.numberFormat();
					} 
				}
			}
		});
		btnEditar.setBounds(326, 254, 89, 23);
		panel.add(btnEditar);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(204, 73, 140, 20);
		panel.add(textFieldNome);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(204, 117, 211, 20);
		panel.add(textFieldDescricao);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(204, 165, 86, 20);
		panel.add(textFieldQuantidade);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(204, 211, 86, 20);
		panel.add(textFieldValor);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnCancelar.setBounds(108, 254, 89, 23);
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(26, 30, 152, 23);
		contentPane.add(panel_1);
		
		JButton button = new JButton(" Informa\u00E7\u00F5es de ajuda");
		button.setBounds(0, 0, 152, 23);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setIcon(new ImageIcon(TelaEditProd.class.getResource("/imagem/question.png")));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
	}
}
