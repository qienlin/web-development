jQuery(document).ready(function() {
	jQuery.get("/web-development/ajax/books", function(data, status) {
		var domParser = new  DOMParser();
        var xmlDoc = domParser.parseFromString(data,'text/xml');
        var elements = xmlDoc.getElementsByTagName("book");
		for (var i = 0; i < elements.length; i++) {
			var name = elements[i].getElementsByTagName("name")[0].firstChild.nodeValue;
			var age = elements[i].getElementsByTagName("age")[0].firstChild.nodeValue;
			alert(name+" "+age);
		}
	});
	jQuery("button").click(function() {
		jQuery.get("/web-development/ajax/TestServlet?name=Daniel", function(data, status) {
			jQuery("#myDiv").text(data);
		});
	});
});

function loadXMLDoc() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "/web-development/ajax/TestServlet?name=Daniel");
	xmlhttp.send();
}
