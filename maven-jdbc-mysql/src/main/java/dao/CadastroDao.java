package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.FabricaConexao;
import model.Cadastro;

public class CadastroDao {
	private Connection cnn;

	public CadastroDao() {
		FabricaConexao fc = new FabricaConexao();
		cnn = fc.criarConexao();
	}

	public void incluir(Cadastro cadastro) {
		try {
			String sql = "INSERT INTO cadastro (nome,telefone) VALUES (?,?);";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, cadastro.getNome());
			st.setLong(2, cadastro.getTelefone());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// IMPLEMENTAR
	public void alterar(Cadastro cadastro) {
		try {
			String sql = "UPDATE cadastro SET nome = ?, SET telefone = ? WHERE id =?";
			PreparedStatement st = cnn.prepareStatement(sql);

			st.setString(1, cadastro.getNome());
			st.setLong(2, cadastro.getTelefone());
			st.setInt(3, cadastro.getId());
			st.execute();

			cnn.close();

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante exclusão do dado.\n" + e);
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
			System.err.println("Ocorreu um erro durante exclusão do dado.\n" + e);
		}
	}

	public List<Cadastro> listar() {
		
		try {
			List<Cadastro> listaCadastro = new ArrayList<Cadastro>();
			
			String sql = "SELECT * FROM cadastro";
			
			PreparedStatement stmt = cnn.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();

			while (rst.next()) {

				Cadastro cadastro = new Cadastro();
				cadastro.setId(rst.getInt("id"));
				cadastro.setNome(rst.getString("nome"));
				cadastro.setTelefone(rst.getLong("telefone"));

				listaCadastro.add(cadastro);
			}
			stmt.close();
			return listaCadastro;
			

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante montagem da lista de cadastro.\n" + e);
		}
		return null;
		
	}

	public Cadastro buscar(String nome) {
		try {
			String sql = "SELECT * FROM cadastro WHERE nome ?";

			PreparedStatement stmt = cnn.prepareStatement(sql);
			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();

			Cadastro cadastro = new Cadastro();

			if (rs.next()) {

				cadastro.setId(rs.getInt("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setTelefone(rs.getLong("telefone"));
			}

			return cadastro;

		} catch (SQLException e) {
			System.err.println("Ocorreu um erro durante pesquisa pelo nome.\n" + e);
		}
		return null;

	}

}
