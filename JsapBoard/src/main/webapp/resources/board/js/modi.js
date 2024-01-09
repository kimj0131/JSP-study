const modiConfirmBtn = document.querySelector("#modiConfirmBtn");
const modiForm = document.querySelector("#modiForm");
const listBtn = document.querySelector("#listBtn");

const validateForm = () => {
	if (modiForm.elements.board_title.value.trim() == "") {
		alert("제목이 비어있습니다!");
		return false;
	} else if (modiForm.elements.board_content.value.trim() == "") {
		alert("내용이 비어있습니다!");
		return false;
	}
	return true;
};

// 이 폼에서 submit이 발생하는 경우 실행되는 이벤트
modiForm.addEventListener("submit", (e) => {
	if (!validateForm()) {
		e.preventDefault(); // 기본 동작을 막는다 (submit 중단)
	}
});

// 버튼을 눌렀을 때 이벤트
modiConfirmBtn.addEventListener("click", (e) => {
	console.dir(modiForm);
	// form.elements : form에 소속되어있는 요소들, name을 통해 한 요소를 선택할 수 있다
	console.log(modiForm.elements);
	console.log(modiForm.elements.board_title);
	validateForm() ? modiForm.submit() : 0;
});
