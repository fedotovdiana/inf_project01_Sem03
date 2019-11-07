<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Actors</title>
</head>
<body>
<p>Actors</p>
<table border="1">
    <#list actors as a>
    <tr>
        <td>
            <form action="http://localhost:8080/star" method="get">
                <input hidden name="actor_id" value="${a.id}">
                <input type="submit" name="name" value="${a.name}"/>
            </form>
        </td>
        <td>${a.photo}</td>
    </tr>
</#list>
</table>
</body>
</html>