<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/main.css">

<meta charset="UTF-8">
<title>추가하기</title>
</head>

<h1 class="sign_up_h1">추가하기</h1>
<body style="   background: linear-gradient(184deg, #242535 30%, #776bf6 138%);"> 
            <form action="/insert" method="post" class="insert_form">
             
              <input type="text" name="inputTitle" placeholder="제목을 입력하세요" class="insert-text" style="color:white"> 
              <textarea name="inputContent" style="resize:none;font-size:18px;color:white" placeholder="내용을 입력하세요" cols="25" rows="10" class="content_area"></textarea>
            
            <button class="insert_btn">추가하기</button>
            
            </form>
        
              <button class="insert_btn insert_reback" id="reback"  onclick="history.back()">돌아가기</button>
          
                 
</body>
</html>