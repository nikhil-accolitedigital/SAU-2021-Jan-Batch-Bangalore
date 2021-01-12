function sameDigit(n)
{   
    var a=n%10;
    while(n!==0)
    {
        var b=n%10;
        if(a !== b)
        {
            return 'Digits are not same';
        }
        n=Math.floor(n/10);
    }
    return 'Digits are same';

}

console.log(sameDigit(66676));

