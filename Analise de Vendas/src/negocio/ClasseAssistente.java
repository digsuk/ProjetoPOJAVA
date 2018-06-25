/*------------------------------------------------
 * Autor: Jonathan Moura
 * Data:03/05/2018
 *------------------------------------------------
 * Descri��o: Classe assistente com m�todos 
 * 			  utilit�rios.
 * 
 *------------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *----------------------------------------------*/
package negocio;

import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;
import javax.swing.JTable;

import entidades.Administrador;
import entidades.Gerente;
import entidades.Produto;
import entidades.Vendedor;

public class ClasseAssistente {
	
	//Gera uma senha de 10 caracteres, atrav�s da convers�o de 
	//valores inteiros aleat�riso em caracteres.
	public static String gerarSenha(){
		final Random random = new Random();
		final int TAMANHO = 10;
		
		char[] caracter = new char[TAMANHO];
        for (int i = 0; i<TAMANHO; i++)
            caracter[i] = toChar(random.nextInt(62));
        return new String(caracter);
	}
	
	//Transforma valores inteiros em caracter
	private static char toChar(int index) {
        if (index < 10)
            return (char)(index + 48); //os chars 48 a 57 representam [0 - 9]
        else if (index < 36)
            return (char)(index + 55); //os chars 65 a 90 representam [A - Z]
        else
            return (char)(index + 61); //os chars 97 a 122 representam [a - z]
    }
	
	//Envia um email com uma mensagem.
	public static void enviarEmail(String email, String senha){
		final String ADMEMAIL = "adm.analise.vendas@gmail.com";
		final String ADMSENHA = "@dM1n001";
		Properties props = new Properties();
        /** Par�metros de conex�o com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication(ADMEMAIL,ADMSENHA);
                         }
                    });

        /** Ativa Debug para sess�o */
        session.setDebug(true);

        try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(ADMEMAIL)); //Remetente

              Address[] toUser = InternetAddress //Destinat�rio(s)
                         .parse(email);  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject(Mensagem.SUBJECTSENHA);//Assunto
              message.setText(Mensagem.TEXTSENHA + senha);

              /**M�todo para enviar a mensagem criada*/
              Transport.send(message);

         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
	}
	
	public static void montarTabelaProduto(List produtos, ModeloTabelaVendProd modelo){
			modelo.addProdutoList(produtos);
	}
	
	public static void montarTabelaProduto(List produtos, ModeloTabelaProduto modelo){	
			modelo.addProdutoList(produtos);
	}

	public static void montarTabelaProduto(Produto produto, ModeloTabelaProduto modelo){		
		if(produto != null){
			modelo.addProduto(produto);
		}
	}
	
	//Monta o comboBox da tela de Gerenciamento de produtos.
	public static List montaComboBox(JComboBox comboBox){
		List vendedores;
		String nome;
		
		//Recuperr cpf do gerente logado.
		String gerenteCPF = ValidarDados.funcionario.getCpf();
		List<String> cpf = new ArrayList();
		
		//Recuperar vendedores subordinados ao gerente logado.
		vendedores = Fachada.getInstance().listarSubordinados(gerenteCPF);
		
		//Adicionar linha em branco no comboBox.
		nome = "";
		cpf.add("");
		comboBox.addItem(nome);
			if(vendedores != null){
				int i = 0;
				while(i < vendedores.size()){
					nome = ((Vendedor)vendedores.get(i)).getNome();
					cpf.add(((Vendedor)vendedores.get(i)).getCpf());
					//Montar comboBox com os resultados recuperados.
					comboBox.addItem(nome);
					i++;
				}
			}
			return cpf;
	}
	
	//Gerar usuario para teste com perfil de administrador
	public static void usuarioAdm(){
		Administrador administrador = new Administrador("Administrador do Programa",
														"12345678910","adm.analise.vendas@gmail.com",
														"123456","Administrador");		
		Fachada.getInstance().cadastrar(administrador);
	}
	//Gerar usuario para teste com perfil de gerente
	public static void usuarioGer(){
		Gerente gerente = new Gerente("Gerente de Vendedor",
									  "22345678910","adm.analise.vendas@gmail.com",
									  "123456","Gerente");		
		Fachada.getInstance().cadastrar(gerente);
	}
	//Gerar usuario para teste com perfil de vendedor
	public static void usuarioVen(){
		Vendedor vendedor = new Vendedor("Vendedor de Produtos",
										 "32345678910","adm.analise.vendas@gmail.com",
										 "123456","Vendedor","22345678910");		
		Fachada.getInstance().cadastrar(vendedor);
	}
}