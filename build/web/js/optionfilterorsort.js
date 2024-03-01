/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//console.log("Loc cute");

function optionSort() {
    var form = document.getElementById("f");
    var formQuery = document.getElementById("search-product");
    var selected = document.getElementById("orderBy");

    var query = document.getElementById("query").value;
    if (query !== "") {
        window.location.href = "search?query=" + query + "&orderBy=" + selected.value;
    } else {
        f.submit();
    }
}



