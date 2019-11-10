<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">

    <title>Films</title>
</head>
<body class="photo">
    <@header/>
</div>
<section class="jumbotron text-center">
    <div class="container">
        <h2 class="jumbotron-heading">Films</h2>
    </div>
</section>
<div class="container">
    <div class="row">
        <form>
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                        <option selected>Countries</option>
                        <option value="1">c1</option>
                        <option value="2">c2</option>
                        <option value="3">c3</option>
                        <option value="4">c4</option>
                    </select>
                </div>
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect2">
                        <option selected>Year</option>
                        <option value="1">2019</option>
                        <option value="2">2018</option>
                        <option value="3">2017</option>
                        <option value="4">2016</option>
                        <option value="5">2015</option>
                    </select>
                </div>
                <div class="col-auto my-1">
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect3">
                        <option selected>Popularity</option>
                        <option value="1">Date</option>
                    </select>
                </div>
                <button type="button" class="btn btn-b btn-default">Find</button>
            </div>
        </form>
    </div>
    <div class="row">
        <#list films as f>
            <div class="col-md-3">
                <div class="card mb-4">
                    <a href="/film?film_id=${f.id}&name=${f.name}"><img src="../../front/img/${f.photo}" class="img-thumbnail" alt="..."></a>
                    <div class="card-body">
                        <ul class="list-unstyled text-center mb-2">
                            <li>
<#--                                <h8 class="display-4 like">318 |</h8>-->
<#--                                <h8 class="display-4 dislike">5</h8>-->
                            </li>
                            <li><a href="/film?film_id=${f.id}&name=${f.name}" class="reg">${f.name}<br>${f.date}</a></li>
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