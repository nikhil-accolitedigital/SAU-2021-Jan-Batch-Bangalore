class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        console.log(this.input.length);
        return this.input.length;
    };
    getUpperCase() {
        console.log(this.input.toUpperCase());
        return this.input.toUpperCase();
    };
    getLowerCase() {
        console.log(this.input.toLowerCase());
        return this.input.toLowerCase();
    };
    vowelAndConsonant(str) {
         var a="";
         var b = "";
         var str = this.input;
         for(let i=0;i<str.length;++i){
             if(/[aeiouAEIOU]/.test(str[i])){
                 a+=str[i];
             }
             else if(/[a-zA-Z]/.test(str[i])){
                 b+=str[i];

             }
             
        }
        console.log(a);
        console.log(b);
        var result = 'Vowels : '+ a  +   '     Consonants : ' +b;
        return result;
    }
    numberExists(){
        var str = this.input;
        for(let i=0;i<str.length;++i){
            if(/[0-9]/.test(str[i]))
            {
                console.log("Number detected :"+str[i]+ " Throw Error");
                return "Number Detected, See the console";
            }
        }

        return "No Number Detected";
        
        
    }
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    document.getElementById("vowelconsonant").innerHTML = inputObject.vowelAndConsonant();
    document.getElementById("anynumber").innerHTML = inputObject.numberExists();


}