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
<h1>Pets for species</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "petInfoSpece">

        </tbody>
    </table>
</div>

<h1>Pets for microchip</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "petInfoMicro">

        </tbody>
    </table>
</div>

<h1>Pets for race</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "petInforace">

        </tbody>
    </table>
</div>

<h1>Pets for size</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "petInforSize">

        </tbody>
    </table>
</div>


<h1>Pets for sex</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "petInforSex">

        </tbody>
    </table>
</div>

<h1>Cases</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>case_id</th>
            <th>created_at</th>
            <th>type</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody id = "caseInfo">

        </tbody>
    </table>
</div>

<div>
    <form action="" id="filter">
        <a href="">Id</a>
        <input type="number" name = "id">
        <br>
        <a href="">Microchip</a>
        <input type="text" name = "microchip">
        <br>
        <a href="">name</a>
        <input type="text" name = "name">
        <br>
        <a href="">specie</a>
        <input type="text" name = "specie">
        <br>
        <a href="">race</a>
        <input type="text" name = "race">
        <br>
        <a href="">size</a>
        <input type="text" name = "size">
        <br>
        <a href="">sex</a>
        <input type="text" name = "sex">
        <br>
        <button style="background-color:#eebb55" type="submit">
            view
        </button>
    </form>
</div>

<h1>Filter</h1>

<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Pet_id</th>
            <th>microchip</th>
            <th>name</th>
            <th>picture</th>
            <th>race</th>
            <th>sex</th>
            <th>size</th>
            <th>species</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody id = "filterPets">

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
        for (let i = 0; i < data.length; i++) {
            console.log(data[i].total);
            console.log(data[i].owners);
        }
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].owners.length; j++) {
                body+= '<tr>' + '<td>' + data[i].owners[j].username + '</td>' + '<td>' +data[i].owners[j].password + '</td>' + '<td>' +data[i].owners[j].email + '</td>' + '<td>' +data[i].owners[j].person_id + '</td>' + '<td>' +data[i].owners[j].name + '</td>' + '<td>' +data[i].owners[j].address + '</td>' + '<td>' +data[i].owners[j].neighborhood + '</td>' + '</tr>';

            }
        }
        document.getElementById('ownerInfo').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/species')
        .then((response) => response.json())
        .then(data => mostrarData1(data));
    const mostrarData1 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].pets.length; j++) {
                body+= '<tr>' + '<td>' + data[i].pets[j].pet_id + '</td>' + '<td>' +data[i].pets[j].microchip + '</td>' + '<td>' +data[i].pets[j].name + '</td>' + '<td>' +data[i].pets[j].picture + '</td>' + '<td>' +data[i].pets[j].race + '</td>' + '<td>' +data[i].pets[j].sex + '</td>' + '<td>' +data[i].pets[j].size + '</td>' + '<td>' +data[i].pets[j].species + '</td>' + '<td>' +data[i].pets[j].owner + '</td>' + '</tr>';
            }
        }
        document.getElementById('petInfoSpece').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/microchip')
        .then((response) => response.json())
        .then(data => mostrarData2(data));
    const mostrarData2 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].pets.length; j++) {
                body+= '<tr>' + '<td>' + data[i].pets[j].pet_id + '</td>' + '<td>' +data[i].pets[j].microchip + '</td>' + '<td>' +data[i].pets[j].name + '</td>' + '<td>' +data[i].pets[j].picture + '</td>' + '<td>' +data[i].pets[j].race + '</td>' + '<td>' +data[i].pets[j].sex + '</td>' + '<td>' +data[i].pets[j].size + '</td>' + '<td>' +data[i].pets[j].species + '</td>' + '<td>' +data[i].pets[j].owner + '</td>' + '</tr>';
            }
        }
        document.getElementById('petInfoMicro').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/race')
        .then((response) => response.json())
        .then(data => mostrarData3(data));
    const mostrarData3 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].pets.length; j++) {
                body+= '<tr>' + '<td>' + data[i].pets[j].pet_id + '</td>' + '<td>' +data[i].pets[j].microchip + '</td>' + '<td>' +data[i].pets[j].name + '</td>' + '<td>' +data[i].pets[j].picture + '</td>' + '<td>' +data[i].pets[j].race + '</td>' + '<td>' +data[i].pets[j].sex + '</td>' + '<td>' +data[i].pets[j].size + '</td>' + '<td>' +data[i].pets[j].species + '</td>' + '<td>' +data[i].pets[j].owner + '</td>' + '</tr>';
            }
        }
        document.getElementById('petInforace').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/sex')
        .then((response) => response.json())
        .then(data => mostrarData4(data));
    const mostrarData4 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].pets.length; j++) {
                body+= '<tr>' + '<td>' + data[i].pets[j].pet_id + '</td>' + '<td>' +data[i].pets[j].microchip + '</td>' + '<td>' +data[i].pets[j].name + '</td>' + '<td>' +data[i].pets[j].picture + '</td>' + '<td>' +data[i].pets[j].race + '</td>' + '<td>' +data[i].pets[j].sex + '</td>' + '<td>' +data[i].pets[j].size + '</td>' + '<td>' +data[i].pets[j].species + '</td>' + '<td>' +data[i].pets[j].owner + '</td>' + '</tr>';
            }
        }
        document.getElementById('petInforSex').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/size')
        .then((response) => response.json())
        .then(data => mostrarData5(data));
    const mostrarData5 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].pets.length; j++) {
                body+= '<tr>' + '<td>' + data[i].pets[j].pet_id + '</td>' + '<td>' +data[i].pets[j].microchip + '</td>' + '<td>' +data[i].pets[j].name + '</td>' + '<td>' +data[i].pets[j].picture + '</td>' + '<td>' +data[i].pets[j].race + '</td>' + '<td>' +data[i].pets[j].sex + '</td>' + '<td>' +data[i].pets[j].size + '</td>' + '<td>' +data[i].pets[j].species + '</td>' + '<td>' +data[i].pets[j].owner + '</td>' + '</tr>';
            }
        }
        document.getElementById('petInforSize').innerHTML = body;
    }
</script>

<script>
    fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/petCases')
        .then((response) => response.json())
        .then(data => mostrarData6(data));
    const mostrarData6 = (data) =>{
        console.log(data);
        let body = ''
        for(let i = 0; i<data.length; i++){
            body+= '<tr>' + '<td> '+data[i].total + '</td>' + '</tr>'
            for (let j = 0; j < data[i].cases.length; j++) {
                body+= '<tr>' + '<td>' + data[i].cases[j].case_id + '</td>' + '<td>' +data[i].cases[j].created_at + '</td>' + '<td>' +data[i].cases[j].type + '</td>' + '<td>' +data[i].cases[j].description + '</td>' + '</tr>';
            }
        }
        document.getElementById('caseInfo').innerHTML = body;
    }
</script>


<script>
    var formulario = document.getElementById('filter');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);

        console.log(datos.get('race'))

        if(datos.get('id') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?pet_id='+datos.get('id'))
                .then((response) => response.json())
                .then(data => mostrarData7(data));
            const mostrarData7 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }
        if(datos.get('microchip') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?microchip='+datos.get('microchip'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }

        if(datos.get('name') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?name='+datos.get('name'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }

        if(datos.get('specie') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?species='+datos.get('specie'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }

        if(datos.get('race') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?race='+datos.get('race'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }

        if(datos.get('size') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?size='+datos.get('size'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }

        if(datos.get('sex') != ""){
            fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets?sex='+datos.get('sex'))
                .then((response) => response.json())
                .then(data => mostrarData8(data));
            const mostrarData8 = (data) =>{
                console.log(data);
                let body = ''
                for(let i = 0; i<data.length; i++){
                    body+= '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' +data[i].microchip + '</td>' + '<td>' +data[i].name + '</td>' + '<td>' +data[i].picture + '</td>' + '<td>' +data[i].race + '</td>' + '<td>' +data[i].sex + '</td>' + '<td>' +data[i].size + '</td>' + '<td>' +data[i].species + '</td>' + '<td>' +data[i].owner + '</td>' + '</tr>';
                }
                document.getElementById('filterPets').innerHTML = body;
            }
        }
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
</body>
</html>