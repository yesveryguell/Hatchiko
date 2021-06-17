<%--
  Created by IntelliJ IDEA.
  User: rguti
  Date: 17/06/2021
  Time: 12:30 p. m.
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
<div>
    <form method="post" action="http://localhost:8080/Hatchiko-1.0-SNAPSHOT/api/upload?pet_id=1" enctype="multipart/form-data">

        <div class="rs-select2 js-select-simple select--no-search">
            <select name="pet_id" required id = "ids">

            </select>
            <div class="select-dropdown"></div>
        </div>
        Choose a file: <input type="file" name="file" />
        <input type="submit" value="Upload" />
    </form>
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


</body>
</html>
