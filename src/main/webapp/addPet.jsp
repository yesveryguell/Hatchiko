<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 1:38 p. m.
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
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

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

</body>
</html>
