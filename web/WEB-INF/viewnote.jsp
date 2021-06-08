<%-- 
    Document   : viewnote
    Created on : Jun 3, 2021, 11:19:53 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form method="post" action="note">
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title:</h3>
        <div><p>${note.title}</p></div>
       
        <h3>Contents: </h3>  
        <p>${note.contents}</p>
        
        <br>
        

        </form>
        
           <a href="note?edit">Edit</a>
    </body>
</html>
