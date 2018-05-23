<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Welcome to Pet Master</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
    </head>

    <body class="text-center" background="img/PlanodefuntoPetMaster.png" style="background-color: white;">
        <form class="form-signin" action="Home"  method="POST">


            <img class="mb-4" src="img/LogoPetMaster.png" alt="logo PetMaster" width="200" height="200">
            <h1 class="h3 mb-3 font-weight-normal">Efetuar Login</h1>
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name = "username" required autofocus>
            <label for="inputPassword" class="sr-only">Senha</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" name = "password" required>
            <label>
                <a href ="Reset.jsp">Esqueci a senha</a>
            </label>
            <button class="btn btn-lg btn-secondary btn-block" type="submit">Entrar</button>
            <p class="mt-5 mb-3 text-muted">&copy; Javazeiros - Projeto Semestre 3 </p>
        </form>
    </body>
    
        <script>


        var loginfailed = "${loginfailed}"



        if (loginfailed == "Usuário ou senha incorreto!") {
            
        alert(loginfailed)

        } 



    </script>
    
</html>
