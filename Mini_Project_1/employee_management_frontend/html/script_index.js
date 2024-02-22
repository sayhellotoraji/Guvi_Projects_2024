//                Fetch API - For Employee List

async function getapi(employee_list_url) {
  const response = await fetch(employee_list_url);
  var fetched_data = await response.json();
  data = fetched_data;

  // Works For multiple record
  console.log("multiple json - " + data[0].first_name);
  console.log(data);
}
/************************************************************************ */
//                    Display Fetched Records

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
            <td><a href="update_employee.html?empID=${data[row].employee_id}">Update</a></td>
            <td><a href="delete_employee.html?empID=${data[row].employee_id}">Delete</a></td>
            </tr>`;
  }
  let ele = document.getElementById("dynamicTable");
  ele.innerHTML = dynamicHTML;
}

/************************************************************************ */

let data;
// const index_url = "http://127.0.0.1:5500/html/";
// const add_url = "http://127.0.0.1:5500/html/add_employee.html";
// const employee_url = `http://localhost:8081/getEmployee/`;


const employee_list_url = "http://localhost:8081/getEmployees";

// Index page
getapi(employee_list_url).then(() => display());

// Add Employee Page
console.log(getapi(employee_url + 19));
// function search(id) {
//   console.log(employee_url);
//   employee_url += id;
//   console.log(employee_url);
//   // console.log(getapi(employee_url));
// }

//****************************************************************** */
