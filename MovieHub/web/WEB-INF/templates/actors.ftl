<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">

    <title>Actors</title>
</head>
<body class="photo">
<div class="header d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom shadow-sm ">
    <h1 class=" my-0 mr-md-auto font-weight-normal">Filmoteka</h1>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2" href="afisha">Afisha</a>
        <a class="p-2" href="films">Films</a>
        <a class="p-2" href="top">Top</a>
        <a class="p-2" href="actors">Actors</a>
        <a class="p-2" href="producers">Producers</a>
        <a class="p-2" href="scriptwriters">Scriptwriters</a>
    </nav>
    <a href="profile"> <img src="../../front/svg/person.svg" class="icon" alt="person"></a>
</div>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">Actors</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <#list actors as a>
            <div class="col-md-3">
                <div class="card mb-2">
                    <a href="/star?actor_id=${a.id}"><img src="../../front/img/${a.photo}" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li><a href="/star?actor_id=${a.id}" class="reg">${a.name}</a></li>
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