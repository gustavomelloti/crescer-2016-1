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
            <form role="form" action="pessoa">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text"  class="form-control" id="nome" name="nome">
                </div>
                <div class="form-group">
                    <label for="idade">Idade:</label>
                    <input type="text"  class="form-control" id="idade" name="idade">
                </div>
                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <input type="radio" name="sexo" value="Masculino"> Masculino
                    <input type="radio" name="sexo" value="Feminino"> Feminino
                    <input type="radio" name="sexo" value="Outro"> Outro
                </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </body>
</html>
