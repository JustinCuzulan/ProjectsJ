<?php
require_once("../pages/header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");

}
if (isset($_POST['delete-submit'])) {

    require 'config.inc.php';

    $id=$_POST['post-id'];
        $stmt = mysqli_stmt_init($conn);
                $sql = "DELETE FROM posts WHERE ID=?";
                
                //provjeravamo da li sql i stmt uopste rade u bazi
                if (!mysqli_stmt_prepare($stmt, $sql)) {
                    header("Location:../pages/Pocetna.php?error=sqlerror");
                    exit();
                } else {
                    
                    mysqli_stmt_bind_param($stmt, "s", $id);
                    mysqli_stmt_execute($stmt);
                    header("Location:../pages/Pocetna.php?successfully=posted");
                    exit();

                }


}else{
        header("Location:../pages/contact.php");
        exit();
    
    }