function validate() {

    var firstName = document.forms["myForm"]["fname"].value;
    var lastName = document.forms["myForm"]["lname"].value;
    var gender = document.forms["myForm"]["gender"].value;
    var course = document.forms["myForm"]["course"].value;
    var emailId = document.forms["myForm"]["email"].value;

    var regex = new RegExp("[a-zA-Z0-9]+@[|a-zA-Z]*.[com]");
    if (firstName == "") {
        alert("Enter the First Name");
        return false;
    }
    else if (lastName == "") {
        alert("Enter the Last Name");
        return false;
    }
    else if (gender == "")
    {
        alert('Please Select a Gender');
        return false;
    }
    else if(!regex.test(emailId))
    {
        alert('Please Enter valid email Id');
        return false;
    }
    else if(course == "")
    {
        alert('Please Select an JS Course');
        return false;
    }
    else{
        alert("Form Submitted successfully!!"); 
        console.log({
            firstName,lastName,emailId,gender,course
        })
        ;
       
        
}
return false;
}

