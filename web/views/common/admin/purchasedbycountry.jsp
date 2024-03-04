<%-- 
    Document   : purchasedbycountry
    Created on : Mar 3, 2024, 5:58:32 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default" id="analytics-country">
    <div class="card-header justify-content-between">
        <h2>Purchased by Country</h2>
        <div class="date-range-report">
            <span></span>
        </div>
    </div>
    <div class="card-body vector-map-world-2">
        <div
            id="regions_purchase"
            style="height: 100%; width: 100%"
            ></div>
    </div>
    <div class="border-top mt-3">
        <div class="row no-gutters">
            <div class="col-lg-6">
                <div
                    class="world-data-chart border-bottom pt-15px pb-15px"
                    >
                    <canvas id="hbar1" class="chartjs"></canvas>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="world-data-chart pt-15px pb-15px">
                    <canvas id="hbar2" class="chartjs"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer d-flex flex-wrap bg-white">
    </div>
</div>
