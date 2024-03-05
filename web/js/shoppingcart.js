/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function xacNhanXoaKhiThayDoiSoLuongVe0(i) {
    var form = document.getElementById("f");
    var soLuong_raw = document.getElementById("quantity" + i).value;
    var soLuong = parseInt(soLuong_raw, 10);

    if (soLuong == 1) {

    } else {
        form.submit();
    }
}


function deleteProduct() {
    var form = document.getElementById("f");
    if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này không!!!")) {
        form.submit();
    }
}

function clearAll() {
    var form = document.getElementById("fclear");
    if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này không!!!")) {
        form.submit();
    }
}