/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descrição: Classe de validação dos campos
 * 			  da tela de cadastro de produto
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package negocio;

import javax.swing.JOptionPane;

import entidades.Funcionario;
import excecoes.CPFNaoEncontradoException;
import excecoes.CampoVazioException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;
import telas.Popup;

public class ValidarDados {
	public static final String GERENTE = "Gerente";
	public static final String VENDEDOR = "Vendedor";
	public static final String ADM = "Administrador";
	public static Funcionario funcionario;
	
	public static boolean validarCampoVazio(String arg0, String arg1, String arg2, String arg3) {
		try {
			if (arg0.equals("") || arg1.equals("") || arg2.equals("") || arg3.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			Popup.campoVazio(cve);
			return false;
		}
		return true;
	}

	public static boolean validarCampoVazio(String arg0, String arg1) {
		try {
			if (arg0.equals("") || arg1.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			Popup.campoVazio(cve);
			return false;
		}
		return true;
	}
	
	public static boolean validarCampoVazio(String arg0) {
		try {
			if (arg0.equals("")) {
				CampoVazioException cve = new CampoVazioException();
				throw cve;
			}
		} catch (CampoVazioException cve) {
			Popup.campoVazio(cve);
			return false;
		}
		return true;
	}
	
	public static boolean validarLogin(String cpf, String senha){
		try{
			funcionario = Fachada.getInstance().procurarFunc(cpf);
			if(!funcionario.getSenha().equals(senha)){
				SenhaInvalidaException sie = new SenhaInvalidaException();
				throw sie;
			}
		}catch(SenhaInvalidaException sie){
			Popup.senhaInvalida(sie);
			return false;
		}catch(CPFNaoEncontradoException cpfnee){
			Popup.cpfNaoEncontrado(cpfnee);
			return false;
		}
		return true;
	}
	
	public static String identificaFuncao(){
		switch(funcionario.getFuncao()){
			case GERENTE: return GERENTE;
			case VENDEDOR: return VENDEDOR;
			case ADM: return ADM;
			default: return null;
		}
	}
	
	public static boolean validarEmail(String email){
		try{
			if(!email.matches("[\\w\\d]+@[^0-9]+(\\.com$|\\.br$)")){
				EmailInvalidoException eie = new EmailInvalidoException();
				throw eie;
			}
			
		}catch(EmailInvalidoException eie ){
			Popup.emailInvalido(eie);
			return false;
		}
		return true;
	}
}
