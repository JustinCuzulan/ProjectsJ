<?php
require_once("../pages/header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");
}
?>
<!DOCTYPE html>
<html>

<head>

    <title>4FoxSake</title>
    <style>
        body{
            color: black;
        }
        .chat{
            height: 150px;
            width: 783px;
            border-bottom: 1px solid black;
        }
        .posiljalac{
            position: relative;
            right: -100px;
            top: 0px;
        }
        .tekst{
            border-top: 1px solid black;
            width: 70%;
            position: relative;
            margin: 0 auto;
            text-align: left;
            right: -10px;
        }
        .deleteDugme{
            border: 0px;
            background-color: inherit;
            color: inherit;
            position: relative;
            left: 700px;
        }
    </style>
</head>

<body>

    

        <?php

        require 'config.inc.php';

        $postTag ='#general';
        $username=$_SESSION['userusername'];
        $admin=$_SESSION['admin'];

        $sql = "SELECT * FROM chat WHERE PrimalacMess=? ORDER BY IDMess DESC";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            exit();
        } else {
            mysqli_stmt_bind_param($stmt, "s", $username);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            while ($row = mysqli_fetch_assoc($result)) {
                echo '<div class="chat"><div class="posiljalac">'.$row['PosiljalacMess'].'</div><div class="tekst"> ' . $row['TextMess'].'</div>';
                echo  '</div>';
                
            }
        }
        if($admin==true){
            $sql = "SELECT * FROM kontakt WHERE Primalac=? ORDER BY ID DESC";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            exit();
        } else {
            mysqli_stmt_bind_param($stmt, "s", $username);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            while ($row = mysqli_fetch_assoc($result)) {
                echo '<div class="chat"><div class="posiljalac">'.$row['Posiljalac'].'</div><div class="tekst"> ' . $row['Tekst'].'</div>';
                echo  '</div>';
                
            }
        }
        }
        ?>



</body>

</html>