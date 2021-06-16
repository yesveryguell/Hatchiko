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
<!-- end banner -->
<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Registration Info</h2>
                <form id="formOwner">

                    <div class="row row-space">
                        <h3>Address</h3>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Address" name="address">
                        </div>
                        <h3>Neighborhood</h3>
                        <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="neighborhood">
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
                                <option value="Municipios Aledaños Bogota D.C.">Municipios Aledaños Bogota
                                    D.C.
                                </option>
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
                            <span class="focus-input100"></span>
                        </div>
                    </div>
                    <div class="p-t-30">
                        <button type="submit" class="btn btn--radius btn--green">Update</button>
                        <a href="pet.jsp" class="btn btn--radius btn--green">Add pet</a>
                        <a href="pet_case.jsp" class="btn btn--radius btn--green">Case</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Pet registration</h2>
                <form id="addPets">
                    <input type="hidden" id="authorId" name="username" value="<%= request.getParameter("username") %>">

                    <h3>Microchip</h3>
                    <div class="input-group">
                        <input class="input--style-2" type="text" placeholder="Microchip" name="microchip" id = "microchip1">
                    </div>
                    <h3>Name</h3>
                    <div class="input-group">
                        <input class="input--style-2" type="text" placeholder="Name" name="name">
                    </div>

                    <h3>Species</h3>
                    <div class="col-2">
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="specie" required>
                                    <option disabled="disabled" selected="selected">Specie</option>
                                    <option value="Canino">Canine</option>
                                    <option value="Felino">Feline</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                    </div>
                    <h3>Race</h3>
                    <div class="input-group">
                        <input class="input--style-2" placeholder="Race" type="text" name="race">
                    </div>
                    <h3>Size</h3>
                    <div class="input-group">
                        <input class="input--style-2" placeholder="Size" type="text" name="size">
                    </div>
                    <h3>Sex</h3>
                    <div class="col-2">
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="sex" required>
                                    <option disabled="disabled" selected="selected">Sex</option>
                                    <option value="Macho">Male</option>
                                    <option value="Hembra">Female</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                    </div>
                    <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit">Add</button>
                        <a href="pet_case.jsp" class="btn btn--radius btn--green">Add pet case</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<h1>Pets</h1>

<div>
    <form id = "editOwner">
        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

        <button style="background-color:#eebb55" type="submit">
            View info
        </button>
    </form>
</div>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>email</th>
            <th>name</th>
            <th>id</th>
            <th>address</th>
            <th>microchip</th>
            <th>edit</th>
        </tr>
        </thead>
        <tbody id = "owners">

        </tbody>
    </table>
</div>

<h1>Pets</h1>

<div>
    <form id = "formPets">
        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

        <button style="background-color:#eebb55" type="submit">
            View pets
        </button>
    </form>
</div>



<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>picture</th>
            <th>Edit</th>
            <th>Created case</th>
        </tr>
        </thead>
        <tbody id = "pets">

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

    var formulario = document.getElementById('formOwner');
    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);

        console.log(datos.get('username'))
        console.log(datos.get('address'))
        console.log(datos.get('neighborhood'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/' + datos.get('username'), {
            method: 'PUT',
            body: JSON.stringify({
                address: datos.get('address'),
                neighborhood: datos.get('neighborhood'),
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json));
    });
</script>

<script>

    var formulario = document.getElementById('editOwner');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))
        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/'+datos1.get('username'))
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        const mostrarData7 = (data) => {


            console.log(data);
            var d = data[0].username;
            console.log(d)
            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].username + '</td>' + '<td>' + data[i].email + '</td>' + '<td>' + data[i].person_id + '</td>' + '<td>' + data[i].name + '</td>' + '<td>' + data[i].address + '</td>' + '<td>' + data[i].neighborhood + '</td>'  + '<td>' + '    <input name="ver" type="button" value="Edit" id="ver" onclick="editOwner(d)"/>' + '</td>'  + '</tr>';
            }
            document.getElementById('owners').innerHTML = body;
        }
    });


    function editOwner(info){
        location.href ="./editOwner.jsp?username="+ info;
    }

</script>

<script>

    var formulario = document.getElementById('formPets');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))
        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/'+datos1.get('username')+"/pets")
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        const mostrarData7 = (data) => {
            console.log(data);
            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' + data[i].microchip + '</td>' + '<td>' + data[i].name + '</td>' + '<td>' + data[i].race + '</td>' + '<td>' + data[i].sex + '</td>' + '<td>' + data[i].size + '</td>' + '<td>' + data[i].species + '</td>' + '<td>' + data[i].picture + '</td>' + '<td>' + '    <input name="ver" type="button" value="Edit" id="ver" onclick="editPet()"/>' + '</td>' + '<td>' + '    <input name="ver" type="button" value="Create case" id="ver" onclick="createdPet()"/>' + '</td>' + '</tr>';
            }
            document.getElementById('pets').innerHTML = body;
        }
    });
</script>

<script>

    var formulario = document.getElementById('addPets');
    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);

        console.log(datos.get('username'))
        console.log(datos.get('microchip'))
        console.log(datos.get('name'))
        console.log(datos.get('specie'))
        console.log(datos.get('race'))
        console.log(datos.get('size'))
        console.log(datos.get('sex'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/' + datos.get('username') + '/pets', {
            method: 'POST',
            body: JSON.stringify({
                microchip: datos.get('microchip'),
                name: datos.get('name'),
                species: datos.get('specie'),
                race: datos.get('race'),
                size: datos.get('size'),
                sex: datos.get('sex'),
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => console.log(json));
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
