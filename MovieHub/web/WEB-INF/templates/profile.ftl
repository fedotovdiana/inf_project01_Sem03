<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<p>${user.name}</p>
<p>${user.login}</p>
<p>${user.password}</p>
<p>${user.photo}</p>
<form action="http://localhost:8080/settings" method="get">
    <input type="submit" value="Settings"/>
</form>
<form action="http://localhost:8080/logout" method="get">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>