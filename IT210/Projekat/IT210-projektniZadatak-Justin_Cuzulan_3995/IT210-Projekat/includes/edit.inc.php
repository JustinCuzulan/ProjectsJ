
<?php
require_once("../pages/header.php");

if (isset($_POST['edit-submit'])) {

    require 'config.inc.php';

    $bio=$_POST['opis'];
    $pic=$_POST['profile-picture'].'.png';
    $username=$_SESSION['userusername'];

        $stmt = mysqli_stmt_init($conn);
                $sql = "UPDATE profileInfo SET slika=?, opis=?  WHERE username=?";
                $stmt = mysqli_stmt_init($conn);
                //provjeravamo da li sql i stmt uopste rade u bazi
                if (!mysqli_stmt_prepare($stmt, $sql)) {
                    header("Location:../pages/profil.php?error=sqlerror");
                    exit();
                } else {
                    
                
                    mysqli_stmt_bind_param($stmt, "sss", $pic, $bio, $username);
                    mysqli_stmt_execute($stmt);
                  
                    header("Location:../pages/profil.php");
                    exit();

                }


}else{
        header("Location:../pages/profil.php");
        exit();
    
    }