let sortDirection = false;
let productData = [
    { productname: 'Clock', highestCurrentBid: '500', noOfBidders: '8', bidEndDate: '2021-09-23' },
    { productname: 'Keyboard', highestCurrentBid: '5000', noOfBidders: '10', bidEndDate: '2021-09-28' },
    { productname: 'Charger', highestCurrentBid: '1300', noOfBidders: '1', bidEndDate: '2021-09-22' },
    { productname: 'Watch', highestCurrentBid: '4000', noOfBidders: '3', bidEndDate: '2021-09-20' },
    { productname: 'Shoes', highestCurrentBid: '5500', noOfBidders: '2', bidEndDate: '2021-09-20' },
];

window.onload = () => {
    loadTableData(productData)
};

function loadTableData(productData) {
    const tableBody = document.getElementById('tableData');
    let dataHTML = '';

    for (let product of productData) {
        dataHTML += "<tr><td>${ product.productname }</td><td>${ product.highestCurrentBid }</td><td>${ product.noOfBidders }</td><td>${ product.bidEndDate }</td><td></td></tr>";
    }
    console.log(dataHTML)
    tableBody.innerHTML = dataHTML;
}