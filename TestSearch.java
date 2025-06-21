package com.cognizant;

public class TestSearch {
    public static void main(String[] args) {
        Product productsLinear[] = {
            new Product(102, "Laptop", "Electronics"),
            new Product(106, "NoteBook", "Stationary"),
            new Product(101, "Bag", "Stationary"),
            new Product(104, "MobilePhone", "Electronics")
        };

        Product productsBinary[] = {
            new Product(101, "Bag", "Stationary"),
            new Product(102, "Laptop", "Electronics"),
            new Product(104, "MobilePhone", "Electronics"),
            new Product(106, "NoteBook", "Stationary")
        };
        long startTime, endTime;
        startTime = System.currentTimeMillis();

        Product linear = Search.Linear(productsLinear, 104);
        endTime = System.currentTimeMillis();
        
        System.out.println("Time taken by Linear Search: " + (endTime - startTime) + " ms");
        System.out.println("Linear Search Result: " + linear);
        
        startTime = System.currentTimeMillis();
        Product bin = Search.Binary(productsBinary, 106);
        endTime = System.currentTimeMillis();

        System.out.println("Time taken by Binary Search: " + (endTime - startTime) + " ms");
        System.out.println("Binary Search Result: " + bin);
        
        
    }
}

class Search {
    public static Product Linear(Product productsLinear[], int searchID) {
        for (Product product : productsLinear) {
            if (product.product_id == searchID) {
                return product;
            }
        }
        return null;
    }

    public static Product Binary(Product productsBinary[], int searchID) {
        int left = 0;
        int right = productsBinary.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (productsBinary[mid].getProductid() == searchID) {
                return productsBinary[mid];
            } else if (productsBinary[mid].getProductid() < searchID) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

class Product {
    int product_id;
    String product_name;
    String category;

    Product(int product_id, String product_name, String category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
    }

    public int getProductid() {
        return product_id;
    }

    public String productName() {
        return product_name;
    }

    public String productCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "[" + product_id + "] " + product_name + " (" + category + ")";
    }
}
