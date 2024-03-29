<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/resources/css/main.css">
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body style="   background: linear-gradient(184deg, #242535 30%, #776bf6 138%);">
 
  
    <h1 class="sign_up_h1">수정하기</h1>
   
 
     <form action="/updateList" method="post" class="insert_form">
     
            
            <input type="text" name="postTitle" value="${requestScope.postTitle }" class="insert-text">
            <textarea style="resize:none;font-size:18px;"name="postContent" class="content_area" cols="25" rows="10" >${requestScope.postContent }</textarea>
            
      
            <input type="hidden" value="${postList.postNo }" name="hiddenPost">
            
            <button class="insert_btn">수정하기</button>
   
      </form>

      <button class="insert_btn update_reback" id="reback" onclick="history.back()">돌아가기</button>



</body>
</html>