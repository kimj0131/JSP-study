<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Tap 기능 만들어보기</title>
		<style>
			.tabContent {
				border: solid 1px black;
				display: none;
			}

			.show {
				display: block;
			}

			#toppings {
				display: grid;
				grid-template-columns: 1fr 1fr 1fr 1fr;
			}

			#toppings > div {
				border: 1px orange solid;
				height: 100px;
			}

			#sauces {
				display: grid;
				grid-template-columns: 1fr 1fr 1fr 1fr;
			}

			#sauces > div {
				border: 1px red solid;
				height: 200px;
			}

			#cheeses {
				display: grid;
				grid-template-columns: 1fr 1fr 1fr 1fr;
			}

			#cheeses > div {
				border: 1px yellow solid;
				height: 200px;
			}
		</style>
	</head>
	<body>
		<div>
			<button onclick="showTab(0)" class="tabBtn">토핑</button>
			<button onclick="showTab(1)" class="tabBtn">소스</button>
			<button onclick="showTab(2)" class="tabBtn">치즈</button>

			<div id="topping" class="tabContent">
				<div id="toppings">
					<div>
						1
						<input type="checkbox" name="topping" />
					</div>
					<div>토핑2</div>
					<div>토핑3</div>
					<div>4</div>
					<div>5</div>
					<div>6</div>
					<div>7</div>
					<div>8</div>
				</div>
			</div>
			<div id="sauce" class="tabContent show">
				<div id="sauces">
					<div>1</div>
					<div>2</div>
					<div>3</div>
					<div>4</div>
				</div>
			</div>
			<div id="cheese" class="tabContent">
				<div id="cheeses">
					<div>1</div>
					<div>2</div>
					<div>3</div>
					<div>4</div>
				</div>
			</div>
		</div>

		<script>
			const toppingTab = document.getElementById("topping");
			const sauceTab = document.getElementById("sauce");
			const cheeseTab = document.getElementById("cheese");

			const tabs = [toppingTab, sauceTab, cheeseTab];

			function showTab(index) {
				for (let i = 0; i < tabs.length; i++) {
					if (i == index) {
						tabs[i].classList.add("show");
					} else {
						tabs[i].classList.remove("show");
					}
				}
			}
		</script>
	</body>
</html>
