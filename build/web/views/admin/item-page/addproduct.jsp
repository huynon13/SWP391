<%-- 
    Document   : addproduct
    Created on : Mar 7, 2024, 8:19:55 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template." />

        <title>Dashboard Add Product</title>

        <!-- GOOGLE FONTS -->
        <link rel="preconnect" href="https://fonts.googleapis.com/" />
        <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;600;700;800&amp;family=Poppins:wght@300;400;500;600;700;800;900&amp;family=Roboto:wght@400;500;700;900&amp;display=swap"
            rel="stylesheet"
            />

        <link
            href="${pageContext.request.contextPath}/css/materialdesignicons.min.css"
            rel="stylesheet"
            />

        <!-- PLUGINS CSS STYLE -->
        <link href="${pageContext.request.contextPath}/css/simplebar.css" rel="stylesheet" />

        <!-- ekka CSS -->
        <link id="ekka-css" rel="stylesheet" href="${pageContext.request.contextPath}/css/ekka.css" />

        <!-- FAVICON -->
        <link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />
    </head>

    <body
        class="ec-header-fixed ec-sidebar-fixed ec-sidebar-dark ec-header-light"
        id="body"
        >
        <!-- WRAPPER -->
        <div class="wrapper">
            <!-- LEFT MAIN SIDEBAR -->
            <jsp:include page="../../common/admin/leftmainsidebar.jsp"></jsp:include>

                <!-- PAGE WRAPPER -->
                <div class="ec-page-wrapper">
                    <!-- Header -->
                <jsp:include page="../../common/admin/header.jsp"></jsp:include>

                    <!-- CONTENT WRAPPER -->
                    <div class="ec-content-wrapper">
                        <div class="content">
                            <div
                                class="breadcrumb-wrapper d-flex align-items-center justify-content-between"
                                >
                                <div>
                                    <h1>Add Product</h1>
                                    <p class="breadcrumbs">
                                        <span><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></span>
                                    <span><i class="mdi mdi-chevron-right"></i></span>Product
                                </p>
                            </div>
                            <div>
                                <a href="${pageContext.request.contextPath}/views/admin/item-page/productlist.jsp" class="btn btn-primary">
                                    View All
                                </a>
                            </div>
                        </div>
                        <form id="f" action="${pageContext.request.contextPath}/addproduct" method="get" class="row g-3">

                            <div class="row">
                                <div class="col-12">
                                    <div class="card card-default">
                                        <div class="card-header card-header-border-bottom">
                                            <h2>Add Product</h2>
                                            <span style="color: green; margin-left: 20px">${requestScope.addProductSucc}</span>
                                        </div>

                                        <div class="card-body">
                                            <div class="row ec-vendor-uploads">
                                                <div class="col-lg-4">
                                                    <div class="ec-vendor-img-upload">
                                                        <div class="ec-vendor-main-img">

                                                            <div class="avatar-upload">
                                                                <div class="avatar-edit">
                                                                    <input
                                                                        type="file"
                                                                        name="image"
                                                                        id="imageUpload"
                                                                        class="ec-image-upload"
                                                                        accept=".png, .jpg, .jpeg"
                                                                        />
                                                                    <label for="imageUpload"
                                                                           ><img
                                                                            src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                            class="svg_img header_svg"
                                                                            alt="edit"
                                                                            /></label>
                                                                </div>
                                                                <div class="avatar-preview ec-preview">
                                                                    <div class="imagePreview ec-div-preview">
                                                                        <img
                                                                            class="ec-image-preview"
                                                                            src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-preview.jpg"
                                                                            alt="edit"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="thumb-upload-set colo-md-12">

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload01"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload02"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload03"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload04"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload05"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload06"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload06"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload06"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="thumb-upload">
                                                                    <div class="thumb-edit">
                                                                        <input
                                                                            type="file"
                                                                            name="image"
                                                                            id="thumbUpload06"
                                                                            class="ec-image-upload"
                                                                            accept=".png, .jpg, .jpeg"
                                                                            />
                                                                        <label for="imageUpload"
                                                                               ><img
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/edit.svg"
                                                                                class="svg_img header_svg"
                                                                                alt="edit"
                                                                                /></label>
                                                                    </div>
                                                                    <div class="thumb-preview ec-preview">
                                                                        <div class="image-thumb-preview">
                                                                            <img
                                                                                class="image-thumb-preview ec-image-preview"
                                                                                src="${pageContext.request.contextPath}/images/upload-preview/vender-upload-thumb-preview.jpg"
                                                                                alt="edit"
                                                                                />
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-8">
                                                    <div class="ec-vendor-upload-detail">

                                                        <div class="col-md-6">
                                                            <label class="form-label">Select Category</label>
                                                            <select name="category" id="Categories" class="form-select">
                                                                <c:forEach items="${sessionScope.categoryAll}" var="category">
                                                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>

                                                        <div style="margin-top: 30px " class="col-md-6">
                                                            <label class="form-label">Select Supperlier</label>
                                                            <select name="supperlier" id="supperlier" class="form-select">
                                                                <c:forEach items="${sessionScope.supperlierAll}" var="supperlier">
                                                                    <option value="${supperlier.supperlierId}">${supperlier.company_name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>

                                                        <div style="margin-top: 30px " class="col-md-12">
                                                            <label for="inputEmail4" class="form-label"
                                                                   >Product name</label
                                                            >
                                                            <input
                                                                type="text"
                                                                name="productName"
                                                                class="form-control slug-title"
                                                                id="productName"
                                                                />
                                                        </div>

                                                        <div  style="margin-top: 30px " class="col-md-12">
                                                            <label class="form-label">Sort Description</label>
                                                            <textarea
                                                                class="form-control"
                                                                rows="2"
                                                                name="sortDescription"
                                                                ></textarea>
                                                        </div>

                                                        <div style="margin-top: 30px " class="col-md-12 mb-25">
                                                            <label class="form-label">Colors</label>
                                                            <c:forEach items="${sessionScope.colorAll}" var="color">
                                                                <div class="form-check form-check-inline">
                                                                    <input 
                                                                        type="radio"
                                                                        name="color"
                                                                        id="color${color.colorId}"
                                                                        value="${color.color}"
                                                                        />
                                                                    <label for="color${color.colorId}">${color.color}</label>
                                                                </div>

                                                            </c:forEach>

                                                        </div>
                                                        <div style="margin-top: 30px "  class="col-md-12 mb-25">
                                                            <label style="margin-right: 13.5px " class="form-label">Size</label>
                                                            <c:forEach items="${sessionScope.sizeAll}" var="size">
                                                                <div class="form-check form-check-inline">
                                                                    <input
                                                                        type="radio"
                                                                        name="size"
                                                                        id="size${size.sizeId}"
                                                                        value="${size.sizeOption}"
                                                                        />
                                                                    <label for="size${size.sizeId}">${size.sizeOption}</label>
                                                                </div>
                                                            </c:forEach>
                                                        </div>

                                                        <div class="col-md-12">
                                                            <label class="form-label">Quantity</label>
                                                            <input
                                                                type="number"
                                                                class="form-control"
                                                                name="quantity"
                                                                id="quantity"
                                                                value=""
                                                                />
                                                        </div>

                                                        <div class="col-md-6">
                                                            <button onclick="optionProduct()" style="margin-top: 30px;" type="button" class="btn btn-primary">
                                                                Apply
                                                            </button>
                                                        </div>

                                                        <div style="margin-top: 30px " class="col-md-6">
                                                            <label class="form-label"
                                                                   >Price <span>( In VNĐ )</span></label
                                                            >
                                                            <input
                                                                type="number"
                                                                class="form-control"
                                                                name="price"
                                                                id="price"
                                                                />
                                                        </div>

                                                        <div style="margin-top: 30px " class="col-md-6">
                                                            <label class="form-label"
                                                                   >Discount <span>(0-100)</span></label
                                                            >
                                                            <input
                                                                type="number"
                                                                class="form-control"
                                                                name="discount"
                                                                id="discount"
                                                                />
                                                        </div>



                                                        <div style="margin-top: 30px " class="col-md-12">
                                                            <label class="form-label">Product Tags</label>

                                                            <textarea
                                                                rows="2"
                                                                style="height: 200px"
                                                                readonly
                                                                type="text"
                                                                class="form-control"
                                                                id="tongHopOption"
                                                                name="optionLuaChon"
                                                                value=""
                                                                ></textarea>

                                                        </div>

                                                        <div style="margin-top: 30px" class="col-md-12">
                                                            <button onclick="submitForm()" type="button" class="btn btn-primary">
                                                                Submit
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- End Content -->
                </div>
                <!-- End Content Wrapper -->

                <!-- Footer -->
                <jsp:include page="../../common/admin/footer.jsp"></jsp:include>
                </div>
                <!-- End Page Wrapper -->
            </div>
            <!-- End Wrapper -->

            <!-- Common Javascript -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-tagsinput.js"></script>
        <script src="${pageContext.request.contextPath}/js/simplebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/optionaddnewproduct.js"></script>
        <!-- Option Switcher -->
        <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
    </body>

</html>
