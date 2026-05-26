package DAO;

import Conexao.ConexaoDB;
import model.Tarefas;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;

public class TarefaDAO {

    public void inserir(Tarefas tarefas) {
        String sql = "INSERT INTO tarefas (titulo, descricao, concluida, data_criacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarefas.getTitulo());
            stmt.setString(2, tarefas.getDescricao());
            stmt.setBoolean(3, tarefas.isConcluida());
            stmt.setString(4, tarefas.getDataCriacao().toString());

            stmt.executeUpdate();
            System.out.println("Tarefa inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tarefa: " + e.getMessage());
        }
    }

    public List<Tarefas> listarTodas() {
        List<Tarefas> tarefas = new ArrayList<>();
        String sql = "SELECT * from Tarefas";

        try (Connection conn = ConexaoDB.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarefas t = new Tarefas(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getBoolean("concluida"),
                        LocalDate.parse(rs.getString("data_criacao"))
                );
                tarefas.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar tarefas: "+ e.getMessage());

        }
        return tarefas;
    }

    public void marcaConcluida(int id){
        String sql = "UPDATE tarefas SET concluida = true WHERE id = ?";
        try (Connection conn = ConexaoDB.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tarefa marcada como concluida!");

        }catch (SQLException e){
            System.out.println("Erro ao atualizar tarefa: "+ e.getMessage());
        }
    }
}
