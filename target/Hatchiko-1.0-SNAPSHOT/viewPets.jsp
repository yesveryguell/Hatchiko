<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 1:29 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
        </tr>
        </thead>
        <tbody id = "pets">

        </tbody>
    </table>
</div>


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
                body += '<tr>' + '<td>' + data[i].pet_id + '</td>' + '<td>' + data[i].microchip + '</td>' + '<td>' + data[i].name + '</td>' + '<td>' + data[i].race + '</td>' + '<td>' + data[i].sex + '</td>' + '<td>' + data[i].size + '</td>' + '<td>' + data[i].species + '</td>' + '<td>' + '<img src = "' + 'imagesPets/' + data[i].picture + '" width="100" height="100">' +'</td>' + '</tr>';
            }
            document.getElementById('pets').innerHTML = body;
        }
    });
</script>
</body>
</html>
