<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" href="images/favicon.png" type="image/gif"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css2?family=Montaga&display=swap">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
    <script language="javascript" src="main.js"></script>
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form" id = "vetLogin">
                <span class="login100-form-title p-b-34">
						<a href="index.html"><img src="images/logo_t.png"/></a>
					</span>

                <span class="login100-form-title p-b-34" >
						Sign In
					</span>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                    <input id="first-name" class="input100" type="text" name="username" placeholder="User name" required="">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password" required="">
                    <input class="input100" type="password" name="pass" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" style="background-color:#eebb55">
                        Sign in
                    </button>
                </div>

                <div class="w-full text-center p-t-27 p-b-239">
						<span class="txt1">
						</span>
                </div>

                <div class="w-full text-center">
                    <a href="vetSignup.jsp" class="txt3">
                        Sign Up
                    </a>
                </div>
            </form>

            <div class="login100-more" style="background-image: url('images/perro.jpg');"></div>

        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>
<script>
    var formulario = document.getElementById('vetLogin');

    formulario.addEventListener('submit', function (e){
        e.preventDefault();

        var datos = new FormData(formulario);

        console.log(datos.get('username'))
        console.log(datos.get('pass'))

        fetch('http://35.206.97.221:8080/Hatchiko-1.0-SNAPSHOT/api/vets/login', {
            method: 'POST',
            body: JSON.stringify({
                username: datos.get('username'),
                password: datos.get('pass')
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then(data => mostrarData(data));
        const mostrarData = (data) =>{
            console.log(data);

            if(data[0] == "Vet"){
                alert("Welcome " + datos.get('username'))
                location.href ="./vet.jsp?username=" + datos.get('username');
            }else{
                alert("Incorrect username and password")
            }
        }

    });

</script>
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<script>
    $(".selection-2").select2({
        minimumResultsForSearch: 20,
        dropdownParent: $('#dropDownSelect1')
    });
</script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>