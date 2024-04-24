
function addNewOffer(parentId, mlsid, nprice, buyerid, offerdate) {
    var newContainer = document.createElement("div");
    newContainer.classList.add("offer-info");
    var newElement0 = document.createElement('h2');
    var newElement1 = document.createElement('p');
    var newElement2 = document.createElement('p');
    var newElement3 = document.createElement('p');
    var newElement4 = document.createElement('p');
    var parentContainer = document.getElementById(parentId);
    newElement0.textContent = 'Offer: ';
    newElement1.textContent = 'MLSID: ' + mlsid;
    newElement2.textContent = 'Negotiated Price: ' + nprice;
    // newElement3.textContent = 'Offer Date: ' + offerdate;
    newElement4.textContent = 'Buyer Id: ' + buyerid;
    newContainer.appendChild(newElement0);
    newContainer.appendChild(newElement1);
    newContainer.appendChild(newElement2);
    // newContainer.appendChild(newElement3);
    newContainer.appendChild(newElement4);
    parentContainer.appendChild(newContainer);
}

document.addEventListener("DOMContentLoaded", function () {
    // Function to show seller information
    function offerInfo() {
        const offerInfoDiv = document.getElementById('offerInfo');
        offerInfoDiv.style.display = 'block';

        // Fetch seller information from the API
        fetch('http://localhost:7070/api/v1/sellerREST/getOfferIdsData', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({})
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch seller information');
                }
                return response.json();
            })
            .then(data => {
                console.log('Seller Info API response:', data);
                console.log(data.length)
                if (data.length > 0) {
                    for (let i = 0; i < data.length; i++) {
                        let mlsid = data[i].mlsid;
                        let price = data[i].price;
                        let buyerid = data[i].buyerId;
                        let offerdate = data[i].offerDate;
                        console.log(mlsid, price, buyerid, offerdate);
                        addNewOffer("offerInfo", mlsid, price, buyerid, offerdate);

                    }

                    // data.forEach(listing => {
                    //     addListing("savedListings", listing.address, listing.price, listing.listeddate, listing.type);
                    // });


                } else {
                    offerInfoDiv.innerHTML = '<p>No seller information found</p>';
                }
            })
            .catch(error => {
                console.error('Error fetching seller information:', error);
                offerInfoDiv.innerHTML = '<p>No offer information yet...</p>';
            });
    }


    // Function to submit the listing form (unchanged)
    function submitListingForm(formData) {
        const submitUrl = 'http://localhost:7070/api/v1/sellerREST/submitListing';

        fetch(submitUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log('Listing submitted:', data);
                fetchPropertyList();
            })
            .catch(error => {
                console.error('Error submitting listing:', error);
            });
    }

    // Add event listener to the listing form (moved inside DOMContentLoaded)
    const listingForm = document.getElementById('listingForm');
    if (listingForm) {
        listingForm.addEventListener('submit', function (event) {
            event.preventDefault();

            const formData = {
                type: document.getElementById('type').value,
                beds: parseInt(document.getElementById('beds').value),
                baths: parseInt(document.getElementById('baths').value),
                price: parseFloat(document.getElementById('price').value),
                address: document.getElementById('address').value
            };

            submitListingForm(formData);
        });
    }

    // Call showSellerInfo to display seller information initially
    offerInfo();
    // Call fetchPropertyList initially to populate the table
    //fetchPropertyList();
});
