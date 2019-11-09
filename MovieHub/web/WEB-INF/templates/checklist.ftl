<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Checklist ${checklist.name}</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.delete').click(function () {
                var name = $(this).attr('name');
                $.ajax({
                    type: "post",
                    url: "/removal",
                    data: {
                        "film_id": name,
                        "checklist_id": ${checklist.id_checklist}
                    },
                    success: function () {
                        $('#' + name).fadeOut();
                    }
                });
            });
        });
    </script>
</head>
<body>
<p>Films</p>
<#if films?has_content>
<table border="1">
    <#list films as f>
        <tr id="${f.id}">
            <td>
                <form action="/film" method="get">
                    <input hidden name="film_id" value="${f.id}"/>
                    <input type="submit" id="name" name="film_name" value="${f.name}"/>
                </form>
            </td>
            <td>${f.country}</td>
            <td>${f.date}</td>
            <td>${f.likes}</td>
            <td>
                <input type="submit" class="delete" name="${f.id}" value="Delete"/>
            </td>
        </tr>
    </#list>
    </#if>
</table>
</body>
</html>