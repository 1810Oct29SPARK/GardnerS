const endPointArtsy = "https://api.artsy.net/api/artists/";
const loginForToken = "https://api.artsy.net/api/tokens/xapp_token?client_id=96eda4509413b44cb867&client_secret=f72307e4f63dc776ba338cc26af437be";
var token;
var stuff;
function getToken(){
    fetch(loginForToken, {"method":"POST"})
    .then(function (response){
        return response.json();
    })
    .then(function(data){
        token = data.token;
    })
    .catch(function(error){
        console.log(error,"Shoot");
    })
}
function artsyCall(artist){
    artist = artist.replace(/\s/g, '-').toLowerCase();
    console.log(endPointArtsy+artist);
    console.log(token);
    fetch(endPointArtsy+artist, {
        method:"GET",
        headers:{
            "X-Xapp-Token":token
        }
    })
    .then(function(response){
        return response.json();
        
    })
    .then(function(data){
        stuff = data;
        console.log(stuff.name);
    })
    .catch(function(error){
        console.log(error, "Damn");
    })
}