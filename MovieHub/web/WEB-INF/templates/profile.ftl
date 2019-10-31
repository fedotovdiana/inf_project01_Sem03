<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<p>${user.name}</p>
<p>${user.login}</p>
<p>${user.password}</p>
<img src="${user.photo!}" width="200">

<p>Checklists</p>
<table border="1">
    <#list checklists as c>
        <tr>
            <td><form action="http://localhost:8080/checklist" method="get">
                <input type="submit" name= "checklist" value="${c.name}"/>
            </form>
            </td>
        </tr>
    </#list>
</table>
<form action="http://localhost:8080/settings" method="get">
    <input type="submit" value="Settings"/>
</form>
<form action="http://localhost:8080/logout" method="get">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>