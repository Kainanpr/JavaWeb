/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empregado;
import persistencia.EmpregadoDAO;

/**
 *
 * @author KainanXD
 */
@WebServlet(name = "EmpregadoController", urlPatterns = {"/EmpregadoController"})
public class EmpregadoController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();  
        RequestDispatcher disp;
        
        String mensagem;
        
        int id=0;
        
        if(request.getParameter("id")==null) {
            disp = request.getRequestDispatcher("/index.jsp");
            disp.forward(request, response);      
        }
        
        else 
            id = Integer.parseInt(request.getParameter("id"));
        
        
        
        
        EmpregadoDAO empDao = new EmpregadoDAO();
        
        try {
            
            Empregado empregado = empDao.getEmpregadoPorCodigo(id);
            
            if(request.getParameter("acao").equals("editar")) {

                //disp = request.getRequestDispatcher("/cadastro.jsp");
                disp = getServletContext().getRequestDispatcher("/cadastro.jsp");
                request.setAttribute("empregado", empregado);            
                disp.forward(request, response);
                
            } else if(request.getParameter("acao").equals("excluir")) {
                empDao.deletar(empregado);
                //disp = request.getRequestDispatcher("/index.jsp");         
                //disp.forward(request, response);
                response.sendRedirect("./index.jsp");
                
            }
            
            
     
            
        } catch(RuntimeException ex) {
            mensagem = "Usuário não encontrado";
            out.println( "<script> alert(' " + mensagem + " '); location.href='./index.jsp'  </script>" );
        }
 
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();  
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String mensagem;
        
        int id;
        if(request.getParameter("id").equals(""))
            id = 0;
        else 
            id = Integer.parseInt(request.getParameter("id"));
        
        String nome = request.getParameter("nome");
        String setor = request.getParameter("setor");
        
        
        
        Empregado empregado = new Empregado();
        empregado.setId(id);
        empregado.setNome(nome);
        empregado.setSetor(setor);
        

        EmpregadoDAO empDao = new EmpregadoDAO();
        
        try {
           empDao.gravar(empregado);
           mensagem = "Usuário gravado com sucesso!";
           
        } catch(RuntimeException ex) {
            
           mensagem = "Erro ao tentar cadastrar usuário!";
        }
        
        
        out = response.getWriter();
        
        out.println( "<script> alert(' " + mensagem + " '); location.href='./index.jsp'  </script>" );
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
