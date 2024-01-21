import java.util.ArrayList;
import java.util.LinkedList;
//create playlists with song name, song artist, and song
public class SongAlbum {
    //private class names and artists
    private String name;
    private String artist;
    private ArrayList<song> songs;

    //constructor
    public SongAlbum(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public SongAlbum() {

    }
    //finding a song in the album
    public song findSong(String title) {
        for (song i : songs) {
            if(i.getTitle().equals(title)) {
                return i;
            } 
        } return null;
    }

    //adding song to album
    //if song already exists, it will not be added using findSong()
    public boolean addSong(String title, double length) {
        if (findSong(title) == null) {
            songs.add(new song(title, length));
            // System.out.println(title+" added to playlist.");
            return true;
        } else {
            // System.out.println(title+" already exists in playlist");
            return false;
        }
    }

    //adding song to playlist
    public boolean addToPlaylist(int track, LinkedList<song> playlist) {
        int index = track-1;
        if (index > 0 && index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        } // System.out.println("Playlist does not have this track");
        return false;
    }
    
    public boolean addToPlaylist(String title, LinkedList<song> playlist) {
        for (song i : this.songs) {
            if (i.getTitle().equals(title)) {
                playlist.add(i);
                return true;
            } 
        } // System.out.println("Playlist does not have this song");
        return false;
    }
}
