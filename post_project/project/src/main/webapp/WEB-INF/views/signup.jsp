<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  
   <link rel="stylesheet" href="/resources/css/main.css">
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body style="   background: linear-gradient(184deg, #242535 30%, #776bf6 138%);">





   <main>
   
    <h1 class="sign_up_h1">회원가입</h1>
    
    <form action="/signup" method="post" class="signup-form" onsubmit="return check()">
     
       <div class="flex_box">
         <input type="text" name="inputId" required autocomplete="off" id="inputId" placeholder="아이디를 입력하세요" style="color:white;background:transparent" class="input-size">
       <span id="checkId" class="span_check"></span>
       </div>

       
       
       <input type="password" name="inputPw" required id="inputPw"placeholder="비밀번호를 입력하세요" style="color:white;background:transparent;height:30px">
       
      <div class="flex_box">
         <input type="password" name="inputPw2" required id="inputPw2"placeholder="비밀번호 재확인" style="color:white;background:transparent" class="input-size">
         <span id="pwMessage" class="span_check"></span>
      </div>

      <div class="flex_box">
         <input type="inputName" name="inputName" id="inputName" required placeholder="이름을 입력하세요(2~5글자)" style="color:white;background:transparent" class="input-size">
         <span id="nameMessage" class="span_check"></span>
      </div>
       
      
       
     
       
       <button class="insert_btn">가입하기</button>
      
    </form>
  
<button class="insert_btn" id="reback" onclick="history.back()">돌아가기</button>

   </main>
   
   <script src="/resources/js/signup.js"></script>
    
</body>
</html>