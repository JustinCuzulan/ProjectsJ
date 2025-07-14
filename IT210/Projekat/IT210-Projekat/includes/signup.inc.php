<?php
if (isset($_POST['signup-submit'])) {

    require 'config.inc.php';

    $username = $_POST['uid'];
    $email = $_POST['mail'];
    $password = $_POST['pwd'];
    $passwordRepeat = $_POST['pwd-repeat'];

    $slika='default.png';
    $opis='Hi there!';

    if (empty($username) || empty($email) || empty($password) || empty($passwordRepeat)) {
         header("Location:../pages/signup.php?error=emptyfields&uid=" . $username . "&email=" . $email);
         exit();
    }
    else if (!filter_var($email, FILTER_VALIDATE_EMAIL) && !preg_match("/^[a-zA-Z0-9]*$/", $username)) {
        header("Location:../pages/signup.php?error=invalidmail&uid");
    }
    else if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        header("Location:../pages/signup.php?error=invalidmail&uid=" . $username);
        exit();
    }
     else if (!preg_match("/^[a-zA-Z0-9]*$/", $username)) {
        header("Location:../pages/signup.php?error=invaliduid&mail=" . $email);
        exit();
    }
    else if ($password !== $passwordRepeat) {
        header("Location:../pages/signup.php?error=passwordcheck&uid=" . $username . "&email=" . $email);
        exit();
    } 
     else {
       $sql = "SELECT username FROM korisnici WHERE username=?";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/signup.php?error=sqlerror");
            exit();
        } else {
             mysqli_stmt_bind_param($stmt, "s", $username);
            mysqli_stmt_execute($stmt);
            mysqli_stmt_store_result($stmt);
            $resultCheck = mysqli_stmt_num_rows($stmt);
            if ($resultCheck > 0) {
                header("Location:../pages/signup.php?error=usertaken&email=" . $email);
                exit();
             } else {
                 $sql = "INSERT INTO korisnici (username, email, password) VALUES (?,?,?)";
                $sql2 = "INSERT INTO profileInfo (username, slika, opis) VALUES (?,?,?)";

                $stmt = mysqli_stmt_init($conn);
                $stmt2=mysqli_stmt_init($conn);
                if (!mysqli_stmt_prepare($stmt, $sql)) {
                    header("Location:../pages/signup.php?error=sqlerror");
                    exit();
                 } else if(!mysqli_stmt_prepare($stmt2, $sql2)){
                    header("Location:../pages/signup.php?error=sql2error");
                    exit();
                    }
                else {
                     $hashedPwd = password_hash($password, PASSWORD_DEFAULT);
                    mysqli_stmt_bind_param($stmt, "sss", $username, $email, $hashedPwd);
                    mysqli_stmt_execute($stmt);
                    mysqli_stmt_bind_param($stmt2, "sss", $username, $slika, $opis);
                    mysqli_stmt_execute($stmt2);
                    header("Location:../pages/signup.php?successfullsignup=success");
                    exit();

                }
            }
        }
    }
    mysqli_stmt_close($stmt);
    mysqli_close($conn);

}
else{
    header("Location:../pages/signup.php");
    exit();

}
