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
    <link rel="stylesheet" href="../styles/AnimacijaStyle.css?v=<?php echo time(); ?>">

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
            <div id="navigacija"><a href="?content=1" style="padding-right: 30px; text-decoration: none;color: rgb(212, 113, 54);">HOME</a>
                <a href="?content=2" style="text-decoration: none;">#general</a>
                <a href="?content=3" style="text-decoration: none;">#entertainment</a>
                <a href="?content=4" style="text-decoration: none;">#news</a>
                <a href="?content=5" style="text-decoration: none;">#funny</a>

                
            </div>
            <div id="message">
                <a href="message.php">messages</a>
            </div>
            

        <?php
        
        }
        if(isset($_GET['error'])){
            if($_GET['error']=="empty"){
                echo '<script> alert("Neko od polja je ostalo prazno!")</script>';
        }
    }
        ?>
    </div>
    <?php
    if (isset($_SESSION['userusername'])) {
    ?>
        <div id="pretraziKorisnika">
            <form action="?content=6" method="POST">
            <label for="pretrazivanje">Pretrazite korisnika</label><br>
            <input id="pretrazivanje" name="search-input" type="text" style="border-radius: 20px;  outline: none; background-color: rgb(255, 250, 199);">
            <button type="submit" name="search-submit" style="border-radius: 17px; background-color: rgb(255, 250, 199); color: rgb(212, 113, 54);">Search</button>
            </form>
        </div>

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
                    <a href="profil.php" style="text-decoration: none;">Your Profile</a><br><br>
                    <a href="about.php" style="text-decoration: none;">About Us</a><br><br>
                    <a href="contact.php" style="text-decoration: none;">Contact Us</a><br>
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
                    <button type="submit" name="logout-submit" style="border-radius: 17px; background-color: rgb(255, 250, 199); border: 0px; margin:0px 0px 20px 10px">
                        logout
                    </button>
                </form>
            </div>
        </div>
        <div id="tijelo">

            <div id="status">

                <div id="korisnickoIme">
                    <?php
                    if (isset($_SESSION["username"])) {
                        echo "<p style='color: rgb(212, 113, 54);'>" . $_SESSION["userusername"] . "</p>";
                    } else {
                        echo "<p> Name can't be found!</p>";
                    }
                    ?>
                </div>

                <div id="TAStatus">
                    <form action="../includes/postsUnos.inc.php" method="POST">
                        <textArea name="unosTeksta" rows="5" cols="35" minlength="1" maxlength="200" style="border-radius: 15px; background-color: rgb(255, 240, 210); outline: none; color: rgb(212, 113, 54); padding:10px" placeholder="Write something..."></textArea>
                        <button type="submit" name="post-submit" style="border-radius: 17px; background-color: rgb(212, 113, 54); color: rgb(255, 250, 199);">POST</button><br>

                    </form>
                </div>

            </div>

            <div id="sadrzaj">
                
                
                
                    <?php
                    if (isset($_GET['content'])) {
                        if ($_GET['content'] == 1) {
                            echo '<div id="animacija"><p id="tekstAnimacija">WELCOME!</p></div><div id="postovi">';
                            include '../includes/posts/home.pos.php';
                        }
                        else if ($_GET['content'] == 2) {
                            include '../includes/posts/general.pos.php';
                            
                        } else if ($_GET['content'] == 3) {
                            include '../includes/posts/entertainment.pos.php';

                        } else if ($_GET['content'] == 4) {
                            include '../includes/posts/news.pos.php';
                        } else if ($_GET['content'] == 5) {
                            include '../includes/posts/funny.pos.php';
                        }else if ($_GET['content']==6){
                            echo '';
                            include '../includes/posts/search.pos.php';
                        }
                    }else{
                        include '../includes/posts/home.pos.php';
                    }
                    
                    ?>
                </div>

            </div>
        </div>
    </div>
    
    <script src="../scripts/PocetnaJS.js"></script>
</body>

</html>