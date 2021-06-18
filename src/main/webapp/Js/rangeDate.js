$(function () {
    $("#fromperiod").datepicker({
        dateFormat: 'dd-mm-yy',
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        onClose: function (selectedDate) {
            $("#toperiod").datepicker("option", "minDate", selectedDate);
        }
    });
    $("#toperiod").datepicker({
        dateFormat: 'dd-mm-yy',
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1,
        selectedDate: "(yyyy-mm-dd)",
        onClose: function (selectedDate) {
            $("#fromperiod").datepicker("option", "maxDate", selectedDate);
        }
    });
    $(".selector").datepicker({
        appendText: "(yyyy-mm-dd)"
    });
    $("#to").datepicker({dateFormat: 'yy-mm-dd'});
});