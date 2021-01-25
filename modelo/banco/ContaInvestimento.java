package modelo.banco;

import java.io.Serializable;

import banco_superior_excecoes.SaldoInsuficienteException;

public class ContaInvestimento implements  IConta,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaInvestimento(String numeroConta, String agencia, String dataAbertura) {	
		// TODO Auto-generated constructor stub
		this.numeroConta = numeroConta;
		this.agencia = agencia;

		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}
	

	public ContaInvestimento(String numeroConta) {
		super();
		this.numeroConta = numeroConta;
	}


	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
	
		if(contaDestino instanceof ContaPoupanca) {
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
		
		}else if((valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO) > saldo)) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
	
	}

	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		if(valorSacado > 0 && this.saldo >= (valorSacado + (valorSacado * CUSTO_SACAR_CONTA_INVESTIMENTO))  && this.status == true) {
			this.saldo -=  (valorSacado + (valorSacado * CUSTO_SACAR_CONTA_INVESTIMENTO));
			System.out.println(this.saldo);
		}else if((valorSacado + (valorSacado * CUSTO_SACAR_CONTA_INVESTIMENTO) > saldo)) {
			throw new SaldoInsuficienteException("Saldo insuficiente!"+valorSacado);
			
		}
		
	}

	@Override
	public void depositar(float valorDepositado) {
		// TODO Auto-generated method stub
		if(valorDepositado > 0 && this.status == true) {
			this.saldo += valorDepositado;	
		}
		
	}

	@Override
	public void desativarConta() {
		// TODO Auto-generated method stub
		this.status = false;
		
	}

	@Override
	public void ativarConta() {
		// TODO Auto-generated method stub
		this.status = true;
		
	}

	@Override
	public String toString() {
		return "ContaInvestimento [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo
				+ ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
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
		ContaInvestimento other = (ContaInvestimento) obj;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		return true;
	}
	
	
	
	

}