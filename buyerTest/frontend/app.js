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