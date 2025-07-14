<?php


require_once("../pages/header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");
}
if (isset($_POST['sendTo-submit'])) {

        require 'config.inc.php';
        
        
        $username=$_SESSION['userusername'];
        $sendTo=$_POST['sendTo-input'];
        $tekst=$_POST['message-input'];
    if(empty($sendTo) || empty($tekst)){
        header("Location:../pages/message.php?error=empty");

}else{
    $sql = "SELECT * FROM korisnici WHERE username=?";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/message.php?error=sqlerror");
            exit();
        }
         else {
            mysqli_stmt_bind_param($stmt, "s",$sendTo);
            mysqli_stmt_execute($stmt);
            mysqli_stmt_store_result($stmt);

            $resultCheck = mysqli_stmt_num_rows($stmt);
            if($resultCheck==0){
                header("Location:../pages/message.php?error=nouser");
                exit();

            }
         
    else{
        $sql = "INSERT INTO chat (PosiljalacMess,PrimalacMess,TextMess) VALUES (?,?,?)";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/message.php?error=sqlerror");
            exit();
        }
         else {
            mysqli_stmt_bind_param($stmt, "sss",$username,$sendTo,$tekst);
            mysqli_stmt_execute($stmt);
            header("Location:../pages/message.php?successfully=sent");
            exit();
         }
         }
        }
}
}
        ?>