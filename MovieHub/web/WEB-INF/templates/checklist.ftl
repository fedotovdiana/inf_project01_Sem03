<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Checklist</title>
</head>
<body>
<p>Films</p>
<#if films?has_content>
<table border="1">
    <#list films as f>
        <tr>
            <td>
                <form action="http://localhost:8080/film" method="get">
                    <input type="submit" name="name" value="${f.name}"/></form>
            </td>
            <td>${f.country}</td>
            <td>${f.date}</td>
            <td>${f.likes}</td>
        </tr>
    </#list>
    </#if>
</table>
</body>
</html>