
<?php

require 'config.inc.php';
$username = $_SESSION['userusername'];
$sql = "SELECT * FROM profileInfo WHERE username=?";
$stmt = mysqli_stmt_init($conn);
if (!mysqli_stmt_prepare($stmt, $sql)) {
    header("Location:../profil.php?error=sqlerror");
    exit();
} else {
    mysqli_stmt_bind_param($stmt, "s", $username);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);

    if ($row = mysqli_fetch_assoc($result)) {

        $_SESSION['userSlika'] = $row['slika'];
        $_SESSION['userOpis'] = $row['opis'];
        
    } else {
        header("Location:../profil.php?error");
        exit();
    }
}
