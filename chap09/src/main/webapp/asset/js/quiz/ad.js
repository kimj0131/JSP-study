const chk1 = document.getElementById("chk1");

addEventListener("beforeunload", (e) => {
	opener.console.log(chk1.checked);
	if (chk1.checked) {
		opener.location.replace("./adStop");
	}
});
