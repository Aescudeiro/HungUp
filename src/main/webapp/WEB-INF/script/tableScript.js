function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

$(document).ready(function () {

  function successCallback(response) {
    console.log(response);
    setInfo(response);
}

function errorCallback(request, status, error) {
    console.log(request + status + error);
}

  var usersTable = $('#myTable');

  $.ajax({
    url: 'http://localhost:8080/hungup/api/company',
    async: true,
    success: successCallback,
    error: errorCallback
});


function setInfo(companyData) {

    for (var i = 0; i < companyData.length; i++) {

        var htmlStr = '<tr id= "row' + companyData[i].id + '"><td>' + companyData[i].id + '</td>' +
            '<td>' + companyData[i].name + '</td>' +
            '<td>' + companyData[i].days + '</td>' +
            '<td>' + companyData[i].rating + '</td>' +
            '<td><button type="button" class="btn btn-primary">+info</button></td></tr>';

        $(htmlStr).appendTo(usersTable)

    }
}
});