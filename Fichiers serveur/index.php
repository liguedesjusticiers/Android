<?php
$con=mysqli_connect("127.0.0.1","root","","bd_starsup_test");

if (mysqli_connect_errno($con)){
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$username = $_POST['username'];
$password = $_POST['password'];
$result = mysqli_query($con,"SELECT * FROM utilisateur WHERE identifiant='$username' AND mdp='$password'");
$check = mysqli_fetch_array($result);

if(isset($check)){
	echo "succes";
}
else{
	echo "echec";
}

mysqli_close($con);
?>