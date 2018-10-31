<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$name=$_POST["name"];

try
{
	
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$sql="update people set status='1' where name='$name'";
$conn->exec($sql);
echo "updated successfully";


}
catch(PDOException $e)
{

}
?>