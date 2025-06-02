/**
 * @author Roshni Daruvuri
 * @version March 14 2024
 */
public interface Likeable {
    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     */
    void like();
    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     */
    void dislike();
    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return returns number of likes
     */
    int getLikes();
    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @return return number of dislikes
     */
    int getDislikes();
}