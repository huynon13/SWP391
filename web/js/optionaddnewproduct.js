/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function optionProduct() {
    var colors = document.getElementsByName("color");
    var sizes = document.getElementsByName("size");
    var quantity = document.getElementById("quantity");
    var tongHopOption = document.getElementById("tongHopOption");
    var giaTriCu = tongHopOption.value;

    var luaChonColor = '';
    var luaChonSize = '';
    var luaChonQuantity = '';
    for (let i = 0; i < colors.length; i++) {
        if (colors[i].checked === true) {
            luaChonColor = colors[i];
        }
    }

    for (let i = 0; i < sizes.length; i++) {
        if (sizes[i].checked === true) {
            luaChonSize = sizes[i];
        }
    }
    luaChonQuantity = quantity.value;
    if (luaChonColor != '' && luaChonSize != '' && luaChonQuantity != '') {
        tongHopOption.value += luaChonColor.value + "-" + luaChonSize.value + "-" + luaChonQuantity + "&";
        luaChonColor.checked = false;
        luaChonSize.checked = false;
        quantity.value = '';
    } else {
        window.alert("Vui lòng lựa chọn đầy đủ các trường thông tin: Color, Size, Quantity!");
    }
}

