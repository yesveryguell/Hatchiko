<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16/06/2021
  Time: 06:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hola:v</title>
</head>
<body>
<h1>filter date</h1>

<div>
    <form id = "visitsDateFilter">

        <input type="hidden" name="username" value="<%= request.getParameter("username") %>">

        <div class="input-group">
            <input class="input--style-2" type="date" placeholder="Created" name="date1" id="date1">
        </div>

        <div class="input-group">
            <input class="input--style-2" type="date" placeholder="Created" name="date2" id="date2">
        </div>

        <input name="ver" type="button" value="Edit" id="ver" onclick="dates()"/>
    </form>
</div>
<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Visit_id</th>
            <th>Type</th>
            <th>Description</th>
            <th>year</th>
            <th>month</th>
            <th>day</th>

        </tr>
        </thead>
        <tbody id = "dateFilter">

        </tbody>
    </table>
</div>


<script>

    var formulario = document.getElementById('visitsDateFilter');

    function dates(){

        var date1 = document.getElementById("date1").value;
        var date2 = document.getElementById("date2").value;
        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))
        console.log(datos1.get('date1'))
        console.log(datos1.get('date2'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/vets/' + datos1.get('username') + '/visits?date1=' + datos1.get('date1') + '&date2=' + datos1.get('date2'))
            .then((response) => response.json())
            .then(data => mostrarData8(data));
        var username = document.getElementById('username');
        const mostrarData8 = (data) => {

            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].visit_id + '</td>' + '<td>' + data[i].type + '</td>' + '<td>' + data[i].description + '</td>' + '<td>' + data[i].year + '</td>' + '<td>' + data[i].month + '</td>' + '<td>' + data[i].day + '</td>' + '</tr>';
            }
            document.getElementById('dateFilter').innerHTML = body;
        }


    }


    function editVet(info){
        location.href ="./editOwner.jsp?username="+ info;
    }

</script>
</body>
</html>
