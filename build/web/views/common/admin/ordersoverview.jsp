<%-- 
    Document   : ordersoverview
    Created on : Mar 3, 2024, 5:55:15 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default">
    <div class="card-header justify-content-center">
        <h2>Orders Overview</h2>
    </div>
    <div class="card-body">
        <canvas id="doChart"></canvas>
    </div>
    <a href="#" class="pb-5 d-block text-center text-muted"
       ><i class="mdi mdi-download mr-2"></i> Download overall
        report</a
    >
    <div class="card-footer d-flex flex-wrap bg-white p-0">
        <div class="col-6">
            <div class="p-20">
                <ul class="d-flex flex-column justify-content-between">
                    <li class="mb-2">
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #4c84ff"
                            ></i
                        >Order Completed
                    </li>
                    <li class="mb-2">
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #80e1c1"
                            ></i
                        >Order Unpaid
                    </li>
                    <li>
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #ff7b7b"
                            ></i
                        >Order returned
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-6 border-left">
            <div class="p-20">
                <ul class="d-flex flex-column justify-content-between">
                    <li class="mb-2">
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #8061ef"
                            ></i
                        >Order Pending
                    </li>
                    <li class="mb-2">
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #ffa128"
                            ></i
                        >Order Canceled
                    </li>
                    <li>
                        <i
                            class="mdi mdi-checkbox-blank-circle-outline mr-2"
                            style="color: #7be6ff"
                            ></i
                        >Order Broken
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>