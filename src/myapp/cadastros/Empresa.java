package myapp.cadastros;

public class Empresa {
	private  Cadastro cadastro;
	private Long im;
	private Long ie;
	
	
	
	public Empresa(Long im, Long ie) {
		this.im = im;
		this.ie = ie;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Long getIm() {
		return im;
	}


	public Long getIe() {
		return ie;
	}


}
