

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="Servlet" method="POST">
            <h1>Login</h1>
            <input type="text" name="name">
            <input type="password" name="password">
            <input type="submit" value="Aceptar">
        </form>
        <a href="Registro.jsp">Registro</a>
    </body>
</html>
