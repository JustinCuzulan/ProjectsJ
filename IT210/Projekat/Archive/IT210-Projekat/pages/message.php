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
    <link rel="stylesheet" href="../styles/PocetnaStyle.css?v=<?php echo time(); ?>">

</head>

<body>
    <div id="zaglavlje">
        <div id="logo">
            <img src="../pictures/4FoxSake.png" alt="LOGO" style="height: 60px; width:70px; border-radius: 70px;"><br><br>
        </div>
        <?php
        if (!isset($_SESSION['userusername'])) {

        ?>
            <div id="goreDesno"></div>
        <?php
        }
        if (isset($_SESSION['userusername'])) {
        ?>
            <div id="navigacija"><a href="Pocetna.php" style="padding-right: 30px; text-decoration: none;">HOME</a>
                
            </div>
            <div id="message">
                <a href="message.php" style="text-decoration: none; color: rgb(212, 113, 54);">messages</a>
            </div>
        <?php
        } ?>
    </div>
    <?php
    if (isset($_SESSION['userusername'])) {
    ?>
        

    <?php }
    ?>
    <div id="ostatak">

        <div id="lijevi">
            <div id="meni">
                <button id="btnPadajuciMeni" style="border: 0ch; background-color: rgb(42, 15, 8);">
                    <img id="slika" src="../pictures/StrelicaMenu.png" alt="menu" width="20px" style="margin-top: 20px; margin-left: 20px;">
                </button>
                <div id="padajuciMeniSadrzaj">
                    <br>
                    <a href="profil.php" style="text-decoration: none; color: rgb(212, 113, 54);">Your Profile</a><br><br>
                    <a href="about.php" style="text-decoration: none;  color: rgb(212, 113, 54);">About Us</a><br><br>
                    <a href="contact.php" style="text-decoration: none; color: rgb(212, 113, 54);">Contact Us</a><br>
                </div>
            </div>

            <div id="korisnik">
                <?php
                if (isset($_SESSION["username"])) {
                    echo "<img id='profilSlika' src='../profilePic/" . $_SESSION["userSlika"] . "'></p>";
                    echo "<p id='imezaglavlje'>" . $_SESSION["userusername"] . "</p>";
                } else {
                    echo "<p> Name can't be found!</p>";
                }
                ?>
                <form action="../includes/logout.inc.php">
                    <button type="submit" name="logout-submit" style="border-radius: 17px; background-color: rgb(255, 250, 199); border: 0px;">
                        logout
                    </button>
                </form>
            </div>
        </div>
        <div id="tijelo">
            <div id="sadrzaj">
                <div id="writeMessageTo" style="padding:10px;">
                    <form action="../includes/message.inc.php" method="POST">
                    <input type="text" name="sendTo-input" placeholder="send message to" style="background-color: rgb(255, 250, 199); color:rgb(42, 15, 8)"><br>
                    <textarea name="message-input" id="messageArea" cols="30" rows="5" placeholder="your message" style="background-color: rgb(255, 250, 199); color:rgb(42, 15, 8)"></textarea>
                    <button type="submit" name="sendTo-submit" style="background-color: rgb(255, 250, 199); color:rgb(42, 15, 8)">Send</button>
                </form>
                <?php
                if(isset($_GET['successfully'])){
        if($_GET['successfully']=="sent"){
            echo '<script> alert("Poruka je poslata")</script>';
        }
    }else if(isset($_GET['error'])){
            if($_GET['error']=="empty"){
                echo '<script> alert("Neko od polja je ostalo prazno!")</script>';
        }
           else if($_GET['error']=="sqlerror"){
                echo '<script> alert("Doslo je do greske pri povezivanju sa bazom!")</script>';
           }
        else if($_GET['error']=="nouser"){
                echo '<script> alert("Korisnik sa tim korisnickim imenom ne postoji!")</script>';
        }
    }
        ?>
                </div>

                <div id="poruke" style="border: 1px solid black;">
                <a href="?content=1" style="text-decoration: none;color:rgb(255, 250, 199);">Show Messages</a>

                <?php
                    if (isset($_GET['content'])) {
                        if ($_GET['content'] == 1) {
                            include '../includes/messageChat.inc.php';   
                    }
                }
                    ?>
                </div>

            </div>
        </div>
    </div>
    <script src="../scripts/PocetnaJS.js"></script>
</body>

</html>