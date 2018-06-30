package telas;

/*------------------------------------------------
 * Autor: Diogo Souza
 * Data:30/06/2018
 *------------------------------------------------
 * Descrição: Tela de Cadastro de Vendedor,
 * feito pelo gerente
 *------------------------------------------------
 * Histórico de modificação
 * Data             Autor                   Descrição
 *
 *----------------------------------------------------------------------*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Vendedor;
import negocio.Fachada;
import negocio.Mensagem;
import negocio.ValidarDados;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class TelaCadVendedor extends JFrame {

	private JPanel contentPane;
	private static TelaCadGerente instance;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	
	public static TelaCadGerente getInstance() {
		if (instance == null)
			instance = new TelaCadGerente();
		return instance;
	}
	
	public void limparcampos() {
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldEmail.setText("");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadGerente frame = new TelaCadGerente();
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
	public TelaCadVendedor() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 99, 594, 472);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(76, 32, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(175, 31, 140, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(76, 57, 46, 14);
		panel.add(lblCPF);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(175, 62, 140, 20);
		panel.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(76, 97, 46, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(175, 102, 140, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent arg0) {
				if(ValidarDados.validarCampoVazio(textFieldNome.getText(), textFieldCPF.getText(), 
						textFieldEmail.getText())) {
					try {
						Vendedor vendedorCadastrado;
						Vendedor vendedor = new Vendedor(textFieldNome.getText(), textFieldCPF.getText(),
								textFieldEmail.getText());
						vendedorCadastrado = Fachada.getInstance().procurarVendedor(textFieldCPF.getText());
						if(vendedorCadastrado == null) {
							Fachada.getInstance().cadastrarVendedor(vendedor);
							JOptionPane.showMessageDialog(null, Mensagem.CADVENDSUC);
							limparcampos();
						}else {
							Popup.VendCadErro();
						}
						
					}catch(NumberFormatException nfe) {
						Popup.numberFormat();
					}
				}
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCadastrar.setBounds(204, 152, 89, 23);
		panel.add(btnCadastrar);
		
		JLabel lblCadastroGerente = new JLabel("Cadastro de gerente");
		lblCadastroGerente.setBounds(10, 63, 173, 25);
		lblCadastroGerente.setForeground(Color.WHITE);
		lblCadastroGerente.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblCadastroGerente);
		
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
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnVendedor.add(mntmCadastrar_1);
		
		JMenuItem mntmGerenciar_1 = new JMenuItem("Gerenciar");
		mnVendedor.add(mntmGerenciar_1);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmNewRelatorio = new JMenuItem("Relat\u00F3rio");
		mnVendas.add(mntmNewRelatorio);
		
		JButton btnAjuda = new JButton("Informa\u00E7\u00F5es de Ajuda");
		btnAjuda.setBounds(10, 32, 173, 23);
		btnAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjuda.setIcon(new ImageIcon(TelaCadGerente.class.getResource("/imagem/question.png")));
		contentPane.add(btnAjuda);
	}
}
