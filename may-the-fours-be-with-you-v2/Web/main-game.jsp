<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import = "game.before.wordsBean" %>
<%! wordsBean bean = new wordsBean(); %>
				
<%@ page session="false" %>
    <jsp:useBean id="bean" type="game.before.wordsBean" scope="request" /> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./styles/bootstrap.min.css" />
<link rel="stylesheet" href="./fonts/belligerentmadness/stylesheet.css" />
<link rel="stylesheet" href="./main.css" />
<title>#MTFBWY-MainGame</title>


<style type="text/css">
body {
	background: url(images/milkyway.jpg) no-repeat center center fixed;
	text-align: center;
	display: in-line:block;
}

a {
	font-size: 2em;
}

header {
	text-align: center;
	margin: 5em 0;
}

header a {
	display: in-line:block;
	text-align: in-line;
	font-size: 1.8em;
}

h1, h2 {
	color: #FFFFFF;
}

footer {
	text-align: center;
}

footer h2 {
	font-size: 1.5em;
}

footer h3 {
	font-size: 1.5em;
}

footer h3 b {
	font-size: 1.3em;
}

footer h3 span {
	font-size: 1em;
}

.letters a {
	display: in-line:block;
	text-align: in-line;
	font-size: 5em;
}

.container {
	text-align: center;
}

#timer a {
	color: #FFFFFF;
	display: in-line:block;
	text-align: in-line;
	font-size: 2em;
}

.jumbotron1 {
	margin-bottom: 0px;
	height: 50px;
	color: white;
	text-shadow: black 0.3em 0.3em 0.3em;
	background: transparent;
}
.dummy{
cursor:default;
}
.one{
height:80px;
font-size:45pt;
text-align:center;
display:in-line;
text-transform: uppercase;
font-family: 'Star Jedi Outline';
background-color:#CCCCCC;
}
.dummy.uppercase{
text-transform: uppercase;
}
.btn{
   font-size:1em;
}
</style>
<script type="text/javascript">

//for the buttons
	function myFunction() {
		
		
	document.getElementById("demo").innerHTML = "${bean.getA()}";
	document.getElementById("demo").disabled = false;

	}
	function myFunction1() {
		document.getElementById("demo1").innerHTML = "${bean.getB()}";
	}
	function myFunction2() {
		document.getElementById("demo2").innerHTML = "${bean.getC()}";
	}
	function myFunction3() {
		document.getElementById("demo3").innerHTML = "${bean.getD()}";
	}
	
	
		
	
	

	////For timer code

	
		function CreateTimer(TimerID, Time) {
			Timer = document.getElementById(TimerID);
			TotalSeconds = Time;
	
			UpdateTimer()
			window.setTimeout("Tick()", 1000);
		}
	
		function Tick() {
			TotalSeconds -= 1;
			UpdateTimer()
			window.setTimeout("Tick()", 1000);
		}
	
		function UpdateTimer() {
			Timer.innerHTML = TotalSeconds;
		}
	
		function Tick() {
			if (TotalSeconds <= 0) {
				//alert("Time's up!")
				window.location.href = "times-up.jsp";
				return;
			}
			
		
	
			TotalSeconds -= 1;
			UpdateTimer()
			window.setTimeout("Tick()", 1000);
		}
	
		function UpdateTimer() {
			var Seconds = TotalSeconds;
	
			var Days = Math.floor(Seconds / 86400);
			Seconds -= Days * 86400;
	
			var Hours = Math.floor(Seconds / 3600);
			Seconds -= Hours * (3600);
	
			var Minutes = Math.floor(Seconds / 60);
			Seconds -= Minutes * (60);
	
			var TimeStr = ((Days > 0) ? Days + " days " : "") + LeadingZero(Hours)
					+ ":" + LeadingZero(Minutes) + ":" + LeadingZero(Seconds)
	
			Timer.innerHTML = TimeStr;
		}
	
		function LeadingZero(Time) {
	
			return (Time < 10) ? "0" + Time : +Time;
	
		}
		//for quitting the game
		 function quitGame ( )
		{
	    document.getElementById("button1").value = "End Game";
		    clearTimeout (Time);
		 
		}
	
</script>
</head>
<body>
<br>
	<div class="jumbotron1">
		<a>Time Limit:</a>
		<br>
		<div id="timer">
			<a><script type="text/javascript">
				window.onload = CreateTimer("timer", 60);
			</script></a>
		</div>
	</div>

	<a><span class="glyphicon glyphicon-thumbs-up"></span> Score : <%out.print(wordsBean.score);%></a>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="jumbotron container-fluid">
				<div class="letters">
				
				
				<!-- <a id="demo">_</a><a id="demo1">_</a><a id="demo2">_</a><a id="demo3">_</a> -->
				<div class="dummy">
				<form  action="checking.html" method="get" id="uppercase" class="col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">	
				 <input type="text" size="1" name="button1"  value="${bean.a}" readonly class="one"> 
				 <input type="text" size="1" name="button2" value="${bean.b}" readonly class="one"> 
				<input type="text" size="1" name="button3" value="${bean.c}" readonly class="one"> 
				<input type="text" size="1" name="button4" value="${bean.d}" readonly class="one">
					<br>
					<br>
					<input type="text" class="form-control" name="answer" required="required"/>
					<br>
					<input type="submit" value="Submit" onclick ="waitGame()" class="btn btn-primary btn-block" id="form-button" name="submitb"/><br>
				</form>
				</div>	
				 
				</div>
				</div>
				
				<form  action="end-game.jsp"
					class="col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">
					<input type="submit" value="End Game" onclick ="quitGame()"
						class="btn btn-primary btn-block" id="form-button" id="end"/><br>
				</form>
			</div>
		</div>
	

	<footer></footer>


</body>
</html>
