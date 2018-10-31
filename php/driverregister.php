<?php
$server="localhost";
$user="root";
$pass="";
$db="TomTom";
$username=$_POST["username"];
$password=$_POST["password"];
$mobile_no=$_POST["mobile_no"];
$license_id=$_POST["license_id"];
$count=0;
try
{
	
$conn=new PDO("mysql:host=$server;dbname=$db",$user,$pass);
$select=$conn->prepare("select username from driver");
$select->execute();
$row=$select->fetchAll();
foreach($row as $rows)
{
	if($rows['username']==$username)
	{
		echo "Username Already present";
		$count=1;
	}
}
if($username!=null && $password!=null && $mobile_no!=null && $license_id!=null)
{
//	echo "please enter all the field";
if($count!=1)
{
$sql="insert into driver(username,password,mobile_no,license_id)values('$username','$password','$mobile_no','$license_id')";
$conn->exec($sql);
echo "Registered successfully";
}

}
else
{
	echo "please enter all the field";
}
}
catch(PDOException $e)
{

}
?>