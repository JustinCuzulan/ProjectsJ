<?php
require_once("header.php");
require_once("footer.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");
}

?>
<!DOCTYPE html>
<html>

<head>
    <title>4FoxSake</title>
    <link rel="stylesheet" href="../styles/ContactStyle.css?v=<?php echo time(); ?>">

</head>

<body>


    <div id="ostatak">

        <div id="lijevi">
            <div id="meni">
                <button id="btnPadajuciMeni" style="border: 0ch; background-color: rgb(42, 15, 8);">
                    <img id="slika" src="../pictures/StrelicaMenu.png" alt="menu" width="20px" style="margin-top: 20px; margin-left: 20px;">
                </button>
                <div id="padajuciMeniSadrzaj">
                <a href="profil.php" style="text-decoration: none;">Your Profile</a> <br><br>

                <a href="about.php" style="text-decoration: none;">About Us</a><br><br>

                    <a href="contact.php" style="text-decoration: none;">Contact Us</a>
                </div>
            </div>

            <div id="korisnik">
                <?php
                if (isset($_SESSION["username"])) {
                    echo "<p>" . $_SESSION["userusername"] . "</p>";
                } else {
                    echo "<p> Nisam pokupio jer sam idiot</p>";
                }
                ?>
                <form action="../includes/logout.inc.php">
                    <button type="submit" name="logout-submit" style="border-radius: 17px; background-color: rgb(255, 250, 199); border: 0px;">logout</button>
                </form>
            </div>
        </div>


        <div id="sadrzajLijevo" style="width: 1000px; padding: 20px; font-size: 25px; margin-top: -50px;" >
            <p style="text-align: center; color:rgb(255, 250, 199)">4FoxSake je mini društvena mreža nastala 2021. godine, čija je svrha da povezuje ljude širom svijeta, i kreira jednu mirnu i zabavnu zajdenicu. Korisnici ove mreže mogu da objavljuju statuse, koji se dotiču neke od ponuđenih tema ili da pišu šta god pođele. Takodje tu je opcija za međusobno komuniciranje sa drugim korisnicima, kao i 24-časovna podrška naših admina, koji su uvijek tu da pomognu. Zabavite se uz personalizaciju vašeg profila, izaberite neku od naših zanimljivih avatara i napišite par rečenica o sebi da biste se predstavili drugim korisnicima. Užuvajte u komunikaciji i ponuđnim sadržajima! Nadamo se da će te se ovdje osjećati ugodno i da će te steći mnoga prijateljstva. <br><br> <i>Za sve prijedloge i komentare kontaktirajte nas!</i></p>
             
        </div>
    </div>
    </div>
    <script src="../scripts/PocetnaJS.js"></script>
    <script src="../scripts/contactValidate.js"></script>
</body>

</html>