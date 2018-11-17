// const endPointArtsy = "https://api.artsy.net/api/artists/";
const endPointWiki = "https://en.wikipedia.org/w/api.php?&origin=*&action=query&format=json&prop=extracts%7Cimages&exsentences=9&exintro=1&explaintext=1&imlimit=20&redirects=1&titles=";
const endPointWikiImages = "https://en.wikipedia.org/w/api.php?origin=*&action=query&prop=imageinfo&iiprop=url&format=json&titles="
const endPointAllPosters = "https://www.allposters.com/gallery?txtSearch=The+Musicians"
const searchBtn = document.getElementById("searchBtn");
//var searchTerm = document.getElementById("searchTerm").value;
searchBtn.addEventListener("click", console.log("Nice")); //wikiCall(searchTerm)
//searchBtn.addEventListener("click",artsyCall(searchTerm));


function wikiCall(artist){
    fetch(endPointWiki+artist)
    .then(function(resp) {
        return resp.json()
    })
    .then(function(data) {  
        var artistName = Object.values(data.query.pages)[0].title;
        document.getElementById("artistName").innerHTML = artistName;
        var artistDescription = Object.values(data.query.pages)[0].extract;
        console.log(artistDescription);
        document.getElementById("artistDescription").innerHTML = descriptionCollapse(artistDescription);
        var wikiImages = Object.values(data.query.pages)[0].images;
        wikiCycle(wikiImages);
    })
}
function wikiCycle(imgObject){
    console.log(imgObject);
    let random = Math.floor(Math.random()*imgObject.length);
    if (imgObject.length<3){
        return null;
    }
    else if (imgObject[random].title=="File:Blue pencil.svg" || 
        imgObject[random].title=="File:Wikiquote-logo.svg" || 
        imgObject[random].title=="File:Searchtool.svg" ||
        imgObject[random].title=="File:Commons-logo.svg" ||
        imgObject[random].title=="File:Wikisource-logo.svg" ||
        imgObject[random].title=="File:WPVA-khamsa.svg" ||
        imgObject[random].title=="File:Portal-puzzle.svg" ||
        imgObject[random].title=="File:P vip.svg" ||
        imgObject[random].title=="File:Wikisource-logo.svg.png" ||
        imgObject[random].title=="File:Wikidata-logo.svg.png" ||
        imgObject[random].title=="File:Question_book-new.svg" ||
        imgObject[random].title=="File:Nuvola_apps_package_graphics.png"
    ){
        wikiCycle(imgObject);
    }
    else {
        fetch(endPointWikiImages + imgObject[random].title)
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            var source = Object.values(data.query.pages)[0].imageinfo[0].url;
            let title = Object.values(data.query.pages)[0].title;
            title = title.slice(5, title.length-4);
            var frame = document.getElementById("frame");
            frame.setAttribute("src", source, "title", title);
        })
    }
}
function descriptionCollapse(stuff){
    let desc = stuff.toString();
    console.log(desc);
    while (desc.includes("(")==true){
        desc = desc.split(/\([^()]*\)/);
        desc = desc.join("");
    }
    let description = desc.replace(/ ,, /g, ", ").replace(/ , /g, ", ").replace(/\./g, ". ").replace(/\.  /g,". ").replace(/ ,\./g,".").replace(/ \. /g,". ");
    return description;
}
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


// this function selects a different picture or each of the 5 artists i have in the gallery.

function galleryPic(author){
    let img = document.getElementById("pic"+author);
    let art = {
        "Caravaggio": [
            {"src":"https://upload.wikimedia.org/wikipedia/commons/b/b2/Caravaggio_Judith_Beheading_Holofernes.jpg","title":"Judith Beheading Holofernes"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/b/b6/Caravaggio_-_I_Musici.jpg","title":"The Musicians"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/f/f6/David_with_the_Head_of_Goliath-Caravaggio_%281610%29.jpg","title":"David with the Head of Goliath"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/1/18/Martirio_di_San_Pietro_September_2015-1a.jpg","title":"The Crucifixion of Saint Peter"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/6/64/Boy_with_a_Basket_of_Fruit-Caravaggio_%281593%29.jpg","title":"Boy with a Basket of Fruit"}
        ],
        "Repin": [
            {"src":"https://upload.wikimedia.org/wikipedia/commons/a/ae/Ilia_Efimovich_Repin_%281844-1930%29_-_Volga_Boatmen_%281870-1873%29.jpg","title":"Barge Haulers on the Volga"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/c/c7/Kurskaya_korennaya.jpg","title":"Religious Procession in Kursk Governate"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/3/33/Iv%C3%A1n_el_Terrible_y_su_hijo%2C_por_Ili%C3%A1_Repin.jpg","title":"Ivan the Terrible and His Son Ivan on November 16th, 1581"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/7/79/Ilja_Jefimowitsch_Repin_-_Reply_of_the_Zaporozhian_Cossacks_-_Yorck.jpg","title":"Reply of the Zaporozhian Cossacks to Sultan Mehmed IV"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/1/1d/Khata_by_Repin.jpg","title":"Ukrainian peasant house"}
        ],
        "Nagel": [
            {"src":"http://arthistoryarchive.com/arthistory/contemporary/images/PatrickNagel-Rio.jpg","title":"Rio"},
            {"src":"http://2.bp.blogspot.com/_qTSG-SpmQ2g/SxPv4h8GitI/AAAAAAAAAd8/jtWstyULdEU/s1600/Patrick_Nagel_020.jpg","title":"Nagel Woman"},
            {"src":"http://www.arts-wallpapers.com/modern_art_wallpapers/patrick_nagel/imweg1.jpg","title":"Nagel Woman with Horse"},
            {"src":"http://authorizedamy.com/wp-content/uploads/2012/01/1226.png","title":"Authorized Amy"},
            {"src":"https://trendland.com/wp-content/uploads/2009/07/patrick-nagel-80s-fashion-illustration_8.jpg","title":"Fashion 80s"}
        ],
        "Nahl": [
            {"src":"https://upload.wikimedia.org/wikipedia/commons/5/5f/Nahl_1872%2C_Sunday_Morning_in_the_Mines.jpg","title":"Sunday Morning in the Mines"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/8/84/Charles_Christian_Nahl%2C_Sacramento_Indian_with_Dogs_1867.jpg","title":"Sacramento Indian with Dogs"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/7/7d/Charles_Christian_Nahl_-_Miners_in_the_Sierras_-_Google_Art_Project.jpg","title":"Miners in the Sierras"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/2/29/Charles_Christian_Nahl_-_Peter_Quivey_and_the_Mountain_Lion_-_Google_Art_Project.jpg","title":"Peter Quivey killed a Mountain Lion"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/3/3d/Charles_Christian_Nahl_1871%2C_The_Rape_Of_The_Sabines_-_The_Invasion.jpg","title":"The Rape of the Sabines"}
        ],
        "Thiebaud": [
            {"src":"http://albertis-window.com/wp-content/uploads/2015/06/Wayne-Theibaud-detail-Folsom-Street-Fair-Cake-Crocker-Art-Museum-2013.jpg","title":"Folsom Street Fair Cake"},
            {"src":"https://redtreetimes.files.wordpress.com/2009/03/thiebaud-fields-and-furrows-11.jpg","title":"Red Tree Times"},
            {"src":"http://www.artfixdaily.com/images/cache/aug3_crocker_thiebaud.jpg","title":"Homecoming"},
            {"src":"https://i.pinimg.com/736x/95/8e/93/958e9384bc995ec65d591cbb937e3b6b.jpg","title":"Interchange"},
            {"src":"https://i.pinimg.com/564x/5c/84/0d/5c840daba6ec5e90143e5f2186dbc667.jpg","title":"Title Unknown"}
        ]
    };
    let index = Math.floor(Math.random()*5);
    console.log(author);
    console.log(art[author][index].src);
    img.setAttribute("src", art[author][index].src);
    img.setAttribute("title", art[author][index].title);   
}