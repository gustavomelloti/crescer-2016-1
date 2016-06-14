<%@page import="java.util.List"%>
<%@page import="br.com.crescer.aula5.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form role="form" action="pessoa" method="POST">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text"  class="form-control" id="nome" name="nome" required="">
                </div>
                <div class="form-group">
                    <label for="idade">Idade:</label>
                    <input type="text"  class="form-control" id="idade" name="idade" required="">
                </div>
                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <input type="radio" name="sexo" value="MASCULINO" required=""> Masculino
                    <input type="radio" name="sexo" value="FEMININO" required=""> Feminino
                    <input type="radio" name="sexo" value="OUTRO" required=""> Outro
                </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Sexo</th>
                    </tr>
               </thead>
               <tbody>
                    <%
                        for (Pessoa exercise : (List<Pessoa>)request.getAttribute("pessoas")) { %>
                            <tr>
                                <td> <%= exercise.getNome()%> </td>
                                <td> <%= exercise.getIdade()%> </td>
                                <td> <%= exercise.getSexo()%> </td>
                            </tr> <%
                        }
                    %>
               </tbody>
            </table>
        </div>
    </body>
</html>
