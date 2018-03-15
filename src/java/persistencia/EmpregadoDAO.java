package persistencia;

import java.sql.Connection; //Classe para armazenar o objeto de conexão
import java.sql.ResultSet; //Armazena o conjunto de registros que vieram do DB
import java.sql.SQLException; //Exceções lançadas pelas JDBC (erros de SQL)
import java.sql.Statement; //Envia a instrução SQL (sem parâmetros)
import java.sql.PreparedStatement; //Envia a instrução SQL (com parâmetros)
import java.util.ArrayList; //Cria um vetor de dados específicos de uma classe
import java.util.List; //Superclasse da ArrayList

import modelo.Empregado;

public class EmpregadoDAO {
    //Executa a conexao com o banco de dados
    private Connection conn;
    
    public EmpregadoDAO()
    {
        conn = ConexaoDB.criaConexao();
    }
    
    public List<Empregado> getLista()
    {
        //Cria o objeto resultado que irá armazenar os registros retornados do DB
        List<Empregado> resultado = new ArrayList<>();

        try {
            //Cria o objeto resultado que irá armazenar os registros retornados do DB para o DB
            Statement stmt = conn.createStatement(); 
            //Armazena o resultado do comando enviado para o banco de dados
            ResultSet result = stmt.executeQuery("SELECT * FROM empregado");
            //rs.next() Aponta para o próximo registro do DB, se houver um
            while(result.next()) {
                //Cria o objeto da classe empregado para armazenar os dados que vieram do DB
                Empregado empregado = new Empregado();
                //Pega o conteudo da coluna "id" do ResultSet(rs)
                empregado.setId(result.getInt("id"));
                //Pega o conteudo da coluna "nome" do ResultSet(rs)
                empregado.setNome(result.getString("nome"));
                //Pega o conteudo da coluna "setor" do ResultSet(rs)
                empregado.setSetor(result.getString("setor"));
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(empregado);
            }
            
        } catch (SQLException ex) {       
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        
        
        //Retorna a lista de empregados encontrados no banco de dados.
        return resultado;
    }
    
    public void gravar(Empregado empregado) {
        
        //String mensagem;
        
        try {
            
            String sql;           
            
            if(empregado.getId() == 0) {
                //Realizar uma inclusão
                sql = "INSERT INTO empregado(nome, setor) VALUES(?, ?)";

            } else {
                //Realizar uma alteração
                sql = "UPDATE empregado SET nome=?, setor=? WHERE id=?";
            }
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, empregado.getNome());
            preStmt.setString(2, empregado.getSetor());
            
            if(empregado.getId() > 0) {
                preStmt.setInt(3, empregado.getId());
            }
            
            //Executa uma instrucao que nao retornará nenhum resultado
            preStmt.execute();     
            
            //mensagem = "Usuário cadastrado com sucesso!";
            
        } catch (SQLException ex) {
            //mensagem = "Erro ao gravar empregado!";
            throw new RuntimeException("Erro ao gravar empregado: " + ex.getMessage());
        }
        
        //return mensagem;
    }
    
    public Empregado getEmpregadoPorCodigo(int id) {
        
        Empregado empregado = new Empregado();
        
        try {
            
            
            String sql = "SELECT * FROM empregado WHERE id=?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            
            preStmt.setInt(1, id);

            ResultSet rs = preStmt.executeQuery(); 
          
            
            if(rs.next()) {
                empregado.setId(id);
                empregado.setNome(rs.getString("nome"));
                empregado.setSetor(rs.getString("setor"));
            } else {
                throw new RuntimeException("Empregado não encontrado");
            }
                    
        } catch (SQLException ex) {

            throw new RuntimeException("Erro ao pesuisar empregado: " + ex.getMessage());
        }
        
        return empregado;
    }
    
    public void deletar(Empregado empregado) { 
        
        try {
            
            String sql = "DELETE FROM empregado WHERE id=?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            
            preStmt.setInt(1, empregado.getId());

             //Executa uma instrucao que nao retornará nenhum resultado
            preStmt.execute();     
            
            
        } catch (SQLException ex) {

            throw new RuntimeException("Erro ao deletar empregado: " + ex.getMessage());
        }
        
    }
            
    
}//Fim da classe
