/*------------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *------------------------------------------------
 * Descrição: Tela de login do usuário
 * 
 *------------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *----------------------------------------------*/
package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.CampoVazioException;
import negocio.ClasseAssistente;
import negocio.Mensagem;
import negocio.ValidarDados;

import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JPasswordField passwordField;
	public static TelaLogin instance;
	
	public static TelaLogin getInstance() {
		if (instance == null) {
			instance = new TelaLogin();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					
					 /*Gerar usuário adiministrador
					 *Chamar apenas quando for usar repositorio Array*/
					 //ClasseAssistente.usuarioAdm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setTitle("An\u00E1lise de Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(127, 173, 334, 242);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);

		JLabel lblCPFVazio = new JLabel("");
		lblCPFVazio.setForeground(Color.RED);
		lblCPFVazio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCPFVazio.setBounds(78, 72, 170, 14);
		panel.add(lblCPFVazio);

		JLabel lblSenhaVazia = new JLabel("");
		lblSenhaVazia.setForeground(Color.RED);
		lblSenhaVazia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSenhaVazia.setBounds(77, 132, 170, 14);
		panel.add(lblSenhaVazia);

		JButton btnEsqueceuASenha = new JButton("Esqueceu a senha?");
		btnEsqueceuASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email, senha;
					do{
						email = JOptionPane.showInputDialog(Mensagem.INFOEMAIL);
						if(email==null)
							break;
						else if(!email.equals("")){
							if(ValidarDados.validarEmail(email)){
								senha = ClasseAssistente.gerarSenha();
								ClasseAssistente.enviarEmail(email, senha);
								break;
							}
							email = "";
							continue;
						}
						Popup.campoVazio(new CampoVazioException());
					}while(email.equals(""));						
			}
		});
		btnEsqueceuASenha.setBorderPainted(false);
		btnEsqueceuASenha.setForeground(SystemColor.textHighlight);
		btnEsqueceuASenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEsqueceuASenha.setBorder(null);
		btnEsqueceuASenha.setBackground(new Color(255, 255, 255));
		btnEsqueceuASenha.setBounds(22, 172, 128, 23);
		panel.add(btnEsqueceuASenha);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = textFieldCPF.getText();
				String senha = passwordField.getText();
				if (ValidarDados.validarCampoVazio(cpf, senha)) {
					if (ValidarDados.validarLogin(cpf, senha)) {
						switch (ValidarDados.identificaFuncao()) {
						case ValidarDados.GERENTE:
							TelaCadProd.getInstance().setVisible(true);
							dispose();
							break;
						case ValidarDados.VENDEDOR:
							TelaCadPedido.getInstance().setVisible(true);
							dispose();
							break;
						case ValidarDados.ADM:
							TelaCadGerente.getInstance().setVisible(true);
							dispose();
							break;
						default: 
							dispose();
						}
					}
				}
			}
		});
		btnOk.setBounds(206, 172, 89, 23);
		panel.add(btnOk);

		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(78, 50, 217, 20);
		panel.add(textFieldCPF);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(22, 53, 46, 14);
		panel.add(lblCpf);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(22, 112, 46, 14);
		panel.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(77, 110, 217, 20);
		panel.add(passwordField);
	}

}