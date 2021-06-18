<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<body>


<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <span class="login100-form-title p-b-34">
						<a href="index.html"><img src="images/logo_t.png"/></a>
					</span>
                <div>
                    <form id="viewId">
                        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">
                        <button style="background-color:#eebb55" type="submit">
                            View ids
                        </button>
                    </form>
                </div>
                <form method="post" action="http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/upload?pet_id=1"
                      enctype="multipart/form-data">

                    <div class="rs-select2 js-select-simple select--no-search">
                        <select name="pet_id" required id="ids">

                        </select>
                        <div class="select-dropdown"></div>
                    </div>
                    Choose a file: <input type="file" name="file"/>
                    <input type="submit" value="Upload"/>
                </form>
            </div>
        </div>
    </div>
</div>


<script>

    var formulario = document.getElementById('viewId');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);
        var dat = "pet_id";
        console.log(datos1.get('username'))
        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/' + datos1.get('username') + "/pets")
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        const mostrarData7 = (data) => {
            console.log(data);
            let body = ''
            body += '<option disabled="disabled" selected="selected">' + dat + '</option>';
            for (let i = 0; i < data.length; i++) {
                body += '<option value= ' + data[i].pet_id + ' >' + data[i].pet_id + '</option>';
            }
            document.getElementById('ids').innerHTML = body;
        }
    });
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
