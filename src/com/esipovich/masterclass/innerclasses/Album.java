package com.esipovich.masterclass.innerclasses;

import com.esipovich.masterclass.linkedlist.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 07.04.2018
 */

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.addSong(new Song(title, duration));
    }

    public boolean addToPlaylist(int trackNumber, List<Song> playlist) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album doesn't have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, List<Song> playlist) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album");
        return false;
    }

    private class SongList {

        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean addSong(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        public Song findSong(String songName) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(songName)) {
                    return song;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }

    }
}
