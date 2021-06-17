<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 1:52 p. m.
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
                <form id = "addCase">
                    <input type="hidden" name="username" value="<%= request.getParameter("username") %>">
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
                    <h3>Created at:</h3>
                    <div class="input-group">
                        <input class="input--style-2" type="date" placeholder="Created" name="created_at">
                    </div>
                    <div class="input-group">
                        <h3>Type: </h3>
                        <select name="type" required>
                            <option disabled="disabled" selected="selected">Specie</option>
                            <option value="Perdida">Lost</option>
                            <option value="Robo">Stole</option>
                            <option value="Fallecimiento">Death</option>
                        </select>
                        <div class="select-dropdown"></div>
                    </div>

                    <div class="input-group">
                        <h3>Description: </h3>
                        <input class="input--style-2" placeholder="Description" type="text" name="description">
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

    var formulario = document.getElementById('addCase');
    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = new FormData(formulario);

        console.log(datos.get('username'))
        console.log(datos.get('pet_id'))
        console.log(datos.get('created_at'))
        console.log(datos.get('type'))
        console.log(datos.get('description'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/' + datos.get('pet_id') + '/petCases', {
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
    });


</script>

</body>
</html>
