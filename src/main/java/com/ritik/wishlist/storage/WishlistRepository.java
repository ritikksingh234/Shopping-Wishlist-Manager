package com.ritik.wishlist.storage;

import com.ritik.wishlist.model.WishlistItem;
import com.ritik.wishlist.structure.Node;
import com.ritik.wishlist.structure.WishlistLinkedList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class WishlistRepository {
    private final Path dataDir = Paths.get("data");
    private final Path binaryFile = dataDir.resolve("wishlist.dat");
    private final Path starterFile = dataDir.resolve("starter_items.txt");
    private final Path backupFile = dataDir.resolve("wishlist_backup.txt");

    public WishlistLinkedList load() {
        try { Files.createDirectories(dataDir); } catch (IOException e) { System.out.println("Could not create data folder: " + e.getMessage()); }
        if (Files.exists(binaryFile)) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(binaryFile))) {
                Object obj = in.readObject();
                if (obj instanceof WishlistLinkedList) return (WishlistLinkedList) obj;
            } catch (Exception e) {
                System.out.println("Saved data could not be read. Loading starter/backup data instead.");
            }
        }
        WishlistLinkedList list = new WishlistLinkedList();
        Path source = Files.exists(backupFile) ? backupFile : starterFile;
        if (Files.exists(source)) {
            try (BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty() || line.startsWith("#")) continue;
                    String[] p = line.split("\\|", -1);
                    if (p.length == 5) {
                        list.add(new WishlistItem(p[0], p[1], Double.parseDouble(p[2]), p[3], Integer.parseInt(p[4])));
                    }
                }
            } catch (Exception e) { System.out.println("Could not load starter data: " + e.getMessage()); }
        }
        save(list);
        return list;
    }

    public void save(WishlistLinkedList list) {
        try {
            Files.createDirectories(dataDir);
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(binaryFile))) { out.writeObject(list); }
            try (BufferedWriter writer = Files.newBufferedWriter(backupFile, StandardCharsets.UTF_8)) {
                Node<WishlistItem> current = list.getHead();
                while (current != null) {
                    WishlistItem i = current.data;
                    writer.write(i.getId() + "|" + i.getName().replace("|", "/") + "|" + i.getPrice() + "|" + i.getCategory().replace("|", "/") + "|" + i.getQuantity());
                    writer.newLine();
                    current = current.next;
                }
            }
        } catch (IOException e) { System.out.println("Warning: data could not be saved: " + e.getMessage()); }
    }
}
