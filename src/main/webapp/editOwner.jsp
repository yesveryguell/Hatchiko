<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 16/06/2021
  Time: 5:33 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Registration Info</h2>
                <form id="editOwner">
                    <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

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
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script>

    var formulario = document.getElementById('editOwner');
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

</body>
</html>
