<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$name=$_POST["name"];
$latitude=$_POST["latitude"];
$longitude=$_POST["longitude"];
/*$name="saravanan";
$mobile_no="9445224283";
$latitude="18.52";
$longitude="19.52";*/
try
{
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$sql="update people set latitude='$latitude',longitude='$longitude',status='0' where name='$name'";
$conn->exec($sql);
echo "inserted successfully";


}
catch(PDOException $e)
{

}
?>