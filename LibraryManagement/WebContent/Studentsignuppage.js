$(function(){
        $("input[type='text']").css("background-color","#EEF0F9");
        $("input[type='password']").css("background-color","#EEF0F9");

    });
    function validateform()
    {
        let name=document.myform.name.value;
        let username=document.myform.username.value;
        let password=document.myform.password.value;
        let cnfpassword=document.myform.cnfpassword.value;
        if(name==""||username==""||password==""||cnfpassword=="")
        {
            alert("* fields are required");
            return false;
        }
        else if(password.length<6 && cnfpassword.length<6)
        {
            alert("pasword must be of length 6");
            return false;
        }
        else if(password.length!=cnfpassword.length)
        {
            alert("password must be same length");
            return false;
        }
        else if(password!=cnfpassword)
        {
            alert("password does not match");
            return false;
        }
        return true;
        
}