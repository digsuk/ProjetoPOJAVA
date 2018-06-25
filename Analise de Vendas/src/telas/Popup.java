/*------------------------------------------------
 * Autor: Diogo Souza
 * Data:04/05/2018
 *------------------------------------------------
 * Descri��o: Telas Assistentes: Para confirma-
 *  ��es e entre outros;
 *------------------------------------------------
 * Hist�rico de modifica��o
 * Data             Autor                   Descri��o
 * 09/05/2018 |  Diogo Souza      | Adi��o do m�todo confirmar exclus�o;
 * 26/05/2018 |  Jonathan Moura   | Adi��o de m�todos e constantes.
 * 02/06/2018 |  Diogo Souza      | Adi��o de m�todos e constantes.
 *----------------------------------------------------------------------*/

package telas;

import javax.swing.JOptionPane;

import excecoes.CPFNaoEncontradoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;
import negocio.Mensagem;

public class Popup {
	private static final String MSGALERT = "Mensagem de alerta";
	private static final String MSGERROR = "Mensagem de erro";
	private static final String MSGINFO = "Informa��es de ajuda";
	private static int confirm;

public static void ConfirmarCadastro() {
		
		confirm = JOptionPane.showConfirmDialog(null, Mensagem.CONFCADASTRO , null , JOptionPane.WARNING_MESSAGE, 3);
	}
	
	public static void ConfirmarExclusao() {
		confirm = JOptionPane.showConfirmDialog(null, Mensagem.CONFEXCLUIR , null,  JOptionPane.WARNING_MESSAGE, 2);
	}
		
	public static void ConfirmarEdicaoDados() {
		confirm = JOptionPane.showConfirmDialog(null, Mensagem.CONFDADOS , null , JOptionPane.WARNING_MESSAGE, 3);
	}
	
	public static void ConfirmarProduto() {
		confirm = JOptionPane.showConfirmDialog(null, Mensagem.CONFPRODUTO , null , JOptionPane.WARNING_MESSAGE, 3);
	}
	
	public static void ConfirmarDistribuicao() {
		confirm = JOptionPane.showConfirmDialog(null, Mensagem.CONFDISTRIBUI , null , JOptionPane.WARNING_MESSAGE, 3);
	}
	
	public static void numberFormat(){
		JOptionPane.showMessageDialog(null, Mensagem.NUMBERFORMAT,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	
	public static void campoVazio(CampoVazioException cve){
		JOptionPane.showMessageDialog(null, cve.getMessage(),MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	
	public static void cpfNaoEncontrado(CPFNaoEncontradoException cpfnee){
		JOptionPane.showMessageDialog(null, cpfnee.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
	
	public static void senhaInvalida(SenhaInvalidaException sie){
		JOptionPane.showMessageDialog(null, sie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
	
	public static void emailInvalido(EmailInvalidoException eie){
		JOptionPane.showMessageDialog(null, eie.getMessage(),MSGERROR,JOptionPane.ERROR_MESSAGE);
	}
	
	public static void selectRow(){
		JOptionPane.showMessageDialog(null, Mensagem.SELECTROW,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	
	public static void select1Row(){
		JOptionPane.showMessageDialog(null, Mensagem.SELECT1ROW,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	public static void quantProd(){
		JOptionPane.showMessageDialog(null, Mensagem.QUANTPROD,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	public static void selectVendedor(){
		JOptionPane.showMessageDialog(null, Mensagem.SELECTVEND,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	public static void prodCadErro(){
		JOptionPane.showMessageDialog(null, Mensagem.CADPRODERRO,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	public static void prodQuantErro(){
		JOptionPane.showMessageDialog(null, Mensagem.CADQUANTERRO,MSGALERT,JOptionPane.WARNING_MESSAGE);
	}
	public static void infoCadProd(){
		JOptionPane.showMessageDialog(null, Mensagem.AJUDACADPROD,MSGINFO,JOptionPane.INFORMATION_MESSAGE);
	}
	public static void infoGerProd(){
		JOptionPane.showMessageDialog(null, Mensagem.AJUDAGERPROD,MSGINFO,JOptionPane.INFORMATION_MESSAGE);
	}
}