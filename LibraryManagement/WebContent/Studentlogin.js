
function validateform() {
        var name=document.forms["myform"]["username"].value;
        var password=document.myform.password.value;

        if(name=="" && password==""){
            alert("* fields are required");
            return false;
        }
        else if(name==null || name=="")
        {
            alert("name must be there");
            return false;
        }
        else if(password=="")
        {
            alert("Password is required");
            return false;
        }
        else if(password.length<=6)
        {
            alert("password must be length 6");
            return false;
        }

        return true;

}
$(function(){
        $("input[type='text']").css("background-color","#EEF0F9");
        $("input[type='password']").css("background-color","#EEF0F9");
        $("select").css("background-color","#EEF0F9");

    });
$("a").addClass("fancy-link");

