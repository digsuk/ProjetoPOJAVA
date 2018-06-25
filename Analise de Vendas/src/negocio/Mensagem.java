/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Classe de mensagens.
 * 
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data            Autor         Descri��o
 * 02/06/2018 | Diogo Souza  | Adi��o de constantes.
 *----------------------------------------------------*/
package negocio;

public class Mensagem {
	//TelaGerenciaProd
	public static final String CADQUANTERRO = "Quantidade solicitada de produto acima da quantidade armazenada!";
	public static final String PRODDIST = "Produto distribuido!";
	public static final String QUANTPROD = "Informe uma quantidade (maior que zero) do produto.";
	public static final String SELECTVEND = "Selecione um vendedor para receber o produto.";
	public static final String SELECTROW = "Selecione ao menos uma linha.";
	public static final String SELECT1ROW = "Selecione uma linha.";
	//TelaCadProd
	public static final String CADPRODERRO = "Produto j� cadastrado com esse nome.";
	public static final String CADPRODSUC = "Produto cadastrado com sucesso!";
	public static final String ATTPRODSUC = "Produto editado com sucesso!";
	public static final String NUMBERFORMAT = "Insira apenas valores n�mericos nos campos de \"Quantidade\" e \"valor\"(inserir ponto ao inv�s de v�rgula).";
	//Em mais de uma tela
	public static final String CAMPOVAZIO = "Preencha todos os campos vazios.";
	//TelaLogin
	public static final String SENHAINVALIDA = "Senha inv�lida, insira novamente.";
	public static final String CPFNENCONTRADO = " n�o est� cadastrado.";
	public static final String EMAILINVALIDO = "Email inv�lido, informe novamente.";
	public static final String INFOEMAIL = "Informe seu email cadastrado para que possamos lhe enviar uma nova senha.";
	//ClasseAssistente
	public static final String SUBJECTSENHA = "Nova senha.";
	public static final String TEXTSENHA = "Sua nova senha foi gerada: ";
	//Popup
	public static final String CONFCADASTRO = "Voc� realmente deseja cadastrar? ";
	public static final String CONFEXCLUIR = "Voc� realmente deseja excluir? ";
	public static final String CONFDADOS = "Voc� confirma os dados editados? ";
	public static final String CONFPRODUTO = "Voc� confirma o cadastro do produto? ";
	public static final String CONFDISTRIBUI = "Voc� confirma a distribui��o dos produtos? ";
	public static final String CADASTRADO = "Cadastrado! ";
	public static final String EXCLUIDO = "Exclu�do! ";
	public static final String EDICAO = "Edi��o conclu�da! ";
	public static final String DISTRIBUIDO = "Produto distribu�do! ";
	//Informa��es de ajuda
		public static final String AJUDACADPROD = "Para cadastrar um produto � necess�rio "+"\n"
												+ "informar o nome do produto, uma descri��o "+"\n"
												+ "que detalhe informa��es adicionais a seu "+"\n"
												+ "respeito, a sua quantidade inserida e o seu "+"\n"
												+ "valor unit�rio.";
		
		public static final String AJUDAGERPROD = "Para gerenciar os prodrutos cadastrados � necess�rio "+"\n"
				  								+ "realizar a busca por um produto informando o seu nome "+"\n"
				  								+ "ou realizar uma busca sem informar o nome do produto "+"\n"
				  								+ "para ver todos os produtos cadastrados. Ap�s realizar "+"\n"
				  								+ "a busca, ser� poss�vel selecionar o produto desejado "+"\n"
				  								+ "na tabela de produtos e editar suas informa��es ou "+"\n"
				  								+ "remover o produto. Tamb�m � poss�vel selecionar um "+"\n"
				  								+ "produto e distribu�-lo a um vendedor cadastrado para "+"\n"
				  								+ "o gerente logado, para isso, basta selecionar um "+"\n"
				  								+ "vendedor no comboBox e selecionar o produto, em "+"\n"
				  								+ "seguida, informar a quantidade a ser distribu�da e "+"\n"
				  								+ "pressionar o bot�o distribuir. Caso deseje retirar "+"\n"
				  								+ "produtos que foram distribuidos a um vendedor, "+"\n"
				  								+ "selecione o produto na tabela do vendedor e informe "+"\n"
				  								+ "a quantidade a ser removida, em seguida, pressione o "+"\n"
				  								+ "bot�o remover.";
	
}
