function sumOfDigits(str)
{
    var sum=0;
    for(var i=0;i<str.length;++i)
    {
        if(/[0-9]/.test(str[i]))
        sum+=parseInt(str[i]);
    }
    return sum;

}
console.log(sumOfDigits('aazaq1345ghjk4546'));