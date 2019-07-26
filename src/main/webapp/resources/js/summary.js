$(document).ready(function() {
    /* tu nasz kod */
    let quantity = $('#quantity').onkeyup( function (event) {
        alert( "Handler for .keyup() called." );
        $('#quantity1').value(quantity.text());
    });
    var categories = $('#categories');
    var institution = $('#institution');
    var street = $('#street');
    var city = $('#city');
    var zipCode = $('#zipCode');
    var pickUpDate = $('#pickUpDate');
    var pickUpTime = $('#pickUpTime');

});


/*

    Ilosc: <p id="quantity1"> </p>
    Kategorie: <p id="categories1"> </p>
    Instytucja: <p id="institution1"> </p>
    Ulica: <p id="street1"> </p>
    Miasto: <p id="city1"> </p>
    Kod Pocztowy: <p id="zipCode1"> </p>
    Data podjecia: <p id="pickUpDate1"> </p>
    Godzina Podjecia: <p id="pickUpTime1"> </p>
    Komentarz: <p id="pickUpComment1"> </p>
 */