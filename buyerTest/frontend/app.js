//function to render a new saved listing object
function addListing(parentId, address, price, listeddate, type) {
    var newContainer = document.createElement("div");
    newContainer.classList.add("saved-listing");
    var newElement1 = document.createElement('p');
    var newElement2 = document.createElement('p');
    var newElement3 = document.createElement('p');
    var newElement4 = document.createElement('p');
    var parentContainer = document.getElementById(parentId);
    newElement1.textContent = 'Address: ' + address;
    newElement2.textContent = 'Price: ' + price;
    newElement3.textContent = 'Listed Date: ' + listeddate;
    newElement4.textContent = 'Type: ' + type;
    newContainer.appendChild(newElement1);
    newContainer.appendChild(newElement2);
    newContainer.appendChild(newElement3);
    newContainer.appendChild(newElement4);
    parentContainer.appendChild(newContainer);
}

//function to render a past offer object (we made up 2 past offers by hardcoded the actual attributes for this part)
function addNewOffer(parentId, mlsid, nprice, sellerid, decision, offerdate) {
    var newContainer = document.createElement("div");
    newContainer.classList.add("offer-info");
    var newElement0 = document.createElement('h2');
    var newElement1 = document.createElement('p');
    var newElement2 = document.createElement('p');
    var newElement3 = document.createElement('p');
    var newElement4 = document.createElement('p');
    var newElement5= document.createElement('p');
    var newElement6 = document.createElement('p');

    var parentContainer = document.getElementById(parentId);
    newElement0.textContent = 'Offer: ' ;
    newElement1.textContent = 'MLSID: ' + mlsid;
    newElement2.textContent = 'Negotiated Price: ' + nprice;
    newElement4.textContent = 'Seller Id: ' + sellerid;
    newElement5.textContent = 'Decision: ' + decision;
    newElement6.textContent = 'Date' + offerdate;
    newContainer.appendChild(newElement0);
    newContainer.appendChild(newElement1);
    newContainer.appendChild(newElement2);
    newContainer.appendChild(newElement4);
    newContainer.appendChild(newElement5);
    newContainer.appendChild(newElement6);
    parentContainer.appendChild(newContainer);
}

//hits the getSavedListingsData REST endpoint to get the saved listings data from listings REST controller using the savedlistingids as query parameters
function fetchDataAndPopulate() {
    fetch('http://localhost:6060/buyerAccount/getSavedListingsData', {method: 'POST',
    headers: {
        'Content-Type': 'application/json' 
    },
    body: JSON.stringify({}) 
})
        .then(response => response.json())
        .then(data => {
            data.forEach(listing => {
                addListing("savedListings", listing.address, listing.price, listing.listeddate, listing.type);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

addNewOffer("offers", 22, 550000, 2, "Approved", " 04.23.2024")
addNewOffer("offers", 23, 330000, 2, "Rejected", " 04.19.2024")
// Call fetchDataAndPopulate when the page is loaded
document.addEventListener('DOMContentLoaded', fetchDataAndPopulate);


// function checkForNewData(){
//     //testData. The final data should be the parameters needed to populate either the savedlisting or the offer.
//     //The function parameters should also need to be changed.
//     var name1 = "Diego";
//     var email1 = "dpena6@gmu.edu";
//     var address1 = "123 SomeStreet Way";
//     var price1 = "Listing Price: $" + 500000;

//     var name2 = "John";
//     var email2 = "jappleseed@gmu.edu";
//     var address2 = "789 OtherSide St";
//     var price2 = "Offer Price: $" + 600000;

//     addListing("savedListings",name1,email1,address1,price1);


//     addListing("offers",name2,email2,address2,price2);

// }

// checkForNewData()
// // setInterval(checkForNewData,3000);