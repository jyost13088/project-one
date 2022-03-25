/* function that runs when the page loads */
let user;
window.addEventListener("load", async function (event){
    //this is to stop the form from reloading 
    event.preventDefault();

    
        let response1 = await fetch(`http://localhost:9000/session`, {
            method: "Get"
            // mode: "no-cors",
           //  body: JSON.stringify(user)
         })
        let responseBody1 = await response1.json();
        if(!responseBody1.success){
            window.location="../";
        }  
        user=responseBody1.data;
        userId=user.user_Id;

  
/*    let userid= {
        user_Id: 1
    
   }
  */  
    //send the http request
    let response = await fetch(`http://localhost:9000/reimbList/${userId}`, {
        method: "get"
       // mode: "no-cors",
       // body: JSON.stringify(userid)
    })
  

    //retrieve the response body
   
    let responseBody = await response.json();
    let list = responseBody.data;

    let listContainerElem = document.getElementById("list-items");
    listContainerElem.innerHTML = "";

        //logic after response body
        if(responseBody.success == false){
            let messageElem = document.getElementById("message")
            messageElem.innerHTML= responseBody.message
    
        
        }else{   
            //populate list container based on list passed
            list.forEach(element => {
                let listItemElem = document.createElement("div");
                listItemElem.className = "items";

                listItemElem.innerHTML = ` | ${element.status} |  $${element.amount} | ${element.submitted} | ${element.type}  |</button>`;

                listContainerElem.appendChild(listItemElem);
            })
        }

    
    
})