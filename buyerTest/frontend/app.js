function addListing(parentId,name,email,address,price){
    var newContainer=document.createElement("div");
    newContainer.classList.add("saved-listing");
    var newElement1 = document.createElement('p');
    var newElement2 = document.createElement('p');
    var newElement3 = document.createElement('p');
    var newElement4 = document.createElement('p');
    //Add all new information here to newContainer
    var parentContainer=document.getElementById(parentId);
    newElement1.textContent=name;
    newElement2.textContent=email;
    newElement3.textContent=address;
    newElement4.textContent=price;
    newContainer.appendChild(newElement1);
    newContainer.appendChild(newElement2);
    newContainer.appendChild(newElement3);
    newContainer.appendChild(newElement4);
    parentContainer.appendChild(newContainer);
}

function checkForNewData(){
    //testData. The final data should be the parameters needed to populate either the savedlisting or the offer.
    //The function parameters should also need to be changed.
    var name1 = "Diego";
    var email1 = "dpena6@gmu.edu";
    var address1 = "123 SomeStreet Way";
    var price1 = 500000;

    var name2 = "John";
    var email2 = "jappleseed@gmu.edu";
    var address2 = "789 OtherSide St";
    var price2 = 600000;

    addListing("savedListings",name1,email1,address1,price1);


    addListing("offers",name2,email2,address2,price2);

}
setInterval(checkForNewData,3000);