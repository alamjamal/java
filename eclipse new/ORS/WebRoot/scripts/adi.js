/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 10;

function isNumber(s1)
{   
	
var s=s1.value;
	var i;
var name=s1.name;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) 
		{
			alert(name+" -------------------Please Enter a Number");
			s1.focus();
			return false;
	}
	
   
	}
    // All characters are numbers.
    return true;
}

function isInteger(s)
{   
	
	var i;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
s=stripCharsInBag(strPhone,validWorldPhoneChars);
return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function ValidateForm(){
	var Phone=document.register.phoneNo
	
	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
		Phone.value=""
		Phone.focus()
		return false
	}
	return true
 }
function showStatus()
{

var form = document.register;
var selectWidget = document.forms.register.elements["addressType"];
 
var myValue = document.getElementById("addresstype").value;

 if(myValue=="home")
 {

   document.register.home.value+=myValue;
 document.register.hno.value+= document.register.houseNo.value;
document.register.street.value+=document.register.sstreet.value;  

 
 
 document.register.country.value+= document.register.scountry.value;
document.register.pin.value+=document.register.spin.value;
  document.register.state.value+=document.register.sstate.value;
 document.register.phone.value+=document.register.phoneNo.value;
document.register.city.value+=document.register.scity.value
}
else if(myValue=="office")
{
  document.register.office.value+=myValue
 document.register.ohno.value+= document.register.houseNo.value
document.register.ostreet.value+=document.register.sstreet.value  
 document.register.ocountry.value+= document.register.scountry.value
document.register.opin.value+=document.register.spin.value
  document.register.ostate.value+=document.register.sstate.value
 document.register.ophone.value+=document.register.phoneNo.value
document.register.ocity.value+=document.register.scity.value

 
 
}
else if(myValue=="personal")
{
 document.register.contact.value+=myValue
 document.register.chno.value+= document.register.houseNo.value
document.register.cstreet.value+=document.register.sstreet.value  
 document.register.ccountry.value+= document.register.scountry.value
document.register.cpin.value+=document.register.spin.value
  document.register.cstate.value+=document.register.sstate.value
 document.register.cphone.value+=document.register.phoneNo.value
document.register.ccity.value+=document.register.scity.value

 
  
}
return true;
}
function checkconformpassword()
{
var password=register.password.value;
var conformpassword=register.conformpassword.value

if(password!=conformpassword)
{
alert("ConformPassword does not matche with Password");
return false;
}
return true;
}

function cleartext()
{

document.register.houseNo.value="";
document.register.sstate.value= "";

document.register.sstreet.value="";
document.register.scountry.value="";
document.register.spin.value= "";
document.register.phoneNo.value="";
document.register.scity.value= "";

return " ";
}
function Encrypt(theText){
output = new String;
Temp = new Array();
Temp2 = new Array();
TextSize = theText.length;
for (i = 0; i < TextSize; i++){
rnd = Math.round(Math.random() * 122) + 68;
Temp[i] = theText.charCodeAt(i) + rnd;
Temp2[i] = rnd;
}
for (i = 0; i < TextSize; i++) {
output += String.fromCharCode(Temp[i], Temp2[i]);
}
return output;
}

function strValidate(string)
{
var string1=string.value
	 
	 var testName =/^([a-z]|[A-Z]| )*$/;
		
    if(!testName.test(string1))
    {
	 alert(string.name    +    "Enter only string values");
string.focus();
        return false; 
		}
		
	
		return true;
}
function abc()
{
	
	var form=document.register
	
	form.city.focus();
	return false;
	return true;
	
}
function abc1()
{
	
	var form=document.register
	form.squest.focus();
	return false;
	return true;
}

