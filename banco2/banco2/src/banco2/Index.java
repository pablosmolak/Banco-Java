package banco2;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		Banco b = new Banco();
		int opcao = 0;
		
		
		do {
			System.out.println("---Smolak's Banking---");
			System.out.println("\nOperações: ");
			System.out.println("1 - Cadastrar Conta");
			System.out.println("2 - Listar contas existentes");
			System.out.println("3 - Entrar em uma conta");
			System.out.println("0 - Sair\n");
			
			System.out.print("Informe a operação desejada: ");
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 1:
				b.cadastarCliente();
				break;
			
			case 2:
				b.ListarClientes();	
				break;
			
			case 3:
				b.EscolherCliente();
				break;
			}
			
		}while (opcao != 0);
		
		System.out.println("saiu");

	}
}
