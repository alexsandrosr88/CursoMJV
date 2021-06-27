package model;

public class Cadastro {
	private Integer id;
	private char pf_pj;
	private String razao_social;
	private String cpf_cnpj;
	private Long telefone1;
	private Long telefone2;
	private String email;
	private String site_instagram;
	private String observacoes;
	private Endereco endereco;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public char getPf_pj() {
		return pf_pj;
	}
	public void setPf_pj(char pf_pj) {
		this.pf_pj = pf_pj;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public Long getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(Long telefone1) {
		this.telefone1 = telefone1;
	}
	public Long getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(Long telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite_instagram() {
		return site_instagram;
	}
	public void setSite_instagram(String site_instagram) {
		this.site_instagram = site_instagram;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
