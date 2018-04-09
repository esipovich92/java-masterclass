package com.esipovich.masterclass.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 07.04.2018
 */

public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String songName) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(songName)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album doesn't have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album");
        return false;
    }
}
