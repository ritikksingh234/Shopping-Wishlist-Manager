# Shopping Wishlist Manager

A Java-based console application designed to manage shopping wishlists efficiently. It provides features for adding, viewing, searching, sorting, updating, and removing wishlist items with persistent file storage.

The project demonstrates core Java programming, Object-Oriented Programming, custom data structures, searching, sorting, and file handling.

## Features

- **Add Items:** Add products with names, prices, categories, and quantities.
- **View Wishlist:** Display all saved wishlist items with their details.
- **Search Items:** Search products using their ID or exact name.
- **Remove Items:** Delete products using their unique item ID.
- **Update Quantity:** Modify the quantity of existing products.
- **Price Sorting:** Sort items from low to high or high to low.
- **Category Filtering:** Filter products by category.
- **Wishlist Summary:** View total items, quantities, and estimated cost.
- **Data Persistence:** Automatically save and load wishlist data.
- **Sample Data:** Includes 45 preloaded sample wishlist items.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core application development |
| ArrayList | Supporting data operations where applicable |
| Custom Singly Linked List | Wishlist data management |
| Bubble Sort | Manual price sorting |
| Linear Search | Item searching |
| File Handling | Persistent data storage |
| VS Code | Development environment |
| Git & GitHub | Version control |

## Project Structure

```text
Shopping-Wishlist-Manager/
│
├── src/
│   └── main/
│       └── java/
│           └── com/ritik/wishlist/
│               ├── Main.java
│               ├── model/
│               │   └── WishlistItem.java
│               ├── structure/
│               │   ├── Node.java
│               │   └── WishlistLinkedList.java
│               ├── service/
│               │   └── WishlistService.java
│               ├── storage/
│               │   └── WishlistRepository.java
│               └── ui/
│                   └── ConsoleInput.java
│
├── docs/
│   ├── PROJECT_REPORT.md
│   ├── TEST_CASES.md
│   └── ARCHITECTURE.md
│
├── README.md
└── .gitignore
```

## How to Run

### Prerequisites

- Java JDK 17 or later
- Visual Studio Code
- Java Extension Pack (recommended)

### Step 1: Clone the Repository

```bash
git clone https://github.com/ritikksingh234/Shopping-Wishlist-Manager.git
```

### Step 2: Open the Project

Open the downloaded project folder in Visual Studio Code.

### Step 3: Compile the Java Files

Open the VS Code terminal and execute:

```powershell
$files = Get-ChildItem -Path .\src\main\java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
New-Item -ItemType Directory -Force -Path .\out | Out-Null
javac -encoding UTF-8 -d .\out $files
```

### Step 4: Run the Application

```powershell
java -cp .\out com.ritik.wishlist.Main
```

## Concepts Demonstrated

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Custom Singly Linked List
- Node-based data management
- Bubble Sort algorithm
- Linear Search algorithm
- File Handling and Data Persistence
- Modular Java Project Architecture

## Future Improvements

- Graphical User Interface (GUI)
- Database integration using MySQL
- User authentication
- Product image support
- Shopping price comparison
- Web-based wishlist management

## Author

**Ritik Kumar Singh**

B.Tech Computer Science and Engineering

GitHub: [ritikksingh234](https://github.com/ritikksingh234)

---

If you find this project useful, consider giving it a ⭐ on GitHub.

**Developed as a Java learning and portfolio project.**
