<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">
    <title>Star</title>

</head>
<body class="photo">
<@header/>
</div>

<div class="container film">
    <div class="row">
        <div class="col-12">
            <h2 class="name">${star.name}</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="../../front/img/${star.photo}" alt="..." class="img-thumbnail ">
        </div>

        <div class="col-9">
            <table class="table">
                <tbody>
                <tr>
                    <th scope="row">Birthday:</th>
                    <td>${star.birthday}</td>
                </tr>
                <tr>
                    <th scope="row">Country:</th>
                    <td>${star.country}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
<#--    <div class="row">-->
<#--        <h2 class="text-center">Films</h2>-->
<#--    </div>-->
<#--    <div class="row">-->
<#--        <div class="col-md-3">-->
<#--            <div class="card mb-2">-->
<#--                <a href="#"><img src="../../front/img/f1.jpg" class="img-thumbnail" alt="..."></a>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
</div>
<@lib/>
</body>
</html>