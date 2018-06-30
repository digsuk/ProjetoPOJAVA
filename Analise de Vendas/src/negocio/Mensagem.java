/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de mensagens.
 * 
 *---------------------------------------------
 * Histórico de modificação
 * Data            Autor         Descrição
 * 02/06/2018 | Diogo Souza  | Adição de constantes.
 * 30/06/2018 | Diogo Souza  | Adição de constantes.
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
	public static final String CADPRODERRO = "Produto já cadastrado com esse nome.";
	public static final String CADPRODSUC = "Produto cadastrado com sucesso!";
	public static final String ATTPRODSUC = "Produto editado com sucesso!";
	public static final String NUMBERFORMAT = "Insira apenas valores númericos nos campos de \"Quantidade\" e \"valor\"(inserir ponto ao invés de vírgula).";
	//Em mais de uma tela
	public static final String CAMPOVAZIO = "Preencha todos os campos vazios.";
	//TelaLogin
	public static final String SENHAINVALIDA = "Senha inválida, insira novamente.";
	public static final String CPFNENCONTRADO = " não está cadastrado.";
	public static final String EMAILINVALIDO = "Email inválido, informe novamente.";
	public static final String INFOEMAIL = "Informe seu email cadastrado para que possamos lhe enviar uma nova senha.";
	//ClasseAssistente
	public static final String SUBJECTSENHA = "Nova senha.";
	public static final String TEXTSENHA = "Sua nova senha foi gerada: ";
	//TelaCadVendedor
	public static final String CADVENDSUC = "Vendedor cadastrado com sucesso:";
	public static final String CADVENDERRO = "Erro ao cadastrar o vendedor:";
	//Popup
	public static final String CONFCADASTRO = "Você realmente deseja cadastrar? ";
	public static final String CONFEXCLUIR = "Você realmente deseja excluir? ";
	public static final String CONFDADOS = "Você confirma os dados editados? ";
	public static final String CONFPRODUTO = "Você confirma o cadastro do produto? ";
	public static final String CONFDISTRIBUI = "Você confirma a distribuição dos produtos? ";
	public static final String CADASTRADO = "Cadastrado! ";
	public static final String EXCLUIDO = "Excluído! ";
	public static final String EDICAO = "Edição concluída! ";
	public static final String DISTRIBUIDO = "Produto distribuído! ";
	//Informações de ajuda
		public static final String AJUDACADPROD = "Para cadastrar um produto é necessário "+"\n"
												+ "informar o nome do produto, uma descrição "+"\n"
												+ "que detalhe informações adicionais a seu "+"\n"
												+ "respeito, a sua quantidade inserida e o seu "+"\n"
												+ "valor unitário.";
		
		public static final String AJUDAGERPROD = "Para gerenciar os prodrutos cadastrados é necessário "+"\n"
				  								+ "realizar a busca por um produto informando o seu nome "+"\n"
				  								+ "ou realizar uma busca sem informar o nome do produto "+"\n"
				  								+ "para ver todos os produtos cadastrados. Após realizar "+"\n"
				  								+ "a busca, será possível selecionar o produto desejado "+"\n"
				  								+ "na tabela de produtos e editar suas informações ou "+"\n"
				  								+ "remover o produto. Também é possível selecionar um "+"\n"
				  								+ "produto e distribuí-lo a um vendedor cadastrado para "+"\n"
				  								+ "o gerente logado, para isso, basta selecionar um "+"\n"
				  								+ "vendedor no comboBox e selecionar o produto, em "+"\n"
				  								+ "seguida, informar a quantidade a ser distribuída e "+"\n"
				  								+ "pressionar o botão distribuir. Caso deseje retirar "+"\n"
				  								+ "produtos que foram distribuidos a um vendedor, "+"\n"
				  								+ "selecione o produto na tabela do vendedor e informe "+"\n"
				  								+ "a quantidade a ser removida, em seguida, pressione o "+"\n"
				  								+ "botão remover.";
	
}
