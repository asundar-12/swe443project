document.addEventListener("DOMContentLoaded", function() {
    // Function to show seller information
    function showSellerInfo() {
        const sellerInfoDiv = document.getElementById('sellerInfo');
        sellerInfoDiv.style.display = 'block';

        // Fetch seller information from the API
        fetch('http://localhost:7070/api/sellers')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch seller information');
                }
                return response.json();
            })
            .then(data => {
                console.log('Seller Info API response:', data);

                if (data.length > 0) {
                    const seller = data[0]; // Assuming there's only one seller
                    const offerIds = seller.offerIds.split(','); // Split offerIds string into array
                    const offerIdsList = offerIds.map(id => `<li>${id}</li>`).join(''); // Create list items

                    const sellerInfoHtml = `
                        <h2>Seller Information</h2>
                        <p><strong>Name:</strong> ${seller.name}</p>
                        <p><strong>Email:</strong> ${seller.email}</p>
                        <p><strong>Offer IDs:</strong></p>
                        <ul>${offerIdsList}</ul>
                    `;
                    sellerInfoDiv.innerHTML = sellerInfoHtml;
                } else {
                    sellerInfoDiv.innerHTML = '<p>No seller information found</p>';
                }
            })
            .catch(error => {
                console.error('Error fetching seller information:', error);
                sellerInfoDiv.innerHTML = '<p>Error fetching seller information</p>';
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
        listingForm.addEventListener('submit', function(event) {
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
    showSellerInfo();
    // Call fetchPropertyList initially to populate the table
    //fetchPropertyList();
});
