<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">
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
                        $('#' + name).fadeOut();
                    }
                });
            });
        });
    </script>
    <title>Profile</title>
</head>
<body class="photo">
<@header/>
</div>
<div class="container">
    <div class="row">
        <form class="form-horizontal profile">
            <h2 class="heading">Profile</h2>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4">
                        <img src="${user.photo}" class="img-thumbnail rounded">
                        <button type="submit" class="btn mb-2"><a class="pro" href="/settings">Settings</a></button>
                        <button type="submit" class="btn mb-2 out"><a class="pro" href="/logout">Sign out</a></button>
                    </div>
                    <div class="col-md-4 inform">
                        <h3><b>Name: </b>${user.name}</h3>
                        <hr>
                        <h3><b>Login: </b>${user.login}</h3>
                    </div>
                    <div class="col-md-4">
                        <h2> My checklists </h2>
                        <#list checklists as c>
                            <div id="${c.id_checklist}">
                                <p class="display-4"><a href="/checklist?checklist_id=${c.id_checklist}" class="reg">${c.name}  </a>
                                    <span><img src="../../front/svg/delete.svg" class="icon delete" name="${c.id_checklist}" alt="delete"></span></p>
                            </div>
                        </#list>
                    </div>
                </div>
<#--                <h3 class="display-3">Recommendations</h3>-->
<#--                <div class="container-fluid">-->
<#--                    <div class="row">-->
<#--                        <div class="col-md-3">-->
<#--                            <a href="#"><img src="../img/f1.jpg" alt="..." class="img-thumbnail"></a>-->
<#--                        </div>-->
<#--                        <div class="col-md-3">-->
<#--                            <a href="#"><img src="../img/f2.jpg" alt="..." class="img-thumbnail"></a>-->
<#--                        </div>-->
<#--                        <div class="col-md-3">-->
<#--                            <a href="#"><img src="../img/f3.jpg" alt="..." class="img-thumbnail"></a>-->
<#--                        </div>-->
<#--                        <div class="col-md-3">-->
<#--                            <a href="#"><img src="../img/f4.jpg" alt="..." class="img-thumbnail"></a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->
            </div>
        </form>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>