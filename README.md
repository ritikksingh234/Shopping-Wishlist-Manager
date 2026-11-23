# Shopping Wishlist Manager (Java) — VS Code Edition

A modular console-based Java project using a **custom singly linked list**, manual Bubble Sort, manual linear search, and file handling.

## Included from the first run

The project starts with **45 sample wishlist items** (IDs W101–W145). The first time you run it, these items are loaded from `data/starter_items.txt` and saved into `data/wishlist.dat` automatically.

## Requirements

- JDK 17 or newer (JDK 25 is also fine)
- Visual Studio Code
- Recommended VS Code extension: **Extension Pack for Java** by Microsoft

## Open and run in VS Code

1. Extract the ZIP file to a normal folder, for example `D:\ShoppingWishlistManager_VSCode`.
2. Open VS Code.
3. Select **File → Open Folder** and choose the extracted `ShoppingWishlistManager_VSCode` folder (the folder that contains `src`, `data`, and this README).
4. Select **Terminal → New Terminal**. Check that the terminal path ends with `ShoppingWishlistManager_VSCode`.
5. Paste this PowerShell command to compile every Java source file:

```powershell
$files = Get-ChildItem -Path .\src\main\java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
New-Item -ItemType Directory -Force -Path .\out | Out-Null
javac -encoding UTF-8 -d .\out $files
```

6. If compilation finishes without an error, run:

```powershell
java -cp .\out com.ritik.wishlist.Main
```

**Important:** Copy only the commands inside the code blocks. Do not type `PS D:\...>` or copy the command prompt/output. Run the commands from the main project folder, not from `src`.

## Menu options

1. Add a new item
2. Display all wishlist items
3. Sort by price (low to high)
4. Sort by price (high to low)
5. Remove an item by ID
6. Search by ID or exact item name
7. Update quantity
8. Filter by category
9. Wishlist summary and total cost
0. Save and exit

## Data and persistence

- `data/starter_items.txt`: the 45 starter records. It is used only when no saved binary file exists.
- `data/wishlist.dat`: primary binary save file, created automatically.
- `data/wishlist_backup.txt`: readable text backup, updated whenever the application saves.
- Your changes are saved after add, remove, quantity update, sort, and exit.

To reset to the original 45 sample items, close the program and delete **both** `data/wishlist.dat` and `data/wishlist_backup.txt`. Keep `starter_items.txt`, then run the project again.

## Project structure

```text
ShoppingWishlistManager_VSCode/
├── data/
│   └── starter_items.txt
├── docs/
│   ├── ARCHITECTURE.md
│   └── TEST_CASES.md
├── src/main/java/com/ritik/wishlist/
│   ├── Main.java
│   ├── model/WishlistItem.java
│   ├── structure/Node.java
│   ├── structure/WishlistLinkedList.java
│   ├── service/WishlistService.java
│   ├── storage/WishlistRepository.java
│   └── ui/ConsoleInput.java
└── README.md
```

## Concepts demonstrated

- Classes, objects, encapsulation, packages
- Custom singly linked list (`Node`, `head`, `tail`, `next`)
- Manual Bubble Sort (no `Collections.sort()` / `Arrays.sort()`)
- Manual linear search (no built-in search utility)
- Add, display, update, remove, category filtering
- Binary object serialization and readable text backup
- Input validation and exception handling

## Notes

- New IDs begin at W146 because the starter list already contains W101–W145.
- Removing an item does not renumber the remaining IDs.
- Duplicate item names are rejected (case-insensitive).
- Prices and quantities must be greater than zero.
