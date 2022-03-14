<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signUp.title'/></title>
</head>
<body>

<h2><a href="?lang=ru">ру</a> </h2>
<h2><a href="?lang=en">en</a> </h2>

<h1><@spring.message 'signUp.head'/></h1>
<form role="form" action="/signUp" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div>
        <label for="email"><@spring.message 'signUp.email'/></label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label for="username"><@spring.message 'signUp.username'/></label>
        <input type="text" name="username" id="username" required autofocus/>
    </div>
    <div>
        <label for="password"><@spring.message 'signUp.password'/></label>
        <input type="password" name="password" id="password" required/>
    </div>
    <button type="submit"><@spring.message 'signUp.submitButton'/></button>
</form>
</body>
</html>