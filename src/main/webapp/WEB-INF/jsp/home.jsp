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

		<script type="text/javascript">
			/* Put JavaScript here */

			dojo.require("dojo.NodeList-fx");
			dojo.addOnLoad(function(){
				// our dom is ready, get the node:
				dojo.query("#testHeading")
				.addClass("testClass") // adds class="testClass"
				.fadeOut({ delay:500 }).play(); // and fade it out after 500 ms
			});

			dojo.require("dojo.NodeList-fx");
			dojo.addOnLoad(function(){
				// get each element with class="para"
				dojo.query(".para")
				.addClass("testClass")
				.fadeOut({ delay: 1000 }).play();
			});
		</script>

		<style type="text/css">
			/* Put CSS here */
			.testClass {
				color:#ff0000;
			}
		</style>
    </head>
    <body><!-- this is a Typical WebPage starting point ... -->
        <h1 id="testHeading">Dojo Skeleton Page</h1>
		<div id="contentNode">
			<p>Some Content To Replace</p>
			<a class="link" href="#">First link</a>
			<a class="link" href="#">Second Link</a>

			<p class="para">First paragraph</p>
			<p class="para">Second paragraph</p>
			<p class="para">Third paragraph</p>
		</div>

		Customer Id: ${customer.id} <br />
		Customer First Name: ${customer.firstName} <br />
		Customer Last Name: ${customer.lastName} <br />
    </body>
</html>
