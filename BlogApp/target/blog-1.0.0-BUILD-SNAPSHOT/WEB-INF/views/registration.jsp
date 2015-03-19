<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>User - Registration</title>

    <link rel="stylesheet" href="resources/css/style.css">

</head>

<body>
<div style="margin-top:5%;">
  <div class="login-card">
    <h1>Sign Up</h1><br>
  <form action="userSignUp" method="POST">
    <input type="text" name="firstname" placeholder="firstname" required>
    <input type="text" name="email" placeholder="email" required>
    <input type="password" name="password" placeholder="Password" required>
     <input type="password" name="password1" placeholder="Confirm Password" required>
    <input type="submit"  class="login login-submit" value="Submit">
  </form>

  <div class="login-help">
    <a href="${pageContext.request.contextPath}/">Login</a> 
  </div>
</div>

</div>



</body>

</html>