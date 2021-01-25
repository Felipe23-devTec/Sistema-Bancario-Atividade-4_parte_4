package modelo.banco;

import java.util.List;

public interface ICliente {
	public void adicionarContaCliente(IConta contaCliente);
	public void adicionarTelefone(String telefone);
	public void removerTelefone(String telefone);
	public void cadastrarConta(IConta conta);
	public IConta buscarContaInvestimento(String numeroConta);

}
