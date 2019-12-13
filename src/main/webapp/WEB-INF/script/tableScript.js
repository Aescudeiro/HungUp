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

function companyInfo(name){
  console.log("did")
  $(".hide").hide();
  $(".show").show();
  $("#title").text(name);
  showDetails(name);
}

function showDetails(name){

  function successCallback(response) {
    alert("hey nigga");
    setReviews(response);
  }

  function errorCallback(request, status, error) {
      console.log(request + status + error);
  }

  var reviewsTable = $('#reviewsTable');

  $.ajax({
    url: 'http://localhost:8080/hungup/api/company/'+ name + '/review',
    async: true,
    success: successCallback,
    error: errorCallback
});

function setReviews(data){
  console.log(data[1].name)
  for(var i = 0; i < data.length; i++){
    var string = '<tr id= "row' + data[i].id + '"><td>' + data[i].id + '</td>' +
    '<td>' + data[i].name + '</td>' +
    '<td>' + data[i].rating + '</td>' +
    '<td>' + data[i].days + '</td>' +
    '<td>' + data[i].review + '</td></tr>';


    $(string).appendTo(reviewsTable)
  }
}



}

$(document).ready(function () {

  $(".show").hide();

  function successCallback(response) {
    //console.log(response);
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
            '<td><button id="btn-' + companyData[i].id +'" type="button" class="btn btn-primary">+info</button></td></tr>';

        $(htmlStr).appendTo(usersTable)

        var name = companyData[i].name;

        $('#btn-' + companyData[i].id).click(function() {
          companyInfo(name);
       });
    }
}
});