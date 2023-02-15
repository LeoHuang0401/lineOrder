
var liffID = '1657828282-o24PQdv3';

liff.init({
	liffId: liffID,
	// 自動進入登入 Line 帳號的登入流程
	withLoginOnExternalBrowser: true, // Enable automatic login process
}).then(function() {
	console.log('LIFF init');
	console.log('LIFF isLogin = ', liff.isLoggedIn());  // 判斷開啟此網頁的 LINE 使用者是否為登入狀態
	// 這邊開始寫使用其他功能
	
	if (liff.isLoggedIn()) {
		console.log('已登入');
		const idToken = liff.getDecodedIDToken();
		console.log('DecodedIDToken : ', idToken) // print decoded idToken object
	} else {
		console.log('未登入');
	}
	
	// 取得使用者公開資料
	liff.getProfile()
	console.log('LIFF Get User Profile : ', liff.getProfile());

	// 引用 LIFF SDK 的頁面，頁面中的 lang 值
	console.log('LIFF language : ', liff.getLanguage());

	// LIFF SDK 的版本
	console.log('LIFF version : ', liff.getVersion());

	// 回傳是否由 LINE App 存取
	console.log('LIFF inClient : ', liff.isInClient);

	// 使用者是否登入 LINE 帳號
	console.log('LIFF loggedIn : ', liff.isLoggedIn);

	// 回傳使用者作業系統：ios、android、web
	console.log('LIFF OS : ', liff.getOS());

	// 使用者的 LINE 版本
	console.log('LIFF Line Version : ', liff.getLineVersion());
	
	
	

}).catch(function(error) {
	console.log(error);
});




