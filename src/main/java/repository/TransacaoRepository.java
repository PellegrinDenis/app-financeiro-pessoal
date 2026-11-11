package repository;

import model.Categoria;
import model.TipoTransacao;
import model.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository {

    public void salvar(Transacao transacao) {
        String sql = "INSERT INTO transacoes (descricao, valor, data, tipo, categoria) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement smtm = conn.prepareStatement(sql)) {
            smtm.setString(1, transacao.getDescricao());
            smtm.setString(2, transacao.getValor().toString());
            smtm.setString(3, transacao.getData().toString());
            smtm.setString(4, transacao.getTipo().name());
            smtm.setString(5, transacao.getCategoria().name());
            smtm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar a transação", e);
        }
    }

    public List<Transacao> listarTodas() {
        String sql = "SELECT id, descricao, valor, data, tipo, categoria FROM transacoes ORDER BY data";
        List<Transacao> lista = new ArrayList<>();

        try(Connection conn = ConexaoBanco.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
           while (rs.next()) {
               lista.add(new Transacao(
                       rs.getInt("id"),
                       rs.getString("descricao"),
                       new BigDecimal(rs.getString("valor")),
                       LocalDate.parse(rs.getString("data")),
                       TipoTransacao.valueOf(rs.getString("tipo")),
                       Categoria.valueOf(rs.getString("categoria"))
               ));
           }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar as transações", e);
        }
        return lista;
    }
}