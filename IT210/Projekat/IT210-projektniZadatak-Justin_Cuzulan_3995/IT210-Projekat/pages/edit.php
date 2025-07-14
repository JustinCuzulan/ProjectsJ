<?php
require_once("header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");
}
?>
<!DOCTYPE html>
<html>

<head>
   
    <title>4FoxSake</title>
    <link rel="stylesheet" href="../styles/profilStyle.css?v=<?php echo time(); ?>">
    <style>#glavni img{
        width: 100px;
        height: 100px;
    }
    
        </style>
</head>

<body>


    
               
                    <div id="postovi">Edit
                    <form action="../includes/edit.inc.php" method="POST">
                        <textarea name="opis" id="" cols="30" rows="5" placeholder="BIO"></textarea>
                        <div id="glavni">
                            <div id="lijevi1">
                                <label>
                                <input type="radio" name="profile-picture" value="1" checked>
                                <img src="../profilePic/1.png" alt="Cow">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="2">
                                <img src="../profilePic/2.png" alt="Goat">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="3">
                                <img src="../profilePic/3.png" alt="Sheep">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="4">
                                <img src="../profilePic/4.png" alt="Horse">
                                </label>
                            </div>
                            <div id="lijevi2">
                            <label>
                                <input type="radio" name="profile-picture" value="5">
                                <img src="../profilePic/5.png" alt="Bull">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="6">
                                <img src="../profilePic/6.png" alt="Male goat">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="7">
                                <img src="../profilePic/7.png" alt="Ram">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="8">
                                <img src="../profilePic/8.png" alt="Donkey">
                                </label>
                            </div>
                            <div id="desni1"></div>
                            <label>
                                <input type="radio" name="profile-picture" value="9">
                                <img src="../profilePic/9.png" alt="Pig">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="10">
                                <img src="../profilePic/10.png" alt="Rabbit">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="11">
                                <img src="../profilePic/11.png" alt="Dog">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="12">
                                <img src="../profilePic/12.png" alt="Cat">
                                </label>
                            <div id="desni2">
                            <label>
                                <input type="radio" name="profile-picture" value="13">
                                <img src="../profilePic/13.png" alt="Duck">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="14">
                                <img src="../profilePic/14.png" alt="Goose">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="15">
                                <img src="../profilePic/15.png" alt="Chicken">
                                </label>
                                <label>
                                <input type="radio" name="profile-picture" value="16">
                                <img src="../profilePic/16.png" alt="Rooster">
                                </label>
                            </div>
                        </div>
                        <button type="submit" name="edit-submit">Save changes</button>
                        </form>
                    </div>
               

    
</body>

</html>