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
    <link rel="stylesheet" href="../styles/profilStyle.css?v=<?php echo time(); ?>">
    <style>
        .post{
            height: 150px;
            width: 800px;
            border-bottom: 1px solid black;
        }
        .postedBy{
            position: relative;
            right: 300px;
            top: 10px;
        }
        .tag{
            position: relative;
            left: 300px;
            top: -10px;
        }
        .tekst{
            border-top: 1px solid black;
            width: 70%;
            position: relative;
            margin: 0 auto;
            text-align: left;
        }
    </style>
</head>

<body>

    

        <?php

        require 'config.inc.php';
        $username = $_SESSION['userusername'];

        $sql = "SELECT * FROM posts WHERE postedBy=? ORDER BY ID DESC";
        $stmt = mysqli_stmt_init($conn);
        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/profil.php?error=sqlerror");
            exit();
        } else {
            mysqli_stmt_bind_param($stmt, "s", $username);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);

            while ($row = mysqli_fetch_assoc($result)) {
                echo '<div class="post"><div class="postedBy">'.$row['postedBy'].'</div><div class="tag">'.$row['postTag'].'</div><div class="tekst"> ' . $row['tekst'] . '</div></div>';
            }
        }
        ?>



</body>

</html>