//null
function Name1Check(){
	var name1 = document.getElementById('name1').value;
}
//null
function Name2Check(){
	var name2 = document.getElementById('name2').value;
}
//null
function Name3Check(){
	var name3 = document.getElementById('name3').value;
}
//null
function Name4Check(){
	var name4 = document.getElementById('name4').value;
}
//null
function NickCheck(){
	var name5 = document.getElementById('nickname').value;
}
//null
function YubinCheck(){
	var name6 = document.getElementById('zipcode').value;
}
//null
function Shi1Check(){
	var name7 = document.getElementById('addr1').value;
}
//null
function Shi2Check(){
	var name9 = document.getElementById('addr2').value;
}
//電話番号最初の桁
function Number1Check(){
	var name10 = document.getElementById('tel1').value;
	if( name10.match( /[^0-9]+/ ) ) {
		alert("年齢は、半角数字のみで入力して下さい。");
      	return 1;
    }
	else if(name10.length != 3 || name10 != 4 ){
			alert("年齢は、半角数字のみで入力して下さい。");
      		return 1;
	}
   
   	return 0;
}
//電話番号の真ん中の桁
function Number2Check(){
	var name11 = document.getElementById('tel2').value;
	if( name11.match( /[^0-9]+/ ) ) {
		alert("年齢は、半角数字のみで入力して下さい。");
      	return 1;
    }
	else if(name11.length !=  || name11.length != 4){
			alert("年齢は、半角数字のみで入力して下さい。");
      		return 1;
	}
   
   	return 0;
}
//電話番号の最後の桁
function Number3Check(){
	var name12 = document.getElementById('tel3').value;
	if(StringLength(name12,1,4) == false){
		
	}
}
//null
function mail1Check(){
	var name13 = document.getElementById('email').value;
}
//null
function mail2Check(){
	var name14 = document.getElementById('email2').value;
}
//null
function pass1Check(){
	var name15 = document.getElementById('pass1').value;
}
//null
function pass2Check(){
	var name16 = document.getElementById('pass2').value;
}
function AllCheck(){
	var check = 0;
	if( check > 0 ) {
      return false;
   }
   return check;
}
function StringLength(input,min,max){
	var i = input.length;
	if(i < min){
		return false;
	}
	if (i > max){
		return false;
	}
	return true;

}