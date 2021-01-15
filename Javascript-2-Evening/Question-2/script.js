const userList = []

class Student{
    constructor(firstName, lastName, gender, age,  rollno, dob, occupation) {
        this.userData = {
            firstName : firstName,
            lastName : lastName,
            gender : gender,
            age : age,
            rollno : rollno,
            dob : dob,
            occupation : occupation
        }
    }
    storeUserData(){
        
        userList.push(this.userData);


    }

    display(){
        console.log(this.userData);
    }
}

function validate() {

    var firstName = document.forms["myForm"]["firstName"].value;
    var lastName = document.forms["myForm"]["lastName"].value;
    var gender = document.forms["myForm"]["gender"].value;
    var age = document.forms["myForm"]["age"].value;
    var rollno = document.forms["myForm"]["rollno"].value;
    var dob = document.forms["myForm"]["dob"].value;
    var occupation = document.forms["myForm"]["occupation"].value;
   
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
    else if(age == "")
    {
        alert('Please Enter your age');
        return false;
    }
    else if(rollno == "")
    {
        alert('Please Enter Roll no.');
        return false;
    }
    
    else if(dob == "")
    {
        alert('Please Enter Date of Birth');
        return false;
    }
    
    else if(occupation == "null")
    {
        alert('Please Enter your occupation');
        return false;
    }
    else{
        alert("Form Submitted successfully!!"); 
        
        
        // const userData = {
        //     firstName,lastName,rollno,gender,dob,age,occupation
        // }   

        //console.log(userData);
        //storeUserData(userData);
        let studentData = new Student(firstName,lastName,gender,age,rollno,gender,dob,occupation);
        studentData.storeUserData();
        studentData.display();


    }
return false;
}



function storeUserData(userData){
    userList.push(userData);
} 

function searchUserByRollno(rollno){
    if(userList.length === 0 || !rollno){
        return null;
    }
    
    var res = userList.filter(userObj => {
        if(userObj.rollno === rollno)
        {
            return true;
        }
        return false;
    })[0]
    return res; 
}


function fetchUser(roll)
{
    //debugger;
    var dataNode = document.getElementById("data");
    var temp = searchUserByRollno(roll);
    if(!temp){
        dataNode.innerText = "";
        
        alert("User not found");
        
    }
    else{
       
        if(dataNode){
            dataNode.innerText = JSON.stringify(temp);
        }
    }
}




