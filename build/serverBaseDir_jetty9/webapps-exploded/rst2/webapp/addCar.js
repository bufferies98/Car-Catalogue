function addCar() {
    var car = {
        model: $("#model").val(),
        topSpeed: $("#topSpeed").val(),
        horsePower: $("#horsePower").val(),
        yearOfManufacture: $("#yearOfManufacture").val()
    }


    $.post({
        url: "http://localhost:8080/rst2/api/cars",
        dataType: "json",
        data: JSON.stringify(car),
        contentType: "application/json",
        success: function(data){
            window.location.href = "index.html";
        }
    });
}