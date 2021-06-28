package model;

public class Endereco {
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private	Character uf;
	private String cidade;
	private char cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Character getUf() {
		return uf;
	}
	public void setUf(Character uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public char getCep() {
		return cep;
	}
	public void setCep(char cep) {
		this.cep = cep;
	}

	
	
}
