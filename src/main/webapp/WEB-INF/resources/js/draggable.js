/*
    Document   : draggable
    Created on : Sep 24, 2009, 11:49:51 AM
    Author     : Richard Scott Smith <rsmith@harriscomputer.com>
    Description:
        Purpose of the stylesheet follows.
*/

drag = function(obj){
	dojo.require("dojo.dnd.Mover");
	dojo.require("dojo.dnd.Moveable");
	dojo.require("dojo.dnd.move");

	obj = new dojo.dnd.Moveable(obj);

	dojo.subscribe("/dnd/move/stop", function(mover){
		console.debug("Stop move", mover);
		x = dojo.byId("desk").offsetLeft;
		y = dojo.byId("desk").offsetTop;
		console.log("Inside the subscribe dojo.move.stop function.");
	});

	return {
		x:x,
		y:y
	}
};

dojo.addOnLoad(drag);