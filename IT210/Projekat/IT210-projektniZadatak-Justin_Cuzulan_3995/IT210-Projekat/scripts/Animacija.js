var
    myText = document.getElementById("tekstAnimacija").innerHTML,
    wrapText = "";

for (var i = 0; i < myText.length; i++) {
    wrapText += "<em>" + myText.charAt(i) + "</em>";
}

document.getElementById("bounceTxt").innerHTML = wrapText;