<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
    <link href="css/main2.css" rel="stylesheet" media="all">
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

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">

    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
          rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
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
                                <a href="index.html"><img src="images/logos.png" alt="#"/></a>
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
                                    <a class="nav-link" href="index.html">Home</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <form id="visitsDateFilter">

                    <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

                    <div class="input-group">
                        <input class="input--style-2" type="date" placeholder="Created" name="date1" id="date1">
                    </div>

                    <div class="input-group">
                        <input class="input--style-2" type="date" placeholder="Created" name="date2" id="date2">
                    </div>

                    <input name="ver" type="button" value="Edit" id="ver" onclick="dates()"/>
                </form>
            </div>
        </div>
    </div>
</div>

<h1>Visits</h1>
<div>
    <form id="formVisits">

        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

        <button style="background-color:#eebb55" type="submit">
            View visits
        </button>
    </form>
</div>
<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Visit_id</th>
            <th>Type</th>
            <th>Description</th>
            <th>year</th>
            <th>month</th>
            <th>day</th>

        </tr>
        </thead>
        <tbody id="visits">

        </tbody>
    </table>
</div>

<h1>filter date</h1>
<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Visit_id</th>
            <th>Type</th>
            <th>Description</th>
            <th>year</th>
            <th>month</th>
            <th>day</th>

        </tr>
        </thead>
        <tbody id="dateFilter">

        </tbody>
    </table>
</div>


<script>

    var formulario = document.getElementById('formVisits');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets/' + datos1.get('username') + '/visits')
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        var username = document.getElementById('username');
        const mostrarData7 = (data) => {

            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].visit_id + '</td>' + '<td>' + data[i].type + '</td>' + '<td>' + data[i].description + '</td>' + '<td>' + data[i].year + '</td>' + '<td>' + data[i].month + '</td>' + '<td>' + data[i].day + '</td>' + '</tr>';
            }
            document.getElementById('visits').innerHTML = body;
        }

    });


    function editVet(info) {
        location.href = "./editOwner.jsp?username=" + info;
    }

</script>

<script>
    var formulario = document.getElementById('visitsDateFilter');

    function dates() {

        var date1 = document.getElementById("date1").value;
        var date2 = document.getElementById("date2").value;
        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))
        console.log(datos1.get('date1'))
        console.log(datos1.get('date2'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets/' + datos1.get('username') + '/visits?date1=' + datos1.get('date1') + '&date2=' + datos1.get('date2'))
            .then((response) => response.json())
            .then(data => mostrarData8(data));
        var username = document.getElementById('username');
        const mostrarData8 = (data) => {

            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].visit_id + '</td>' + '<td>' + data[i].type + '</td>' + '<td>' + data[i].description + '</td>' + '<td>' + data[i].year + '</td>' + '<td>' + data[i].month + '</td>' + '<td>' + data[i].day + '</td>' + '</tr>';
            }
            document.getElementById('dateFilter').innerHTML = body;
        }


    }


    function editVet(info) {
        location.href = "./editOwner.jsp?username=" + info;
    }

</script>

<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/plugin.js"></script>
<!-- sidebar -->
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/custom.js"></script>
<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>

<!-- Jquery JS-->
<script src="vendor/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/datepicker/moment.min.js"></script>
<script src="vendor/datepicker/daterangepicker.js"></script>

<!-- Main JS-->
<script src="js/global.js"></script>
</body>
</html>
