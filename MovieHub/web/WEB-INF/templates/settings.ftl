<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Settings</title>
</head>
<body>
<p>Settings</p>
<form action="http://localhost:8080/settings" method="post">
    <input type="text" name="name" value="${user.name}"/>
    <input type="text" name="login" value="${user.login}"/>
    <input type="password" name="password" value="${user.password}"/>
    <input type="text" name="photo" value="${user.photo}"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>