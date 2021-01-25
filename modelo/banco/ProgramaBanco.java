package modelo.banco;

import banco_superior_excecoes.ClienteJaCadastradoException;
import banco_superior_excecoes.ClienteNaoEncontradoException;
import banco_superior_excecoes.SaldoInsuficienteException;
import banco_superior_persistencia.PersistenciaEmArquivoCliente;

public class ProgramaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PersistenciaEmArquivoCliente pac = new PersistenciaEmArquivoCliente();
        
        //********Cadastro de novo cliente  e atualizar novo cliente Test : 5
        
        //ICliente cliente1 = new ClientePessoaFisica("Marcos","01","11-02-2011");
        //IConta conta1 = new ContaPoupanca("12f","zz","12");
        //cliente1.adicionarContaCliente(conta1);
        
        //pac.atualizarClienteCPFf("555", cliente1);
        ICliente cliente1;
        try {
			cliente1 = pac.localizarClientePorCPF("555");
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //ICliente cliente1;
		//try {
			//cliente1 = pac.localizarClientePorCPF("555");
		//} catch (ClienteNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			//System.out.println(e1.getMessage());
		//}
        
        //try {
			//cliente1.buscarContaInvestimento("1c").sacar(20f);
		//} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
		//}
        
        //***********Cadastro de um novo cleinte Test : 4*********
        
        //ICliente cliente1 = new ClientePessoaFisica("Marcos","01","11-02-2011");
        //IConta conta1 = new ContaInvestimento("1c","bb","11-03-2011");
        //conta1.depositar(100f);
        //cliente1.adicionarContaCliente(conta1);
        //cliente1.adicionarTelefone("12-65474");
        //System.out.println(cliente1);
        //try {
			//pac.cadastrarCliente(cliente1);
		//} catch (ClienteJaCadastradoException e) {
			 //TODO Auto-generated catch block
			//System.out.println(e.getMessage());
		//}
       //ICliente cliente1 = pac.localizarClientePorCPF("01");
       //System.out.println(cliente1);
        
        //**********Verifica se cliente ja esta cadastrado********
        //try {
			//pac.cadastrarCliente(cliente1);
		//} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
		//}
        
        //*************Cadastro de pessoa fisica e pesquisa Test : 2****************
        
       //ICliente cliente1 = new ClientePessoaFisica("Gustavo","555","12-5-2014");
       //IConta conta1 = new ContaPoupanca("12f","zz","12");
       //cliente1.adicionarContaCliente(conta1);
       //cliente1.adicionarTelefone("34-5677");
       //System.out.println(cliente1);
       //try {
		   //pac.cadastrarCliente(cliente1);
	   //} catch (ClienteJaCadastradoException e) {
		// TODO Auto-generated catch block
		   //System.out.println(e.getMessage());
	   //}
        
        //ICliente cliente1 = pac.localizarClientePorCPF("555");
        //ICliente cliente2 = pac.localizarClientePorCNPJ("111");
        
        //System.out.println(cliente1);
        //System.out.println(cliente2);
        
        
        //********Cadastro de um cliente CNPJ e pesquisa-Test : 1***********
        
        //ICliente pj1 = new ClientePessoaJuridica("111","Ble","EmA","@fmail");
		//IConta conta5 = new ContaCorrente("1A","BB","12-07-2020");
		
		//pj1.adicionarContaCliente(conta5);
		
		//pj1.adicionarTelefone("81-98965-9876");
		
		
		//try {
			//pac.cadastrarCliente(pj1);
		//} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
		//}
       
       

		

	}		
		 
}