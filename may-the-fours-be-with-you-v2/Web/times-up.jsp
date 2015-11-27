<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./styles/bootstrap.min.css" />
<link rel="stylesheet" href="./fonts/belligerentmadness/stylesheet.css" />
<link rel="stylesheet" href="./main.css"/>
<script type="text/javascript" src="/Timer.js"></script>
<title>#MTFBWY-TimesUP</title>
<style type="text/css">
body {
	background: url(images/milkyway.jpg)no-repeat center center fixed; 
	text-align: left;
	font-color:#FFFFFF
	display:in-line:block;
	}
	
header {
	text-align: center;
	margin: 5em 0;
}
header a{
	display:in-line:block;
	text-align:in-line;
	font-size: 1.8em;
	
}
.row h1{
font-color:red;
}
h1,h2{
color:red;
}
footer {
	text-align: center;
}

footer h2 {
	font-size: 1.5em;
}
footer h3 {
	font-size: 1.5em;
	color:#FFFFFF
}
footer h3 b {
	font-size: 1.3em;
}

footer h3 span {
	font-size: 1em;
}
.letters a{
display:in-line:block;
text-align:in-line;
font-size: 5em;
}
.container{
text-align:center;
}
.container a{
text-align:center;
display:in-line:block;
text-align:in-line;
font-size: 1.8em;
}
.jumbotron {
	width: 30em;
	margin: auto;
}
</style>
</head>
<body>
		<%@ page import = "game.before.wordsBean" %>
		<%! wordsBean bean = new wordsBean(); %>
			<br>
			<br>
		<div class="container">
			<div class="row">
				<div class="jumbotron">

				<h3 style="color:red">SCORE</h3>

				<h3>SCORE</h3>
				<h1 style="font-color:red"><%out.println(wordsBean.score); %></h1>
				<% if (wordsBean.score==0 || wordsBean.score==1) { %>
				<img src="images/r2d2.png" height=150 width=200 align="right" />
				<% } else if ( wordsBean.score==2 || wordsBean.score==3)  { %> 
				<img src="images/yoda.png" height=150 width=200 align="right" />
				<% } else if ( wordsBean.score==4 || wordsBean.score==5)  { %>
				<img src="images/darth.png" height=150 width=200 align="right" />
				<% }%>

				<br>
				<h3>Time's Up!</h3>
				<a>Time Limit is 60 seconds only.</a> 
				<h3>List of other possible words:</h3>
				<%
					String[] listWordsArray = wordsBean.words;
					for(int i=1; i<listWordsArray.length; i++){
						out.println(listWordsArray[i]);
					}
				%>
		</div>
		<form action="index.jsp" class="col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">
		<br><input type="submit" value="Go Back to Menu" class="btn btn-primary btn-block"
						id="form-button"/><br>
		</form>
				<!-- action="initializegame.html" --><form action="initializegame.html" action="main-game.jsp"   class="col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">
		<br><input type="submit" value="New Game" class="btn btn-primary btn-block"
						id="form-button"/><br>
	</form>
			</div>
			</div>
			
		
</body>
</html>