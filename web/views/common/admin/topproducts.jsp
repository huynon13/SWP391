<%-- 
    Document   : topproducts
    Created on : Mar 3, 2024, 6:02:07 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default ec-card-top-prod">
    <div class="card-header justify-content-between">
        <h2>Top Products</h2>
        <div>
            <button class="text-black-50 mr-2 font-size-20">
                <i class="mdi mdi-cached"></i>
            </button>
            <div class="dropdown show d-inline-block widget-dropdown">
                <a
                    class="dropdown-toggle icon-burger-mini"
                    href="#"
                    role="button"
                    id="dropdown-product"
                    data-bs-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
                    data-display="static"
                    >
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item">
                        <a href="#">Update Data</a>
                    </li>
                    <li class="dropdown-item">
                        <a href="#">Detailed Log</a>
                    </li>
                    <li class="dropdown-item">
                        <a href="#">Statistics</a>
                    </li>
                    <li class="dropdown-item">
                        <a href="#">Clear Data</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="card-body mt-10px mb-10px py-0">
        <div class="row media d-flex pt-15px pb-15px">
            <div
                class="col-lg-3 col-md-3 col-2 media-image align-self-center rounded"
                >
                <a href="#"
                   ><img
                        src="assets/img/products/p1.jpg"
                        alt="customer image"
                        /></a>
            </div>
            <div
                class="col-lg-9 col-md-9 col-10 media-body align-self-center ec-pos"
                >
                <a href="#">
                    <h6 class="mb-10px text-dark font-weight-medium">
                        Baby cotton shoes
                    </h6>
                </a>
                <p class="float-md-right sale">
                    <span class="mr-2">58</span>Sales
                </p>
                <p class="d-none d-md-block">
                    Statement belting with double-turnlock hardware adds
                    “swagger” to a simple.
                </p>
                <p class="mb-0 ec-price">
                    <span class="text-dark">$520</span>
                    <del>$580</del>
                </p>
            </div>
        </div>
        <div class="row media d-flex pt-15px pb-15px">
            <div
                class="col-lg-3 col-md-3 col-2 media-image align-self-center rounded"
                >
                <a href="#"
                   ><img
                        src="assets/img/products/p2.jpg"
                        alt="customer image"
                        /></a>
            </div>
            <div
                class="col-lg-9 col-md-9 col-10 media-body align-self-center ec-pos"
                >
                <a href="#">
                    <h6 class="mb-10px text-dark font-weight-medium">
                        Hoodies for men
                    </h6>
                </a>
                <p class="float-md-right sale">
                    <span class="mr-2">20</span>Sales
                </p>
                <p class="d-none d-md-block">
                    Statement belting with double-turnlock hardware adds
                    “swagger” to a simple.
                </p>
                <p class="mb-0 ec-price">
                    <span class="text-dark">$250</span>
                    <del>$300</del>
                </p>
            </div>
        </div>
        <div class="row media d-flex pt-15px pb-15px">
            <div
                class="col-lg-3 col-md-3 col-2 media-image align-self-center rounded"
                >
                <a href="#"
                   ><img
                        src="assets/img/products/p3.jpg"
                        alt="customer image"
                        /></a>
            </div>
            <div
                class="col-lg-9 col-md-9 col-10 media-body align-self-center ec-pos"
                >
                <a href="#">
                    <h6 class="mb-10px text-dark font-weight-medium">
                        Long slive t-shirt
                    </h6>
                </a>
                <p class="float-md-right sale">
                    <span class="mr-2">10</span>Sales
                </p>
                <p class="d-none d-md-block">
                    Statement belting with double-turnlock hardware adds
                    “swagger” to a simple.
                </p>
                <p class="mb-0 ec-price">
                    <span class="text-dark">$480</span>
                    <del>$654</del>
                </p>
            </div>
        </div>
    </div>
</div>