<?php
$con=mysqli_connect("127.0.0.1","root","","bd_starsup_test");

if (mysqli_connect_errno($con)){
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT identifiant FROM utilisateur WHERE identifiant='$username' AND mdp='$password'");
$row = mysqli_fetch_array($result);
$data = $row[0];

if($data){
	echo $data;
}

mysqli_close($con);
?>