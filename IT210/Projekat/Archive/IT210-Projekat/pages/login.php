<?php
require_once("header.php");
?>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="../styles/loginStyle.css?v=<?php echo time(); ?>">

</head>

<body>
    <div class="formaLogin">
        <form action="../includes/login.inc.php" method="post">
            <p>LOGIN</p>
            <input id="txt_uname" name="mailuid" type="text" placeholder="Username/E-mail"><br>

            <input id="txt_pwd" name="pwd" type="password" placeholder="Password"><br>
            <br>
            <button type="submit" name="login-submit">login</button><br>
        </form>
        <?php
        if (isset($_GET['error'])) {
            if ($_GET['error'] == "emptyfields") {
                echo '<p id="signupError"> Fill in all fields!</p>';
            } else if ($_GET['error'] == "invaliduidmail") {
                echo '<p id="signupError"> Username or email are invalid!</p>';
            } else if ($_GET['error'] == "wrongpwd") {
                echo '<p id="signupError"> Wrong password!</p>';
            } else if ($_GET['error'] == "nouser") {
                echo '<p id="signupError"> No user with those credentials!</p>';
            }
        }

        ?>
        <br><br>
        <a href="signup.php" style="color: rgb(42, 15, 8);">Signup</a>
    </div>
</body>

</html>