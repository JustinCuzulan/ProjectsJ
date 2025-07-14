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
                <a href="profil.php" style="text-decoration: none;">Your Profile</a><br><br>

                <a href="about.php" style="text-decoration: none;">About Us</a>

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


        <div id="sadrzajLijevo">
            <p>Need help? Write us a messagge.</p>
            <form action="../includes/Contact.inc.php" method="post"
            style="margin-top: 30px;" id="contact-forma">
                <input type="text" id="ime" name="ime" placeholder="Name"><br><br>
                <input type="text" id="prezime" name="prezime" placeholder="Surname"><br><br>
                <input type="text" id="brojTelefona" name="brojTelefona" placeholder="Phone number">
                <br><br>
                <textarea name="poruka" id="poruka" cols="30" rows="10" placeholder="Your message"></textarea><br><br>
                <button name="contact-submit" type="submit">Submit</button>
            </form>
        </div>
        
        <div id="sadrzajDesno">
            <div class="mapouter" style="margin:0 auto; margin-top: 30px;">
                <div class="gmap_canvas">
                    <iframe width="271" height="270" id="gmap_canvas" src="https://maps.google.com/maps?q=foxy%20productions&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
                    </iframe>
                    <a href="https://www.zipcodewiki.net">
                    </a>
                    <br>
                    <style>
                        .mapouter {
                            position: relative;
                            text-align: right;
                            height: 270px;
                            width: 271px;
                            border: 2px solid black;
                            border-radius: 15px;

                        }
                    </style>
                    <a href="https://www.embedgooglemap.net">
                    </a>
                    <style>
                        .gmap_canvas {
                            overflow: hidden;
                            background: none !important;
                            height: 270px;
                            width: 271px;
                            border-radius: 15px;
                        }
                    </style>
                </div>
            </div>
               <p style="text-align: center; margin:0 auto"> 0038712398123 </p><br><br>
               <p style="text-align: center; margin-top:-20px">justincuzulan@gmail.com</p>

        </div>
    </div>
    </div>
    <script src="../scripts/PocetnaJS.js"></script>
    <script src="../scripts/contactValidate.js"></script>
</body>

</html>