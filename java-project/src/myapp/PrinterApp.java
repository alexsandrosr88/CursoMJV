package myapp;

import java.text.SimpleDateFormat;
import java.util.List;

import myapp.cadastros.Empresa;
import myapp.cadastros.Endereco;
import myapp.pedidos.Pedido;
import myapp.pedidos.PedidoItem;
import myapp.util.FormatUtil;

public class PrinterApp {
	public static void imprimirPedido(Pedido pedido) {
		//GERAR O CUPOM
		//CRIAR O OBJETO - ENDERECO - LOGRADOURO, NUMERO, BAIRRO, CIDADE - SIGLA ESTADO
		//FORMATAR O CNPJ, IE, EM - PLUS
		
		//substring
		//split
		//regex
		//pattern
		//matches
		//String celFormatado = new Long(11987652345L).toString().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");
		
		
		///System.out.printf("Mr.%2$s,%1$s\n\n", "GLEYSON", "SAMPAIO");
		
		String myCep = "65450897";
		String b1 = myCep.substring(0,2);
		String b2= myCep.substring(2,5);
		String b3= myCep.substring(5,8);
		
		//System.out.println(b1 + "." + b2 + "-" + b3);
		//System.out.println(String.format("%s.%s-%s", b1,b2,b3));
		
		
		//System.out.println(myCep.replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2-$3") );
		
		
		Empresa empresa = pedido.getEmpresa();
		
		System.out.println(empresa.getCadastro().getEndereco());
		
		Endereco e = empresa.getCadastro().getEndereco();
		String cep = e.getCep().toString().replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2-$3");
		
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------------------------------\n");
		sb.append(empresa.getCadastro().getNome() + "\n");
		sb.append(String.format("%s, %s, %s - %s - %s Cep: %s \n", e.getLogradouro(), e.getNumero(),e.getBairro(), e.getCidade(),e.getUf(), cep   ));
		sb.append(String.format("CNPJ: %s \n", FormatUtil.formatCnpj(empresa.getCadastro().getCpfCnpj())));
		sb.append(String.format("IE: %s\nIM: %s\n",empresa.getIe().toString().replaceAll( ("(\\d{3})(\\d{3})(\\d{3})"), "$1.$2.$3"), 
				empresa.getIm().toString().replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2.$3")));
		sb.append("----------------------------------------------------------------\n");
		
		//NUMA LINHA DATA FORMATADA - CCF (6) DIGITOS - COO (6DIGITOS)
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String dataFormatada = formatador.format(pedido.getData());
		sb.append(String.format("%-40s CCF:%06d CCO:%06d",dataFormatada, pedido.getCcf(), pedido.getCoo()) );
		
		
		sb.append("\n----------------------------------------------------------------\n");
		
		List<PedidoItem> itens = pedido.getItens();
		
		sb.append(String.format("%-35s%10s%10s%10s\n", "ITEM","QUANT", "R$ UNIT", "R$ TOTAL"));
		
		for(PedidoItem i: itens) {
			String q = String.format("%.2f",i.getQuantidade());
			String vu = String.format("%.2f",i.getValorVenda());
			String vt = String.format("%.2f",i.getValorTotal());
			
			sb.append(String.format("%-35s%10s%10s%10s\n",i.getProduto().getTitulo(),  q,vu,vt));
			
		}
		sb.append("\n----------------------------------------------------------------\n");
		
		sb.append(String.format("TOTAL %.2f\n", pedido.getValorTotal()));
		
		System.out.println(sb.toString());
		//depois de tudo bonitinho	
		//vamos salvar o cupum no disco
	}	
}

//Path path = Paths.get(newFile);
//Files.write(path, bytes);
