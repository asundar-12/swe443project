document.addEventListener('DOMContentLoaded', function () {
	const searchForm = document.getElementById('searchForm');
	const propertyListings = document.getElementById('propertyListings');
	  // Fetch data from the API endpoint
	  let response = [];
	  let globalListings = [];
	  const retrieveData = async () =>{
	  try {
	      let response = await axios.get("http://localhost:8080/api/v1/listing");
	      globalListings = response.data;
	      console.log(response.data); // Check to see if data is fetched successfully
	  } catch (error) {
	      console.error(error);
	      // Handle error
	  }
	};

	retrieveData().then(response => {
		displayPropertyListings(globalListings);
	    });
	// const response = [

	// 	{ address: '123 Main St', image: 'image1.jpg', propertyType: 'House', beds: 3, baths: 2, mlsid: 123, price: 250000 },
	// 	{ address: '456 Elm St', image: 'image2.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 456, price: 180000 },
	// 	{ address: '789 Oak St', image: 'image3.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 789, price: 120000 },
	// 	{ address: '101 Pine St', image: 'image4.jpg', propertyType: 'House', beds: 4, baths: 3, mlsid: 101, price: 350000 },
	// 	{ address: '202 Elm St', image: 'image5.jpg', propertyType: 'Apartment', beds: 1, baths: 1, mlsid: 202, price: 100000 },
	// 	{ address: '303 Oak St', image: 'image6.jpg', propertyType: 'Condo', beds: 3, baths: 2.5, mlsid: 303, price: 300000 },
	// 	{ address: '404 Maple St', image: 'image7.jpg', propertyType: 'House', beds: 9, baths: 6, mlsid: 404, price: 200000 },
	// 	{ address: '505 Cedar St', image: 'image8.jpg', propertyType: 'Apartment', beds: 3, baths: 2, mlsid: 505, price: 220000 },
	// 	{ address: '606 Elmwood St', image: 'image9.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 606, price: 150000 },
	// 	{ address: '707 Oakwood St', image: 'image10.jpg', propertyType: 'House', beds: 6, baths: 4.5, mlsid: 707, price: 400000 },
	// 	{ address: '808 Maplewood St', image: 'image11.jpg', propertyType: 'Apartment', beds: 2, baths: 1.5, mlsid: 808, price: 180000 },
	// 	{ address: '909 Pinewood St', image: 'image12.jpg', propertyType: 'Condo', beds: 4, baths: 2, mlsid: 909, price: 320000 },
	// 	{ address: '1010 Cedarwood St', image: 'image13.jpg', propertyType: 'House', beds: 3, baths: 2, mlsid: 1010, price: 280000 },
	// 	{ address: '1111 Pinehurst St', image: 'image14.jpg', propertyType: 'Apartment', beds: 2, baths: 1.5, mlsid: 1111, price: 170000 },
	// 	{ address: '1212 Maplehurst St', image: 'image15.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 1212, price: 140000 },
	// 	{ address: '1313 Cedarhurst St', image: 'image16.jpg', propertyType: 'House', beds: 4, baths: 3, mlsid: 1313, price: 360000 },
	// 	{ address: '1414 Elmwood St', image: 'image17.jpg', propertyType: 'Apartment', beds: 3, baths: 2, mlsid: 1414, price: 210000 },
	// 	{ address: '1515 Oakwood St', image: 'image18.jpg', propertyType: 'Condo', beds: 2, baths: 1.5, mlsid: 1515, price: 160000 },
	// 	{ address: '1616 Maplewood St', image: 'image19.jpg', propertyType: 'House', beds: 5, baths: 3.5, mlsid: 1616, price: 410000 },
	// 	{ address: '1717 Pinewood St', image: 'image20.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 1717, price: 190000 },
	// 	{ address: '2121 Oak St', image: 'image21.jpg', propertyType: 'House', beds: 3, baths: 2, mlsid: 2121, price: 270000 },
	// 	{ address: '2222 Elm St', image: 'image22.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 2222, price: 190000 },
	// 	{ address: '2323 Oakwood St', image: 'image23.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 2323, price: 130000 },
	// 	{ address: '2424 Maple St', image: 'image24.jpg', propertyType: 'House', beds: 4, baths: 3, mlsid: 2424, price: 330000 },
	// 	{ address: '2525 Cedar St', image: 'image25.jpg', propertyType: 'Apartment', beds: 3, baths: 2, mlsid: 2525, price: 220000 },
	// 	{ address: '2626 Pine St', image: 'image26.jpg', propertyType: 'Condo', beds: 2, baths: 1.5, mlsid: 2626, price: 160000 },
	// 	{ address: '2727 Elmwood St', image: 'image27.jpg', propertyType: 'House', beds: 5, baths: 3.5, mlsid: 2727, price: 380000 },
	// 	{ address: '2828 Oakwood St', image: 'image28.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 2828, price: 200000 },
	// 	{ address: '3030 Pinewood St', image: 'image30.jpg', propertyType: 'House', beds: 4, baths: 3, mlsid: 3030, price: 360000 },
	// 	{ address: '3131 Elmwood St', image: 'image31.jpg', propertyType: 'Apartment', beds: 3, baths: 2, mlsid: 3131, price: 210000 },
	// 	{ address: '3232 Oakwood St', image: 'image32.jpg', propertyType: 'Condo', beds: 2, baths: 1.5, mlsid: 3232, price: 170000 },
	// 	{ address: '3333 Maplewood St', image: 'image33.jpg', propertyType: 'House', beds: 5, baths: 3.5, mlsid: 3333, price: 400000 },
	// 	{ address: '3434 Pinewood St', image: 'image34.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 3434, price: 180000 },
	// 	{ address: '3535 Cedarwood St', image: 'image35.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 3535, price: 150000 },
	// 	{ address: '3636 Pinehurst St', image: 'image36.jpg', propertyType: 'House', beds: 4, baths: 3, mlsid: 3636, price: 370000 },
	// 	{ address: '3737 Elmwood St', image: 'image37.jpg', propertyType: 'Apartment', beds: 3, baths: 2, mlsid: 3737, price: 220000 },
	// 	{ address: '3838 Oakwood St', image: 'image38.jpg', propertyType: 'Condo', beds: 2, baths: 1.5, mlsid: 3838, price: 180000 },
	// 	{ address: '3939 Maplewood St', image: 'image39.jpg', propertyType: 'House', beds: 5, baths: 3.5, mlsid: 3939, price: 420000 },
	// 	{ address: '4040 Pinewood St', image: 'image40.jpg', propertyType: 'Apartment', beds: 2, baths: 1, mlsid: 4040, price: 190000 },
	// 	{ address: '4141 Cedarwood St', image: 'image41.jpg', propertyType: 'Condo', beds: 1, baths: 1, mlsid: 4141, price: 160000 }
	// ];



	// displayPropertyListings(response);

	searchForm.addEventListener('submit', function (event) {
		event.preventDefault();
		console.log('Form submitted');
		const propertyTypeFilter = document.getElementById('propertyTypeFilter').value.toLowerCase();
		const bedsFilter = parseInt(document.getElementById('bedsFilter').value);
		const bathsFilter = parseInt(document.getElementById('bathsFilter').value);
		const mlsidFilter = parseInt(document.getElementById('mlsidFilter').value);
		const addressFilter = document.getElementById('addressFilter').value.toLowerCase();
		const priceFilter = parseInt(document.getElementById('priceFilter').value);

		console.log('Filters:', propertyTypeFilter, bedsFilter, bathsFilter, mlsidFilter, addressFilter, priceFilter);
		const filteredListings = globalListings.filter(listing => {
			console.log("Filtering listing : " + listing)
			let matchesFilters = true;

			if (propertyTypeFilter) {
				matchesFilters = matchesFilters && listing.type.toLowerCase().includes(propertyTypeFilter.toLowerCase());
			}

			if (bedsFilter) {
				matchesFilters = matchesFilters && listing.beds <= parseInt(bedsFilter);
			}

			if (bathsFilter) {
				matchesFilters = matchesFilters && listing.baths <= parseInt(bathsFilter);
			}

			if (mlsidFilter) {
				matchesFilters = matchesFilters && listing.mlsid === parseInt(mlsidFilter);
			}

			if (addressFilter) {
				matchesFilters = matchesFilters && listing.address.toLowerCase().includes(addressFilter.toLowerCase());
			}

			if (priceFilter) {
				matchesFilters = matchesFilters && listing.price <= parseInt(priceFilter);
			}

			return matchesFilters;
		});

		console.log('Filtered Listings:', filteredListings);

		displayPropertyListings(filteredListings);
	});

	function displayPropertyListings(listings) {
		propertyListings.innerHTML = '';
		listings.forEach(listing => {
			const listingElem = document.createElement('div');
			listingElem.classList.add('property-listing');
			listingElem.innerHTML = `
		    <h3>${listing.address}</h3>
		    <img src="${listing.image}" alt="Property Image">
		    <p id="propertyType_${listing.mlsid}"><strong>Property Type:</strong> ${listing.type}</p>
		    <p id="beds_${listing.mlsid}"><strong>Beds:</strong> ${listing.beds}</p>
		    <p id="baths_${listing.mlsid}"><strong>Baths:</strong> ${listing.baths}</p>
		    <p id="mlsid_${listing.mlsid}"><strong>MLS ID:</strong> ${listing.mlsid}</p>
		    <p class="price"><strong>Price:</strong> ${listing.price}</p>
		    <button class="message-seller-btn"> Save Listing</button>
		    <button class="message-seller-btn1"> Offer</button>`;
			propertyListings.appendChild(listingElem);
		});
		// Add event listeners for the "Message Seller with Offer" buttons
		const messageSellerBtns = document.querySelectorAll('.message-seller-btn1');
		messageSellerBtns.forEach(offerBtn => {
			offerBtn.addEventListener('click', function () {
				const offerInput = prompt('Enter your negotiable offer:');
				const listedPriceElem = this.parentNode.querySelector('.price');
				const listedPrice = parseFloat(listedPriceElem.textContent.split(':')[1].trim().replace('$', ''));
				const seventyPercent = 0.75 * listedPrice;
				console.log("75 percent is: " + seventyPercent)
				if (offerInput) {
					const offerAmount = parseFloat(offerInput);
					if (offerAmount >= seventyPercent) {
						const newTextNode = document.createTextNode(`Offered: ${offerInput} to Seller!`);
						offerBtn.parentNode.replaceChild(newTextNode, offerBtn);
					} else {
						alert(`Offer must be at least 75% of Listed Price (${seventyPercent}). Please try again.`);
					}
				}
			});
		});
	}
});