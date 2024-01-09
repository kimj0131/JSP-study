const modiBtn = document.querySelector("#modiBtn");
const inputPassword = document.querySelector("#inputPassword");

const getHashedPassword = (password) => sha256(password).toUpperCase();
const checkHash = () => boardPassword === getHashedPassword(inputPassword.value);

modiBtn.addEventListener("click", (e) => {
	if (checkHash()) {
		location.href = "./modify?board_id=" + board_id;
	} else {
		alert("비밀번호가 틀렸습니다!");
	}
});

const delBtn = document.querySelector("#delBtn");
const delBtn2 = document.querySelector("#delBtn2");
//
const delForm = document.querySelector("#delForm");
const hiddenPassword = document.querySelector("#hiddenPassword");

delBtn.addEventListener("click", (e) => {
	// const option = "width=500,height=300,top=150,left=1000";
	// open("./delete?board_id=" + board_id, "_blank", option);

	// 풀이
	if (checkHash()) {
		hiddenPassword.value = getHashedPassword(inputPassword.value);
		delForm.submit();
	} else {
		alert("비밀번호가 틀렸습니다!");
	}
});

delBtn2.addEventListener("click", (e) => {
	const option = "width=500,height=300,top=150,left=1000";
	const popup = open("./delete/open", "_blank", option);
});
