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
			#moveable1 {
				background: #fff;
				border: 1px solid black;
				padding:8px;
			}
			#handle1 {
				background: #333;
				color: #fff;
				font-weight: bold;
				cursor: pointer;
				border: 1px solid black;
			}
			#moveable2 {
				position: absolute;
				background: #fff;
				width:  200px;
				height: 200px;
				left: ${customer.leftPosition}px;
				top:  ${customer.topPosition}px;
				padding: 10px 20px;
				margin: 10px 20px;
				border: 10px solid black;
				cursor: pointer;
				radius:8pt;
				-moz-border-radius:8pt 8pt;
			}
			#moveable3 {
				position: relative;
				width: 150px;
				height: 100px;
				background: #ff8;
				color: blue;
				font-weight: bold;
			}
		</style>
		<script type="text/javascript">
			dojo.require("dojo.dnd.Mover");
			dojo.require("dojo.dnd.Moveable");
			dojo.require("dojo.dnd.move");

			var x, y;
			var m1, m2;
			var initDND = function(){
				m1 = new dojo.dnd.Moveable("moveable1", {handle: "handle1"});
				m2 = new dojo.dnd.Moveable("moveable2");
				m3 = new dojo.dnd.Moveable("moveable3");

				dojo.subscribe("/dnd/move/start", function(mover){
					console.debug("Start move", mover);
				});
				dojo.subscribe("/dnd/move/stop", function(mover){
					console.debug("Stop move", mover);
					x = dojo.byId("moveable2").offsetLeft;
					y = dojo.byId("moveable2").offsetTop;
					dojo.byId("outputHere").innerHTML = "("+ x + "," + y + ")";
				});

				dojo.connect(m1, "onMoveStart", function(mover){
					console.debug("Start moving m1", mover);
				});
				dojo.connect(m1, "onMoveStop", function(mover){
					console.debug("Stop moving m1", mover);
				});
			};
			dojo.addOnLoad(initDND);

		</script>

	</head>
	<body><!-- this is a Typical WebPage starting point ... -->
		<h1>Dojo Moveable Test</h1>

		<h3>No Dojo Effects Here</h3>
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

		<table id="moveable1">
			<tr><td id="handle1" colspan="2">You can drag the table using this handle.</td></tr>
			<tr><td>Customer Id:</td><td>${customer.id}</td></tr>
			<tr><td>First Name:</td><td>${customer.firstName}</td></tr>
			<tr><td>Last Name:</td><td>${customer.lastName}</td></tr>
		</table>

		<div id="moveable2">
			<div>
				Customer Id: ${customer.id} <br />
				Customer First Name: ${customer.firstName} <br />
				Customer Last Name: ${customer.lastName} <br />
			</div>
			<div>You can drag this whole object around.</div>
			<div id="moveable3">You can move this paragraph. It is relatively positioned.</div>
		</div>
	</body>
</html>
