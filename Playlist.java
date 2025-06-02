import java.util.ArrayList;

/**
 * @author Roshni Daruvuri
 * @version March 14 2024
 */
public class Playlist implements Comparable<Playlist>, Likeable {
    private String title;
    private User owner;
    private int dateCreated;
    private ArrayList<Song> songs;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param title takes in the title of the playlist
     * @param owner owner of the playlist (user)
     * @param dateCreated when the playlist was created
     */
    public Playlist(String title, User owner, int dateCreated) {
        if (title == null) {
            this.title = "Untitled Playlist";
        } else {
            this.title = title;
        }

        this.owner = owner;

        if (dateCreated < 0) {
            this.dateCreated = 0;
        } else {
            this.dateCreated = dateCreated;
        }

        this.songs = new ArrayList<Song>();
        this.duration = 0;
        this.likes = 0;
        this.dislikes = 0;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param song the song that needs to be added into the playlist
     */
    public void addSong(Song song) {
        if (song != null) {
            songs.add(song);
            this.duration += song.getDuration();
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns a boolean to check if the song is removed
     * @param song the song that needs to be remove
     */
    public boolean removeSong(Song song) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (songs.get(i).equals(song)) {
                songs.remove(i);
                this.duration -= song.getDuration();
                return true;
            }
        }
        return false;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns an array of the playlist's songs
     */
    public Song[] toArray() {
        Song[] songArray = new Song[this.songs.size()];
        for (int i = 0; i < this.songs.size(); i++) {
            songArray[i] = this.songs.get(i);
        }
        return songArray;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns an array with the top and worst songs, two elements
     */
    public Song[] topAndWorstSong() {
        Song tempTop = this.songs.get(0);
        Song tempWorst;
        Song[] topAndWorstSong = new Song[2];
        for (int i = 0; i < this.songs.size(); i++) {
            if (tempTop.compareTo(this.songs.get(i)) < 0) {
                tempTop = this.songs.get(i);
            }
        }
        tempWorst = tempTop;
        for (int i = 0; i < this.songs.size(); i++) {
            if (tempWorst.compareTo(this.songs.get(i)) > 0) {
                tempWorst = this.songs.get(i);
            }
        }

        topAndWorstSong[0] = tempTop;
        topAndWorstSong[1] = tempWorst;
        return topAndWorstSong;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns a string describing the playlist
     */
    public String toString() {
        return this.title + " has " + this.songs.size() + " songs, is " + this.duration
            + " long, has a like factor of " + (this.likes - this.dislikes) + ", and was created "
            + this.dateCreated + " days after the platform released.";
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param obj in an object that needs to be compared
     * @return a true or false if they are equal
     */
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Playlist objPlaylist = (Playlist) obj;
            return ((this.title.equals(objPlaylist.getTitle())) && (this.owner == objPlaylist.getOwner())
                && (this.songs.size() == objPlaylist.getSongs().size())
                && (this.duration == objPlaylist.getDuration()));
        } else {
            return false;
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param other the playlist that is being compared to
     * @return returns an integer that describes the comparition
     */
    public int compareTo(Playlist other) {
        return this.dateCreated - other.getDateCreated();
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the owner of the playlist (user)
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the time of the playlist
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the arraylist of songs in the playlist
     */
    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the integer of the creation date
     */
    public int getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     */
    public void like() {
        this.likes += 1;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     */
    public void dislike() {
        this.dislikes += 1;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the number of likes
     */
    public int getLikes() {
        return this.likes;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns the number of dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }

}