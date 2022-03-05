<%@taglib prefix="m" uri="http://java.met.edu/BasicWebApp" %>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Visitor</h1>
		<b>Current Time: </b><m:clock format="hh:mm:ss a"/>
		<p>
			<b>WINNER: </b>
			<m:lotto id="digit" size="10">
				<i>${digit}</i>
			</m:lotto>
		</p>
	</body>
</html>

