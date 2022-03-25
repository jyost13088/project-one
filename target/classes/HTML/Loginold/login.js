/* function that runs when the page loads */
document.getElementById("login-form").addEventListener("submit", async function (event){
    //this is to stop the form from reloading 
    event.preventDefault();
    
    //retrieve input elements from the dom
    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");

    //get values from the input elements and put it into an object
    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }
    
    //send the http request
    let response = await fetch(`${domain}/login`, {
        method: "POST",
       // mode: "no-cors",
        body: JSON.stringify(user)
    })

    //retrieve the response body
   // let responseBody = await response.json();
    let responseBody = await response.json();
    
    console.log(responseBody);

    //logic after response body
    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        //console.log("Login Successful",responseBody.data)

        //redirect page to dashboard page if credentials were successful

       // window.location = "./dashboard?userId=" + responseBody.data.id
       // window.location = `./EmpDashboard/index.html?username=${responseBody.data.username}`
       // window.location = `./EmpDashboard/index.html`;

    }
    
})