<%-- 
    Document   : soldbyitems
    Created on : Mar 3, 2024, 6:00:15 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default Sold-card-table">
    <div class="card-header justify-content-between">
        <h2>Sold by Category</h2>
        <div class="tools">
            <button class="text-black-50 mr-2 font-size-20">
                <i class="mdi mdi-cached"></i>
            </button>
            <div class="dropdown show d-inline-block widget-dropdown">
                <a
                    class="dropdown-toggle icon-burger-mini"
                    href="#"
                    role="button"
                    id="dropdown-units"
                    data-bs-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
                    data-display="static"
                    ></a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item"><a href="#">Action</a></li>
                    <li class="dropdown-item">
                        <a href="#">Another action</a>
                    </li>
                    <li class="dropdown-item">
                        <a href="#">Something else here</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div
        class="card-body py-0 compact-units"
        data-simplebar
        style="height: 534px"
        >
        <table class="table">
            <tbody>
                <tr>
                    <td class="text-dark">Backpack</td>
                    <td class="text-center">9</td>
                    <td class="text-right">
                        33%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">T-Shirt</td>
                    <td class="text-center">6</td>
                    <td class="text-right">
                        150%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Coat</td>
                    <td class="text-center">3</td>
                    <td class="text-right">
                        50%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Necklace</td>
                    <td class="text-center">7</td>
                    <td class="text-right">
                        150%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Jeans Pant</td>
                    <td class="text-center">10</td>
                    <td class="text-right">
                        300%
                        <i
                            class="mdi mdi-arrow-down-bold text-danger pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Shoes</td>
                    <td class="text-center">5</td>
                    <td class="text-right">
                        100%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">T-Shirt</td>
                    <td class="text-center">6</td>
                    <td class="text-right">
                        150%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Watches</td>
                    <td class="text-center">18</td>
                    <td class="text-right">
                        160%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">Inner</td>
                    <td class="text-center">156</td>
                    <td class="text-right">
                        120%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
                <tr>
                    <td class="text-dark">T-Shirt</td>
                    <td class="text-center">6</td>
                    <td class="text-right">
                        150%
                        <i
                            class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                            ></i>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="card-footer d-flex flex-wrap bg-white">
        <a href="#" class="text-uppercase py-3">View Report</a>
    </div>
</div>