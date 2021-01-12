

function isPrime(num)
{
    
    for(let i=2;i*i<=num;++i)
    {
        if(num%i === 0)
        return false;
    }
    
    return true;
    
}

function findDistinctPrimeFactors(n)
{
    var arr=[];
    if(isPrime(n) == true)
    {
        arr.push(1);
    }
    else
    {
        for(let i=2;i<=n/2;++i)
        {
            if(n%i === 0)
            {
                if(isPrime(i) == true)
                {
                    if (!arr.includes(i))
                    {
                        arr.push(i);
                    }
                }
            }
        }
    }
    return arr;
}
console.log(findDistinctPrimeFactors(630));
