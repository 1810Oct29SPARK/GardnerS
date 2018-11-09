//API project
const endPoint = "https://api.openbrewerydb.org/breweries?by_state=";
function grabJSON(state) {
    fetch(endPoint + state)
    .then((response) => {return response.json();})
    .then((function(data){
        var target = document.getElementById("list");
        if(target){target.remove();}
        var div = document.getElementById("listDiv");
        var list = document.createElement("ul");
        div.appendChild(list);
        list.setAttribute("id","list");
        for(let i=0;i<data.length;i++){
            var entry = document.createElement("li");
            entry.appendChild(document.createTextNode(data[i].name));
            list.appendChild(entry);
        }
    }));
}
//This API is messed up, for Alaska I got North Dakota Breweries.
//For Iowa it gives CA breweries.
//Lots of things are in the wrong places.