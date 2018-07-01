/*---------------------------------------------
 * Autor: Diogo Souza
 * Data:15/06/2018
 *---------------------------------------------
 * Descrição: Classe de cadastro do pedido
 * 			  no repositorio BD ou Array.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/

package negocio;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Pedido;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioPedido;


public class CadastroPedido {
	
	private IRepositorioPedido repositorio;
	
	public CadastroPedido(IRepositorioPedido repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Pedido pedido){
		repositorio.inserir(pedido);
	}
	public List procurar(String cpf, String dataDe, String dataAte) {
		//if(!cpf.equals("") && (dataDe.equals("") && dataAte.equals(""))){
			return repositorio.procurar(cpf);
		//}
		/*else if(!dataDe.equals("") && dataAte.equals("") ){
			
		}
		else if(!cpf.equals("") && (!dataDe.equals("") && !dataAte.equals(""))){
			lista = ;
		}
		else if(){
			
		}*/
	}
}
