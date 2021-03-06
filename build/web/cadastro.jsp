<%@include file="menu.jsp" %>
    
    <div class="container">
        <h1 class="mt-5">Cadastro de Funcionário</h1>

        <form class="mt-3" method="post" action="EmpregadoController">

            <input type="hidden" name="id" value="${empregado.id}">

            <div class="form-group">
              <label for="nome">Digite seu nome: </label>
              <input type="text" name="nome" class="form-control" id="nome"  placeholder="Enter name" value="${empregado.nome}">
            </div>
            
            <div class="form-group">
              <label for="setor">Digite seu setor:</label>
              <input type="text" name="setor" class="form-control" id="setor" placeholder="Enter setor" value="${empregado.setor}">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
