//                Fetch API - For Single Employee

async function getapi(employee_list_url) {
  const response = await fetch(employee_list_url);
  var fetched_data = await response.json();

  // Contains the Returned Employee Record
  data = fetched_data;

  // Works For single record
  console.log("single json - " + data.first_name);

  // The Employee Record is returned
  console.log(data);
}
/*************************************************************** */

//                    Prepopulate Form Data

function populateForm() {
  // console.log((document.getElementById("first_name").innerHTML = "HI"));
  document.getElementById("employee_id").innerHTML = data.employee_id;
  document.getElementById("first_name").innerHTML = data.first_name;
  document.getElementById("middle_name").innerHTML = data.middle_name;
  document.getElementById("last_name").innerHTML = data.last_name;
  document.getElementById("dob").innerHTML = data.dob;
  document.getElementById("sex").innerHTML = data.sex;
  document.getElementById("mobile_no").innerHTML = data.mobile_no;
  document.getElementById("email").innerHTML = data.email;
  document.getElementById("address").innerHTML = data.address;
  document.getElementById("doj").innerHTML = data.doj;
  document.getElementById("department_name").innerHTML = data.department_name;
  document.getElementById("salary").innerHTML = data.salary;
}

/*************************************************************** */
// Update page
const employee_url = `http://localhost:8081/getEmployee/`;

// data is global object
let data;

let id = window.location.href.split("=")[1];
const get_employee_id_url = employee_url + window.location.href.split("=")[1];
getapi(get_employee_id_url).then(() => populateForm());

// Testing - Fetch current url & get empID
console.log(employee_url + window.location.href.split("=")[1]);
