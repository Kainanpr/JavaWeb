package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    
    //Atributos
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //Não é mais necessario carregar o driver
    private static final String URL = "jdbc:mysql://localhost:3306/teste"; 
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection conn = null; //Responsavel por realizar a conexao
    //private Statement statement; //Responsavel por realizar a pesquisa no banco de dados
    //private ResultSet resultSet; //Armazena o resultado da pesquisa
    
    
    //Metodos
    public static Connection criaConexao() 
    {
        if(conn == null)
        {
            try {
                Class.forName(DRIVER);  //Não é mais necessario carregar o driver
                conn = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conexão efetuada com sucesso!");
            } catch (SQLException ex) {
                System.out.println("Erro ao se conectar com o banco de dados:\n" + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver:\n" + ex.getMessage());
            }
        }
        
        return conn;       
    }
    
    //Metodo responsavel por realizar a desconexao
    public static void desconectar()
    {
        try {
            conn.close(); // Fecha a conexao
            //JOptionPane.showMessageDialog(null, "BD desconectado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão com o banco de dados:\n" + ex.getMessage());
        }
    }

}//Fim da classe
