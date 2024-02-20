//            Acutal Working Code

async function getapi(url) {
  const response = await fetch(url);
  var fetched_data = await response.json();
  data = fetched_data;
  console.log(data.first_name);
}

function display() {
  document.getElementById("name").innerHTML = data.first_name;
}

let data;
const url = "http://localhost:8081/getEmployee/1";

 getapi(url).then(()=>display());

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
