<?php
session_start();

?>
<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="../pictures/4FoxSakeFavicon.png" type="image/x-icon" style="border-radius: 100%;">  

    <link rel="stylesheet" href="../styles/headerStyle.css?v=<?php echo time();?>">
</head>

<body>


    <div id="zaglavlje">
        <div id="logo">
            <img src="../pictures/4FoxSake.png" alt="LOGO" style="height: 60px; width:70px; border-radius: 70px;"><br><br>
        </div>
        <?php
        if(!isset($_SESSION['userusername'])) {
            
        ?>
        <div id="goreDesno"></div>
        <?php 
        } 
        if(isset($_SESSION['userusername'])) {
        ?>
       <div id="navigacija"><a href="Pocetna.php" style="padding-right: 30px; text-decoration: none;">HOME</a>
                          
    </div>
    
        <?php 
    }?>
    </div>
</body>

</html>