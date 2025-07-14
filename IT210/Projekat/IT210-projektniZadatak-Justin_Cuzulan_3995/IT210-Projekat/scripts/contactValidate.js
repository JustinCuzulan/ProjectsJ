var ime = document.getElementById('ime');
var prezime = document.getElementById('prezime');
var broj = document.getElementById('brojTelefona');
var poruka = document.getElementById('poruka');
var forma = document.getElementById('contact-forma');

function validacijaBroja(broj) {
    var prviChar = broj.substring(0, 1);
    var ostatak = broj.substring(1, broj.length);
    if (/^\d+$/.test(ostatak) && (prviChar === '+' || (prviChar >= '0' && prviChar <= '9'))) {
        return true;
    } else {
        return false;
    }
};

forma.addEventListener('submit', function(ev) {
    if (ime.value.includes(" ")) {
        window.alert("Unesite ime u pravilnom formatu!");
        ime.focus();
        ev.preventDefault();
    }
    if (prezime.value.includes(" ")) {
        window.alert("Unesite prezime u pravilnom formatu!");
        ime.focus();
        ev.preventDefault();
    }
    if (!validacijaBroja(brojTelefona.value)) {
        window.alert("Unesite broj telefona u pravilnom formatu!");
        brojTelefona.focus();
        ev.preventDefault();
    }
    if (poruka.value.length < 3 || poruka.value.length > 1000) {
        window.alert("Unesite poruku u pravilnom formatu!")
        poruka.focus();
        ev.preventDefault();
    }
})