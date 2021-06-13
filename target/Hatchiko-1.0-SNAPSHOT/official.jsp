<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Hatchiko</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- fevicon -->
    <link rel="icon" href="images/favicon.png" type="image/gif"/>
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
          media="screen">
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet'>
    <link href="https://fonts.googleapis.com/css2?family=Dosis&display=swap" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->
<body class="main-layout">
<!-- loader  -->
<div class="loader_bg">
    <div class="loader"><img src="images/loading.gif" alt="#"/></div>
</div>
<!-- end loader -->
<!-- header -->
<header>
    <!-- header inner -->
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                    <div class="full">
                        <div class="center-desk">
                            <div class="logo">
                                <a href="index.jsp"><img src="images/logos.png" alt="#"/></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                    <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.jsp">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#service"> Service</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#contact">Contact</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="about.jsp"> About </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="sign-in.jsp">Sign In</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- end banner -->
<div id="" class="hosting">
    <div class="container">
        <form>
            <input class="">
        </form>
    </div>
</div>
<h1>Owners</h1>
<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>password</th>
            <th>email</th>
            <th>person_id</th>
            <th>name</th>
            <th>address</th>
            <th>neighborhood</th>

        </tr>
        </thead>
        <tbody id = "ownerInfo">

        </tbody>
    </table>
</div>

<h1>Vets</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>password</th>
            <th>email</th>
            <th>name</th>
            <th>address</th>
            <th>neighborhood</th>

        </tr>
        </thead>
        <tbody id = "vetInfo">

        </tbody>
    </table>
</div>
<!-- Hosting -->
<footer>
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-10 offset-md-1">
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p>© 2019 All Rights Reserved. <a href="https://html.design/">Free html Templates</a><a
                                href="hello-servlet">Hello Servlet</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>


</footer>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners')
        .then((response) => response.json())
        .then(data => mostrarData(data));
    const mostrarData = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td>' + data[i].username + '</td>' + '<td>' +data[i].password + '</td>' + '<td>' +data[i].email + '</td>' + '<td>' +data[i].person_id + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].address + '</td>' + '<td>' +data[i].neighborhood + '</td>' + '</tr>';
        }
        document.getElementById('ownerInfo').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets')
        .then((response) => response.json())
        .then(data => mostrarData1(data));
    const mostrarData1 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td>' + data[i].username + '</td>' + '<td>' +data[i].password + '</td>' + '<td>' +data[i].email + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].address + '</td>' + '<td>' +data[i].neighborhood + '</td>' + '</tr>';
        }
        document.getElementById('vetInfo').innerHTML = body;
    }
</script>
<!-- end footer -->
<!-- Javascript files-->
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/plugin.js"></script>
<!-- sidebar -->
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/custom.js"></script>
<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
</body>
</html>