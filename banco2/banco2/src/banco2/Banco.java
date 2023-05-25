package banco2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
	
	private List<Conta> contas = new  ArrayList<Conta>();
	Scanner ler = new Scanner(System.in);
	
	public void cadastarCliente() {
		System.out.println("\n---Cadastro---");
		System.out.print("Informe o nome do cliente: ");
		String nome = ler.nextLine();
		Conta c = new Conta(nome);
		contas.add(c);
		
	}
	
	public void ListarClientes() {
		System.out.println("\n---Contas---");
		for(Conta c : contas) {
			System.out.println("Cod: " + c.getNumero() + " -> Nome: " + c.getCliente());	
		}

	}
	
	public void EscolherCliente() {
		ListarClientes();
		System.out.print("Infome o Código da conta que deseja entrar: ");
		int numero = ler.nextInt();
		Conta c = FindConta(numero);
		if(c != null) {
			int opcao = 0;
			do {
				System.out.println("\n---Conta do " + c.getCliente() + "---");
				System.out.println("Saldo: " + c.getSaldo());
				System.out.println("\nOperações: ");
				System.out.println("1 - Sacar");
				System.out.println("2 - Depositar");
				System.out.println("3 - Transferir");
				System.out.println("0 - Voltar ao Menu Principal");
				System.out.print("\nInforme a operação que deseja efetuar: ");
				opcao = ler.nextInt();
				
				switch(opcao) {
				case 1:
					System.out.print("Informe o Valor: ");
					float valor = ler.nextFloat();
					if(c.sacar(valor)) {
						System.out.println("Saque Realizado com Sucesso!");
					}else{
						System.out.println("Valor Invalido!");
					}
					break;
				case 2:
					System.out.print("Informe o Valor: ");
					float valorDeposito = ler.nextFloat();
					c.depositar(valorDeposito);
					break;
				case 3:
					System.out.println("Escolha a conta de destino: ");
					ListarClientes();
					int numeroCliente = ler.nextInt();
					Conta destino = FindConta(numeroCliente);
					if(destino != null && destino != c) {
						System.out.println("Conta destino: " + destino.getCliente());
						System.out.println("Deseja continuar? 1 - sim");
						int opcaoContinuar = ler.nextInt();
						if(opcaoContinuar == 1) {
							System.out.println("Informe o Valor: ");
							float valorT = ler.nextFloat();
							//c.transferir(valorT, destino);
							Conta.transferir(c, valorT, destino);
						}
					}else if(destino == c){
						System.out.println("Você não pode Transferir para mesma conta, Revise as informações!");
						
					}
					break;
				}
				
			} while (opcao != 0);
			
			
		}
		
	}
	
	public Conta FindConta(int numero) {
		for(Conta c : contas) {
			if(c.getNumero() == numero) {
				return c;
			}
		}
		return null;
	}
}
