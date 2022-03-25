/* function that runs when the page loads */
window.addEventListener("load", async function (event){
    //this is to stop the form from reloading 
   // event.preventDefault();
    let response= await fetch(`${domain}/session`);
        //method: "POST"
        // mode: "no-cors",
         //body: JSON.stringify(user)
    
     
    let responseBody = await response.json();
    if(!responseBody.success){
        window.location="../";
    }
    user=responseBody.data; 
    
    //send the http request
     response = await fetch(`http://localhost:9000/reimbList`, {
        method: "get",
       // mode: "no-cors",
       // body: JSON.stringify(userid)
    })


    //retrieve the response body
   
     responseBody = await response.json();
  
    let list = responseBody.data;

    //remove whats currently in list
    let listContainerElem = document.getElementById("list-items");
    listContainerElem.innerHTML = "";
        
        //logic after response body
        if(responseBody.success == false){
            let messageElem = document.getElementById("message")
            messageElem.innerHTML= responseBody.message
            //send the http request


        
    
        }else{   
            //populate list container based on list passed
            list.forEach(element => {
                let listItemElem = document.createElement("div");
                listItemElem.className = "items";

                listItemElem.innerHTML = ` |   ${element.status} |  [${element.reimb_Id}]  |   s${element.amount} |      ${element.submitted}  |      ${element.type}  | </button>`;

                listContainerElem.appendChild(listItemElem);
            })
        }
})        

async function selection(){
    document.getElementById("message").innerHTML = "";

    let selValue=document.getElementById("selStatus").value;
    
    let reimbIdValue = document.getElementById("inputReimbId").value;
    // format date and time
    /*
    let curDate= new Date();
    let time=curDate.getHours() + ":" + curDate.getMinutes() + ":" + curDate.getSeconds() ;
    let cDay = curDate.getDay();
    let cMonth = curDate.getMonth();
    let cYear = curDate.getFullYear();
    dateTime=cYear + "/" + cMonth + "/" + cDay + " " + time;
    */
    var timeStamp = Math.floor (Date.now () / 1000);

   // console.log(timeStamp);

    let selObjDenied = "";
    let selObjApp = "" ;

 //console.log("reimbidvalue  " + reimbIdValue);
// console.log("selValue " + selValue);

    if(reimbIdValue != "" && reimbIdValue != null) {


        if (selValue="Denied"){
             selObjDenied = {
                reimb_Id : reimbIdValue,
                status_Id : 2,
                resolver: user.user_Id,
                //resolver: 1,
                resolved: timeStamp
                 }
        }else{
                 selObjApp = {
                    reimb_Id : reimbIdValue,
                    status_Id : 3,
                    resolver: user.user_Id,
                  // resolver: 1,
                    resolved: timeStamp
                }
    
        }        
        if (selValue=="Denied"){
            let response = await fetch(`http://localhost:9000/reimb`, {
                 method: "patch",
           
                 body: JSON.stringify(selObjDenied)
            })

            responseBody = await response.json()
            let reimb = responseBody.data;
            
            if(responseBody.success == false){
                var messageElem1 = document.getElementById("message")
                    messageElem1.innerHTML= responseBody.message
            }else{
                var messageElem1 = document.getElementById("message")
                messageElem1.innerHTML= responseBody.message
            }
        }else{
            let response = await fetch(`${domain}/reimb`, {
                method: "patch",
            // mode: "no-cors", 
            body: JSON.stringify(selObjApp)
            })
            responseBody = await response.json();
        
        
            if(responseBody.success == false){
                var messageElem1 = document.getElementById("message")
                    messageElem1.innerHTML= responseBody.message
            } else{
                var messageElem1 = document.getElementById("message")
                messageElem1.innerHTML= responseBody.message
            }       
        }   

        
        
    }else{
        //console.log(message)
        var messageElem1 = document.getElementById("message")
       // messageElem1.innerHTML= "Reimbusrement ID is a required field"
        document.getElementById("message").innerHTML = "Reimbursement ID is a require field";
    } 
 

}
       
    
