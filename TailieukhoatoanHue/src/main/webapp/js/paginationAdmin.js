/**
 * 
 */
var current_page = 1;
var records_per_page = 2;
var objJson = [ {
	adName : "AdName 1"
}, {
	adName : "AdName 2"
}, {
	adName : "AdName 3"
}, {
	adName : "AdName 4"
}, {
	adName : "AdName 5"
}, {
	adName : "AdName 6"
}, {
	adName : "AdName 7"
}, {
	adName : "AdName 5"
}, {
	adName : "AdName 6"
}, {
	adName : "AdName 7"
}, {
	adName : "AdName 8"
}, {
	adName : "AdName 9"
}, {
	adName : "AdName 10"
}, {
	adName : "AdName 11"
}

]; // Can be obtained from another source, such as your objJson variable






function firstPage(first) {
	if (first == "btn_first") {
		document.getElementById("1").classList.add("active");
		document.getElementById("5").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		document.getElementById("btn_next").style.visibility = "visible";
		document.getElementById("btn_prev").style.visibility = "hidden";
		if (objJson.length / records_per_page > 0) {
			document.getElementById("btn_next1").innerHTML = 1;
		}
		if (objJson.length / records_per_page > 1) {
			document.getElementById("btn_next2").innerHTML = 2;
		}

		if (objJson.length / records_per_page > 2) {
			document.getElementById("btn_next3").innerHTML = 3;
		}
		if (objJson.length / records_per_page > 3) {
			document.getElementById("btn_next4").innerHTML = 4;
		}
		if (objJson.length / records_per_page > 4) {
			document.getElementById("btn_next5").innerHTML = 5;
		}
		if (current_page > 1) {
			current_page = 1;
			changePage(current_page);
		}
	} 

}
function clickPage1(page1) {
	if (page1 == "btn_next1") {
		document.getElementById("1").classList.add("active");
		document.getElementById("5").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		document.getElementById("btn_next").style.visibility = "visible";
		if (parseInt(document.getElementById("btn_next1").innerHTML) == 1) {
			document.getElementById("btn_prev").style.visibility = "hidden";
		}

		if (current_page >= 1) {
			current_page = parseInt(document.getElementById("btn_next1").innerHTML);
			changePage(current_page);
		}
	} 

}
function clickPage2(page2) {
	if (page2 == "btn_next2") {
		document.getElementById("2").classList.add("active");
		document.getElementById("5").classList.remove("active");
		document.getElementById("1").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		document.getElementById("btn_prev").style.visibility = "visible";
		document.getElementById("btn_next").style.visibility = "visible";
		if (current_page >= 1) {
			current_page = parseInt(document.getElementById("btn_next2").innerHTML);
			changePage(current_page);
		}
	} 

}
function clickPage3(page3) {
	if (page3 == "btn_next3") {
		document.getElementById("btn_prev").style.visibility = "visible";
		document.getElementById("3").classList.add("active");
		document.getElementById("5").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("1").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		document.getElementById("btn_next").style.visibility = "visible";
		if (current_page >= 1) {
			current_page = parseInt(document.getElementById("btn_next3").innerHTML);
			changePage(current_page);
		}
	} 

}
function clickPage4(page4) {
	if (page4 == "btn_next4") {
		document.getElementById("btn_prev").style.visibility = "visible";
		document.getElementById("4").classList.add("active");
		document.getElementById("5").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("1").classList.remove("active");
		document.getElementById("btn_next").style.visibility = "visible";
		if (current_page >= 1) {
			current_page = parseInt(document.getElementById("btn_next4").innerHTML);
			changePage(current_page);
		}
	}

}
function clickPage5(page5) {
	if (page5 == "btn_next5") {
		document.getElementById("btn_prev").style.visibility = "visible";
		document.getElementById("5").classList.add("active");
		document.getElementById("1").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		if (parseInt(document.getElementById("btn_next5").innerHTML) >= Math
				.ceil(objJson.length / records_per_page)) {
			document.getElementById("btn_next").style.visibility = "hidden";
		}
		if (current_page >= 1) {
			current_page = parseInt(document.getElementById("btn_next5").innerHTML);
			changePage(current_page);
		}
	} 

}

function lastPage(last) {

	if (last == "btn_last") {
		document.getElementById("5").classList.add("active");
		document.getElementById("1").classList.remove("active");
		document.getElementById("2").classList.remove("active");
		document.getElementById("3").classList.remove("active");
		document.getElementById("4").classList.remove("active");
		document.getElementById("btn_next").style.visibility = "hidden";
		document.getElementById("btn_prev").style.visibility = "visible";
		if (objJson.length <= records_per_page) {
			document.getElementById("btn_next1").innerHTML = Math
					.ceil(objJson.length / records_per_page);
		} else if (Math.ceil(objJson.length / records_per_page) == 2) {
			document.getElementById("btn_next1").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 1;
			document.getElementById("btn_next2").innerHTML = Math
					.ceil(objJson.length / records_per_page);
		} else if (Math.ceil(objJson.length / records_per_page) == 3) {
			document.getElementById("btn_next1").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 2;
			document.getElementById("btn_next2").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 1;
			document.getElementById("btn_next3").innerHTML = Math
					.ceil(objJson.length / records_per_page);
		} else if (Math.ceil(objJson.length / records_per_page) == 4) {
			document.getElementById("btn_next1").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 3;
			document.getElementById("btn_next2").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 2;
			document.getElementById("btn_next3").innerHTML = Math
					.ceil(objJson.length / records_per_page) - 1;
			document.getElementById("btn_next4").innerHTML = Math
					.ceil(objJson.length / records_per_page);
		} else {

			if (objJson.length / records_per_page > 0) {
				document.getElementById("btn_next1").innerHTML = Math
						.ceil(objJson.length / records_per_page) - 4;
			}
			if (objJson.length / records_per_page > 1) {
				document.getElementById("btn_next2").innerHTML = Math
						.ceil(objJson.length / records_per_page) - 3;
			}

			if (objJson.length / records_per_page > 2) {
				document.getElementById("btn_next3").innerHTML = Math
						.ceil(objJson.length / records_per_page) - 2;
			}
			if (objJson.length / records_per_page > 3) {
				document.getElementById("btn_next4").innerHTML = Math
						.ceil(objJson.length / records_per_page) - 1;
			}
			if (objJson.length / records_per_page > 4) {
				document.getElementById("btn_next5").innerHTML = Math
						.ceil(objJson.length / records_per_page);
			}
			if (current_page >= 1) {
				current_page = Math.ceil(objJson.length / records_per_page);
				changePage(current_page);
			}
		}

	}
}
function prevPage(prev) {
	if (prev == "btn_prev") {
		document.getElementById("btn_next").style.visibility = "visible";
		var bien1 = parseInt(document.getElementById("btn_next1").innerHTML);

		if (current_page - 1 == 1) {
			document.getElementById("btn_prev").style.visibility = "hidden";
		}
		var bien2 = parseInt(document.getElementById("btn_next2").innerHTML);
		var bien3 = parseInt(document.getElementById("btn_next3").innerHTML);
		var bien4 = parseInt(document.getElementById("btn_next4").innerHTML);
		var bien5 = parseInt(document.getElementById("btn_next5").innerHTML);
		if (bien1 > 1) {
			document.getElementById("btn_next1").innerHTML = bien1 - 1;
			document.getElementById("btn_next2").innerHTML = bien2 - 1;
			document.getElementById("btn_next3").innerHTML = bien3 - 1;
			document.getElementById("btn_next4").innerHTML = bien4 - 1;
			document.getElementById("btn_next5").innerHTML = bien5 - 1;
		}
		if (current_page > 1) {
			current_page--;
			if(bien1==1){
				switch(current_page){
				case bien1 : document.getElementById("1").classList.add("active");
				document.getElementById("2").classList.remove("active");
				break;
				case bien2:document.getElementById("2").classList.add("active");
				document.getElementById("3").classList.remove("active");
				break;
				case bien3:document.getElementById("3").classList.add("active");
				document.getElementById("4").classList.remove("active");
				break;
				case bien4:document.getElementById("4").classList.add("active");
				document.getElementById("5").classList.remove("active");
				break;
				case bien5:document.getElementById("5").classList.add("active");
				
				break;
				}
				
			}
			changePage(current_page);

		}
	} 

}

function nextPage(next) {
	if (next == "btn_next") {
		document.getElementById("btn_prev").style.visibility = "visible";
		if ((current_page + 1) * records_per_page >= objJson.length) {
			document.getElementById("btn_next").style.visibility = "hidden";
		} else {
			document.getElementById("btn_next").style.visibility = "visible";
		}
		var bien3 = parseInt(document.getElementById("btn_next3").innerHTML);
		var bien1 = parseInt(document.getElementById("btn_next1").innerHTML);
		var bien2 = parseInt(document.getElementById("btn_next2").innerHTML);
		var bien4 = parseInt(document.getElementById("btn_next4").innerHTML);
		var bien5 = parseInt(document.getElementById("btn_next5").innerHTML);

		if (current_page <= numPages()) {
			if (bien5 < objJson.length / records_per_page) {
				document.getElementById("btn_next1").innerHTML = bien1 + 1;
				document.getElementById("btn_next2").innerHTML = bien2 + 1;
				document.getElementById("btn_next3").innerHTML = bien3 + 1;
				document.getElementById("btn_next4").innerHTML = bien4 + 1;
				document.getElementById("btn_next5").innerHTML = bien5 + 1;

			}
			current_page++;
			
			if((bien5+1)*records_per_page >objJson.length){
				switch(current_page){
				case bien1 : document.getElementById("1").classList.add("active");
				
				break;
				case bien2:document.getElementById("2").classList.add("active");
				document.getElementById("1").classList.remove("active");
				break;
				case bien3:document.getElementById("3").classList.add("active");
				document.getElementById("2").classList.remove("active");
				break;
				case bien4:document.getElementById("4").classList.add("active");
				document.getElementById("3").classList.remove("active");
				break;
				case bien5:document.getElementById("5").classList.add("active");
				document.getElementById("4").classList.remove("active");
				break;
				}
				
			}
			changePage(current_page);
			
			

		}
	}
	function changePage(page, bien3) {
		var btn_next = document.getElementById("btn_next");
		var btn_prev = document.getElementById("btn_prev");
		var listing_table = document.getElementById("listingTable");
		var page_span = document.getElementById("page");
		if (current_page * records_per_page < objJson.length) {
			page_span.innerHTML = current_page * records_per_page + "/"
					+ objJson.length;
		} else {
			page_span.innerHTML = objJson.length + "/" + objJson.length;
		}
		// Validate page
		if (page < 1)
			page = 1;
		if (page > numPages())
			page = numPages();
		listing_table.innerHTML = "";
		for (var i = (page - 1) * records_per_page; i < (page * records_per_page); i++) {
			listing_table.innerHTML += objJson[i].adName + "<br>";
		}

	}

	function numPages() {
		return Math.ceil(objJson.length / records_per_page);
	}

	window.onload = function() {
		changePage(1);
	};
	

}