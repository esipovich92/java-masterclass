package com.esipovich.masterclass.innerclasses;

import com.esipovich.masterclass.linkedlist.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 07.04.2018
 */

public class Playlist {

    private List<Album> albums;

    public Playlist() {
        this.albums = new ArrayList<>();
    }
}
