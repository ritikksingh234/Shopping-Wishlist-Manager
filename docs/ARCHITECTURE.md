# Architecture

- `Main`: application entry point and menu controller.
- `model/WishlistItem`: item data (ID, name, unit price, category, quantity) and line-total calculation.
- `structure/Node`: linked-list node containing data and next reference.
- `structure/WishlistLinkedList`: custom singly linked list; add, search, remove, display, category filter, total, and manual Bubble Sort.
- `service/WishlistService`: validates new entries, prevents duplicate names, and generates non-repeating IDs.
- `storage/WishlistRepository`: loads starter data on first run and persists the list using Java object serialization plus a text backup.
- `ui/ConsoleInput`: reusable console input and numeric validation.

The application uses a custom linked list rather than Java's built-in collection sorting/searching methods, so the core data-structure and algorithm requirements remain visible.
