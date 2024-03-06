<%-- 
    Document   : useractivity
    Created on : Mar 3, 2024, 5:56:10 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default" id="user-activity">
    <div class="no-gutters">
        <div>
            <div class="card-header justify-content-between">
                <h2>User Activity</h2>
                <div class="date-range-report">
                    <span></span>
                </div>
            </div>
            <div class="card-body">
                <div class="tab-content" id="userActivityContent">
                    <div
                        class="tab-pane fade show active"
                        id="user"
                        role="tabpanel"
                        >
                        <canvas id="activity" class="chartjs"></canvas>
                    </div>
                </div>
            </div>
            <div
                class="card-footer d-flex flex-wrap bg-white border-top"
                >
            </div>
        </div>
    </div>
</div>