package br.com.agenda.factory;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mDanielSE
 */
public class ConnectionFactory {

    // Nome do usuario do banco
    private static final String USERNAME = "root";
    // Senha do banco
    private static final String PASSWORD = "danielroot";
    // Caminho do banco, porta, nome do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    /*
    Conexao com o banco de dados
     */
    public static Connection createConnectionToMySQL() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        //Recuperar uma conexao com o banco de dados
        Connection con = createConnectionToMySQL();
        if (con != null) {
            System.out.println("Conexao bem sucedida");
            con.close();
        }
    }

}
