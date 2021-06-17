<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 2:30 p. m.
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
                <form id = "viewCase">
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
                        <input class="input--style-2" type="date" placeholder="Created" name="created_at1">
                    </div>

                    <h3>Created at:</h3>
                    <div class="input-group">
                        <input class="input--style-2" type="date" placeholder="Created" name="created_at2">
                    </div>


                    <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit">View info</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<h1>filter date</h1>
<div>
    <table class="table table-dark table-striped table-bordered">
        <thead>
        <tr>
            <th>Case id</th>
            <th>Type</th>
            <th>Description</th>
            <th>year</th>
            <th>month</th>
            <th>day</th>

        </tr>
        </thead>
        <tbody id="cases">

        </tbody>
    </table>
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
    var formulario = document.getElementById('viewCase');

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos1 = new FormData(formulario);

        console.log(datos1.get('username'))
        console.log(datos1.get('created_at1'))
        console.log(datos1.get('created_at2'))

        fetch('http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/pets/' + datos1.get('pet_id') + '/petCases?date1='+datos1.get('created_at1')+'&date2='+datos1.get('created_at2'))
            .then((response) => response.json())
            .then(data => mostrarData7(data));
        var username = document.getElementById('username');
        const mostrarData7 = (data) => {

            let body = ''
            for (let i = 0; i < data.length; i++) {
                body += '<tr>' + '<td>' + data[i].case_id + '</td>' + '<td>' + data[i].type + '</td>' + '<td>' + data[i].description + '</td>' + '<td>' + data[i].year + '</td>' + '<td>' + data[i].month + '</td>' + '<td>' + data[i].day + '</td>' + '</tr>';
            }
            document.getElementById('cases').innerHTML = body;
        }

    });


</script>
</body>
</html>
