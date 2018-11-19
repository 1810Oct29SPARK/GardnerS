//the below is for the gallery page
function galleryPic(author){
    let img = document.getElementById("pic"+author);
    let art = {
        "Caravaggio": [
            {"src":"https://upload.wikimedia.org/wikipedia/commons/b/b2/Caravaggio_Judith_Beheading_Holofernes.jpg","title":"Judith Beheading Holofernes"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/b/b6/Caravaggio_-_I_Musici.jpg","title":"The Musicians"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/f/f6/David_with_the_Head_of_Goliath-Caravaggio_%281610%29.jpg","title":"David with the Head of Goliath"},
            {"src":"https://upload.wikimedia.org/wikipedia/commons/f/f7/Caravaggio_-_Martirio_di_San_Pietro.jpg","title":"The Crucifixion of Saint Peter"},
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
    img.setAttribute("src", art[author][index].src);
    img.setAttribute("title", art[author][index].title);   
}
//the above is for the gallery page.
//the below is for the search page.
const endPointWiki = "https://en.wikipedia.org/w/api.php?&origin=*&action=query&format=json&prop=extracts%7Cimages&exsentences=9&exintro=1&explaintext=1&imlimit=20&redirects=1&titles=";
const endPointWikiImages = "https://en.wikipedia.org/w/api.php?origin=*&action=query&format=json&prop=imageinfo&iiprop=url&titles="
//this function will call for the artist info from wikipedia.
function wikiCall(artist){
    let name = document.getElementById("artistName");
    let desc = document.getElementById("artistDescription");
    let frame = document.getElementById("frame");
    let link = document.getElementById("link");
    fetch(endPointWiki+artist)
    .then(function(resp) {
        return resp.json()
    })
    .then(function(data) {  
        let artistDescription = Object.values(data.query.pages)[0].extract;
        if (artistDescription.includes("refer to")){
            name.innerHTML = "Uh Oh. You need to be more specific.";
            desc.innerHTML = "It seems like you searched for too general of a term. If you are looking for a specific artist try to include their full name.";
            frame.setAttribute("src", "http://esq.h-cdn.co/assets/17/07/1600x800/landscape-1487277724-lead.jpg");
            link.innerText = "";
        }
        else {
            let artistName = Object.values(data.query.pages)[0].title;
            name.innerHTML = artistName;
            name.setAttribute("href","https://en.wikipedia.org/wiki/"+artistName);
            desc.innerHTML = descriptionCollapse(artistDescription);
            link.innerHTML = "Search for prints by "+artistName;
            link.setAttribute("href", "https://www.allposters.com/gallery?txtSearch="+artistName)
            let wikiImages = Object.values(data.query.pages)[0].images;
            wikiCycle(wikiImages);
            artsyCall(artist);
        }
    })
    .catch(function(error){
        name.innerHTML = "Oops, something went wrong."
        desc.innerHTML = "It seems like there was a problem somewhere down the pipe that led to your search not showing anything. Hopefully there was only a small error and everything will be working soon enough. In the mean time, check that you entered everything correctly, then try again."
        frame.setAttribute("src", "http://esq.h-cdn.co/assets/17/07/1600x800/landscape-1487277724-lead.jpg");
        link.innerText = "";
        console.log(error);
    })
}
//this function will grab the pictures that are present on the wikipedia page.
function wikiCycle(imgObject){
    let frame = document.getElementById("frame");
    let random = Math.floor(Math.random()*imgObject.length);
    if (imgObject.length<6){
        //if there aren't very many pics on a page let's set the image to what artsy has.
        noWiki(document.getElementById("artistName").innerText);
    }
    else if (
        //wikipedia returns at max 20 images used on the page.
        //however these can be any image used on the page.
        //often the images are not useful for my purposes.
        //these are the icons wikipedia uses. I know I didn't get all of them.
        imgObject[random].title=="File:Blue pencil.svg" || 
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
        imgObject[random].title=="File:Nuvola_apps_package_graphics.png" ||
        imgObject[random].title=="File:Loudspeaker.svg" ||
        imgObject[random].title=="File:Office-book.svg" ||
        imgObject[random].title=="File:Gnome-mime-sound-openclipart.svg" ||
        imgObject[random].title=="File:Fr-Ceci-n-est-pas-une-pipe.ogg" ||
        imgObject[random].title=="File:Nuvola_apps_kaboodle.svg" ||
        imgObject[random].title=="File:PD-icon.svg" ||
        imgObject[random].title=="File:Books-aj.svg_aj_ashton_01.svg"
        //Well Shucks fella, you got too many of these. if only Wikipedia wasn't being such a punk with the returned images.
    ){
        wikiCycle(imgObject);
    }
    else {
        fetch(endPointWikiImages + imgObject[random].title)
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            let source = Object.values(data.query.pages)[0].imageinfo[0].url;
            let title = Object.values(data.query.pages)[0].title;
            title = title.slice(5, title.length-4);
            frame.setAttribute("src", source);
            frame.setAttribute("title", title);
        })
        .catch(function(error){
            console.log(error);
        })
    }
}
//this function cleans up the returned bios for artists. it gets rid of anything between ( and ).
function descriptionCollapse(stuff){
    let desc = stuff.toString();
    while (desc.includes("(")==true){
        desc = desc.split(/\([^()]*\)/);
        desc = desc.join("");
    }
    let description = desc.replace(/ ,, /g, ", ").replace(/ , /g, ", ").replace(/\./g, ". ").replace(/\.  /g,". ").replace(/ ,\./g,".").replace(/ \. /g,". ");
    return description;
}

//this function sets up a bunch of artist names to be searched for with the wiki api
function randomArtist(){
    let placeholder = document.getElementById("searchTerm");
    let potential =["Rembrandt","Norman Rockwell","Albrecht Durer","Edward Hopper","Leonardo da Vinci","Rapheal","Titian","El Greco","Francisco de Goya","Edouard Manet","Edgar Degas","Claude Monet","Henri Rousseau","Paul Gauguin","Edvard Munch","Gustav Klimt","Henri Matisse","Pablo Picasso","Diego Rivera","Georgia O’Keeffe","Georges Seurat","Vincent van Gogh","Frida Kahlo","René Magritte","Ansel Adams","M. C. Escher"];
    let index = Math.floor(Math.random()*potential.length);
    placeholder.setAttribute("placeholder", potential[index]);
    placeholder.value = potential[index];
    wikiCall(potential[index]);

}
//this makes a call to the artsy api to check if anything by this artist is for sale.
const endPointArtsy = "https://api.artsy.net/api/artists/";
const loginForToken = "https://api.artsy.net/api/tokens/xapp_token?client_id=96eda4509413b44cb867&client_secret=f72307e4f63dc776ba338cc26af437be";
var token;
function getToken(){
    fetch(loginForToken, {method:"POST"})
    .then(function (response){
        return response.json();
    })
    .then(function(data){
        token = data.token;
        console.log(token);
    })
    .catch(function(error){
        console.log(error);
        setTimeout(getToken(),6000);
    })
}
function artsyCall(artist){
    artist = artist.replace(/\s/g, '-').toLowerCase();
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
        //Change Stuff Here Boyo.
        let similarArtists = data["_links"].similar_artists.href;
        otherArtsyCall(similarArtists);
    })
    .catch(function(error){
        let artsyLink = document.getElementById("artsyLink");
        artsyLink.innerHTML = "";
        console.log(error);
    })
}
function otherArtsyCall(artistsUrl){
    let artsyLink = document.getElementById("artsyLink");
    fetch(artistsUrl, {
        method:"GET",
        headers:{
            "X-Xapp-Token":token
        }
    })
    .then(function(response){
        return response.json();
    })
    .then(function(data){
        let artistsArray = data["_embedded"].artists;
        artsyLink.innerHTML = "";
        for (let i = 0; i<artistsArray.length; i++){
            let paragraph = document.createElement("p");
            let entry = document.createElement("a");
            entry.appendChild(document.createTextNode("Learn about "+artistsArray[i].name+", a similar artist"));
            entry.setAttribute("target", "_blank");
            entry.setAttribute("href", artistsArray[i]["_links"].permalink.href);
            paragraph.appendChild(entry);
            artsyLink.appendChild(paragraph);
        }
    })
    .catch(function(error){
        artsyLink.innerHTML = "";
        console.log(error);
    })
}
function noWiki(artist){
    let frame = document.getElementById("frame");
    artist = artist.replace(/\s/g, '-').toLowerCase();
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
        let picLink = data["_links"].image.href;
        picLink = picLink.replace("{image_version}","large");
        frame.setAttribute("src",picLink);
    })
    .catch(function(error){
        console.log(error);
    })
}
//the above is for the search page.
//the below is for the home page
function signUp(){
    let signedUp = document.getElementById("signedUp");
    if(signedUp){signedUp.remove();}
    let name = document.getElementById("nameInput").value.toLowerCase();
    name = name.charAt(0).toUpperCase() + name.slice(1);
    let email = document.getElementById("emailInput").value;
    if(name.includes(" ") && email.includes("@") && email.includes(".")){
        let panel = document.getElementById("panel");
        let para = document.createElement("p");
        para.setAttribute("id", "signedUp");
        para.setAttribute("class", "largeText");
        name = name.split(" ")[0];
        para.innerText = name+", thanks for signing up. We will make sure to provide interesting reading material without cluttering your inbox.";
        panel.appendChild(para);
    }
}
function quotePull(){
    let quoteBody = document.getElementById("quoteBody");
    let quoteAuthor = document.getElementById("quoteAuthor");
    let quotes = [
        {"body":'"The Arts and Sciences, essential to the prosperity of the State and to the ornament of human life, have a primary claim to the encouragement of every lover of his country and mankind."',"author":"George Washington"},
        {"body":'"Art is a nation\'s most precious heritage. For it is in our works of art that we reveal to ourselves and to others the inner vision which guides us as a nation. And where there is no vision, the people perish."',"author":"Lyndon B. Johnson"},
        {"body":'"Aeschylus and Plato are remembered today long after the triumphs of Imperial Athens are gone. Dante outlived the ambitions of thirteenth century Florence. Goethe stands serenely above the politics of Germany, and I am certain that after the dust of centuries has passed over cities, we too will be remembered not for victories or defeats in battle or in politics, but for our contribution to the human spirit."',"author":"John F. Kennedy"},
        {"body":'"If you have only two pennies, spend the first on bread and the other on hyacinths for your soul."',"author":"Arab Proverb"},
        {"body":'"Life without industry is guilt; industry without art is brutality."',"author":"John Rushkin"},
    ];
    let index = Math.floor(Math.random()*5);
    quoteBody.innerText = quotes[index].body;
    quoteAuthor.innerText = quotes[index].author;
}
//the above is for the home page