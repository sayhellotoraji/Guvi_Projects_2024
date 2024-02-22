/*

                For Testing Purpose

1. Testing Rest API & Front End Data Binding
    Please keep this code - For Future Reference

-> Didnt work at first: Because of CSRF
-> Add @CrossOrigin("*") to all RestController methods in SpringBoot Application

Redirect link after form submit
document.getElementById("employeeForm").addEventListener("submit", redirectFunction);

function redirectFunction() {
  alert("The form was submitted");
  window.location.href = "http://127.0.0.1:5500/html/";
}



2. Remember the display() method gets loaded before the json is fetched

function display() {
  document.getElementById("name").innerHTML = data.first_name;
}

let data;
const url = "http://localhost:8081/getEmployee/1";


So inorder to execute the display method after the getapi is executed 
Use Promises -> use .then()
getapi(url);
display();


Alternate way to do:

fetch(url)
.then(res => res.json())
.then(out =>
  console.log('Checkout this JSON! ', out))
.catch(err => { throw err });

*/





// Testing current page
// const currentURL = window.location.href;
// console.log(currentURL);
//****************************************************************** */