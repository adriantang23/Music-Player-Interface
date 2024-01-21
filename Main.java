import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Scanner;
public class Main {
    private static ArrayList<SongAlbum> albums = new ArrayList<>();
    public static void main(String[] args) {
        //first test object
        SongAlbum album = new SongAlbum("Album1","Kanye West");
        album.addSong("Runaway", 7.0);
        album.addSong("I wonder", 4.5);
        album.addSong("Ghost Town", 3.8);
        albums.add(album);

        SongAlbum album2 = new SongAlbum("Album2", "Mac Miller");
        album.addSong("Self Love", 5.2);
        album.addSong("100 Grandkids", 4.5);
        album.addSong("Missed Calls", 3.6);
        albums.add(album2);

        LinkedList<song> playlist1 = new LinkedList<>();
        albums.get(0).addToPlaylist("Runaway", playlist1);
        albums.get(0).addToPlaylist("Ghost Town", playlist1);
        albums.get(0).addToPlaylist("Missed Calls", playlist1);

        play(playlist1);

    }

    private static void play(LinkedList<song> playlist) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        boolean foward = true;

        ListIterator<song> ListIterator = playlist.listIterator();

        if (playlist.size()==0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now Playing" + ListIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {

                case 0:
                    System.out.println("Playlist over");
                    quit = true;
                    break;

                case 1:
                    if(!foward) {
                        if(ListIterator.hasNext()) {
                            ListIterator.next();
                        } foward = true;
                    } if (ListIterator.hasNext()) {
                        System.out.println("Now Playing" + ListIterator.next().toString());
                    } else {
                        System.out.println("No songs left on list");
                        foward = false;
                    } break;
                
                case 2:
                    if (foward) {
                        if (ListIterator.hasPrevious()) {
                            ListIterator.previous();
                        } foward = false;
                    } if (ListIterator.hasPrevious()) {
                        System.out.println("Now Playing " + ListIterator.previous().toString());
                    } else {
                        System.out.println("Now playing first song");
                        foward = false;
                    } break;

                case 3:
                    if(foward) {
                        if(ListIterator.hasPrevious()){
                            System.out.println("Now Playing" + ListIterator.previous().toString());
                            foward = false;
                        } else {
                            System.out.println("Now playing first song");
                        }
                    } else {
                        if(ListIterator.hasNext()) {
                            System.out.println("Now Playing" + ListIterator.next().toString());
                            foward = true;
                        } else {
                            System.out.println("No songs left on list");
                        }
                    } break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;
            }
        } 

    }

    private static void printMenu() {
        System.out.println("All Songs");
        System.out.println("0 - quit\n" + 
                "1 - next song\n" +
                "2 - previous song\n" + 
                "3 - replay song\n" + 
                "4 - show all songs\n" + 
                "5 - print all songs\n");
    }

    private static void printList(LinkedList<song> playlist) {
        Iterator<song> iterator = playlist.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");

    }


}