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
            <td><form action="http://localhost:8080/film" method="get">
                    <input type="submit" name = "name" value="${f.name}"/></form></td>
            <td>${f.country}</td>
            <td>${f.date}</td>
            <td>${f.likes}</td>
        </tr>
    </#list>
</table>
<form action="http://localhost:8080/logout" method="get">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>