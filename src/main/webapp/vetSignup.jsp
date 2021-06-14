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
</head>
<body>
<!--logo_transparent-->
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form" id="formVet">
                 <span class="login100-form-title p-b-34">
						<a href="index.html"><img src="images/logo_t.png"/></a>
					</span>

                <span class="login100-form-title p-b-34">
						Sign Up
					</span>
                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                    <input id="first-name" class="input100" type="text" name="username" placeholder="Username">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="email">
                    <input id="email" class="input100" type="text" name="email" placeholder="email">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                    <input class="input100" type="password" name="pass" placeholder="Re - password">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="name">
                    <input id="name" class="input100" type="text" name="name" placeholder="Name">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="address">
                    <input id="address" class="input100" type="text" name="address" placeholder="Address">
                    <span class="focus-input100"></span>
                </div>

                <div data-validate="neighborhood">
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

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" style="background-color:#eebb55" type="submit">
                        Sign up
                    </button>
                </div>

                <div class="w-full text-center p-t-27 p-b-239">
						<span class="txt1">
						</span>
                </div>

                <div class="w-full text-center">
                    <a href="signVet.jsp" class="txt3">
                        Sign In
                    </a>
                </div>
            </form>

            <div class="login100-more" style="background-image: url('images/perro2.jpg');"></div>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

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

<script>
    var formulario = document.getElementById('formVet');
    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);

        //console.log(datos.get('owner'))
        console.log(datos.get('username'))
        console.log(datos.get('email'))
        console.log(datos.get('password'))
        console.log(datos.get('name'))
        console.log(datos.get('address'))
        console.log(datos.get('neighborhood'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets', {
            method: 'POST',
            body: JSON.stringify({
                username: datos.get('username'),
                email: datos.get('email'),
                password: datos.get('password'),
                name: datos.get('name'),
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


<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>
