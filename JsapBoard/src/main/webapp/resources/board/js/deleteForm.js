opener.console.log("팝업열림");

const confirmBtn = document.querySelector("#confirmBtn");
const inputPassword = document.querySelector("#inputPassword");

// detail에 있는 delForm을 불러옴
const delForm = opener.document.querySelector("#delForm");

const checkHash = () => boardPassword === sha256(inputPassword.value).toUpperCase();

confirmBtn.addEventListener("click", (e) => {
	if (checkHash()) {
		delForm.submit();
		alert("삭제되었습니다");
		close();
	} else {
		alert("비밀번호가 틀렸습니다");
	}
});

const closeBtn = document.querySelector("#closeBtn");
closeBtn.addEventListener("click", (e) => {
	close();
});
