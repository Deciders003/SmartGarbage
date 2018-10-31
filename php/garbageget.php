<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";

try
{
	$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
	$sql=$conn->prepare("select * from garbage");
$response=array();
	$sql->execute();
	$row=$sql->fetchAll();
	foreach($row as $rows)
	{
	array_push($response,array("latitude"=>$rows['latitude'],"longitude"=>$rows['longitude']));
	}
	echo json_encode($response);
}
catch(PDOException $e)
{
	
}
?>