import java.util.ArrayList;

/**
 * @author Roshni Daruvuri
 * @version March 14 2024
 */
public class User {
    private String username;
    private ArrayList<Playlist> library;
    private Song currentPlaying;

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param username the username of the user
     */
    public User(String username) {
        if (username == null) {
            this.username = "";
        } else {
            this.username = username;
        }
        this.currentPlaying = null;
        this.library = new ArrayList<Playlist>();
        Playlist liked = new Playlist("liked", this, 0);
        this.library.add(liked);
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param title title of the new playlist
     * @param age the date created of the new playlist
     */
    public void createPlaylist(String title, int age) {
        if (this.getPlaylist(title) ==  null) {
            Playlist newPlay = new Playlist(title, this, age);
            this.addPlaylist(newPlay);
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param playlist the playlist being added
     * @return if this playlist replaces one already existing or not
     */
    public boolean addPlaylist(Playlist playlist) {
        if (this.library.size() == 1) {
            this.library.add(playlist);
            return false;
        }
        for (int i = 1; i < this.library.size(); i++) {
            if (this.library.get(i).getTitle().equals(playlist.getTitle())) {
                this.library.set(i, playlist);
                return true;
            }
        }

        for (int i = 1; i < this.library.size(); i++) {
            if (this.library.get(i).compareTo(playlist) <= 0) {
                this.library.add(i, playlist);
                return false;
            }
        }
        this.library.add(playlist);
        return false;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param name name of the playlist trying to find
     * @return returns the playlist with that name
     */
    public Playlist getPlaylist(String name) {
        for (int i = 0; i < this.library.size(); i++) {
            if (this.library.get(i).getTitle().equals(name)) {
                return this.library.get(i);
            }
        }
        return null;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param title the title of the playlist being removed
     * @return returns if this happens or not
     */
    public boolean removePlaylist(String title) { //what if the title doesn't exist
        if ((this.getPlaylist(title) != null) && (this.getPlaylist(title).getOwner() != this)) {
            this.library.remove(this.getPlaylist(title));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param song takes in a song to like
     */
    public void likeSong(Song song) {
        if (!this.library.get(0).getSongs().contains(song)) {
            song.like();
            this.library.get(0).addSong(song);
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param song takes in a song to dislike
     */
    public void dislikeSong(Song song) {
        song.dislike();
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param goodPlaylist the playlist trying to like
     */
    public void likePlaylist(Playlist goodPlaylist) {
        goodPlaylist.like();
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param badPlaylist the playlist trying to dislike
     */
    public void dislikePlaylist(Playlist badPlaylist) {
        badPlaylist.dislike();
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param user user we are tyring to share to
     * @param ind index of the playlist trying to share
     */
    public void sharePlaylist(User user, int ind) {
        user.addPlaylist(this.library.get(ind));
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param song the song that is currently playing
     */
    public void playSong(Song song) {
        this.currentPlaying = song;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     */
    public void pauseSong() {
        this.currentPlaying = null;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return string of the user
     */
    public String toString() {
        if (this.currentPlaying == null) {
            return this.username + " is idle";
        } else {
            return this.username + " is listening to "
                + this.currentPlaying.getTitle() + ", Duration: "
                + this.currentPlaying.getDuration() + ", Likes: " + this.currentPlaying.getLikes()
                + ", Dislikes: " + this.currentPlaying.getDislikes();
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return the list of playlists in the library
     */
    public ArrayList<Playlist> getLibrary() {
        return this.library;
    }
}