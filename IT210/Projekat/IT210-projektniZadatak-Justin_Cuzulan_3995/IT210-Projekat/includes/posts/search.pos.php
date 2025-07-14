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
        .post {
            height: 150px;
            width: 783px;
            border-bottom: 1px solid black;
        }

        .postedBy {
            position: relative;
            right: -100px;
            top: 10px;
        }

        .tag {
            position: relative;
            left: 650px;
            top: -10px;
        }

        .tekst {
            border-top: 1px solid black;
            width: 70%;
            position: relative;
            margin: 0 auto;
            text-align: left;
        }

        .deleteDugme {
            border: 0px;
            background-color: inherit;
            color: inherit;
            position: relative;
            left: 700px;
        }
         #slikaProfila {
            height: 80px;
            width: 80px;
            position: relative;
            right: -50px;
            top: 10px;
            border: 1px solid rgb(255, 250, 199);
            border-radius: 100%;
            
        }

        #ime {
            position: relative;
            top: -85px;
            right: -200px;
            font-size: 30px;
        }

        #opis {
            position: relative;
            top: -110px;
            right: 10px;
            text-align: right;
            font-size: 18px;
            font-style: italic;
        }
    </style>
</head>

<body>



    <?php
    if (isset($_POST['search-submit'])) {
        require '../includes/config.inc.php';

        $searchedUsername = $_POST['search-input'];
        $admin = $_SESSION['admin'];
        $username = $_SESSION['userusername'];

        $sql = "SELECT * FROM posts WHERE postedBy=? ORDER BY ID DESC";
        $sql2 = "SELECT * FROM profileInfo WHERE username=?";
        $stmt = mysqli_stmt_init($conn);
        $stmt2 = mysqli_stmt_init($conn);

        if (!mysqli_stmt_prepare($stmt, $sql)) {
            header("Location:../pages/profil.php?error=sqlerror");
            exit();
        } else if (!mysqli_stmt_prepare($stmt2, $sql2)) {
            header("Location:../pages/profil.php?error=sqlerror");
            exit();
        } else {
            mysqli_stmt_bind_param($stmt2, "s", $searchedUsername);


            mysqli_stmt_execute($stmt2);

            $result2 = mysqli_stmt_get_result($stmt2);

            if ($row2 = mysqli_fetch_assoc($result2)) {
                echo "<img id='slikaProfila' src='../profilePic/" . $row2['slika'] . "'alt='profilePic'>";
                echo "<p id='ime'>" . $row2["username"] . "</p>";
                echo "<p id='opis'>" . $row2["opis"] . "</p> <hr>";
            }

            mysqli_stmt_bind_param($stmt, "s", $searchedUsername);
            mysqli_stmt_execute($stmt);
            $result = mysqli_stmt_get_result($stmt);
            while ($row = mysqli_fetch_assoc($result)) {
                echo '<div class="post"><div class="postedBy">' . $row['postedBy'] . '</div><div class="tag">' . $row['postTag'] . '</div><div class="tekst"> ' . $row['tekst'] . '</div>';
                if ($row['postedBy'] == $username || $admin == true) {
                    echo '<form action="../includes/delete.inc.php" method="POST"> <input type="hidden" name="post-id" value="' . $row['ID'] . '"/> <button type="submit" class="deleteDugme" name="delete-submit">delete</button></form>';
                }
                echo  '</div>';
            }
        }
    }
    ?>



</body>

</html>