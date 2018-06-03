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
	 
	
}
