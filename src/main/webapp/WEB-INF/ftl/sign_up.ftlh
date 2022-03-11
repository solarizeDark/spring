<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Please, sign up</title>
</head>
<body>
<h1>Log in</h1>

<form role="form" action="/signUp" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <button type="submit">Sign up</button>
</form>
</body>
</html>