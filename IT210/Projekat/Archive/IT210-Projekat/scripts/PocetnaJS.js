var btn = document.getElementById("btnPadajuciMeni");
var sadrzaj = document.getElementById("padajuciMeniSadrzaj");
console.log("blahblah1");
var slika = document.getElementById("slika");

btn.addEventListener("click", function() {
    slika.style.transform += "rotate(180deg)";
    if (sadrzaj.style.display == "block") {
        sadrzaj.style.display = "none";

    } else {
        console.log("blahblah");
        sadrzaj.style.display = "block";
    }

});