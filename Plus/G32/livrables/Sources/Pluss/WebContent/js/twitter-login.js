var width = 820;
var height= 580;
var left = (screen.width/2)-(width/2);

function loginTwitter() {
	window.open("https://pluss.ddns.net:8443/Pluss/Main?op=signInTwitter",
			"mywindow","menubar=0,resizable=0,scrollbars=no,width="+width+",height="+height+",status=0,toolbar=0,left="+left+",top=120");
}
	
function loginFacebook() {
	window.open("https://pluss.ddns.net:8443/Pluss/Main?op=signInFacebook",
			"mywindow","menubar=0,resizable=0,scrollbars=no,width="+width+",height="+height+",status=0,toolbar=0,left="+left+",top=120");
}