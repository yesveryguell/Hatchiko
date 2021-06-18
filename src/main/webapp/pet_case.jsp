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
                <form id="addCases">
<%--                    <input type="hidden" id="pet_id" name="pet_id" value="<%= request.getParameter("pet_id") %>">--%>
                    <h3>Created at: </h3>
                    <div class="input-group">
                        <input class="input--style-2" type="date" placeholder="Created at" name="created_at" required="">
                    </div>
                    <div class="input-group">
                        <h3>Type: </h3>
                        <select name="type" required>
                            <option disabled="disabled" selected="selected">Type</option>
                            <option value="lost-it">Lost it</option>
                            <option value="stolen">Stolen</option>
                            <option value="dead">Dead</option>
                        </select>
                        <div class="select-dropdown"></div>
                    </div>

                    <div class="input-group">
                        <h3>Description: </h3>
                        <input class="input--style-2" placeholder="Description" type="text" name="description" required="">
                    </div>
                    <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit">Add case</button>
                        <a class="btn btn--radius btn--green" href="visit.jsp">Add visit</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
    <h1>Cases</h1>

    <div>
        <form id = "formCase">
            <input type="hidden" name="pet_id" value="<%= request.getParameter("pet_id") %>">

            <button style="background-color:#eebb55" type="submit">
                View cases
            </button>
        </form>
    </div>



    <div>
        <table class="table table-dark table-striped table-bordered">
            <thead>
            <tr>
                <th>Case Id</th>
                <th>Created at</th>
                <th>Type</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody id = "cases">

            </tbody>
        </table>
    </div>

</footer>


<%--<script>--%>

<%--    var formulario = document.getElementById('formCase');--%>

<%--    formulario.addEventListener('submit', function (e) {--%>
<%--        e.preventDefault();--%>

<%--        var datos3 = new FormData(formulario);--%>

<%--        console.log(datos3.get('username'))--%>
<%--        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets/'+datos3.get('username'))--%>
<%--            .then((response) => response.json())--%>
<%--            .then(data => mostrarData8(data));--%>
<%--        const mostrarData8 = (data) => {--%>
<%--            console.log(data);--%>
<%--            console.log(username)--%>
<%--            let body = ''--%>
<%--            for (let i = 0; i < data.length; i++) {--%>
<%--                body += '<tr>' + '<td>' + data[i].username + '</td>' + '<td>' + data[i].email + '</td>' +  '<td>' + data[i].name + '</td>' + '<td>' + data[i].address + '</td>' + '<td>' + data[i].neighborhood + '</td>'  + '<td>' + ' <input name="ver" type="button" value="Edit" id="ver" onclick="editOwner(d)"/>' + '</td>'  + '</tr>';--%>
<%--            }--%>
<%--            document.getElementById('cases').innerHTML = body;--%>
<%--        }--%>
<%--    });--%>


<%--    function editVet(info){--%>
<%--        location.href ="./editVet.jsp?username="+ info;--%>
<%--    }--%>

<%--</script>--%>

<script>
    var formulario = document.getElementById('addCases');
    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);
        console.log(1)
        console.log(datos.get('created_at'))
        console.log(datos.get('type'))
        console.log(datos.get('description'))

        fetch('http://35.206.97.221:8080/Hatchiko-1.0-SNAPSHOT/api/pets/' + 1 + '/petCases', {
            method: 'POST',
            body: JSON.stringify({
                created_at: datos.get('created_at'),
                type: datos.get('type'),
                description: datos.get('description'),
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json));
        alert("Created case")
    });
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