<#include 'header.ftl'>
<#include 'libraries.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../front/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../front/css/style.css" type="text/css">

    <title>Sign up</title>
</head>
<body class="photo">
<@header/>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-offset-5 col-md-6">
            <form class="form-horizontal form" action="sign_up" method="post" enctype="multipart/form-data">
                <span class="heading">Sign up</span>
                <form>
                    <div class="form-group row">
                        <label for="staticName" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="staticName" name="name"
                                   placeholder="Enter name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Login</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="staticEmail" name="login"
                                   placeholder="email@example.com">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" name="password"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="FormControlFile" class="col-sm-2 col-form-label">Photo</label>
                        <div class="col-sm-10">
                            <input type="file" readonly class="form-control-file" name="photo" id="FormControlFile">
                        </div>
                    </div>
                    <#--                    <button type="submit" class="btn btn-primary mb-2">Sign up</button>-->
                    <input type="submit" class="btn btn-primary mb-2" value="Sign up">
                </form>
            </form>
        </div>
    </div>
</div>
<@lib/>
</body>
</html>