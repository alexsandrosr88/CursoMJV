package myapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import myapp.cadastros.CD;
import myapp.cadastros.Cadastro;
import myapp.cadastros.Empresa;
import myapp.factory.FabricaCadastro;
import myapp.pedidos.Pedido;
import myapp.pedidos.PedidoItem;

public class Application {
	public static void main(String[] args) {
		//REQUISITO
		//1 CRIAR OBJETOS QUE RELACIONANDO-SE EU TEREI UMA PESRPECTIVA DE TER UM PEDIDO COM
		//TODAS AS INFORMAÇÕES
		//2 IMPRIMIR ESTE PEDIDO NO ESTILO CUPOM
		
		
		Cadastro artista = FabricaCadastro.criarCadastro("BRUCE DICKSON", "a@a", 989089090L);
			
		CD p1 = new CD(); // Livro()
		p1.setCodigoBarras("989789789");
		p1.setTitulo("IRON MAIDEN");
		p1.setValorVenda(199.90);
		p1.setFaixa(10);
		p1.setArtista(artista);
		
		artista = FabricaCadastro.criarCadastro("PINK FLOYD", null, 989089090L);
		
		CD p2 = new CD(); // Livro()
		p2.setCodigoBarras("989789789");
		p2.setTitulo("THE WALL");
		p2.setValorVenda(157.90);
		p2.setFaixa(8);
		p2.setArtista(artista);
		
		Empresa empresa = new Empresa(908908L, 908098L);
		Cadastro cadEmpresa = new Cadastro();
		cadEmpresa.setCpfCnpj("123456789000001");
		cadEmpresa.setNome("IFOOD PEDIDOS");
		cadEmpresa.setEmail("pedidos@pedidos.com");
		cadEmpresa.setEndereco("Rua Inácio de Nobrega, 1036, Centro - SP");
		cadEmpresa.setTelefone(11987654321L);
		empresa.setCadastro(cadEmpresa);
		
		Pedido pedido = new Pedido();
		pedido.setEmpresa(empresa);
		Cadastro comprador = FabricaCadastro.criarCadastro("GLEYSON", "b@b", 89678789L);
		
		pedido.setComprador(comprador);
		pedido.setData(new Date(2021,6,16));
		pedido.setValorTotal(325.0);
		pedido.setId(23234);
		
		List<PedidoItem> itens = new ArrayList<>();
		PedidoItem item = new PedidoItem();
		item.setProduto(p1);
		item.setQuantidade(2.0);
		item.setValorVenda(p1.getValorVenda());
		item.setValorTotal(item.getQuantidade() * item.getValorVenda());
		
		itens.add(item);
		
		item= new PedidoItem();
		item.setProduto(p2);
		item.setQuantidade(4.0);
		item.setValorVenda(p2.getValorVenda());
		item.setValorTotal(item.getQuantidade() * item.getValorVenda());
		
		itens.add(item);
		
		pedido.setItens(itens);
		
		PrintApp.imprimirPedido(pedido);

	}
	
}
