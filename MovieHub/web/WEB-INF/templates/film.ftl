<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Film</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#call').click(function () {
                $.ajax({
                    type: "post",
                    url: "/film",
                    data: {
                        "input": $('select[name=selectors]').val(),
                        "name": "${film.name}"
                    },
                    success: function () {
                        alert('Film was added!');
                    }
                });
            });
        });
    </script>
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

<p>Categories</p>
<table border="1">
    <#list categories as c>
        <tr>
            <td>${c.name}</td>
        </tr>
    </#list>
</table>

<#if actors?has_content>
    <p>Actors</p>
    <table border="1">
        <#list actors as a>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input type="submit" name="actor_name" value="${a.name}"/></form>
                </td>
                <td>${a.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if producers?has_content>
    <p>Producers</p>
    <table border="1">
        <#list producers as p>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input type="submit" name="producer_name" value="${p.name}"/></form>
                </td>
                <td>${p.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if scriptwriters?has_content>
    <p>Scriptwriters</p>
    <table border="1">
        <#list scriptwriters as s>
            <tr>
                <td>
                    <form action="http://localhost:8080/star" method="get">
                        <input type="submit" name="scr_name" value="${s.name}"/></form>
                </td>
                <td>${s.photo}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if comments?has_content>
    <p>Comments</p>
    <table border="1">
        <#list comments as c>
            <tr>
                <td>${c.user}</td>
                <td>${c.title}</td>
                <td>${c.text}</td>
                <td>${c.date}</td>
            </tr>
        </#list>
    </table>
</#if>

<#if user??>
    <p>Add to</p>
    <table border="1">
        <#if checklists?has_content>
            <tr>
                <select name="selectors">
                    <#list checklists as c>
                        <option id=${c.name}>${c.name}</option>
                    </#list>
                </select>
            </tr>
            <tr><input type="button" value="Add film into" id="call"/></tr>
        </#if>
        <tr>
            <td>
                <form action="http://localhost:8080/creation" method="post">
                    <input type="text" name="input"/>
                    <input type="hidden" name=name value="${film.name}"/>
                    <input type="submit" id="add" value="To new checklist"/>
                </form>
            </td>
        </tr>
    </table>
    <div id="somediv"></div>
</#if>
</body>
</html>

<#--<form action="http://localhost:8080/creating" method="post">-->
<#--    <input type="text" name="checklist"/>-->
<#--    <input type="submit" id="add" value="Add checklist"/></form>-->