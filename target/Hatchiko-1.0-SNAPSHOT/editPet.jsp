<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 11:55 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>
    <form id = "viewId">
        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

        <button style="background-color:#eebb55" type="submit">
            View ids
        </button>
    </form>
</div>

<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <div class="wrapper wrapper--w960">
        <div class="card card-2">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Pet registration</h2>
                <form id="editPet">
                    <input type="hidden" id="authorId" name="username" value="<%= request.getParameter("username") %>">

                    <h3>Pet id</h3>
                    <div class="col-2">
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="pet_id" required id = "ids">

                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
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

    var formulario = document.getElementById('viewId');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);
        var dat = "pet_id";
        console.log(datos1.get('username'))
        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/'+datos1.get('username')+"/pets")
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        const mostrarData7 = (data) => {
            console.log(data);
            let body = ''
            body+='<option disabled="disabled" selected="selected">' + dat + '</option>';
            for (let i = 0; i < data.length; i++) {
                body+= '<option value= ' + data[i].pet_id  +' >' + data[i].pet_id + '</option>';
            }
            document.getElementById('ids').innerHTML = body;
        }
    });
</script>

<script>
    var formulario = document.getElementById('editPet');
    formulario.addEventListener('submit', function (e){
        e.preventDefault();

        var datos = new FormData(formulario);
        console.log(datos.get('username'))
        console.log(datos.get('pet_id'))
        console.log(datos.get('name'))
        console.log(datos.get('specie'))
        console.log(datos.get('race'))
        console.log(datos.get('size'))
        console.log(datos.get('sex'))

        alert("Your information was updated")

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/owners/' + datos.get('username')+'/pets/'+datos.get('pet_id'), {
            method: 'PUT',
            body: JSON.stringify({
                name: datos.get('name'),
                species: datos.get('specie'),
                race: datos.get('race'),
                size: datos.get('size'),
                sex: datos.get('sex')
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
