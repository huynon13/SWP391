/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteCategory(address, name) {
    if(confirm('Are you sure you want to delete Category: ' + name + '?')){
        console.log(window.location.host + address);
        window.location.href = address;
    }
}

