function loginSuccess(result) {
	addCookie(cookie_key, result.data.id, 2);
	addCookie(userName, result.data.name, 2);
	addCookie(userFace, result.data.face, 2);
	location.href = "index.html";
}