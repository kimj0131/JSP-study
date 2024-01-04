// opener : open() 함수를 통해 이 창을 연 부모의 window 객체

console.log(opener);

const btn1 = document.querySelector("#btn1");
const btn2 = document.querySelector("#btn2");

const btn3 = opener.document.querySelector("#btn1");

btn1.addEventListener("click", (e) => {
	opener.document.body.style.backgroundColor = "black";
	opener.document.body.style.color = "white";
});

btn2.addEventListener("click", (e) => {
	btn3.style.fontSize = "30px";
});
