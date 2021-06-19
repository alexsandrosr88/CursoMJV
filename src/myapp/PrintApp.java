package myapp;

import java.text.SimpleDateFormat;

import myapp.cadastros.Empresa;
import myapp.pedidos.Pedido;

public class PrintApp {
	
	public static void imprimirPedido(Pedido pedido) {
		//Gerar o cupom
		//Criar o objeto Endereco - Logrado, numero, Bairro, Cidade, Sigla Estado
		//Formatar o CNPJ, IE e o EM
		Empresa empresa = pedido.getEmpresa();	
		
		System.out.printf("Mr.%2s,1%s,\n\n", "Alexsandro","Da Silva Ramos");
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(empresa.getCadastro().getNome() + "\n");
		sb.append(empresa.getCadastro().getEndereco() + "\n");
		sb.append("CNPJ: "+ empresa.getCadastro().getCpfCnpj() + "\n");
		sb.append(String.format("CNPJ: %s \n", empresa.getCadastro().getCpfCnpj()));
		sb.append(String.format("IE: %d\nIM: %d",empresa.getIe(),empresa.getIm()));
		sb.append("--------------------------------------------------------------\n");
		
		//Numa Linha Data Formatada - CCF (6 Digitos - COO (6 digitos) 
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = formatador.format(pedido.getData());
		sb.append(pedido.getData());
		sb.append(dataFormatada);
		sb.append("--------------------------------------------------------------\n");
		sb.append(String.format("TOTAL %.2f", pedido.getValorTotal()));
		System.out.println(sb.toString());
				
				
		/*
		System.out.println(empresa.getCadastro().getNome());
		System.out.println(empresa.getCadastro().getEndereco());
		System.out.println("CNPJ: "+ empresa.getCadastro().getCpfCnpj());
		System.out.println("IE: " +empresa.getIe());
		System.out.println("IM: " +empresa.getIm());
		*/
	}
}
