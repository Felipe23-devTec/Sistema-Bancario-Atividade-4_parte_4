package modelo.banco;

import banco_superior_excecoes.SaldoInsuficienteException;

public interface IConta {
	public final float CUSTO_SACAR_CONTA_CORRENTE = 0.01f;
	public final float CUSTO_SACAR_CONTA_SALARIO = 0.01f;
	public final float TAXA_ADMINISTRACAO = 0.25f;
	public final float CUSTO_SACAR_CONTA_INVESTIMENTO = 0.01f;
	public final float CUSTO_SACAR_CONTA_POUPANÇA = 0.01f;
	
	static final float RENDIMENTO_POUPANÇA = 0.05f;
	
	public void sacar(float valorSacado) throws SaldoInsuficienteException;
	
	public  void depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException;
	
	public void ativarConta();

}
