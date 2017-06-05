<%-- 
    Document   : index
    Created on : Apr 27, 2017, 11:29:17 AM
    Author     : albertcahyawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Sales</title> 
        <!-- BOOTSTRAP STYLES-->
        <link href="./Assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="./Assets/css/font-awesome.css" rel="stylesheet" /> 
        <!-- CUSTOM STYLES-->
        <link href="./Assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.htm">Qino</a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> Last access : 17 May 2017 &nbsp; ${message} <a href="logout.htm" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="Assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <a class="active-menu" href="index.htm"><i class="fa fa-bar-chart-o fa-3x"></i>Sales</a>
                        </li>
                        <li>
                            <a  href="inventory.htm"><i class="fa fa-desktop fa-3x"></i>Inventory</a>
                        </li>
                        <li>
                            <a  href="employee.htm"><i class="fa fa-qrcode fa-3x"></i>Employee</a>
                        </li>
                        <li  >
                            <a  href="restaurant.htm"><i class="fa fa-edit fa-3x"></i> Restaurant </a>
                        </li>


                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" > 
                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-md-12">

                            <!-- Earning Start -->
                            <div class="col-md-4 col-sm-4">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Earning
                                    </div>
                                    <div class="panel-body"> 
                                        <p> Profit: Rp ${totalprofit} </p>
                                        <p> Cost: Rp ${totalcost}</p> 
                                        <hr /> 
                                        <p> Profit: Rp ${totalprofit} </p>
                                    </div>
                                    <div class="panel-footer">

                                    </div>
                                </div>
                                    
                                    <!-- Chart Start -->
 
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Chart
                                    </div>
                                    <div class="panel-chart-body">
                                        <img id="Chart" src="./Assets/img/graph.png" />
                                    </div>
                                    <div class="panel-footer">

                                    </div>
                                </div> 

                            <!-- Chart End -->
                                    
                            </div> 
                            <!--  Earning End -->

                            

                            <!-- Sales Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Sales Table
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example"> 
                                            <thead>
                                                <tr><th>ItemName</th>
                                                    <th>QuantitySold</th>
                                                    <th>NetSales</th>
                                                    <th>CostOfGood</th>
                                                    <th>GrossProfit</th>
                                                </tr>
                                            </thead>
                                            <tbody> 
                                                <c:forEach items="${users}" var="user">
                                                    <tr>
                                                        <td><c:out value="${user.username}"/></td>
                                                        <td><c:out value="${user.email}"/></td>
                                                        <td><c:out value="${user.phonenumber}"/></td>
                                                        <td><c:out value="${user.accessright}"/></td>
                                                        <td><c:out value="${user.accessright}"/></td>

                                                    </tr> 
                                                </c:forEach>   
                                                
                                                
                                            </tbody>
                                        </table>  
                                    </div>

                                </div>
                            </div>
                            <!--End Sales Tables -->

                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <hr /> 
                </div>
                <!-- /. PAGE INNER  --> 
            </div>


            <!-- /. PAGE WRAPPER  -->
        </div> 

    </body>
</html>


