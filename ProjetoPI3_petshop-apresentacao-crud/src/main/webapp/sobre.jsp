<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pet Shop</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">


        <!-- Custom styles for this template -->
        <!--link href="css/homepage.css" rel="stylesheet"-->
    </head>
    <body id="page-top">

        <%@include  file="navbar.html" %>

        <br>
        <br>
        <br>
        <br>
        <div align ="center">

            <img class="mb-4" src="img/LogoPetMaster.png" alt="logo PetMaster" width="200" height="200">

            <br>    
            <img src="Apresentacao/Slide1.png" id="mainImage" name="mainImage" width="100%" height="100%" alt="">
            <img src="Apresentacao/Slide2.png" id="mainImage" name="mainImage" width="100%" height="100%" alt="">
            <img src="Apresentacao/Slide3.png" id="mainImage" name="mainImage" width="100%" height="100%" alt="">
            <img src="Apresentacao/Slide4.png" id="mainImage" name="mainImage" width="100%" height="100%" alt="">
            <img src="Apresentacao/Slide5.png" id="mainImage" name="mainImage" width="100%" height="100%" alt="">

            <!--a href="" onclick="swapImage(0);"><img src="/images/first.png" border=0 alt="First"></a>
            <a href="" onclick="swapImage(currentIndex - 1);"><img src="/images/left.png" border=0 alt="Back"></a>
            <a href="" onclick="swapImage(currentIndex + 1);"><img src="/images/right.png" border=0 alt="Next"></a>
            <a href="" onclick="swapImage(maxIndex);"><img src="/images/last.png" border=0 alt="Last"></a-->

        </div>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; Javazeiros - Projeto Semestre 3</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacidade</a></li>
                <li class="list-inline-item"><a href="#">Termos</a></li>
                <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
            </ul>
        </footer>

    </body>

    <!--script type="text/javascript">
        //Initilize start value to 1 'For Slide1.GIF'
        var currentIndex = 1;
    
        //NOTE: Set this value to the number of slides you have in the presentation.
        var maxIndex = 12;
    
        function swapImage(imageIndex) {
            //Check if we are at the last image already, return if we are.
            if (imageIndex > maxIndex) {
                currentIndex = maxIndex;
                return;
            }
    
            //Check if we are at the first image already, return if we are.
            if (imageIndex < 1) {
                currentIndex = 1;
                return;
            }
    
            currentIndex = imageIndex;
            //Otherwise update mainImage
            document.getElementById("mainImage").src = 'Slide' + currentIndex + '.GIF';
            main
            return;
        }
    </script-->


</html>