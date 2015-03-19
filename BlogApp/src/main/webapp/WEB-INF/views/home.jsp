<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Blog - Log-in</title>

    <link rel="stylesheet" href="resources/css/style.css">

</head>

<body>
<div style="margin-top:5%;">
  <div class="login-card">
    <h1>Log-in</h1><br>
  <form action="userLogin" method="POST">
    <input type="text" name="email" placeholder="Email">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
    <a href="registration">Register</a> | <a href="#">Forgot Password</a>
  </div>
  <div style="float:none;margin:0px auto;width:50%;margin-top:4px;">
  		<small style="color:red">${message}</small>
  </div>
</div>

</div>



</body>

</html>