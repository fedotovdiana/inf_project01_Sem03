<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Afisha</title>
</head>
<body>
<p>Afisha</p>
<table border="1">
    <#list films as f>
        <tr>
            <td>
                <form action="/film" method="get">
                    <input hidden name="film_id" value="${f.id}">
                    <input type="submit" name="name" value="${f.name}"/>
                </form>
            </td>
            <td>${f.country}</td>
            <td>${f.date}</td>
        </tr>
    </#list>
</table>
</body>
</html>