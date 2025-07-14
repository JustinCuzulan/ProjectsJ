<?php



if (isset($_POST['login-submit'])) {
    require 'config.inc.php';

    $mailuid = $_POST['mailuid'];
    $password = $_POST['pwd'];
if (empty($mailuid) || empty($password)) {
        header("Location:../pages/login.php?error=emptyfields");
        exit();
    } else {
        $sql = "SELECT * FROM korisnici WHERE username=? OR email=?;";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/login.php?error=sqlerror");
            exit();
        }
        else {
            mysqli_stmt_bind_param($stmt, "ss", $mailuid, $mailuid);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            if($row = mysqli_fetch_assoc($result)){
            $pwdCheck= password_verify($password,$row['password']);
            if($pwdCheck == false){
                header("Location:../pages/login.php?error=wrongpwd");
                exit();
            }
            else if($pwdCheck == true){
                session_start();
                $_SESSION['userId'] = $row['ID'];
                $_SESSION['userusername'] = $row['username'];
                $_SESSION['username']=$mailuid;
                $_SESSION['admin']=$row['ADMIN'];
                if($row['ADMIN']=='Admin'){
                    $_SESSION['admin']=true;
                }else{
                    $_SESSION['admin']=false;
                }
                header("Location:../pages/Pocetna.php");
                exit();
            }
            else{
                header("Location:../pages/login.php?error=wrongpwd");
                exit();
            }
            }
            else{
                header("Location:../pages/login.php?error=nouser");
                exit();
            }
        }
    }
} else {
    header("Location:../pages/login.php");
    exit();
}
