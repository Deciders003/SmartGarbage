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
$select=$conn->prepare("select username,password from driver");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	//echo $rows['username'];
	if($rows['username']==$username && $rows['password']==$password)
	{
		echo "LoginSuccessfully";
	}
}
}

catch(PDOException $e)
{
	
}
?>