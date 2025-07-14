<?php
require_once("header.php");
require_once("../includes/profil.inc.php");
require_once("footer.php");
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
        #profilZaglavlje img {
            height: 80px;
            width: 80px;
            position: relative;
            right: 280px;
            top: 10px;
            border: 1px solid rgb(255, 250, 199);
            border-radius: 100%;
        }

        #ime {
            position: relative;
            top: -85px;
            right: 190px;
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

        #edit,
        #edit:visited,
        #edit:hover {
            position: relative;
            top: -240px;
            left: 350px;
            color: rgb(42, 15, 8);

            text-decoration: none;
        }
    </style>
</head>

<body>


    <div id="ostatak">

        <div id="lijevi">
            <div id="meni">
                <button id="btnPadajuciMeni" style="border: 0ch; background-color: rgb(42, 15, 8); z-index:1;">
                    <img id="slika" src="../pictures/StrelicaMenu.png" alt="menu" width="20px" style="margin-top: 20px; margin-left: 20px;">
                </button>
                <div id="padajuciMeniSadrzaj">
                    <a href="profil.php" style="text-decoration: none;">Your Profile</a><br><br>

                    <a href="about.php" style="text-decoration: none;">About Us</a><br><br>
                    <a href="contact.php" style="text-decoration: none;">Contact Us</a>

                </div>
            </div>

            <div id="korisnik">
                <?php
                if (isset($_SESSION["username"])) {
                    echo "<p>" . $_SESSION["userusername"] . "</p>";
                } else {
                    echo "<p> Error no username!</p>";
                }
                ?>
                <form action="../includes/logout.inc.php">
                    <button type="submit" name="logout-submit" style="border-radius: 17px; background-color: rgb(255, 250, 199); border: 0px;">logout</button>
                </form>
            </div>
        </div>
        <div id="profil">
            <div id="profilZaglavlje">
                <div>
                    <?php

                    if (isset($_SESSION["userSlika"]) && isset($_SESSION["userOpis"])) {
                        echo "<img  src='../profilePic/" . $_SESSION['userSlika'] . "'alt='profilePic'>";
                        echo "<p id='ime'>" . $_SESSION["userusername"] . "</p>";
                        echo "<p id='opis'>" . $_SESSION["userOpis"] . "</p>";
                    } else {
                        echo "<p> Error no pic!</p>";
                    }

                    ?>

                </div>
                <a href="?content=1" id="edit">Edit</a>
            </div>
            <div id="postovi">
                <?php
                if (isset($_GET['content'])) {
                    if ($_GET['content'] == 1) {
                        include 'edit.php';
                    }
                } else {
                    include '../includes/postsProfile.inc.php';
                }
                ?>
            </div>
        </div>
    </div>

    <script src="../scripts/PocetnaJS.js"></script>
</body>

</html>