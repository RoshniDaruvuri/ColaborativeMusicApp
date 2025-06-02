/**
 * @author Roshni Daruvuri
 * @version March 14 2024
 */
public class Song implements Comparable<Song>, Likeable {
    private String title;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param title title of the song
     * @param duration how long the song is
     */
    public Song(String title, int duration) {
        if (title == null) {
            this.title = "Untitled Song";
        } else {
            this.title = title;
        }

        if ((duration < 0) || (duration > 10)) {
            this.duration = 5;
        } else {
            this.duration = duration;
        }

        this.likes = 0;
        this.dislikes = 0;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param song parameter of the song that is being compared
     * @return returns an integer which represents which song has a higher like factor
     */
    public int compareTo(Song song) {
        int tempThisFactor = this.likes - this.dislikes;
        int tempOtherFactor = song.getLikes() - song.getDislikes();
        return tempThisFactor - tempOtherFactor;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param obj parameter of the obj that is being compared
     * @return a boolean to see if it's equal or not
     */
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Song objSong = (Song) obj;
            return ((this.title.equals(objSong.getTitle())) && (this.duration == objSong.getDuration())
                && (this.likes == objSong.getLikes()) && (this.dislikes == objSong.getDislikes()));
        } else {
            return false;
        }
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return a string to print out
     */
    public String toString() {
        return this.title + ", Duration: " + this.duration + ", Likes: " + this.likes + ", Dislikes: " + this.dislikes;
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
     * @return return the title string
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns how long the song is
     */
    public int getDuration() {
        return this.duration;
    }
}