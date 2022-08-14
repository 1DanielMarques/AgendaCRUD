package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mDanielSE
 */
public class ContatoDAO {

    // Classe de regra de negocio
    public void create(Contato contato) {
        String sql = "INSERT INTO contatos(nome,idade,sexo,profissao,dataCadastro) "
                + " VALUES (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexao
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setString(3, contato.getSexo());
            pstm.setString(4, contato.getProfissao());
            pstm.setDate(5, new Date(contato.getDataCadastro().getTime()));

            pstm.execute();
            System.out.println("---SALVO COM SUCESSO---");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Contato> read() {
        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();
        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que recupera os dados do banco
        ResultSet rst = null;
        try {
            //Cria conexao
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Contato contato = new Contato();
                // Recuperando id
                contato.setId(rst.getInt("id"));
                contato.setNome(rst.getString("nome"));
                contato.setIdade(rst.getInt("idade"));
                contato.setSexo(rst.getString("sexo"));
                contato.setProfissao(rst.getString("profissao"));
                contato.setDataCadastro(rst.getDate("dataCadastro"));
                contatos.add(contato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contatos;

    }

    public void update(Contato contato) throws Exception {

        String sql = "UPDATE contatos SET nome = ?, idade = ?, sexo = ?, profissao = ?, dataCadastro = ? "
                + " WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // Criar conexao
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setString(3, contato.getSexo());
            pstm.setString(4, contato.getProfissao());
            pstm.setDate(5, new Date(contato.getDataCadastro().getTime()));
            pstm.setInt(6, contato.getId());

            pstm.execute();
            System.out.println("---ATUALIZADO COM SUCESSO!---");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Delete by id
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM contatos WHERE id = ? ";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            System.out.println("---EXCLUÍDO COM SUCESSO!---");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
