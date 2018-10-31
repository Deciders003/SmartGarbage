<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$username=$_POST["username"];
$password=$_POST["password"];
$mobile_no=$_POST["mobile_no"];
//$license_id=$_POST["license_id"];
$count=0;
try
{
	
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$select=$conn->prepare("select name from people");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	if($rows['name']==$username)
	{
		echo "Username Already present";
		$count=1;
	}
}
if($username!=null && $password!=null && $mobile_no!=null)
{
if($count!=1)
{
$sql="insert into people(name,password,mobile_no)values('$username','$password','$mobile_no')";
$conn->exec($sql);
echo "Registered successfully";
}
}
else
{
	echo "Please enter all the field";
}
}

catch(PDOException $e)
{

}
?>