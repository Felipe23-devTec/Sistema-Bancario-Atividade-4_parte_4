package modelo.banco;

import java.io.Serializable;

import banco_superior_excecoes.SaldoInsuficienteException;

public class ContaPoupanca implements IConta, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaPoupanca(String numeroConta, String agencia, String dataAbertura) {
		
		// TODO Auto-generated constructor stub
		this.numeroConta = numeroConta;
		this.agencia = agencia;

		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}
	
	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
	
		if(contaDestino instanceof ContaPoupanca) {
			
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			
			contaDestino.depositar(valorTransferido);
		
		}else {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
			
		}
		

	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		
		if(valorSacado > 0 && this.saldo >= (valorSacado + (valorSacado * CUSTO_SACAR_CONTA_POUPANÇA))  && this.status == true) {
			this.saldo -=  (valorSacado + (valorSacado * CUSTO_SACAR_CONTA_POUPANÇA));
			
		}else if(valorSacado + (valorSacado * CUSTO_SACAR_CONTA_POUPANÇA) > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
			
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
		return "ContaPoupanca [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
}
