<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Films</title>
</head>
<body>
<p>Films</p>
<table border="1">
    <#list films as f>
        <tr>
            <td>
                <form action="http://localhost:8080/film" method="get">
                    <input hidden name="film_id" value="${f.id}">
                    <input type="submit" name="name" value="${f.name}"/>
                </form>
            </td>
            <td>${f.country}</td>
            <td>${f.date}</td>
        </tr>
    </#list>
</table>
<form action="/profile" method="get">
    <input type="submit" value="Profile"/>
</form>
<form action="/actors" method="get">
    <input type="submit" value="Actors"/>
</form>
<form action="/producers" method="get">
    <input type="submit" value="Producers"/>
</form>
<form action="/scriptwriters" method="get">
    <input type="submit" value="Scriptwriters"/>
</form>
<a href="http://localhost:8080/top" class="button">Top</a>
<a href="http://localhost:8080/afisha" class="button">Afisha</a>
</body>
</html>