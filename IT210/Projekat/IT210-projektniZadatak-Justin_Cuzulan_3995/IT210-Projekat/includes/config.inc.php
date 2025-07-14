<?php


$servername="localhost";
$dBUsername="root";
$dBPassword="";
$dBName="drustvenaMreza";

$conn=mysqli_connect($servername,$dBUsername,$dBPassword,$dBName);

if(!$conn){
    die("ERROR: Could not connect.".mysqli_connect_error());
}
?>