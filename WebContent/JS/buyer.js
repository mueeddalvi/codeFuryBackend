let sortDirection = false;
let productData = [
    { productname: 'Clock', minimumBidAmount: '500', noOfBidders: '8', bidEndDate: '2021-09-23' }, // comes from json data java
    { productname: 'Keyboard', minimumBidAmount: '5000', noOfBidders: '10', bidEndDate: '2021-09-28' },
    { productname: 'Charger', minimumBidAmount: '1300', noOfBidders: '1', bidEndDate: '2021-09-22' },
    { productname: 'Watch', minimumBidAmount: '4000', noOfBidders: '3', bidEndDate: '2021-09-20' },
    { productname: 'Shoes', minimumBidAmount: '5500', noOfBidders: '2', bidEndDate: '2021-09-20' },
];


window.onload = () => {
    loadTableData(productData)
};

function loadTableData(productData) {
    const tableBody = document.getElementById('tableData');
    let dataHTML = "<table><tr>";

    for (let product of productData) {
        dataHTML += "<td>" + product.productname + "</td><td>" + product.minimumBidAmount + "</td><td>" + product.noOfBidders + "</td><td>" + product.bidEndDate + "</td><td></td><td>" + "edit" + "</td></tr>";
    }
    dataHTML += "</tr></table>"

    console.log(dataHTML)
    tableBody.innerHTML = dataHTML;
}