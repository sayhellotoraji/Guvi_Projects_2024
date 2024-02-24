//                Fetch API - For Single Employee

async function getapi(employee_list_url) {
  const response = await fetch(employee_list_url);
  var fetched_data = await response.json();

  // Contains the Returned Employee Record
  data = fetched_data;

/*  
  Works For single record
  console.log("single json - " + data.first_name);

  The Employee Record is returned
  console.log(data);
*/
}
/*************************************************************** */

//                    Prepopulate Form Data

function populateForm() {
  // console.log((document.getElementById("first_name").value = "HI"));
  document.getElementById("employee_id").value = data.employee_id;
  document.getElementById("first_name").value = data.first_name;
  document.getElementById("middle_name").value = data.middle_name;
  document.getElementById("last_name").value = data.last_name;
  document.getElementById("dob").value = data.dob;
  document.getElementById("sex").value = data.sex;
  document.getElementById("mobile_no").value = data.mobile_no;
  document.getElementById("email").value = data.email;
  document.getElementById("address").value = data.address;
  document.getElementById("doj").value = data.doj;
  document.getElementById("department_name").value = data.department_name;
  document.getElementById("salary").value = data.salary;
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
// console.log(employee_url + window.location.href.split("=")[1]);
