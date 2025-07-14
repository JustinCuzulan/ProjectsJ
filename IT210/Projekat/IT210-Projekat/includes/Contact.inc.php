<?php
require_once("../pages/header.php");
if (!isset($_SESSION['userusername'])) {
    header("Location:/IT210-Projekat/pages/login.php");

}
//Kako korisnik ne bi mogao da pristupi stranici bez klika na dugme signup-submit
//pitamo se da li je dugme pritisnuto, ako jeste moze se nastaviti ako nije->
if (isset($_POST['contact-submit'])) {

    require 'config.inc.php';

    $posiljalac = $_SESSION['userusername'];
    $primalac = 'Justin';
    $text = $_POST['poruka'];
    $ime = $_POST['ime'];
    $prezime = $_POST['prezime'];
    $brojTelefona = $_POST['brojTelefona'];
    $kontaktInfo=$ime.' '.$prezime.' '.$brojTelefona;

        $stmt = mysqli_stmt_init($conn);
                $sql = "INSERT INTO kontakt (Posiljalac, Primalac, Tekst,KontaktInfo) VALUES (?,?,?,?)";
                $stmt = mysqli_stmt_init($conn);
                //provjeravamo da li sql i stmt uopste rade u bazi
                if (!mysqli_stmt_prepare($stmt, $sql)) {
                    header("Location:../pages/contact.php?error=sqlerror");
                    exit();
                } else {
                    
                
                    mysqli_stmt_bind_param($stmt, "ssss", $posiljalac, $primalac, $text,$kontaktInfo);
                    mysqli_stmt_execute($stmt);
                  
                    header("Location:../pages/contact.php?successfully=sent");
                    exit();

                }


}else{
        header("Location:../pages/contact.php");
        exit();
    
    }