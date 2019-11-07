<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Producers</title>
</head>
<body>
<p>Producers</p>
<table border="1">
    <#list producers as p>
        <tr>
            <td>
                <form action="http://localhost:8080/star" method="get">
                    <input hidden name="producer_id" value="${p.id}">
                    <input type="submit" name="name" value="${p.name}"/>
                </form>
            </td>
            <td>${p.photo}</td>
        </tr>
    </#list>
</table>
</body>
</html>