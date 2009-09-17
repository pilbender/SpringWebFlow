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
			@import "featureexplorer/Dojo/Drag%20And%20Drop/dndDefault.css"
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
				left: 100px;
				top:  100px;
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
		<h1>Dojo Moveable test</h1>

		<table id="moveable1">
			<tr><td id="handle1" colspan="2">You can drag the table using this handle.</td></tr>
			<tr><td>1</td><td>Customer Id: ${customer.id}</td></tr>
			<tr><td>2</td><td>First Name: ${customer.firstName}</td></tr>
			<tr><td>3</td><td>Last Name: ${customer.lastName}</td></tr>
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

		<h3>No Dojo Effect Here</h3>
		Customer Id: ${customer.id} <br />
		Customer First Name: ${customer.firstName} <br />
		Customer Last Name: ${customer.lastName} <br />

	</body>
</html>
