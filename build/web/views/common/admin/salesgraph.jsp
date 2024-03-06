<%-- 
    Document   : salesgraph
    Created on : Mar 3, 2024, 5:54:27 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="user-acquisition" class="card card-default">
    <div class="card-header">
        <h2>Sales Report</h2>
    </div>
    <div class="card-body">
        <ul
            class="nav nav-tabs nav-style-border justify-content-between justify-content-lg-start border-bottom"
            role="tablist"
            >
            <li class="nav-item">
                <a
                    class="nav-link active"
                    data-bs-toggle="tab"
                    href="#todays"
                    role="tab"
                    aria-selected="true"
                    >Today's</a
                >
            </li>
            <li class="nav-item">
                <a
                    class="nav-link"
                    data-bs-toggle="tab"
                    href="#monthly"
                    role="tab"
                    aria-selected="false"
                    >Monthly
                </a>
            </li>
            <li class="nav-item">
                <a
                    class="nav-link"
                    data-bs-toggle="tab"
                    href="#yearly"
                    role="tab"
                    aria-selected="false"
                    >Yearly</a
                >
            </li>
        </ul>
        <div class="tab-content pt-4" id="salesReport">
            <div
                class="tab-pane fade show active"
                id="source-medium"
                role="tabpanel"
                >
                <div class="mb-6" style="max-height: 247px">
                    <canvas id="acquisition" class="chartjs2"></canvas>
                    <div id="acqLegend" class="customLegend mb-2"></div>
                </div>
            </div>
        </div>
    </div>
</div>
