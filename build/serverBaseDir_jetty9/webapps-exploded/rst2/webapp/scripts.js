var defaultPagination = {
    totalPages: 1,
    visiblePages: 5,
    startPage: 1,
    onPageClick: function (event, page) {
        var filter = getFilter();
        filter.page = page - 1;
        getData(filter);
    }
};

var sentRequest = false;

function getFilter() {
    var filter = {
        page: 0,
        perPage: 10,
        withModel: $("#modelFilter").val()
    };
    return filter;
}

function getData(filter) {
    if(sentRequest) return;
    sentRequest = true;
    $.get({
        url: "http://localhost:8080/rst2/api/cars",
        dataType: "json",
        data: filter,
        success: function(data){
            $("#carsTableBody tr").remove();
            console.log(data.distinctModels);

            $("#modelFilter").autocomplete({
                source: data.distinctModels
            });

            if($('#pagination-list').data("twbs-pagination")){
                    $('#pagination-list').twbsPagination('destroy');
            }
            $('#pagination-list').twbsPagination($.extend({}, defaultPagination, {
                startPage: data.page + 1,
                totalPages: data.totalPages
            }));

            $.each(data.data, function(index){
                var tr = $('<tr>');
                tr.append("<td> " + data.data[index].model + "</td>");
                tr.append("<td> " + data.data[index].topSpeed + "</td>");
                tr.append("<td> " + data.data[index].horsePower + "</td>");
                tr.append("<td> " + data.data[index].yearOfManufacture + "</td>");
                $("#carsTableBody").append(tr);
            });

            sentRequest = false;
        }

    });
}

$(document).ready(function() {
    getData(getFilter());

    $("#pagination-list").twbsPagination(defaultPagination);
    $("#filterButton").click(function (e){
        getData(getFilter());
    });
});