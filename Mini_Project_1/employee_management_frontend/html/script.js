//            Acutal Working Code

// Fetch API
async function getapi(url) {
  const response = await fetch(url);
  var fetched_data = await response.json();
  data = fetched_data;
  // Works For single record
  console.log("single json - " + data.first_name);

  // Works For multiple record
  console.log("multiple json - " + data[0].first_name);
  console.log(data);
}

/*
----------------- Works well for single row ----------------------
function display() {
  document.getElementById("emp_id").innerHTML = data.employee_id;
  document.getElementById("name").innerHTML = data.first_name;
  document.getElementById("mobile_no").innerHTML = data.mobile_no;
  document.getElementById("email").innerHTML = data.email;
  document.getElementById("designation").innerHTML = data.department_name;
}
*/

// Display Fetched Records
function display() {
  // for Dynamic table creation

  let dynamicHTML = "";
  for (let row = 0; row < data.length; row++) {
    // Use ` - backticks for multiple line string
    dynamicHTML += `<tr>
            <td>${data[row].employee_id}</td>
            <td>${data[row].first_name}</td>
            <td>${data[row].mobile_no}</td>
            <td>${data[row].email}</td>
            <td>${data[row].department_name}</td>
            <td><a href="update_employee">Update</a></td>
            <td><a href="#">Delete</a></td>
            </tr>`;
  }
  let ele = document.getElementById("dynamicTable");
  ele.innerHTML = dynamicHTML;
}

/*
Testing - Redirect link after form submit
document.getElementById("employeeForm").addEventListener("submit", redirectFunction);

function redirectFunction() {
  alert("The form was submitted");
  window.location.href = "http://127.0.0.1:5500/html/";
}

*/


let data;
const url = "http://localhost:8081/getEmployees";

getapi(url).then(() => display());

/*

Remember the display() method gets loaded before the json is fetched
So inorder to execute the display method after the getapi is executed 
Use Promises -> use .then()
getapi(url);
display();

*/

//****************************************************************** */

/*
                For Testing Purpose

Testing Rest API & Front End Data Binding
Please keep this code - For Future Reference

-> Didnt work at first: Because of CSRF
-> Add @CrossOrigin("*") to all RestController methods in SpringBoot Application



function display() {
  document.getElementById("name").innerHTML = data.first_name;
}

let data;
const url = "http://localhost:8081/getEmployee/1";



fetch(url)
.then(res => res.json())
.then(out =>
  console.log('Checkout this JSON! ', out))
.catch(err => { throw err });

*/
