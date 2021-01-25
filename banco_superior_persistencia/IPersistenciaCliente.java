package banco_superior_persistencia;


import banco_superior_excecoes.ClienteJaCadastradoException;
import banco_superior_excecoes.ClienteNaoEncontradoException;
import modelo.banco.ICliente;

public interface IPersistenciaCliente {
	
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException;
	
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException;
    
        public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException;
        
	public void atualizarClienteCPFf(String cpf, ICliente objClienteAtualizar);
      
        public void atualizarClienteCNPJ(String cnpj, ICliente objClienteAtualizar);
    
         public void removerCliente(ICliente obj);
}
