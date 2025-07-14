<?php
require_once("../pages/header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");

}
if (isset($_POST['post-submit'])) {

    require 'config.inc.php';

    $username = $_SESSION['userusername'];
    $tekst = $_POST['unosTeksta'];
    $postTag= '#general';
    if(empty($tekst)){
        header("Location:../pages/Pocetna.php?error=empty");

    }else{
    if(strpos($tekst,'#general')==true){
    $postTag= '#general';
    }else if(strpos($tekst,'#entertainment')==true){
        $postTag= '#entertainment';
    }else if(strpos($tekst,'#news')==true){
        $postTag= '#news';
    }else if(strpos($tekst,'#funny')==true){
        $postTag= '#funny';
    }else{
        $postTag= '#general';
        echo 'ISPIS';
    
}
        $stmt = mysqli_stmt_init($conn);
                $sql = "INSERT INTO posts (postedBy, tekst, postTag) VALUES (?,?,?)";
                
                //provjeravamo da li sql i stmt uopste rade u bazi
                if (!mysqli_stmt_prepare($stmt, $sql)) {
                    header("Location:../pages/Pocetna.php?error=sqlerror");
                    exit();
                } else {
                    
                    mysqli_stmt_bind_param($stmt, "sss", $username, $tekst,$postTag);
                    mysqli_stmt_execute($stmt);
                    header("Location:../pages/Pocetna.php?successfully=posted");
                    exit();

                }

            }
}else{
        header("Location:../pages/contact.php");
        exit();
    
    }
