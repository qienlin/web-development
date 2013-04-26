   jQuery(document).ready(function() {
	loadPagingBooks(jQuery("#currentPage").text());
//	jQuery.get("/web-development/ajax/books", function(data, status) {
//		var domParser = new  DOMParser();
//        var xmlDoc = domParser.parseFromString(data,'text/xml');
//        var elements = xmlDoc.getElementsByTagName("book");
//		for (var i = 0; i < elements.length; i++) {
////			var name = elements[i].getElementsByTagName("name")[0].firstChild.nodeValue;
////			var age = elements[i].getElementsByTagName("age")[0].firstChild.nodeValue;
//			//alert(name+" "+age);
//		}
//	});
	jQuery("button").click(function() {
		jQuery.get("/web-development/ajax/TestServlet?name=Daniel", function(data, status) {
			jQuery("#myDiv").text(data);
		});
	});
	
	jQuery("#previous").click(function(){
		loadPagingBooks(parseInt(jQuery("#currentPage").text()) - 1);
	});
	jQuery("#next").click(function(){
		loadPagingBooks(parseInt(jQuery("#currentPage").text()) + 1);
	});
});

function loadPagingBooks(page) {
	jQuery("#bookTable").css("visibility", "hidden");
	jQuery("body").removeClass("loaded");
	jQuery.ajax({
		url : "/web-development/ajax/TestServlet",
		data : {
			"page" : page
		},
		type : "POST",
		timeout : 1500,
		success : function(data) {
//			 alert(data);
			jQuery("body").addClass("loaded");
			jQuery("#bookTable").css("visibility", "visible");
		},
		error : function() {
			jQuery("body").addClass("loaded");
			jQuery("#books").css("text-align", "center").html(
					"Request timeout...");
		}
	});
}

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
