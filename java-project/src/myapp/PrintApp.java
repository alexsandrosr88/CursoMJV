package myapp;

import java.text.SimpleDateFormat;

import myapp.cadastros.Empresa;
import myapp.pedidos.Pedido;
import myapp.pedidos.PedidoItem;

public class PrintApp {
	
	public static void imprimirPedido(Pedido pedido) {
		//Gerar o cupom
		//Criar o objeto Endereco - Logrado, numero, Bairro, Cidade, Sigla Estado
		//Formatar o CNPJ, IE e o EM
		Empresa empresa = pedido.getEmpresa();	
		
		StringBuilder sb = new StringBuilder();
		sb.append(empresa.getCadastro().getNome() + "\n");
		sb.append(empresa.getCadastro().getLogradouro()+" ");
		sb.append(empresa.getCadastro().getNumero() +", ");
		sb.append(empresa.getCadastro().getBairro()+ " - ");
		sb.append(empresa.getCadastro().getUf()+ "\n");
		sb.append(String.format("CNPJ: %s.%s.%s.%s-%s\n", empresa.getCadastro().getCpfCnpj().substring(0,2),
				empresa.getCadastro().getCpfCnpj().substring(2,5), empresa.getCadastro().getCpfCnpj().substring(5,8),
				empresa.getCadastro().getCpfCnpj().substring(8,12),empresa.getCadastro().getCpfCnpj().substring(12,14)));
		sb.append(String.format("IE: %s.%s.%s\n", empresa.getIe().toString().substring(0,3),
				empresa.getIe().toString().substring(3,6),empresa.getIe().toString().substring(6,9)));
		sb.append(String.format("IM: %s.%s.%s\n", empresa.getIm().toString().substring(0,2),
				empresa.getIm().toString().substring(2,5),empresa.getIm().toString().substring(5,8)));
		sb.append("--------------------------------------------------------------\n");
		
		//Numa Linha Data Formatada - CCF (6 Digitos - COO (6 digitos) 
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = formatador.format(pedido.getData());
		sb.append(dataFormatada + "    CCF:000001"+ "     COO:000002" + "\n");
		sb.append("--------------------------------------------------------------\n");
		sb.append("        CUPOM FISCAL"+ "\n");
		sb.append("ITEM  CÓDIGO  DESCRIÇÃO  QTD.UN VL UNIT ( R$) ST VL  ITEM ( R$)" + "\n");
		sb.append("--------------------------------------------------------------\n");
		//for(int i; i < pedido.getItens; i++) {
		for(PedidoItem i: pedido.getItens()) {
			int qteItem = 1;
			sb.append(qteItem + "  " + "           "+ i.getProduto().getTitulo() 
				+" " +  i.getQuantidade().toString() + "   "+  i.getValorVenda().toString() + "\n");
			qteItem++;
		}
		sb.append(String.format("TOTAL $%.2f", pedido.getValorTotal()));
		System.out.println(sb.toString());
	}
}
