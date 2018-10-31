<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$username=$_POST["username"];
$password=$_POST["password"];

try
{
	
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$select=$conn->prepare("select name,password from people");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	//echo $rows['name'];
	if($rows['name']==$username && $rows['password']==$password)
	{
		echo "LoginSuccessfully";
	}
	else
	{
	echo "please enter the correct username and password";	
	}
}
}
catch(PDOException $e)
{
	
}
?>