<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="menu.jsp" %>

    
    <div class="container">
        <h1 class="mt-5">Lista de Empregados</h1>
 
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Setor</th>
              </tr>
            </thead>
            
            <jsp:useBean id="empregadoDao" class="persistencia.EmpregadoDAO"/>
            
            <tbody>
              <c:forEach var="empregado" items="${empregadoDao.lista}">

            <tr>
                <td>${empregado.id}</td>
                <td>${empregado.nome}</td>
                <td>${empregado.setor} 
                    <div class="float-right">
                        <a class="btn btn-primary" href="EmpregadoController?acao=editar&id=${empregado.id}">Editar</a>
                        <a class="btn btn-danger" href="EmpregadoController?acao=excluir&id=${empregado.id}" onclick="return confirm('Deseja realmente excluir este registro?')">Excluir</a>
                    </div>
                </td>
            </tr>

            </c:forEach>
            </tbody>          
        </table>   
            
        <a class="btn btn-primary" href="cadastro.jsp">Novo Empregado</a><br>
            
    </div>
            
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
