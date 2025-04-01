package sandbox;

import java.util.*;
import java.util.stream.Stream;

public class CollectionsDemo {
    public static void main(String[] args) {
        // ===== List Examples =====
        System.out.println("===== LIST EXAMPLES =====");
        demonstrateArrayList();
        demonstrateLinkedList();
        
        // ===== Set Examples =====
        System.out.println("\n===== SET EXAMPLES =====");
        demonstrateHashSet();
        demonstrateTreeSet();
        
        // ===== Map Examples =====
        System.out.println("\n===== MAP EXAMPLES =====");
        demonstrateHashMap();
        demonstrateTreeMap();
        
        // ===== Queue Examples =====
        System.out.println("\n===== QUEUE EXAMPLES =====");
        demonstrateQueue();
        
        // ===== Collection Operations =====
        System.out.println("\n===== COLLECTION OPERATIONS =====");
        demonstrateCollectionOperations();
    }
    
    // ArrayLists are good for random access and storing ordered elements
    private static void demonstrateArrayList() {
        System.out.println("\n--- ArrayList ---");
        
        List<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        System.out.println("Fruits list: " + fruits);
        
        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));
        
        // Inserting at specific position
        fruits.add(2, "Grape");
        System.out.println("After inserting Grape at index 2: " + fruits);
        
        // Removing elements
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        
        // Removing by index
        fruits.remove(0); // removes Apple
        System.out.println("After removing first element: " + fruits);
        
        // Checking if element exists
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        
        // Different ways to iterate
        System.out.println("\nIterating using enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        System.out.println("\nIterating using iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
        
        System.out.println("\nIterating using forEach (Java 8+):");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
    }
    
    // LinkedLists are better for frequent insertions/deletions
    private static void demonstrateLinkedList() {
        System.out.println("\n--- LinkedList ---");
        
        LinkedList<String> names = new LinkedList<>();
        
        // Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // LinkedList specific methods
        names.addFirst("First");
        names.addLast("Last");
        
        System.out.println("Names: " + names);
        System.out.println("First name: " + names.getFirst());
        System.out.println("Last name: " + names.getLast());
        
        // Remove first and last
        System.out.println("Removed first: " + names.removeFirst());
        System.out.println("Removed last: " + names.removeLast());
        System.out.println("Names after removal: " + names);
    }
    
    // HashSets store unique elements with no guaranteed order
    private static void demonstrateHashSet() {
        System.out.println("\n--- HashSet ---");
        
        Set<Integer> numbers = new HashSet<>();
        
        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(10); // Duplicate, will be ignored
        
        System.out.println("Numbers set: " + numbers);
        System.out.println("Set size: " + numbers.size()); // Should be 3, not 4
        
        // Checking if element exists
        System.out.println("Contains 20? " + numbers.contains(20));
        
        // Removing elements
        numbers.remove(20);
        System.out.println("After removing 20: " + numbers);
        
        // Iterating
        System.out.println("Set elements:");
        for (Integer number : numbers) {
            System.out.println("- " + number);
        }
    }
    
    // TreeSets store unique elements in sorted order
    private static void demonstrateTreeSet() {
        System.out.println("\n--- TreeSet ---");
        
        Set<String> sortedNames = new TreeSet<>();
        
        // Adding elements (notice they'll be sorted alphabetically)
        sortedNames.add("Zach");
        sortedNames.add("Bob");
        sortedNames.add("Alice");
        sortedNames.add("Yasmine");
        
        System.out.println("Sorted names: " + sortedNames);
        
        // Using TreeSet with custom objects requires a Comparator or Comparable implementation
        Set<Person> people = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        people.add(new Person("Zach", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Alice", 35));
        
        System.out.println("People sorted by name:");
        for (Person person : people) {
            System.out.println("- " + person.getName() + " (" + person.getAge() + ")");
        }
    }
    
    // HashMaps store key-value pairs with no guaranteed order
    private static void demonstrateHashMap() {
        System.out.println("\n--- HashMap ---");
        
        Map<String, Integer> ages = new HashMap<>();
        
        // Adding key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        
        System.out.println("Ages map: " + ages);
        
        // Accessing values by key
        System.out.println("Bob's age: " + ages.get("Bob"));
        
        // Default value if key not found
        System.out.println("David's age: " + ages.getOrDefault("David", 0));
        
        // Checking if key exists
        System.out.println("Contains key 'Alice'? " + ages.containsKey("Alice"));
        System.out.println("Contains value 40? " + ages.containsValue(40));
        
        // Updating a value
        ages.put("Alice", 26); // Overwrites the previous value
        System.out.println("Alice's new age: " + ages.get("Alice"));
        
        // Getting all keys
        System.out.println("All keys: " + ages.keySet());
        
        // Getting all values
        System.out.println("All values: " + ages.values());
        
        // Iterating through entries
        System.out.println("Map entries:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        
        // Java 8+ forEach
        System.out.println("\nUsing forEach:");
        ages.forEach((name, age) -> System.out.println("- " + name + ": " + age));
    }
    
    // TreeMaps store key-value pairs in sorted key order
    private static void demonstrateTreeMap() {
        System.out.println("\n--- TreeMap ---");
        
        Map<String, String> countries = new TreeMap<>(); // Sorted by keys
        
        // Adding elements
        countries.put("US", "United States");
        countries.put("FR", "France");
        countries.put("IN", "India");
        countries.put("AU", "Australia");
        
        System.out.println("Countries (sorted by key): " + countries);
        
        // TreeMap specific navigation methods
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(90, "Excellent");
        scores.put(80, "Good");
        scores.put(70, "Satisfactory");
        scores.put(60, "Pass");
        scores.put(50, "Fail");
        
        System.out.println("\nScores map: " + scores);
        
        // Finding closest matches
        System.out.println("Floor entry for 85: " + scores.floorEntry(85)); // <= 85
        System.out.println("Ceiling entry for 65: " + scores.ceilingEntry(65)); // >= 65
        
        // Navigating the map
        System.out.println("First entry: " + scores.firstEntry());
        System.out.println("Last entry: " + scores.lastEntry());
        System.out.println("Higher entry than 70: " + scores.higherEntry(70)); // > 70
        System.out.println("Lower entry than 70: " + scores.lowerEntry(70)); // < 70
    }
    
    // Queues follow the First-In-First-Out (FIFO) principle
    private static void demonstrateQueue() {
        System.out.println("\n--- Queue ---");
        
        Queue<String> queue = new LinkedList<>();
        
        // Adding elements
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        
        System.out.println("Queue: " + queue);
        
        // Viewing the head without removing
        System.out.println("Head of queue (peek): " + queue.peek());
        
        // Removing elements (FIFO order)
        System.out.println("Removed: " + queue.poll()); // Removes and returns "First"
        System.out.println("Queue after poll: " + queue);
        
        // Priority Queue demonstration
        System.out.println("\n--- PriorityQueue ---");
        
        // Min heap by default (smallest element has highest priority)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        
        System.out.println("Priority Queue: " + priorityQueue);
        System.out.println("Head of priority queue: " + priorityQueue.peek());
        
        System.out.println("Polling elements:");
        while (!priorityQueue.isEmpty()) {
            System.out.println("- " + priorityQueue.poll());
        }
        
        // Max heap (using a custom comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        
        System.out.println("\nMax Heap Priority Queue:");
        while (!maxHeap.isEmpty()) {
            System.out.println("- " + maxHeap.poll());
        }
    }
    
    // Common operations on collections
    private static void demonstrateCollectionOperations() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        // Creating a copy
        List<Integer> copyOfList1 = new ArrayList<>(list1);
        System.out.println("Copy of List 1: " + copyOfList1);
        
        // Sorting
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 2));
        System.out.println("Unsorted list: " + unsortedList);
        
        Collections.sort(unsortedList);
        System.out.println("Sorted list: " + unsortedList);
        
        // Reverse
        Collections.reverse(unsortedList);
        System.out.println("Reversed list: " + unsortedList);
        
        // Shuffle
        Collections.shuffle(unsortedList);
        System.out.println("Shuffled list: " + unsortedList);
        
        // Finding max and min
        System.out.println("Max value: " + Collections.max(unsortedList));
        System.out.println("Min value: " + Collections.min(unsortedList));
        
        // Binary search (requires sorted list)
        Collections.sort(unsortedList);
        int index = Collections.binarySearch(unsortedList, 3);
        System.out.println("Index of 3 in sorted list: " + index);
        
        // Java 8+ Stream operations
        System.out.println("\n--- Stream Operations ---");
        
        // Filtering
        List<Integer> filteredList = list1.stream()
                                         .filter(num -> num > 2)
                                         .toList(); // Java 16+
        System.out.println("Filtered list (> 2): " + filteredList);
        
        // Mapping
        List<Integer> squaredList = list1.stream()
                                       .map(num -> num * num)
                                       .toList();
        System.out.println("Squared list: " + squaredList);
        
        // Reducing
        int sum = list1.stream().reduce(0, Integer::sum);
        System.out.println("Sum of list1: " + sum);
        
        // Find distinct elements combined from both lists
        List<Integer> distinctCombined = Stream.concat(list1.stream(), list2.stream())
                                              .distinct()
                                              .sorted()
                                              .toList();
        System.out.println("Distinct combined elements: " + distinctCombined);
    }
}