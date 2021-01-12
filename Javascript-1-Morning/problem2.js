function changeCapitalization(s)
{
    var str = " ";
    for (var i = 0; i<s.length;++i) {
        if (/[a-z]/.test(s[i]))
         str += s[i].toUpperCase();
        else
         str += s[i].toLowerCase();
    }
    return str;

}
console.log(changeCapitalization('JavaSCriPt'));
