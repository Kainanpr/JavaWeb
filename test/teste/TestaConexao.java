package teste;

import java.sql.Connection;
import persistencia.ConexaoDB;


public class TestaConexao {
    
    public static void main(String[] args) {
        
        Connection conn = ConexaoDB.criaConexao();
                
    }
        
    
}
