<jsp:useBean id="ctr" class="basic.web.app.CounterBean" scope="session"/>
<jsp:setProperty name="ctr" property="step" value="10"/>
<jsp:useBean id="greeter" class="basic.web.app.GreeterBean" scope="application"/>
<jsp:setProperty name="greeter" property="*"/>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>${greeter.message}</h1>
		<b>Number of greetings: </b>${ctr.nextCount}
		<hr/>
		<form method="POST">
			<p>
				<b>Person:</b>
				<input type="text" name="person"/>
			</p>
			<p>
				<b>Period:</b>
				<select name="period">
					<option>Night</option>
					<option>Morning</option>
					<option>Afternoon</option>
					<option>Evening</option>
				</select>
			</p>
			<input type="submit" value="Greet"/>
		</form>
	</body>
</html>

