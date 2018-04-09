package com.esipovich.masterclass.innerclasses;

import com.esipovich.masterclass.linkedlist.Album;
import com.esipovich.masterclass.linkedlist.Song;

import java.util.*;

/**
 * @author Artem Esipovich 09.04.2018
 */

public class Main {
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.

    private static List<com.esipovich.masterclass.linkedlist.Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        com.esipovich.masterclass.linkedlist.Album album = new com.esipovich.masterclass.linkedlist.Album("Dreams of freedom", "Bob Marley");
        album.addSong("Buffalo Soldier", 3.05);
        album.addSong("Waiting in Wain", 3.45);
        album.addSong("Three little birds", 4.01);
        album.addSong("Mr. Brown", 4.32);
        albums.add(album);

        album = new Album("Uprising", "Bob Marley");
        album.addSong("Concrete Jungle", 4.02);
        album.addSong("War", 2.47);
        album.addSong("Rastaman Chant", 5.11);
        album.addSong("Revolution", 3.27);
        album.addSong("Rat Race", 4.55);
        albums.add(album);

        List<com.esipovich.masterclass.linkedlist.Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("War", playlist);
        albums.get(0).addToPlaylist("Three little birds", playlist);
        albums.get(0).addToPlaylist("Speed king", playlist); //Doesn't exist
        albums.get(0).addToPlaylist(4, playlist);
//        albums.get(0).addToPlaylist(3, playlist);
        albums.get(0).addToPlaylist(2, playlist);
        albums.get(0).addToPlaylist(20, playlist);

        play(playlist);
    }

    private static void play(List<com.esipovich.masterclass.linkedlist.Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<com.esipovich.masterclass.linkedlist.Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached start of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: ");
        System.out.println("0 - quit");
        System.out.println("1 - play next song");
        System.out.println("2 - play previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list of songs in the playlist");
        System.out.println("5 - pring available actions");
        System.out.println("6 - delete current song");
    }

    private static void printList(List<com.esipovich.masterclass.linkedlist.Song> songs) {
        Iterator<Song> iterator = songs.iterator();
        System.out.println("=========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=========================");
    }
}
