<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$name=$_POST["name"];
$name="god";
try
{
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$select=$conn->prepare("select latitude,longitude from people where name='$name'");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	echo $rows['latitude'].",".$rows['longitude'];
}


}
catch(PDOException $e)
{

}
?>