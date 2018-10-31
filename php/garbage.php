<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$latitude=$_POST["lat"];
$longitude=$_POST["long"];
try
{
	
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$sql="insert into garbage(latitude,longitude)values($latitude,$longitude)";
$conn->exec($sql);
echo "inserted successfully";
}
catch(PDOException $e)
{

}
?>