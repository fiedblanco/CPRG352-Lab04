<%-- 
    Document   : editnote
    Created on : Jun 3, 2021, 11:20:14 PM
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
        <form  method="post" action="note" >

            <h1>Simple Note Keeper</h1>
            <h3>Edit Note</h3>

            <label for="titleEdit">Title:</label>
            <input type="text" name="titleEdit" value="${note.title}" > 

            <br>

            <h4>Contents:</h4>
            <textarea name="contentEdit"> ${note.contents}</textarea>
            <br>

            <input type="submit" value="Save">
        </form>
    </body>
</html>
