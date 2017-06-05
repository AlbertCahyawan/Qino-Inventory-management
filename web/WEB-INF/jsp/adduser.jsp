<%-- 
Document   : adduser
Created on : Apr 27, 2017, 11:29:17 AM
Author     : albertcahyawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a  href="inventory.htm"><i class="fa fa-desktop fa-3x"></i>Inventory</a>
                        </li>
                        <li>
                            <a  class="active-menu" href="employee.htm"><i class="fa fa-qrcode fa-3x"></i>Employee</a>
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
                            <form role="form">
                                <br/>

                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                    <input type="text" name="name" class="form-control" placeholder="Name" />
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="text" name="email" class="form-control" placeholder="Email" />
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon">@</span>
                                    <input type="text" name="phone" class="form-control" placeholder="PhoneNumber" />
                                </div>

                                <div class="form-group input-group">
                                    <span class="input-group-addon">@</span>
                                    <select name="AccessRight">
                                        <option value="Admin">Admin</option>
                                        <option value="Manager">Manager</option>
                                        <option value="Staff">Staff</option> 
                                    </select>
                                </div>

                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                    <input type="password" name="password" class="form-control" placeholder="Enter Password" />
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                    <input type="password" name="retypepassword" class="form-control" placeholder="Retype Password" />
                                </div>

                                <input type="submit" class="btn btn-success " value="Save"/>
                                <hr /> 
                            </form>
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
