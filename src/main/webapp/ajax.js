jQuery(document).ready(function() {
	loadPagingBooks(jQuery("#currentPage").text());
	jQuery("#previous").click(function(){
		loadPagingBooks(parseInt(jQuery("#currentPage").text()) - 1);
	});
	jQuery("#next").click(function(){
		loadPagingBooks(parseInt(jQuery("#currentPage").text()) + 1);
	});
});

function loadPagingBooks(page) {
	jQuery("#bookTable tbody tr:not(:first)").remove();
	jQuery("#bookTable").css("visibility", "hidden");
	jQuery("body").removeClass("loaded");
	jQuery.ajax({
		url : "/web-development/ajax/books",
		data : {
			"page" : page
		},
		type : "POST",
		timeout : 5000,
		success : function(data) {
			jQuery("#currentPage").text(new DOMParser().parseFromString(data,'text/xml').getElementsByTagName("page")[0].firstChild.nodeValue);
			var totalPages = new DOMParser().parseFromString(data,'text/xml').getElementsByTagName("totalPages")[0].firstChild.nodeValue;
			jQuery("#totalPage").text(totalPages);
			jQuery("#next").show();
			jQuery("#previous").show();
			if(parseInt(jQuery("#currentPage").text()) <= 1){
				jQuery("#previous").hide();
			}else if(parseInt(jQuery("#currentPage").text()) >= parseInt(totalPages)){
				jQuery("#next").hide();
			}
			var elements = new DOMParser().parseFromString(data,'text/xml').getElementsByTagName("book");
			for (var i = 0; i < elements.length; i++) {
				var tr = jQuery("#bookTable tbody tr:first").clone().show();
				jQuery(tr).find("td.id").html(elements[i].getElementsByTagName("id")[0].firstChild.nodeValue);
				jQuery(tr).find("td.name").html(elements[i].getElementsByTagName("name")[0].firstChild.nodeValue);
				jQuery(tr).find("td.price").html(elements[i].getElementsByTagName("price")[0].firstChild.nodeValue);
				jQuery(tr).find("td.isbn").html(elements[i].getElementsByTagName("isbn")[0].firstChild.nodeValue);
				jQuery("tbody").append(tr);
			}
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
