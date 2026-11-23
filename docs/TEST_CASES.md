# Suggested test cases

1. First run: confirm 45 items load and IDs range from W101 to W145.
2. Display: choose option 2 and verify all starter items appear.
3. Total: choose option 9 and confirm total is calculated from unit price × quantity.
4. Add: add `Tablet`, price `15000`, category `Electronics`, quantity `1`; expect ID W146.
5. Duplicate: try adding `tablet`; expect duplicate-name validation.
6. Invalid price: try price `0` or a negative value; expect validation.
7. Sort ascending and descending; verify price order.
8. Search: search W101 and an exact item name.
9. Remove: remove W145; then search W145 and confirm it is absent.
10. Quantity: update W101 quantity to 2 and check the line total.
11. Persistence: exit with option 0, reopen, and verify the changes remain.
12. Missing ID: try removing W999; expect “Item not found”.
