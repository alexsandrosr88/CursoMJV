package myapp.factory;

import myapp.cadastros.Cadastro;

public class FabricaCadastro {
	public static Cadastro criarCadastro(String nome, String email, Long telefone) {
		if( (nome ==null || email == null || telefone ==null) ) {
			System.err.println("valores invalidos");
			return null;
		}
		
		Cadastro cliente = new Cadastro();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		return cliente;
	}
}
