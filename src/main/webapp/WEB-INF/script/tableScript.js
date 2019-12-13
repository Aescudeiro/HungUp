var name = "";
var counter = 0;

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


function companyInfo(name) {
  $(".hide").hide();
  $(".show").show();
  $("#title").text(name);
  showDetails(name);
}

function showDetails(name) {


  function successCallback(response) {
    setReviews(response);
  }

  function errorCallback(request, status, error) {
    console.log(request + status + error);
  }

  var reviewsTable = $('#reviewsTable');

  $.ajax({
    url: 'http://localhost:8080/hungup/api/company/' + name + '/review',
    async: true,
    success: successCallback,
    error: errorCallback
  });

  function setReviews(data) {
    var x = document.getElementById("reviewsTable").rows.length


    for (var i = 0; i < data.length; i++) {
      var string = '<tr id= "row' + data[i].id + '"><td>' + data[i].id + '</td>' +
        '<td>' + data[i].name + '</td>' +
        '<td>' + data[i].rating + '</td>' +
        '<td>' + data[i].days + '</td>' +
        '<td>' + data[i].review + '</td></tr>';

      console.log("loop");
      $(string).appendTo(reviewsTable)

    }
  }
}

function menu() {
  location.reload();
  $(".show").hide();
  $("#review").hide();
  $(".hide").show();
  $("#title").text("For your impatient ass");
}

function adjust_textarea(h) {
  h.style.height = "20px";
  h.style.height = (h.scrollHeight) + "px";
}

function addReviewForm() {
  $("#review").show();

  console.log(name);
  $("#companyName").val(name);
}

function addReview() {
  $("#review").hide;

  function successCallback() {
    alert("Review Added Sucessfully");
    menu();

  }

  function errorCallback() {
    alert("not okay");
  }

  $.ajax({
    url: 'http://localhost:8080/hungup/api/company/' + name + '/review',
    type: 'POST',
    data: JSON.stringify({
      "name": $("#formName").val(),
      "rating": $("#formRating").val(),
      "days": $("#formDays").val(),
      "review": $("#formDescription").val()
    }),
    async: true,
    contentType: 'application/json',
    success: successCallback,
    error: errorCallback
  });
}

$(document).ready(function () {

  $(".show").hide();
  $("#review").hide();

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
        '<td><button id="btn-' + companyData[i].id + '" type="button" class="btn btn-primary">+info</button></td></tr>';
      counter++;
      $(htmlStr).appendTo(usersTable)

      name = companyData[i].name;

      $('#btn-' + companyData[i].id).click(function () {
        companyInfo(name);
      });
    }
  }
});