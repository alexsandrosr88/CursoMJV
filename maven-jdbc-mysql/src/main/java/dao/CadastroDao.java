package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.FabricaConexao;
import model.Cadastro;
import model.Endereco;

public class CadastroDao {
	private Connection cnn;

	public CadastroDao() {
		FabricaConexao fc = new FabricaConexao();
		cnn = fc.criarConexao();
	}

	public void incluir(Cadastro cadastro) {
		try {
			String sql = "call novo_cad (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, String.valueOf(cadastro.getPf_pj()));
			st.setString(2, cadastro.getRazao_social());
			st.setString(3, cadastro.getCpf_cnpj());
			st.setLong(4, cadastro.getTelefone1());
			st.setLong(5, cadastro.getTelefone2());
			st.setString(6, cadastro.getEmail());
			st.setString(7, cadastro.getObservacoes());
			st.setString(8, cadastro.getEndereco().getLogradouro());
			st.setString(9, cadastro.getEndereco().getNumero());
			st.setString(10, cadastro.getEndereco().getBairro());
			st.setString(11, cadastro.getEndereco().getCidade());
			st.setString(12, String.valueOf(cadastro.getEndereco().getUf()));
			st.setString(13, String.valueOf(cadastro.getEndereco().getCep()));
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante inclusão dos dados.\n" + e);
		}
	}

	// IMPLEMENTAR
	public void alterar(Cadastro cadastro) {
		try {
			String sql = "UPDATE cadastro SET nome = ?, telefone = ? WHERE id =?";
			PreparedStatement st = cnn.prepareStatement(sql);

			st.setString(1, String.valueOf(cadastro.getPf_pj()));
			st.setString(2, cadastro.getRazao_social());
			st.setString(3, cadastro.getCpf_cnpj());
			st.setLong(4, cadastro.getTelefone1());
			st.setLong(5, cadastro.getTelefone2());
			st.setString(6, cadastro.getEmail());
			st.setString(7, cadastro.getObservacoes());
			st.setString(8, cadastro.getEndereco().getLogradouro());
			st.setString(9, cadastro.getEndereco().getNumero());
			st.setString(10, cadastro.getEndereco().getBairro());
			st.setString(11, cadastro.getEndereco().getCidade());
			st.setString(12, String.valueOf(cadastro.getEndereco().getUf()));
			st.setString(13, String.valueOf(cadastro.getEndereco().getCep()));
			st.executeUpdate();

			st.close();

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante alteração dos dados.\n" + e);
		}

	}

	public void excluir(Integer id) {

		try {
			String sql = "DELETE cadastro FROM cadastro WHERE id =?";
			PreparedStatement st = cnn.prepareStatement(sql);

			st.setInt(1, id);
			st.execute();

			cnn.close();

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante exclusão do dado ID:\n" +id + "\n" + e);
		}
	}

	public List<Cadastro> listar() {
		
		try {
			List<Cadastro> listaCadastro = new ArrayList<Cadastro>();
			
			String sql = "SELECT * FROM cadastro INNER JOIN endereco ON fk_endereco = id_endereco";
			
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();
				Endereco end = new Endereco();
				cadastro.setId(rs.getInt("codigo"));
				cadastro.setPf_pj(rs.getString("pf_pj").charAt(0));
				cadastro.setRazao_social(rs.getString("razao_social"));
				cadastro.setCpf_cnpj(rs.getString("cpf_cnpj"));
				cadastro.setTelefone1(rs.getLong("telefone1"));
				cadastro.setTelefone2(rs.getLong("telefone2"));
				cadastro.setEmail(rs.getString("email"));
				cadastro.setObservacoes(rs.getString("obs"));
				cadastro.setSite_instagram(rs.getString("site_instagram"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setNumero(rs.getString("numero"));
				end.setComplemento(rs.getString("complemento"));
				end.setBairro(rs.getString("bairro"));
				end.setCidade(rs.getString("cidade"));
				end.setUf(rs.getString("uf").charAt(0));
				end.setCep(rs.getString("cep").charAt(0));
				cadastro.setEndereco(end);
			
			
				listaCadastro.add(cadastro);
			}
			st.close();
			
			return listaCadastro;
			

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante montagem da lista de cadastro.\n" + e);
		}
		return null;
		
	}
	
	public List<Cadastro> busca(String nome) {
		try {
			List<Cadastro> listaCadastro = new ArrayList<Cadastro>();
			
			String sql = "SELECT * FROM cadastro WHERE nome = ?";
			
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nome);
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();
				cadastro.setId(rs.getInt("id"));
				cadastro.setRazao_social(rs.getString("nome"));
				cadastro.setTelefone1(rs.getLong("telefone"));

				listaCadastro.add(cadastro);
			}
			st.close();
			
			return listaCadastro;
			

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante montagem da lista de cadastro.\n" + e);
		}
		return null;

	}

	public Cadastro buscarNome(String nome) {
		Cadastro cadastro = null;
		try {
			String sql = "SELECT * FROM cadastro WHERE nome = ?";

			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nome);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				cadastro = new Cadastro();
				cadastro.setId(rs.getInt("id"));
				cadastro.setRazao_social(rs.getString("nome"));
				cadastro.setTelefone1(rs.getLong("telefone"));
			}

			return cadastro;

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro ao realizar pesquisa pelo nome.\n"+ nome + e);
		}
		return null;

	}
	
	public Cadastro buscarId(Integer id) {
		Cadastro cadastro = null;
		try {
			String sql= "SELECT * FROM cadastro WHERE id = ?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				cadastro = new Cadastro();
				cadastro.setId(rs.getInt("id"));
				cadastro.setRazao_social(rs.getString("nome"));
				cadastro.setTelefone1(rs.getLong("telefone"));
			}
			
			st.close();
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante pesquisa pelo id:\n"+ id + e);
		}
		return  cadastro;
	}
	
	
	public boolean existsByNome(String nome) {
		boolean exists = false;
		try {
			String sql= "SELECT * FROM cadastro WHERE nome = ?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nome);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				return true;

			}
			st.close();
						
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante pesquisa pelo nome.\n"+ nome + e);
		}
		return  exists;
	}

}
