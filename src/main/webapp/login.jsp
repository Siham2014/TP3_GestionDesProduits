<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">

</head>
<body>
   
    
    <% if(request.getAttribute("error") != null) { %>
    <div class="alert alert-danger text-center">
        <%= request.getAttribute("error") %>
    </div>
<% } %>

    <% if(request.getAttribute("success") != null) { %>
        <p style="color:green;"><%= request.getAttribute("success") %></p>
    <% } %>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-6">
 <h2 class="text-center"> Connectez-vous</h2>
  <div class="card">
   <form action="<%=request.getContextPath()%>/login" method="post">
   
   <div class="form-group mb-3">
     <label >Nom d'utilisateur : </label>
     <input type="text"  name="username" class="form-control" required> 
   </div>
   
   <div class=" form-group mb-3">
     <label >Mot de passe : </label>
     <input type="password"  name="password" class="form-control" required> 
   </div>
   
   <div class="form-group mb-3">
    <button type="submit" class="btn btn-success form-control">Connecter</button>
   </div>
   
   </form>
     <a href="<%=request.getContextPath()%>/register">Creer un compte</a>
  </div>
</div>

</div>
</div>
</body>
</html>