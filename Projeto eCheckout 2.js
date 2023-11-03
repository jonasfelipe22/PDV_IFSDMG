class Product {
    constructor(name, barcode, price, quantity, suppliers, description) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.suppliers = suppliers;
        this.description = description;
    }
}

class Customer {
    constructor(name, address, phoneNumber, email, document) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.document = document;
    }
}

class eCheckout {
    constructor() {
        this.products = [];
        this.customers = [];
        this.sales = [];
    }

    addProduct(product) {
        this.products.push(product);
    }

    addCustomer(customer) {
        this.customers.push(customer);
    }

    makeSale(product, customer, quantity, paymentMethod) {
        let totalAmount = product.price * quantity;
        let sale = {
            product: product.name,
            customer: customer.name,
            quantity: quantity,
            totalAmount: totalAmount,
            date: new Date(),
            paymentMethod: paymentMethod
        };
        this.sales.push(sale);
    }

    viewSales() {
        console.log(this.sales);
    }
}

let eCheckout = new eCheckout();
let product1 = new Product('Product 1', '1234567890', 100, 10, 'Supplier 1', 'Description 1');
let product2 = new Product('Product 2', '1234567891', 200, 5, 'Supplier 2', 'Description 2');
let customer1 = new Customer('Customer 1', 'Address 1', '1234567890', 'customer1@email.com', '123.456.789-00');
let customer