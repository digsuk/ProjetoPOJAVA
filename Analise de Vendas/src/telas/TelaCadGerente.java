package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class TelaCadGerente extends JFrame {

	private JPanel contentPane;
	private static TelaCadGerente instance;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JTextField textFieldFuncao;
	
	public static TelaCadGerente getInstance() {
		if (instance == null)
			instance = new TelaCadGerente();
		return instance;
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
	public TelaCadGerente() {
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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 277, 594, 294);
		contentPane.add(panel);
		
		JLabel lblCadastroGerente = new JLabel("Cadastro de gerente");
		lblCadastroGerente.setForeground(Color.WHITE);
		lblCadastroGerente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroGerente.setBounds(10, 63, 173, 25);
		contentPane.add(lblCadastroGerente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(87, 108, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(143, 107, 140, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(87, 149, 46, 14);
		contentPane.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(143, 148, 140, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(87, 185, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(143, 184, 140, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o:");
		lblFuncao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncao.setBounds(87, 210, 57, 20);
		contentPane.add(lblFuncao);
		
		textFieldFuncao = new JTextField();
		textFieldFuncao.setBounds(143, 215, 140, 20);
		contentPane.add(textFieldFuncao);
		textFieldFuncao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(301, 243, 89, 23);
		contentPane.add(btnCadastrar);
		
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
		btnAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAjuda.setIcon(new ImageIcon(TelaCadGerente.class.getResource("/imagem/question.png")));
		btnAjuda.setBounds(10, 32, 173, 23);
		contentPane.add(btnAjuda);
	}
}
