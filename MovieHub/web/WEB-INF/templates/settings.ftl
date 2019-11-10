<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">

    <title>Settings</title>
</head>
<body class="photo">
<@header/>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-offset-5 col-md-6">
            <form class="form-horizontal form" action="settings" method="post" enctype="multipart/form-data">
                <span class="heading">Settings</span>
                <form>
                    <div class="form-group row">
                        <label for="staticName" class="col-sm-2 col-xl-4 col-md-3 col-form-label">Name</label>
                        <div class="col-sm-10 col-xl-8 col-md-9">
                            <input type="text" class="form-control" id="staticName" name="name" value="${user.name}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-xl-4 col-md-3 col-form-label">Login</label>
                        <div class="col-sm-10 col-xl-8 col-md-9">
                            <input type="text" class="form-control" id="staticEmail" name="login" value="${user.login}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-xl-4 col-md-3 col-form-label">Password</label>
                        <div class="col-sm-10 col-xl-8 col-md-9">
                            <input type="password" class="form-control" name="password" id="inputPassword">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="FormControlFile" class="col-sm-2 col-xl-4 col-md-3 col-form-label">Photo</label>
                        <div class="col-sm-10 col-xl-8 col-md-9">
                            <input type="file" readonly class="form-control-file" name="photo" id="FormControlFile"
                                   value="${user.photo}">
                        </div>
                    </div>
                    <#--                    <button type="submit" class="btn btn-primary mb-2">СОХРАНИТЬ</button>-->
                    <input type="submit" class="btn btn-primary mb-2" value="Save">
                </form>
            </form>
        </div>
    </div>
</div>
<@lib/>
</body>
