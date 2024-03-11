/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var colorId = null;
var sizeId = null;
function userOptionColor(element, id, pid) {
    // Lấy danh sách tất cả các phần tử li trong cùng danh sách
    var listItems = element.parentNode.getElementsByTagName('li');
    var form = document.getElementById("f");
    for (var i = 0; i < listItems.length; i++) {
        listItems[i].classList.remove('selected');
    }

    element.classList.add('selected');
    colorId = id;
    console.log(sizeId);
    console.log(colorId);
    if (sizeId != null && colorId != null) {
        f.action = "productdetail?colorid=" + colorId + "&sizeid=" + sizeId + "&productid=" + pid;
        colorId = null;
        sizeId = null;
        f.submit();
    }
}


function userOptionSize(element, id, pid) {
// Lấy danh sách tất cả các phần tử li trong cùng danh sách
    var listItems = element.parentNode.getElementsByTagName('li');
    var form = document.getElementById("f");
    for (var i = 0; i < listItems.length; i++) {
        listItems[i].classList.remove('selected');
    }

// Thêm lớp 'selected' cho phần tử được click
    element.classList.add('selected');
    sizeId = id;
    console.log(sizeId);
    console.log(colorId);
    if (sizeId != null && colorId != null) {
        f.action = "productdetail?colorid=" + colorId + "&sizeid=" + sizeId + "&productid=" + pid;
        colorId = null;
        sizeId = null;
        f.submit();
    }
}

var currentURL = window.location.href;
var url = new URL(currentURL);
colorId = url.searchParams.get("colorid");
if (colorId == null) {
    colorId = url.searchParams.get("cid");
}
sizeId = url.searchParams.get("sizeid");
if (sizeId == null) {
    sizeId = url.searchParams.get("sid");
}
var productId = url.searchParams.get("productid");
if(productId == null){
    var productId = url.searchParams.get("pid");
}

if (colorId != null && sizeId != null) {
    var colors = document.getElementsByClassName("colors");
    console.log(colors)
    for (var i = 0; i < colors.length; i++) {
        if (colors[i].classList[0] == 'color' + colorId) {
            colors[i].classList.add('selected');
        } else {
            colors[i].classList.remove('selected');
        }
    }

    var sizes = document.getElementsByClassName("sizes");
    console.log(colors)
    for (var i = 0; i < sizes.length; i++) {
        if (sizes[i].classList[0] == 'size' + sizeId) {
            sizes[i].classList.add('selected');
        } else {
            sizes[i].classList.remove('selected');
        }
    }

}












