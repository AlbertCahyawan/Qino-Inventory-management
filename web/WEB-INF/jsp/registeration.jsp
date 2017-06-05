<%-- 
    Document   : registration
    Created on : May 14, 2017, 9:53:49 PM
    Author     : albertcahyawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registeration</title>
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
  <div class="container">
    <div class="row text-center  ">
      <div class="col-md-12">
        <br /><br />
        <h2> Qino : Register ${message}</h2>
        
        <br />
      </div>
    </div>
    <div class="row">
     
      <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
        <div class="panel panel-default">
          <div class="panel-heading">
            <strong>  New User ? Register Yourself </strong>  
          </div>
          <div class="panel-body">
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
                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                <input type="password" name="password" class="form-control" placeholder="Enter Password" />
              </div>
              <div class="form-group input-group">
                <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                <input type="password" name="retypepassword" class="form-control" placeholder="Retype Password" />
              </div>
              
              <input type="submit" class="btn btn-success " value="Register"/>
              <hr />
              Already Registered ?  <a href="loginForm.htm" >Login here</a>
            </form>
          </div>
          
        </div>
      </div>
      
      
    </div>
  </div> 
</body>
</html>