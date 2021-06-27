package jdbc_application;

import java.util.List;
import java.util.Scanner;

import dao.CadastroDao;

import model.Cadastro;

public class JdbcApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();

		// Inclui Dados
		// IncluiCadastro();

		// listar cadastro
		// ListaCadastro();
		
		//Exclui Cadastro 
		//ExcluiCadastro();
		
		//Alterar Cadastro
		
		AlteraCadastro();
		
		

	}
	static void AlteraCadastro() {
		Scanner sc = new Scanner(System.in);
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();
		
		String nome = "";
		Long telefone;
		int opcao  = 0;
		Integer id;
		
		System.out.println("informe o ID que deseja alterar:");
			id = sc.nextInt();
		System.out.println();
		
		System.out.println("O que você deseja alterar?");
		
		StringBuilder sb = new StringBuilder();
		//sb.append(String.format("O que você deseja alterar: \n 1- Nome: %d\n 2- Telefone %d\n", opcao,opcao,opcao);
		
		//
		System.out.println();
		System.out.println("1 - Nome");
		opcao = sc.nextInt();
		System.out.println();
		System.out.println("2 - Telefone ");
		opcao = sc.nextInt();
		System.out.println();
		System.out.println("3 - Os dois ");
		opcao = sc.nextInt();
		
		switch (opcao) {	
			case 1: 
				System.out.println("informe o novo nome:");
				nome = sc.next();
				cadastro.setNome(nome);
			break;
			case 2:
				System.out.println("Informe o novo telefone:");
				telefone = sc.nextLong();
				cadastro.setTelefone(telefone);
				break;
			case 3:
				System.out.println("informe o novo nome:");
				nome = sc.next();
				cadastro.setNome(nome);
				
				System.out.println();
				
				System.out.println("Informe o novo telefone:");
				telefone = sc.nextLong();
				cadastro.setTelefone(telefone);
				break;
				
				default:
					System.out.println("Opção inválida!");
		}
	}

	static void ExcluiCadastro() {
		Scanner sc = new Scanner(System.in);
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();

		System.out.println("Informe o ID do cadastro que deseja excluir:");
		Integer id = sc.nextInt();

		cadastro.setId(id);
		dao.excluir(cadastro);

		System.out.println("Cadastro excluido com sucesso!");
	}

	static void IncluiCadastro() {
		Scanner sc = new Scanner(System.in);
		String nome = "";
		Long telefone;

		CadastroDao dao = new CadastroDao();
		Cadastro cadastro = new Cadastro();

		System.out.println("Você informe o nome para incluir no cadastro:");
		nome = sc.next();
		cadastro.setNome(nome);

		System.out.println("Você informe o telefone para incluir no cadastro:");
		telefone = sc.nextLong();

		cadastro.setTelefone(telefone);

		dao.incluir(cadastro);
		
		System.out.println("Cadastro incluído com sucesso!");
	}

	static void ListaCadastro() {
		CadastroDao dao = new CadastroDao();

		List<Cadastro> lista = dao.listar();

		for (Cadastro i : lista) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("ID: %d | Nome: %s | Telefone: %s\n", i.getId(),
					i.getNome(),i.getTelefone().toString()));
			System.out.println(sb.toString());
		}
	}

}
