<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Film</title>
</head>
<body>
<p>${film.name}</p>
<table border="1">
    <tr>
        <td>${film.country}</td>
        <td>${film.date}</td>
        <td>${film.likes}</td>
        <td>${film.dislikes}</td>
        <td>${film.photo}</td>
        <td>${film.text}</td>
    </tr>
</table>

<p>Actors</p>
<table border="1">
    <#list actors as a>
        <tr>
            <td><form action="http://localhost:8080/star" method="get">
                    <input type="submit" name = "actor_name" value="${a.name}"/></form></td>
            <td>${a.photo}</td>
        </tr>
    </#list>
</table>

<p>Producers</p>
<table border="1">
    <#list producers as p>
        <tr>
            <td><form action="http://localhost:8080/star" method="get">
                    <input type="submit" name = "producer_name" value="${p.name}"/></form></td>
            <td>${p.photo}</td>
        </tr>
    </#list>
</table>

<p>Scriptwriters</p>
<table border="1">
    <#list scriptwriters as s>
        <tr>
            <td><form action="http://localhost:8080/star" method="get">
                    <input type="submit" name = "scr_name" value="${s.name}"/></form></td>
            <td>${s.photo}</td>
        </tr>
    </#list>
</table>

</body>
</html>