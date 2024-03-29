<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="body">
  

   
  <div class="main_box">
     
  
     
     
    <c:choose>
      <c:when test="${empty sessionScope.loginMember}">
        <%-- 로그인되지 않은 경우 --%>

        <div class="star">
          <p class="p">G</p>
         
             </div>

        <form action="login" method="post" class="form">
          <input type="text" name="inputId" class="input-btn" placeholder="userId"><br>
          <input type="password" name="inputPw" class="input-btn" placeholder="Password"><br>
          <button class="btn">로그인</button>
        </form>
        
        <a href="/signup" class="signup">회원가입</a>
        
      </c:when>
      
      <c:otherwise>
        <%-- 로그인된 경우 --%>
        
        
        <c:choose>
         
          <c:when test="${empty postList }">
          
           <h2 class="empty_h2">작성한 글이 없습니다</h2>
          
          </c:when>
          
          <c:otherwise>
          
         
          <h1 style="text-align: center;color:white;margin-bottom:50px;font-size:50px">  ${loginMember.memberName }의 좋아하는 노래 순위</h1>
          
           <table>
 
             <tr>
<td class="td_head_font">번호</td>
<td class="td_head_font">제목</td>
<td class="td_head_font">가사</td>
<td class="td_head_font">날짜</td>

             </tr>
          

              <c:forEach var="st" items="${postList }">
               
            <tr>
              <td class="td1"> ${st.postNo } </td>
              <td class="td2">  ${st.postTitle } </td>
              <td class="td3">  ${st.postContent } </td>
              <td class="td4">  ${st.postDate }</td>

              <td> <a href="/updateList?postNo=${st.postNo}" class="a_tag_btn" id="sujeong-btn">수정하기</a></td>
              <td> <a href="/deleteList?postNo=${st.postNo}" onclick="return confirm('정말 삭제하시겠습니까?')" class="a_tag_btn" id="delete-btn">삭제하기</a></td>


            </tr>
              

       
           
         
           
          
                
               
              
                
             
             
                 
            
             </c:forEach>

           
  
           </table>
        
           
           
           
          
          </c:otherwise>
           
           
        
        </c:choose>
        <a href="/insert" class="addbtn">추가하기</a>
        <a href="logout" class="logOut">로그아웃</a>
        
        
        
        
        
        
        
        
      </c:otherwise>
    </c:choose>

  </div>
  
 
   
   
   
   <c:if test="${not empty sessionScope.message }">
   
      <script>
       
      alert("${message}")
        
      </script>
      
      <c:remove var="message" scope="session"/>
   
   </c:if>
   
</body>
</html>