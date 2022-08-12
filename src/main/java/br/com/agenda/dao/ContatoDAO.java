package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * @author mDanielSE
 */
public class ContatoDAO {

    // Classe de regra de negocio
    public void save(Contato contato) {
        String sql = "INSERT INTO contatos(nome,idade,dataCadastro) "
                + " VALUES (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexao
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.execute();
            System.out.println("SALVO COM SUCESSO");
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

}
