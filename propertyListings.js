document.addEventListener('DOMContentLoaded', function () {
	const searchForm = document.getElementById('searchForm');
	const propertyListings = document.getElementById('propertyListings');
	// Fetch data from the API endpoint
	let response = [];
	let globalListings = [];
	const retrieveData = async () => {
		try {
			let response = await axios.get("http://localhost:8080/api/v1/listing");
			globalListings = response.data;
			console.log(response.data); // Check to see if data is fetched successfully
		} catch (error) {
			console.error(error);
			// Handle error
		}
	};
	//calls the function i just defined above.
	retrieveData().then(response => {
		displayPropertyListings(globalListings);
	});


	searchForm.addEventListener('submit', function (event) {
		event.preventDefault();
		console.log('Form submitted');

		//Get the filter values from the document elements that represent the filter bar
		const propertyTypeFilter = document.getElementById('propertyTypeFilter').value.toLowerCase();
		const bedsFilter = parseInt(document.getElementById('bedsFilter').value);
		const bathsFilter = parseInt(document.getElementById('bathsFilter').value);
		const mlsidFilter = parseInt(document.getElementById('mlsidFilter').value);
		const addressFilter = document.getElementById('addressFilter').value.toLowerCase();
		const priceFilter = parseInt(document.getElementById('priceFilter').value);

		console.log('Filters:', propertyTypeFilter, bedsFilter, bathsFilter, mlsidFilter, addressFilter, priceFilter);
		
		//multiple if conditions to see which filters are selected based on the filter variables. more than one filter can be chosen.
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

	//this function takes in listing objects, creates a div for each of them and inserts in the data of the listing object in a formatted html snippet.
	//Each 'card' that is displayed on the frontend includes a header, image, 5 paragraphs, and 2 buttons (1 for save listing, 1 for message button)
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
		    <p class="mlsid"><strong>MLS ID:</strong> ${listing.mlsid}</p>
		    <p class="price"><strong>Price:</strong> ${listing.price}</p>
		    <button class="save-listing-btn"> Save Listing</button>
		    <button class="message-seller-btn1"> Offer</button>`;
			propertyListings.appendChild(listingElem);
		});

		const saveListingButtons = document.querySelectorAll('.save-listing-btn');
		saveListingButtons.forEach(saveListingBtn => {
			saveListingBtn.addEventListener('click', function () {
				const mlsidText = this.parentNode.querySelector('.mlsid').textContent.split(':')[1].trim();
				console.log("MLSID first: " + mlsidText);
				const listingmlsid = parseInt(mlsidText.trim()); // Trim any leading/trailing whitespace
				console.log("MLSID type: " + typeof (listingmlsid)); // Check the type of listingmlsid
				console.log("Parsed MLSID: " + listingmlsid); // Log the parsed MLSID
				const saveListingEvent = async () => {
					try {
						let response = await axios.post("http://localhost:9000/api/v1/mainREST/sendListingId", listingmlsid, {
							headers: {
							    'Content-Type': 'application/json'
							}});
						console.log(response.data); // Check to see if data is fetched successfully
					} catch (error) {
						console.error(error);
						// Handle error
					}
				};
				//calls the function I just defined above and returns a response.
				saveListingEvent().then(response => {
					console.log("Sent saved listing id ")
					console.log(listingmlsid)
					console.log("to buyer")
				});
			});
		});

		// Add event listeners for the "Message Seller with Offer" buttons
		const messageSellerBtns = document.querySelectorAll('.message-seller-btn1');
		messageSellerBtns.forEach(offerBtn => {
			offerBtn.addEventListener('click', function () {
				//input validation: determines if the price submitted is at least 75% of original price(retrieved from price class in the html content)
				const offerInput = prompt('Enter your negotiable offer:');
				const listedPriceElem = this.parentNode.querySelector('.price');
				const listedPrice = parseFloat(listedPriceElem.textContent.split(':')[1].trim().replace('$', ''));
				const seventyPercent = 0.75 * listedPrice;
				console.log("75 percent is: " + seventyPercent)
				if (offerInput) {
					const offerAmount = parseFloat(offerInput);
					console.log("OFfer amount type" + typeof (offerAmount));
					if (offerAmount >= seventyPercent) {
						const newTextNode = document.createTextNode(`Offered: ${offerInput} to Seller!`);
						const mlsidText = this.parentNode.querySelector('.mlsid').textContent.split(':')[1].trim();
						console.log("MLSID first: " + mlsidText);
						const listingmlsid = Number(mlsidText.trim()); // Trim any leading/trailing whitespace
						console.log("MLSID type: " + typeof (listingmlsid)); // Check the type of listingmlsid
						console.log("Parsed MLSID: " + listingmlsid); // Log the parsed MLSID
						const sendOffer = async () => {
							try {
								let response = await axios.post("http://localhost:8080/api/v1/offer", { "buyerid": 1, "sellerid": 2, "mlsid": listingmlsid, "negotiatedPrice": offerAmount });
								console.log(response.data); // Check to see if data is fetched successfully
							} catch (error) {
								console.error(error);
								// Handle error
							}
						};
						sendOffer().then(response => {
							console.log("Sent offer for")
							console.log(listingmlsid)
							console.log("to seller")
						});
						offerBtn.parentNode.replaceChild(newTextNode, offerBtn);
					} else {
						alert(`Offer must be at least 75% of Listed Price (${seventyPercent}). Please try again.`);
					}
				}
			});
		});
	}
});

