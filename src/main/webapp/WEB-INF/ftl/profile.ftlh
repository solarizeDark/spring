<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
<h1>Profile page</h1>
<label for="info">Personal info</label>
<form role="form" action="/profile" method="post" id="info">
    <div>
        <label for="Name">Name</label>
        <input type="text" id="name" required autofocus/>
    </div>
    <div>
        <label for="Surame">Surname</label>
        <input type="text" id="surname" required autofocus/>
    </div>
    <div>
        <label for="Age">Age</label>
        <input type="text" id="age" required autofocus/>
    </div>
    <div>
        <label for="Group">Group</label>
        <input type="text" id="group" required autofocus/>
    </div>
    <button type="submit">Add info</button>
</form>
</body>
</html>
