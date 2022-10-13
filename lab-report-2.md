# Lab Report 2
## ArrayTest: Average Without Lowest
For the averageWithoutLowest() method, the failure-inducing input was {2, 3, 4, 2, 2}, which should output 2.75 but instead output 1.75.
```
double[] input2 = {2.0, 3.0, 4.0, 2.0, 2.0};
assertEquals(2.75, ArrayExamplesaverageWithoutLowest(input2), 0.0001);
```
![Terminal output](https://imgur.com/ARi9G2r)

The bug turned out to be whenever the lowest value in the array was duplicated more than once, it caused the method to remove all the duplicate elements instead of just one. This was fixed by creating a boolean statement that determined whether or not one of the lowest elements was removed. If one is removed, the statement flips from false to true, and then streamlines the remaining elements to all be included in the final calculation.

The first code block shows the faulty code, while the second code block shows the fixed code:
```
static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
        if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
        if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
}
```
```
static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
        if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    boolean removed = false;
    for(double num: arr) {
        if(num != lowest || removed == true) { sum += num; }
        else { removed = true; }
    }
    return sum / (arr.length - 1);
}
```
***
## LinkedListTest: Append
The failure-inducing input for append() was by appending a 10, 20, and 30 respectively and proceeding to check if the last value in the linked list was a 30. Instead, an infinite loop was found in the terminal.
```
LinkedList tester = new LinkedList();
tester.append(10);
tester.append(20);
tester.append(30);
assertEquals(30, tester.root.next.next.value);
```
![Terminal output](https://imgur.com/luyBvP4)

This time, the bug turned out to be in the condition when dealing with appending to a linked list with more than 1 existing element. Inside the while loop, whenever the end was detected, a new node would be added, thus creating the infinite loop. The solution was to move the creation of a new node outside the while loop:
```
public void append(int value) {
    if(this.root == null) {
        this.root = new Node(value, null);
        return;
    }
    // If it's just one element, add if after that one
    Node n = this.root;
    if(n.next == null) {
        n.next = new Node(value, null);
        return;
    }
    // Otherwise, loop until the end and add at the end with a null
    while(n.next != null) {
        n = n.next;
        n.next = new Node(value, null);
    }
}
```
```
public void append(int value) {
    if(this.root == null) {
        this.root = new Node(value, null);
        return;
    }
    // If it's just one element, add if after that one
    Node n = this.root;
    if(n.next == null) {
        n.next = new Node(value, null);
        return;
    }
    // Otherwise, loop until the end and add at the end with a null
    while(n.next != null) {
        n = n.next;
    }
    n.next = new Node(value, null);
}
```
