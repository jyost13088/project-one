



let user;

/* function that runs when the page loads */
window.onload = async function(){
    event.preventDefault();
    let response = await fetch(`http://localhost:9000/session`,{ mode: 'no-cors'});
        //method: "POST"
        // mode: "no-cors",
       //  body: JSON.stringify(user)
    
    let responseBody = await response.json();
    
    if(!responseBody.success){
        window.location="../";
    }
     user=responseBody.data;
    console.log(user);
    document.getElementById("fname").innerHTML=user.firstname;
    document.getElementById("lname").innerHTML=user.lastname;
    document.getElementById("email").innerHTML=user.email;
}

   

document.getElementById("create-reimb").addEventListener("submit", async function (event){
    //this is to stop the form from reloading 
    event.preventDefault();

    
   // let userIdInputElem = document.getElementById("userId")
    let amountInputElem = document.getElementById("amount");
    let descInputElem = document.getElementById("desc");
    let e = document.getElementById("type");
    
    var type_Id = e.value;
    let  varStatusId = "1";

    if (type_Id == "FOOD"){varTypeId = "1"};
    if (type_Id == "LODGING"){varTypeId = "2"};
    if (type_Id == "TRAVEL"){varTypeId = "3"};
    let reimb = {

        amount: amountInputElem.value,
        description: descInputElem.value,
        author: user.user_Id,
        status_Id: varStatusId,
        type_Id: varTypeId

    }
    console.log(reimb);

    let response = await fetch(`http://localhost:9000/reimb`, {
        method: "PUT",
       // mode: "no-cors",
        body: JSON.stringify(reimb)
    })
    let responseBody = await response.json();

    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
        //window.location = `../EmpDashboard/index.html`;
        document.getElementById("amount").innerHTML = "";
        document.getElementById("desc").innerHTML = "";
        
    }    
})   
