<?php
require_once ("header.php");
?>
<!DOCTYPE html>
<html>
<header>
    <title>Signup</title>
    <link rel="stylesheet" href="../styles/loginStyle.css?v=<?php echo time();?>">
</header>

<body>
    
    <div class="formaLogin">
        <form action="../includes/signup.inc.php" method="post">
        <p>SIGNUP</p>
            <input name="uid" type="text" placeholder="Username"><br>
            <input name="mail" type="text" placeholder="E-mail"><br>
            <input name="pwd" type="password" placeholder="Password"><br>
            <input name="pwd-repeat" type="password" placeholder="Repeat password">
            <br><br>
            <button type="submit" name="signup-submit">Signup</button><br><br>
        </form>
        <a href="login.php" style="color: rgb(42, 15, 8);">Login</a>
        <?php
    if(isset($_GET['error'])){
        if($_GET['error']=="emptyfields"){
            echo '<p id="signupError"> Fill in all field!</p>';
        }
        else if($_GET['error']=="invaliduidmail"){
            echo '<p id="signupError"> Username or email are invalid!</p>';
        }
        else if($_GET['error']=="passwordcheck"){
            echo '<p id="signupError"> Passwords dont match!</p>';
        }
        else if($_GET['error']=="sqlerror"){
            echo '<p id="signupError"> Connection with database failed!</p>';
        }
        else if($_GET['error']=="ql2error"){
            echo '<p id="signupError"> Connection with database failed!</p>';
        }
    }
    else if(isset($_GET['successfullsignup'])){
        if($_GET['successfullsignup']=="success"){
            echo '<p id="signupsuccess"> Signup Successfull </p>';
        }
    }
    ?>
    </div>
</body>

</html>