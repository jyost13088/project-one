/* function that runs when the page loads */
let user;
window.onload = async function(){
    let response = fetch(`${globals}/checkSession/check`,{
      method: get
    })  
    let responseBody = await response.Json();
  //console.log("responseBody " + responseBody) 
  user=responseBody.data; 
    if (!responseBody.success){
      window.location = "./";
    }
    if(user.role_Id_pk = 1){
      window.location="../ModifyReimb/"
    }
    
}

  
       window.location = `../CreateReimb/index.html`;

    

}