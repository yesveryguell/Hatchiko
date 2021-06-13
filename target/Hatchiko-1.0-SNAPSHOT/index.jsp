<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <link rel="icon" href="images/favicon.png" type="image/gif" />
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
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
    <div class="loader"><img src="images/loading.gif" alt="#" /></div>
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
                                <a href="index.jsp"><img src="images/logos.png" alt="#" /></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                    <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="../index.jsp">Home</a>
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
                                    <select name="sign-in">
                                        <option value="official">Official</option>
                                        <option value="owner">Owner</option>
                                        <option value="vet">Vet</option>
                                    </select>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- end header inner -->
<!-- end header -->
<!-- banner -->
<section class="banner_main">
    <div class="container">
        <div class="row d_flex">
            <div class="col-md-5">
                <div class="text-bg">
                    <h1>Four Paws Citizens<br>Hatchiko</h1>
                    <p>Our software development give to every user the possibility to track your pet. </p>
                    <p>Take a look and sign up.</p>
                </div>
            </div>
            <div class="col-md-7">
                <div class="text-img">
                    <figure><img src="images/paws2.png"/></figure>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end banner -->
<!-- Hosting -->
<div id="" class="hosting">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>How does it work?</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="web_hosting">
                    <figure><img src="images/Microchip.jpg" alt="#"/></figure>
                    <p>Each pet must have a table that combines the cases and visits that are registered by the veterinarian, ordered by date in descending order
                        and being able to filter by date range.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end Hosting -->
<!-- Services  -->
<div id="service" class="Services">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Owner and pet</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-5 col-lg-4 col-md-10 col-sm-20">
                <div class="Services-box">
                    <i><img src="images/icono3.png" alt="#" /></i>
                    <h3> Owner </h3>
                    <p> Here you can register, you just have to add your data, add the information requested in the following form. </p>
                    <a class="read_more" href="ownerAdd.jsp">Add Owner</a>
                </div>
            </div>
            <div class="col-xl-5 col-lg-4 col-md-10 col-sm-30">
                <div class="Services-box">
                    <i><img src="images/paw.png" alt="#" /></i>
                    <h3> Pet </h3>
                    <p> Here you can register your vet for make controls to every pet.  </p>
                    <a class="read_more" href="vetAdd.jsp">Add Vet</a>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-10 offset-md-1">
                    <div class="cont">
                        <h3>Contact us</h3>
                        <p>     Park Way
                            Cupertino, CA 95014
                            (408) 996–1010
                            <!--Address from Apple-->
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p>© 2019 All Rights Reserved. <a href="https://html.design/">Free html Templates</a><a href="hello-servlet">Hello Servlet</a></p>
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