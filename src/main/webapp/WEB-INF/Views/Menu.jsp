<!DOCTYPE htmnl>
<html lang="en">
<head>
<title>Bootstrap Cas</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a href="Home" class="navbar-brand"><img src="<c:url value="/resources/images/logo.png"/>"  style="max-height:50px; margin-top: -15px;" alt="logo" /></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="RegistrationPage"> SignUp </a></li>
					<li><a href="LoginPage"> Login </a></li>
				</ul>
<ul class="nav navbar-nav">

<c:forEach var="category" items="${categoryList}">


<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
<ul class="dropdown-menu scrollable-menu" role="menu">
<li><a href="#">AirConditioner</a></li>
<li><a href="#">TV</a></li>
<li><a href="#">Refrigerator</a></li>
</ul>
</li>

</c:forEach>



<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Appliances<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="#">AirConditioner</a></li>
<li><a href="#">TV</a></li>
<li><a href="#">Refrigerator</a></li>
</ul>
</li>
</ul>
</div>
</nav>
<div class="container">
<h3>Navbar With Dropdown</h3>
<p>This example adds a dropdown menu for the "page1" button in the navigation bar.</p>
</div>


</body>