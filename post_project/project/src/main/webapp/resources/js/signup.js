const signUp = {
    "inputId" : false,
    "inputPw" : false,
    "inputPw2" : false,
    "inputName" : false,


};


const inputId = document.getElementById("inputId");
const checkId = document.getElementById("checkId");

inputId.addEventListener("keyup", function(){
 
  const regtest = /^[a-z][\w]{3,10}$/;

  if(regtest.test(this.value)){
    checkId.innerText = "정상입력";
    checkId.style.color ="green";
    signUp.inputId = true;
  }else{
    checkId.innerText = "비정상입력";
    checkId.style.color = "red";
    signUp.inputId = false;
  }
 

});

const inputPw = document.getElementById("inputPw");
const inputPw2 = document.getElementById("inputPw2");
const pwMessage = document.getElementById("pwMessage");

inputPw2.addEventListener("keyup", function(){

  if(inputPw.value.length == 0){
     this.value = "";
     alert("비밀번호를 먼저 입력");
     inputPw.focus();
     signUp.inputPw = false;
  }

});

inputPw.addEventListener("keyup", function(){

  if(  (this.value == inputPw2.value) && this.value.length != 0 ){
    pwMessage.style.color = "green";
    pwMessage.innerText = "비밀번호가 일치합니다";
    signUp.inputPw = true;
    signUp.inputPw2 = true;

  }else{
    pwMessage.style.color = "red";
    pwMessage.innerText = "비밀번호가 일치하지않습니다";
    signUp.inputPw = false;
    signUp.inputPw2 = false;
  }

});


inputPw2.addEventListener("keyup", function(){

  if(  (this.value == inputPw2.value) && this.value.length != 0 ){
    pwMessage.style.color = "green";
    pwMessage.innerText = "비밀번호가 일치합니다";
    signUp.inputPw = true;
    signUp.inputPw2 = true;

  }else{
    pwMessage.style.color = "red";
    pwMessage.innerText = "비밀번호가 일치하지않습니다";
    signUp.inputPw = false;
    signUp.inputPw2 = false;
  }

});

const inputName = document.getElementById("inputName");
const nameMessage = document.getElementById("nameMessage");

inputName.addEventListener("keyup", function(){
 
  const regtest = /^[ㄱ-힣]{2,5}$/;

  if(regtest.test(this.value)){
      nameMessage.innerText = "정상입력됨";
      signUp.inputName = true;
      nameMessage.style.color = "green";
  }else{
    nameMessage.innerText = "비정상";
    signUp.inputName = false;
    nameMessage.style.color = "red";
  }

})

function check(){
  for(let key in signUp){
    if(!signUp[key]){
        alert("유효성 검사 실패");
        return false;
    }
  }
  return true;
};




