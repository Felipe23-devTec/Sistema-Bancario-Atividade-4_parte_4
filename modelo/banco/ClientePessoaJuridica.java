package modelo.banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientePessoaJuridica implements ICliente, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cnpj;
	String razaoSocial;
	String nome;
	String email;
	
	HashSet<String> telefones = new HashSet<String>();
    
	private ArrayList<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
			
	}
	
	public ClientePessoaJuridica(String cnpj, String razaoSocial, String nome, String email) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "ClientePessoaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nome=" + nome + ", email="
				+ email + ", telefones=" + telefones + ", contas=" + contas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	public void adicionarContaCliente(IConta contaCliente){
		contas.add(contaCliente);
		System.out.println(contas);
	}
	public boolean contemContaCliente(IConta conta) {
		return this.contas.contains(conta);
		
	}
	public void adicionarTelefone(String telefone) {
		telefones.add(telefone);
		
	}
	public void removerTelefone(String telefone) {
		if(telefones.contains(telefone)) {
			telefones.remove(telefone);
			System.out.println("Telefone adicionado com sucesso");
			
		}else {
			System.out.println("Telefone nao adicionado");
			
		}
		
	}
	public void cadastrarConta(IConta conta) {
		contas.add(conta);
		
	}

	@Override
	public IConta buscarContaInvestimento(String numeroConta) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
