<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$name=$_POST["name"];
try
{
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$sql="update people set latitude='0',longitude='0',status='0' where name='$name'";
$conn->exec($sql);
echo "Updated successfully";


}
catch(PDOException $e)
{

}
?>