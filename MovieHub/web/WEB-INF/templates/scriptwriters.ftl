<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Scriptwriters</title>
</head>
<body>
<p>Scriptwriters</p>
<table border="1">
    <#list scriptwriters as s>
        <tr>
            <td>
                <form action="http://localhost:8080/star" method="get">
                    <input hidden name="scr_id" value="${s.id}">
                    <input type="submit" name="name" value="${s.name}"/>
                </form>
            </td>
            <td>${s.photo}</td>
        </tr>
    </#list>
</table>
</body>
</html>