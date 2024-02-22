let id = window.location.href.split("=")[1];
// const get_employee_id_url = employee_url + window.location.href.split("=")[1];

document.getElementById("confirmation_msg").innerHTML =
  "Delete Employee with id:" + id;

document.getElementById("deleteEmployeeForm").action =
  "http://localhost:8081/delete/" + id;
