<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$latitude=$_POST["latitude"];
$longitude=$_POST["longitude"];
try
{
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$sql="delete from garbage where latitude='$latitude' and longitude='$longitude'";
$conn->exec($sql);
echo "Removed successfully";


}
catch(PDOException $e)
{

}
?>