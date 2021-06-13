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
    <link rel="stylesheet" href="css/main2.css">
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
        <div class="card-body">
            <form method="post" action="api/owners">
                <h3>Name</h3>
                <div class="input-group">
                    <input class="input--style-2" type="text" placeholder="Name" name="name">
                </div>
                <div class="input-group">
                    <h3>Address</h3>
                    <input class="input--style-2" placeholder="Address" type="text" name="address">
                </div>
                <h3>Neighborhood</h3>
                <div class="col-2">
                    <div class="input-group">
                        <div class="rs-select2 js-select-simple select--no-search">

                            <select name="neighborhood">
                                <option disabled="disabled" selected="selected">Neighborhood</option>
                                <option value="A. Nriño">A. Nriño</option>
                                <option value="B. Unidos">B. Unidos</option>
                                <option value="Bosa">Bosa</option>
                                <option value="C.Bolivar">C.Bolivar</option>
                                <option value="Chapinero">Chapinero</option>
                                <option value="Engativa">Engativa</option>
                                <option value="Fontibon">Fontibon</option>
                                <option value="Kennedy">Kennedy</option>
                                <option value="La candelaria">La candelaria</option>
                                <option value="Los martires">Los martires</option>
                                <option value="Municipios Aledaños Bogota D.C.">Municipios Aledaños Bogota D.C.</option>
                                <option value="P. Aranda">P. Aranda</option>
                                <option value="R. Uribe">R. Uribe</option>
                                <option value="San Cristobal">San Cristobal</option>
                                <option value="Santa Fe">Santa Fe</option>
                                <option value="Suba">Suba</option>
                                <option value="Sumapaz">Sumapaz</option>
                                <option value="Teusaquillo">Teusaquillo</option>
                                <option value="Tunjuelito">Tunjuelito</option>
                                <option value="Usaquen">Usaquen</option>
                                <option value="Usme">Usme</option>
                                <option value="Sin Identificar">Sin Identificar</option>
                            </select>
                            <div class="select-dropdown"></div>
                        </div>
                    </div>
                </div>
                <div class="p-t-30">
                    <button class="btn btn--radius btn--green" type="submit">Add</button>
                    <a href="pet.jsp" class="btn btn--radius btn--green">Add pet</a>
                    <a type="submit" class="btn btn--radius btn--green">Update</a>
                    <a href="pet_case.jsp" class="btn btn--radius btn--green">Case</a>
                </div>
            </form>
        </div>
    </div>

</div>
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