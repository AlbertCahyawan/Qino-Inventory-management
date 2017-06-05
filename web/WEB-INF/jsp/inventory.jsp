<%-- 
    Document   : inventory
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
        <title>Inventory</title>
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
                     font-size: 16px;"> Last access : 17 May 2017 &nbsp; <a href="logout.htm" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="Assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <a  href="index.htm"><i class="fa fa-bar-chart-o fa-3x"></i>Sales</a>
                        </li>
                        <li>
                            <a class="active-menu" href="inventory.htm"><i class="fa fa-desktop fa-3x"></i>Inventory</a>
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
                    <!-- User Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Item Tables <a href="additem.htm" class="btn btn-success ">ADD Item</a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr><th>Item Num</th>
                                            <th>Item Name</th>
                                            <th>Item Price</th>
                                            <th>Item Cost</th>
                                            <th>Item Category</th>
                                            <th>Item Quantity</th>
                                        </tr>
                                    </thead>
                                    <tbody>  
                                        <c:forEach items="${Items}" var="items">
                                            <tr> 
                                                <td><c:out value="${items.uid}"/></td>
                                                <td><c:out value="${items.itemName}"/></td>
                                                <td><c:out value="${items.itemPrice}"/></td> 
                                                <td><c:out value="${items.itemCost}"/></td> 
                                                <td><c:out value="${items.itemCategory}"/></td>
                                                <td><c:out value="${items.quantity}"/></td>
                                                <td><a href="edititem.htm?itemid=${items.uid}&itemname=${items.itemName}&itemcategory=${items.itemCategory}&itemprice=${items.itemPrice}&itemcost=${items.itemCost}&quantity=${items.quantity}&minquantity=${items.minimumQuantity}"><img src="./Assets/img/edit.png" class="user-icon"/></a>
                                                    <a href="deleteitem.htm?itemid=${items.uid}&itemname=${items.itemName}"><img src="./Assets/img/delete.png" class="user-icon"/></a>
                                                </td>
                                            </tr> 
                                        </c:forEach>
                                    </tbody> 
                                </table> 
                            </div>

                        </div>
                    </div>
                    <!--End User Tables -->
                    <hr /> 
                </div>
                <!-- /. PAGE INNER  --> 
            </div>


            <!-- /. PAGE WRAPPER  -->
        </div> 

    </body>
</html>
