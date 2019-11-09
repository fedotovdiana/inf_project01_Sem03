<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.delete').click(function () {
                var name = $(this).attr('name');
                $.ajax({
                    type: "post",
                    url: "/delete",
                    data: {
                        "checklist_id": name
                    },
                    success: function () {
                        alert("You deleted it" + name);
                        $('#' + name).fadeOut();
                    }
                });
            });
        });
    </script>
</head>
<body>
<p>${user.name}</p>
<p>${user.login}</p>
<p>${user.password}</p>
<img src="${user.photo!}" width="200">

<p>Checklists</p>
<table border="1">
    <#list checklists as c>
        <div id="${c.id_checklist}">
            <div>
                <form action="/checklist" method="get">
                    <input hidden id="checklist_id" name="checklist_id" value="${c.id_checklist}"/>
                    <input type="submit" name="checklist" value="${c.name}"/>
                </form>
            </div>
            <div>
                <input type="submit" class="delete" name="${c.id_checklist}" value="Delete"/>
            </div>
            <hr>
        </div>
    </#list>
</table>
<form action="/settings" method="get">
    <input type="submit" value="Settings"/>
</form>
<form action="/logout" method="get">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>