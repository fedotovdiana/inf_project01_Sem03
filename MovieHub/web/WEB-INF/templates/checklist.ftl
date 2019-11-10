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
    <title>${checklist.name}</title>
</head>
<body class="photo">
<@header/>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">${checklist.name}</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <#list films as f>
            <div class="col-md-3">
                <div class="card mb-4" id="${f.id}">
                    <a href="#"><img src="../img/f1.jpg" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li><a href="/film?film_id=${f.id}&name=${f.name}" class="reg">${f.name}</a>
                                <img src="../../front/svg/delete.svg" class="icon delete" name="${f.id}" alt="delete"></li>
                        </ul>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>