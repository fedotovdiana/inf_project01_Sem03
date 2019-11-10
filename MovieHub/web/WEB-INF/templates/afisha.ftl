<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">

    <title>Afisha</title>
</head>
<body class="photo">
<@header/>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">New films</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <#list films as f>
            <div class="col-md-3">
                <div class="card mb-4">
                    <a href="/film?film_id=${f.id}&name=${f.name}"><img src="../../front/img/${f.photo}" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li><a href="/film?film_id=${f.id}&name=${f.name}" class="reg">${f.name}<br>${f.country}<br>${f.date}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<@lib/>
</body>
</html>