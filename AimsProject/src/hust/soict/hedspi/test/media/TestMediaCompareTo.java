package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

import java.util.Iterator;
import java.util.List;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc
                (1,"The Lion King", "Animation", 87, "Roger Allers", 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc
                (2,"Aladdin", "Science Fiction", 124, "George Lucas", 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc
                (3,"Star Wars", "Animation", 90, "John Musker",18.99f);
        
        CompactDisc cd1 = new CompactDisc(4, "Poem", "music", "IU", 12.3f);
        CompactDisc cd2 = new CompactDisc(5, "Lilac", "music", "IU", 32.4f);

        Book b1 = new Book(6, "NewBegin", 8.1f);
        Book b2 = new Book(7, "Nice", 10.4f);

        java.util.Collection<Media> collection = new java.util.ArrayList<>();
        collection.add(dvd2);
        collection.add(dvd1);
        collection.add(dvd3);
        collection.add(cd1);
        collection.add(cd2);
        collection.add(b1);
        collection.add(b2);
//
        display(collection);

    }

    private static void display(java.util.Collection<Media> collection) {
        Iterator<Media> iterator = collection.iterator();
        iterator = collection.iterator();
        System.out.println("-------------------------------------");
        System.out.println("The medias currently in the order are: ");
        System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-12s| %-5s | %-5s%n",
                "STT", "Type", "ID", "Title", "Category", "Total", "Number", "Length");
        int i = 1;
        while(iterator.hasNext()) {
            Media media = iterator.next();
            if (media instanceof Book) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ |%n", i, "Book",
                        media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            } else if(media instanceof DigitalVideoDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ |%n", i, "DVD",
                        media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            } else if(media instanceof CompactDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ | %-5s | %-5s%n", i, "CD",
                        media.getId(), media.getTitle(), media.getCategory(), media.getCost(),
                        ((CompactDisc)media).getTracks().size(), ((CompactDisc) media).getLength());
            }
            i++;
        }

        java.util.Collections.sort((List<Media>)collection);
        iterator = collection.iterator();
        System.out.println("-------------------------------------");
        System.out.println("The medias in sorted order are: ");
        System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-12s| %-5s | %-5s%n", "STT", "Type", "ID", "Title", "Category", "Total", "Number", "Length");
        i = 1;
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if(media instanceof Book) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ |%n", i, "Book", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }else if(media instanceof DigitalVideoDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ |%n", i, "DVD", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            }else if(media instanceof CompactDisc) {
                System.out.printf("%-3s | %-6s | %-5s | %-15s | %-15s | %-10s$ | %-5s | %-5s%n", i, "CD", media.getId(), media.getTitle(), media.getCategory(), media.getCost(), ((CompactDisc)media).getTracks().size(), ((CompactDisc) media).getLength());
            }
            i++;
        }
        System.out.println("--------------------------------------");
    }

}
