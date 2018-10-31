<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$name=$_POST["name"];
try
{
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$select=$conn->prepare("select status from people where name='$name'");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	echo $rows['status'];
}


}
catch(PDOException $e)
{

}

?>