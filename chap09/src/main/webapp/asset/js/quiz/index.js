console.log(document.cookie);
if (document.cookie != "ad=close") {
	open("./ad.jsp", "_blank", "width=580, height=840, top=80, left=100");
}
