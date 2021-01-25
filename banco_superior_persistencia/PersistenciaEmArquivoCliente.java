package banco_superior_persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import banco_superior_excecoes.ClienteJaCadastradoException;
import banco_superior_excecoes.ClienteNaoEncontradoException;
import modelo.banco.ClientePessoaFisica;
import modelo.banco.ClientePessoaJuridica;
import modelo.banco.ICliente;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente{
	
	
	private ArrayList<ICliente> clientesCadastrados = new ArrayList<ICliente>();
    
	public PersistenciaEmArquivoCliente() {
		LerConteudoArquivo();
		
		
	}
	@Override
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException{
		// TODO Auto-generated method stub
		if(!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			System.out.println("Clientes cadastrados "+clientesCadastrados);
			salvarEmArquivo();
		}else {
			throw new ClienteJaCadastradoException("Cliente ja cadastrado!");
		}
		
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException{
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaFisica(cpf);
		System.out.println(clientesCadastrados);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
			
		}else {
			throw new ClienteNaoEncontradoException("Cliente nao encontrado!");
			
		}
		return cliente;
	}
		

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException{
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaJuridica(cnpj);
		System.out.println(clientesCadastrados);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
			
		}else {
			throw new ClienteNaoEncontradoException("Cliente nao encontrado!");
		}
		return cliente;
	}

	@Override
	public void removerCliente(ICliente obj) {
		// TODO Auto-generated method stub
		if(clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		}
		
	}
	public void atualizarClienteCPFf(String cpf, ICliente objClienteAtualizar) {
		ICliente cliente = new ClientePessoaFisica(cpf);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			clientesCadastrados.set(index, objClienteAtualizar);
			salvarEmArquivo();
			System.out.println(clientesCadastrados);
		}
		
	}
	public void atualizarClienteCNPJ(String cnpj, ICliente objClienteAtualizar) {
		ICliente cliente = new ClientePessoaFisica(cnpj);
		if(clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			clientesCadastrados.set(index, objClienteAtualizar);
			salvarEmArquivo();
			System.out.println("Cliente atualizado");
			
		}else {
			System.out.println("Cliente nao se encontra no arquivo");
		}
		
	}
	private void salvarEmArquivo(){
		try {
			FileOutputStream fos = new FileOutputStream("p.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			System.out.println("Dados inseridos");
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void LerConteudoArquivo() {
		try {
			FileInputStream fis = new FileInputStream("p.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
