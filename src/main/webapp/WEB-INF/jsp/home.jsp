<%-- 
    Document   : home
    Created on : Sep 13, 2009, 11:18:07 PM
    Author     : scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
	"http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
		<title>Dojo Toolkit Test Page</title>

		<!-- load the dojo toolkit base -->
		<script type="text/javascript" src="resources/dojo/dojo.js"></script>
		<script type="text/javascript" src="resources/dojo/dijit.js"></script>
		<script type="text/javascript" src="resources/dojo/dojox.js"></script>

		<style type="text/css">
			#desk {
				position: absolute;
				background: #fff;
				width:  20px;
				height: 20px;
				left: ${customer.leftPosition}px;
				top:  ${customer.topPosition}px;
				border: 2px solid black;
				cursor: pointer;
				radius:8pt;
				-moz-border-radius:8pt 8pt;
			}
		</style>
		<script type="text/javascript">
			dojo.require("dojo.dnd.Mover");
			dojo.require("dojo.dnd.Moveable");
			dojo.require("dojo.dnd.move");

			var x, y;
			var desk;
			var initDND = function(){
				desk = new dojo.dnd.Moveable("desk");

				dojo.subscribe("/dnd/move/start", function(mover){
					console.debug("Start move", mover);
				});
				dojo.subscribe("/dnd/move/stop", function(mover){
					console.debug("Stop move", mover);
					x = dojo.byId("desk").offsetLeft;
					y = dojo.byId("desk").offsetTop;
					dojo.byId("outputHere").innerHTML = "("+ x + "," + y + ")";
				});
			};
			dojo.addOnLoad(initDND);

		</script>

	</head>
	<body><!-- this is a Typical WebPage starting point ... -->
		<h1>Classroom</h1>

		<h3>Quick Dynamic Output</h3>
		Customer Id: ${customer.id} <br />
		Customer First Name: ${customer.firstName} <br />
		Customer Last Name: ${customer.lastName} <br />

		<div id="outputHere">
			New Coordinates Here
		</div>

		<form action="home.do" method="GET" enctype="multipart/form-data">
			<input type="text" name="leftPosition" value="${customer.leftPosition}" />
			<input type="text" name="topPosition" value="${customer.topPosition}" />
			<input type="submit" value="Save" />
		</form>

		<div id="desk"></div>
	</body>
</html>
