/**
 * 
 */
// Returns an array of maxLength (or less) page numbers
// where a 0 in the returned array denotes a gap in the series.
// Parameters:
//   totalPages:     total number of pages
//   page:           current page
//   maxLength:      maximum size of returned array
function getPageList(totalPages, page, maxLength) {
  if (maxLength < 5) throw "maxLength must be at least 5";

  function range(start, end) {
    return Array.from(Array(end - start + 1), (_, i) => i + start);
  }

  var sideWidth = maxLength < 9 ? 1 : 2;
  var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
  var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
  if (totalPages <= maxLength) {
    // no breaks in list
    return range(1, totalPages);
  }
  if (page <= maxLength - sideWidth - 1 - rightWidth) {
    // no break on left of page
    return range(1, maxLength - sideWidth - 1)
      .concat([0])
      .concat(range(totalPages - sideWidth + 1, totalPages));
  }
  if (page >= totalPages - sideWidth - 1 - rightWidth) {
    // no break on right of page
    return range(1, sideWidth)
      .concat([0])
      .concat(
        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
      );
  }
  // Breaks on both sides
  return range(1, sideWidth)
    .concat([0])
    .concat(range(page - leftWidth, page + rightWidth))
    .concat([0])
    .concat(range(totalPages - sideWidth + 1, totalPages));
}

$(function() {
  // Number of items and limits the number of items per page
  var numberOfItems = $("#jar .content").length;
  var limitPerPage = 6	;
  // Total pages rounded upwards
  var totalPages = Math.ceil(numberOfItems / limitPerPage);
  // Number of buttons at the top, not counting prev/next,
  // but including the dotted buttons.
  // Must be at least 5:
  var paginationSize = 5;
  var currentPage;

  function showPage(whichPage) {
    if (whichPage < 1 || whichPage > totalPages) return false;
    currentPage = whichPage;
    $("#jar .content")
      .hide()
      .slice((currentPage - 1) * limitPerPage, currentPage * limitPerPage)
      .show();
    // Replace the navigation items (not prev/next):
    $(".pagination li").slice(1, -1).remove();
    getPageList(totalPages, currentPage, paginationSize).forEach(item => {
      $("<li>")
        .addClass(
          "page-item " +
            (item ? "current-page " : "") +
            (item === currentPage ? "active " : "")
        )
        .append(
          $("<a>")
            .addClass("page-link")
            .attr({
              href: "javascript:void(0)"
            })
            .text(item || "...")
        )
        .insertBefore("#next-page");
    });
    return true;
  }

  // Include the prev/next buttons:
  $(".pagination").append(
    $("<li>").addClass("page-item").attr({ id: "previous-page" }).append(
      $("<a>")
        .addClass("page-link")
        .attr({
          href: "javascript:void(0)"
        })
        .text("Prev")
    ),
    $("<li>").addClass("page-item").attr({ id: "next-page" }).append(
      $("<a>")
        .addClass("page-link")
        .attr({
          href: "javascript:void(0)"
        })
        .text("Next")
    )
  );
  
  // Show the page links
  $("#jar").show();
  showPage(1);

  // Use event delegation, as these items are recreated later
  $(
    document
  ).on("click", ".pagination li.current-page:not(.active)", function() {
    return showPage(+$(this).text());
  });
  $("#next-page").on("click", function() {
    return showPage(currentPage + 1);
  });

  $("#previous-page").on("click", function() {
    return showPage(currentPage - 1);
  });
  $(".pagination").on("click", function() {
    $("html,body").animate({ scrollTop: 0 }, 0);
  });
});
function getPageList1(totalPages, page, maxLength) {
	  if (maxLength < 5) throw "maxLength must be at least 5";

	  function range(start, end) {
	    return Array.from(Array(end - start + 1), (_, i) => i + start);
	  }

	  var sideWidth = maxLength < 9 ? 1 : 2;
	  var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
	  var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
	  if (totalPages <= maxLength) {
	    // no breaks in list
	    return range(1, totalPages);
	  }
	  if (page <= maxLength - sideWidth - 1 - rightWidth) {
	    // no break on left of page
	    return range(1, maxLength - sideWidth - 1)
	      .concat([0])
	      .concat(range(totalPages - sideWidth + 1, totalPages));
	  }
	  if (page >= totalPages - sideWidth - 1 - rightWidth) {
	    // no break on right of page
	    return range(1, sideWidth)
	      .concat([0])
	      .concat(
	        range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages)
	      );
	  }
	  // Breaks on both sides
	  return range(1, sideWidth)
	    .concat([0])
	    .concat(range(page - leftWidth, page + rightWidth))
	    .concat([0])
	    .concat(range(totalPages - sideWidth + 1, totalPages));
	}
//cái 2
//All the JS code to append markup for the search and pagination links is in this file.
//Create pagination links depending on the number of students. We want 10 max per page.
//The first 10 students are shown when the page loads, and each pagination link displays the correct students.
//Clicking on “1” in the pagination links should should show students 1 to 10, etc...
//The correct HTML markup gets appended in the correct place (see filter-example.html) when the page loads.
//Searching is not case sensitive, you can type "Delano" or "delano"
//When the search button is pressed, the results should show up.
//Pagination links should update depending on the number of search results. 

//get all the main elements on the page
var page = document.querySelector(".page");
var pageHeader = document.querySelector(".page-header");
var studentList = document.querySelector(".student-list");
var eachStudent = document.querySelectorAll(".student-item");
var studentDetails = document.querySelector(".student-details");
var navlink = document.querySelector('.navlink');

//Set the pages variable
var currentPage = 1;
var numPages = 5;
var studentsPerPage = 5;
var index;


//Recreate Search Element in Js
var searchBar = function createBar (searchString) {

	var studentSearch = document.createElement("div");
	var input = document.createElement("input");
	var searchButton = document.createElement("button");

	input.type="text";

	var txtNode = document.createTextNode("Search");
	if ( typeof txtNode == "object" ) {
		searchButton.appendChild(txtNode);
	}

	studentSearch.setAttribute("class", "student-search");
	input.setAttribute("id", "inputSearch");
	searchButton.setAttribute("id", "search-button");
	
	//append these elements to the page
	studentSearch.appendChild(input);
	studentSearch.appendChild(searchButton);

	input.placeholder = "Type name here..";

	return studentSearch;
}

//Recreate pagination system in Js
var paginationFilter = function pageFilter (nbOfEntries) {
	var pagination = document.createElement('div');
	var ulList = document.createElement('ul');
	var liList = document.createElement('li');
	var pageLink = document.createElement('a');

	pagination.setAttribute("class", "pagination");
	pageLink.setAttribute("class", "navlink");
	pageLink.setAttribute("href", "#");

	pagination.appendChild(ulList);
	ulList.appendChild(liList);
	liList.appendChild(pageLink);

	return pagination;	
};

//Finding the number of students
var numberOfStudents = function () {
	var numberOfStudents = eachStudent.length;
	return (numberOfStudents);
}

//Finding the number of pages
var numberOfPages = function () {
	var numberOfPages = parseInt(numberOfStudents() / studentsPerPage);
	if ( numberOfStudents() % studentsPerPage > 0 ){
		numPages += 1;
	}
	return numberOfPages;
}
//Hiding all the students
var hideAll = function () {
	for (var i = 0; i < numberOfStudents(); i++) {
		eachStudent[i].style.display = "none";
	}
};

//Display only the 10 first items on the page
function showStudents (number) {
	for (var i = 0; i < studentsPerPage; i++) {
		index = number * studentsPerPage - studentsPerPage + i;
		eachStudent[index].style.display = "block";
		console.log(index);
	} 
};



function createPages () {
	for (var i = 0; i <= numberOfPages(); i++) {
		page.appendChild(paginationFilter());
		var navlink = document.getElementsByClassName(".navlink");
		var linkText = document.createTextNode(i);
		//navlink.appendChild('linkText');
		console.log(linkText);
	}
};


function changePage (pageNumber) {
	var studentList = student
//number multiplies like a template in the show student function in order 
}

var searchFunction = function searchFeature(searchString) {
	console.log("Is my search feature working?");
	//Get the value entered in the search box
	var inputString = document.getElementById('inputSearch');
	//var stringValue = inputString.value;
	//Onkeyup we want to filter the content by the string entered in the search box

	inputString.onkeyup = function() {
			//toUpperCase to make it case insensitive
			var filter = inputString.value.toUpperCase();
		//loop through all the lis 
		for (var i = 0; i < eachStudent.length; i++) {
			//Do this for all the elements (h3, email, joined-details, date)
			var tagName = document.getElementsByTagName("h3");
			var studentInfo = eachStudent[i].innerText;
			/*console.log(studentInfo, filter, studentInfo.toUpperCase().indexOf(filter));*/
			//display all the results where indexOf() does not return -1
			if (studentInfo.toUpperCase().indexOf(filter) != -1)  {
				eachStudent[i].style.display = 'list-item';
			} else {
				eachStudent[i].style.display = 'none';
			}
		}
	}
}


function addElements() {
	console.log('Add search bar, trying to anyway...')
	pageHeader.appendChild(searchBar());
	var searchButton = document.getElementById("search-button");
	searchButton.addEventListener("click", searchFunction);
	
	createPages();
}

function changePage (number) {
	document.addEventListener( "DOMContentLoaded", hideAll());
	document.addEventListener( "DOMContentLoaded", showStudents(number));
}

changePage(1);


window.onload = addElements();
window.onload = searchFunction();


