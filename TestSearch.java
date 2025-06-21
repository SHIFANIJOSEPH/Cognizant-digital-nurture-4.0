package com.cognizant;

/*

What is Asymptotic Notation?
Asymptotic notation describes the growth of an algorithm’s running time or space usage as the input size (n) becomes very large.

It's a mathematical way to compare the efficiency of algorithms, especially when exact timing isn't practical due to different hardware or input variations.

Big O Notation (O)
Big O gives an upper bound on the time complexity — how the runtime grows in the worst case.

1.Linear Search
How it works:
It goes through the array element by element from start to end, checking if the current element matches the search value.

Time Complexity:
Best Case:

*Search element is at the first index.

*Only 1 comparison is made.

Time Complexity: O(1)

Average Case:

*Search element is somewhere in the middle of the array.

 *On average, n/2 comparisons are made.

*Time Complexity: O(n)

Worst Case:

*Search element is at the last index or not found.

*It will traverse the entire array.

Time Complexity: O(n)

 2. Binary Search
 How it works:
Works only on a sorted array.

It keeps dividing the array in half, checking the middle element each time.

Time Complexity:
Best Case:

Search element is at the middle of the array on the first check.

Only 1 comparison.

Time Complexity: O(1)

Average Case:

Search element is somewhere in the array, requiring about log₂(n) comparisons.

Each step cuts the search space in half.

Time Complexity: O(log n)

Worst Case:

Search element is not present or located at the extreme ends.

Will perform log₂(n) comparisons until it concludes.

Time Complexity: O(log n)


*/

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


