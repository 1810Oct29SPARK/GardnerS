
// this is to login
const loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click",login);
function login(){
    let username = document.getElementById("usernameInput").value;
    let password = document.getElementById("passwordInput").value;
    const loginHead = {'info':'y'};
    const loginEnd = "http://localhost:7001/Project1/Employee?username="+username+"&password="+password;
    console.log(username,password);
    fetch(loginEnd,{headers:loginHead})
    .then(function(r) {return r.json()})
    .then(function(data){
        console.log(data[0]);
        //if the credientials are not good
        if (data[0].id==null) {
            sessionStorage.removeItem("ID");
            location.reload();
        }
        else {
            let firstname = data[0].firstName;let lastname = data[0].lastName;let email = data[0].email;let phone = data[0].phone;let id = data[0].id;
            sessionStorage.setItem("ID",id);
            let empType = data[0].isManager;
            let firstDiv = document.getElementById("firstname");let lastDiv = document.getElementById("lastname");let emailDiv = document.getElementById("email");let phoneDiv = document.getElementById("phone");
            firstDiv.innerText = firstname;lastDiv.innerText = lastname;emailDiv.innerText = email;phoneDiv.innerText = phone;
            giveListenerChange();
            underReimbursements();
            belowMe();
            document.getElementById("login-div").style = "display:none";
            document.getElementById("employee-div").style = "display:block";
            document.getElementById("logout-div").style = "display:block";
            if (empType=="B" || empType=="Y") {
                document.getElementById("manager-div").style = "display:block";
            }
        }
    });
}
let logout2 = document.getElementById("logout-div");
logout2.addEventListener("click",logout);
function logout(){
    sessionStorage.removeItem("ID");
    location.reload();
}


//below is to change the value of your employeeInfo
//each button will have a relative change course
let changeBtn = document.getElementsByClassName("info-btn");
let changeArr = Array.prototype.slice.call(changeBtn);
//console.log(changeArr);
function giveListenerChange(){
    for (let i=0;i<changeArr.length;i++) {
        changeBtn[i].addEventListener("click", change);
    }
}
//clicking the button changes the database.
function change(){
    let changeHead ={"change":"iop"};
    let neu = this.previousElementSibling;
    let neuVal =neu.value;
    let ogId = neu.previousElementSibling.id;
    fetch("http://localhost:7001/Project1/Employee?field="+ogId+"&value="+neuVal+"&id="+sessionStorage.getItem("ID"), {headers:changeHead});
    setTimeout(login,3000);
}

//this is to submit a new reimbursement
let subBtn = document.getElementById("sub-reimb");
subBtn.addEventListener("click",submitReimbursement);
function submitReimbursement(){
    let description = document.getElementById("submit-description").firstChild.value;
    let amount = document.getElementById("submit-amount").firstChild.value;
    let head = {"reimbursement":"jph"};
    let end = "http://localhost:7001/Project1/Employee?description="+description+"&amount="+amount+"&id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head});
}

//This is to display your reimbursements
function yourReimbursements(){
    let head = {"all":"posgdhlagjsdag"};
    let end = "http://localhost:7001/Project1/Employee?id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head})
    .then(function(t){return t.json();})
    .then(function(data){
        let list = document.getElementById("my-reimb");
        console.log(data[0],data[0].length);
        for(let r=0;r<data[0].length;r++){
            let newDiv = document.createElement("div");
            newDiv.id = "rId-"+data[0][r].rId;
            let statusDiv = document.createElement("div");
            let descDiv = document.createElement("div");
            let amtDiv = document.createElement("div");
            newDiv.append(statusDiv.innerText=data[0][r].status);
            newDiv.append(descDiv.innerText=data[0][r].description);
            newDiv.append(amtDiv.innerText=data[0][r].amount);
            list.appendChild(newDiv);
        }
    })
}

//these are manager functions from here on out

//this sets a new user
let newUserBtn = document.getElementById("new-user-btn");
newUserBtn.addEventListener("click",newUser);
function newUser(){
    let username = document.getElementById("new-username").value;
    let password = document.getElementById("new-password").value;
    let head = {"hired":"adaflgj"};
    let end = "http://localhost:7001/Project1/Manager?username="+username+"&password="+password+"&id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head});
}

//this gets the underlings of the current user
let underBtn = document.getElementById("show-under");
underBtn.addEventListener("click",belowMe);
function belowMe(){
    let head = {"people":"qwertyuiop"};
    let end = "http://localhost:7001/Project1/Manager?id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head})
    .then(function(f){return f.json();})
    .then(function(data){
        let list = document.getElementById("under-list");
        console.log(data[0],data[0].length);
        for(let r=0;r<data[0].length;r++){
            let newDiv = document.createElement("div");
            let firstDiv = document.createElement("div");
            let lastDiv = document.createElement("div");
            let emailDiv = document.createElement("div");
            let phoneDiv = document.createElement("div");
            newDiv.appendChild(firstDiv);
            newDiv.appendChild(lastDiv);
            newDiv.appendChild(emailDiv);
            newDiv.appendChild(phoneDiv);
            firstDiv.innerText=data[0][r].firstName;
            lastDiv.innerText=data[0][r].lastName;
            emailDiv.innerText=data[0][r].email;
            phoneDiv.innerText=data[0][r].phone;
            list.appendChild(newDiv);
        }
    })
}

//this gets the reimbursements of my underlings
function underReimbursements(){
    let head = {"total":"gohasdfl"};
    let end = "http://localhost:7001/Project1/Manager?id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head})
    .then(function(r){return r.json();})
    .then(function(data){
        let list = document.getElementById("under-reimbursement-list");
        console.log(data[0],data[0].length);
        for(let r=0;r<data[0].length;r++){
            let newDiv = document.createElement("div");
            newDiv.id = "under-rId-"+data[0][r].rId;
            let statusDiv = document.createElement("div");
            let descDiv = document.createElement("div");
            let amtDiv = document.createElement("div");
            let empDiv = document.createElement("div");
            let appBtn = document.createElement("button");
            let denyBtn = document.createElement("button");
            appBtn.setAttribute("class","approved");
            denyBtn.setAttribute("class","denied");
            newDiv.appendChild(empDiv);
            newDiv.appendChild(statusDiv);//.innerText=data[0][r].status);
            newDiv.appendChild(appBtn);//.innerText="Approve this Reimbursement");
            newDiv.appendChild(denyBtn);//.innerText="Deny this Reimbursement");
            newDiv.appendChild(descDiv);//.innerText=data[0][r].description);
            newDiv.appendChild(amtDiv);//.innerText=data[0][r].amount);
            empDiv.innerText=data[0][r].eId;
            statusDiv.innerText=data[0][r].status;
            appBtn.innerText="Approve this Reimbursement";
            denyBtn.innerText="Deny this Reimbursement";
            descDiv.innerText=data[0][r].description;
            amtDiv.innerText=data[0][r].amount;
            list.appendChild(newDiv);
        }
    })
    giveListenerApprove();
    giveListenerDeny();
}

//this gets the reimbursements of one of my underlings
let targetBtn = document.getElementById("show-target-reimbuserments");
targetBtn.addEventListener("click",targetReimbursements);
function targetReimbursements(){
    let target = document.getElementById("target").value;
    let head = {"single":"gohafl"};
    let end = "http://localhost:7001/Project1/Manager?target="+target+"&id="+sessionStorage.getItem("ID");
    fetch(end,{headers:head})
    .then(function(r){return r.json();})
    .then(function(data){
        let list = document.getElementById("target-reimbursement-list");
        console.log(data[0],data[0].length);
        for(let r=0;r<data[0].length;r++){
            let newDiv = document.createElement("div");
            newDiv.id = "target-rId-"+data[0][r].rId;
            let statusDiv = document.createElement("div");
            let descDiv = document.createElement("div");
            let amtDiv = document.createElement("div");
            let appBtn = document.createElement("button");
            let denyBtn = document.createElement("button");
            appBtn.setAttribute("class","approved");
            denyBtn.setAttribute("class","denied");
            newDiv.appendChild(statusDiv);//.innerText=data[0][r].status);
            newDiv.appendChild(appBtn);//.innerText="Approve this Reimbursement");
            newDiv.appendChild(denyBtn);//.innerText="Deny this Reimbursement");
            newDiv.appendChild(descDiv);//.innerText=data[0][r].description);
            newDiv.appendChild(amtDiv);//.innerText=data[0][r].amount);
            statusDiv.innerText=data[0][r].status;
            appBtn.innerText="Approve this Reimbursement";
            denyBtn.innerText="Deny this Reimbursement";
            descDiv.innerText=data[0][r].description;
            amtDiv.innerText=data[0][r].amount;
            list.appendChild(newDiv);
        }
    })
    giveListenerApprove();
    giveListenerDeny();
}

//this is to set the status on a reimbursement
let approveBtn = document.getElementsByClassName("approved");
let approveArr = Array.prototype.slice.call(approveBtn);
function giveListenerApprove(){
    for (let i=0;i<approveArr.length;i++) {
        approveBtn[i].addEventListener("click", approveReimbursement);
    }
}
let denialBtn = document.getElementsByClassName("denied");
let denialArr = Array.prototype.slice.call(denialBtn);
function giveListenerDeny(){
    for (let i=0;i<denialArr.length;i++) {
        denialBtn[i].addEventListener("click", denyReimbursement);
    }
}




function approveReimbursement(){
    let rId = this.parentElement.id;
    let split = rId.split("-");
    let oof = split[split.length-1];
    console.log(rId);
    let status = "Approved";
    let head = {"status":"zbn"};
    let end = "http://localhost:7001/Project1/Manager?status="+status+"&reimbursementId="+oof;
    fetch(end,{headers:head});
}

function denyReimbursement(){
    let rId = this.parentElement.id;
    let split = rId.split("-");
    let oof = split[split.length-1];
    console.log(rId);
    let status = "Denied";
    let head = {"status":"zbn"};
    let end = "http://localhost:7001/Project1/Manager?status="+status+"&reimbursementId="+oof;
    fetch(end,{headers:head});
}

setInterval(giveListenerApprove,1000);