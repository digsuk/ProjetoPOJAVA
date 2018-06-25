/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:24/06/2018
 *---------------------------------------------
 * Descrição: Repositório Array de pedidos.
 *---------------------------------------------
 * Histórico de modificação
 * Data    Autor    Descrição
 *       |        |
 *-------------------------------------------*/
package dados;

import entidades.Pedido;
import excecoes.CPFNaoEncontradoException;
import interfaces.IRepositorioPedido;

public class RepPedidoArray implements IRepositorioPedido {
	private static final int TAMANHO = 1000000;
	private Pedido[] repositorio;
	private int indice;
	private int i;
	
	public RepPedidoArray(){
		i = 0;
		indice = 0;
		repositorio = new Pedido[TAMANHO];
	}
		
	public int getIndice(String cpf) {
		i = 0;
		if (indice != 0) {
			while (!cpf.equals(repositorio[i].getVendedor().getCpf())) {
				if (i == indice - 1) {
					return -1;
				} else
					i++;
			}
			return i;
		}
		return -1;
	}
	
	public boolean existe(String cpf) {
		i = getIndice(cpf);
		if (i == -1)
			return false;
		else
			return true;
	}
	
	public void inserir(Pedido pedido){
		repositorio[indice] = pedido;
		indice++;
	}
	public Pedido procurar(String cpf)throws CPFNaoEncontradoException{
		if (existe(cpf)) {
			return this.repositorio[i];
		} else{
			CPFNaoEncontradoException cpfnee = new CPFNaoEncontradoException(cpf);
			throw cpfnee;
		}
	}
}
