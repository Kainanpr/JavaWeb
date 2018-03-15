package teste;

import java.util.List;
import modelo.Empregado;
import persistencia.EmpregadoDAO;

public class TesteDAO {
    
    public static void main(String[] args) {
        
        EmpregadoDAO empDAO = new EmpregadoDAO();
        
        List<Empregado> empregados = empDAO.getLista();
        
        for(Empregado emp : empregados) {
            System.out.print(emp.getId() + "    ");
            System.out.print(emp.getNome() + "    "); 
            System.out.println(emp.getSetor());
        }
             
        
    }
    
}
