<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-md-6">
 <h2 class="text-center"> Inscrivez-vous</h2>
  <div class="card">
   <form action="<%=request.getContextPath()%>/register" method="post">
 
   
   <div class="form-group mb-3">
     <label >Nom d'utilisateur : </label>
     <input type="text"  name="username" class="form-control" required> 
   </div>
   
   <div class=" form-group mb-3">
     <label >Mot de passe : </label>
     <input type="password"  name="password" class="form-control" required> 
   </div>
   
   <div class="form-group mb-3">
    <button type="submit" class="btn btn-success form-control">Créer</button>
   </div>
   </form>
  </div>
</div>

</div>
</div>

</body>
</html>