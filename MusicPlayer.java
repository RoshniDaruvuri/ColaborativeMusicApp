/**
 * @author Roshni Daruvuri
 * @version March 14 2024
 */
public class MusicPlayer {
    /**
     * @author Roshni Daruvuri
     * @version March 14 2024
     * @param args command line arguments
     */
    public static void main(String[] args) {
        User roshni = new User("roshnid");
        User aditi = new User("aditij");

        Song noRoleModelz = new Song("NoRoleModlez", 3);
        Song kevinHeart = new Song("KevinHeart", 2);
        Song workOut = new Song("WorkOut", 4);
        Song myEyes = new Song("MyEyes", 3);
        Song butterflyEffect = new Song("ButterFlyEffect", 2);
        Song topiaTwins = new Song("TopiaTwins", 3);
        Song godPlan = new Song("GodPlan", 3);
        Song richFlex = new Song("RichFlex", 2);
        Song noTitle = new Song(null, 4);

        roshni.createPlaylist("jCole", 2);
        roshni.createPlaylist("travisScott", 1);
        aditi.createPlaylist("drake", 1);

        roshni.getPlaylist("jCole").addSong(noRoleModelz);
        roshni.getPlaylist("jCole").addSong(kevinHeart);
        roshni.getPlaylist("jCole").addSong(workOut);

        roshni.getPlaylist("travisScott").addSong(myEyes);
        roshni.getPlaylist("travisScott").addSong(butterflyEffect);
        roshni.getPlaylist("travisScott").addSong(topiaTwins);

        aditi.getPlaylist("drake").addSong(godPlan);
        aditi.getPlaylist("drake").addSong(richFlex);
        aditi.getPlaylist("drake").addSong(noTitle);

        roshni.likeSong(workOut);
        roshni.likeSong(myEyes);
        aditi.likeSong(godPlan);
        aditi.likeSong(richFlex);

        roshni.dislikeSong(kevinHeart);
        aditi.dislikeSong(noTitle);

        roshni.likePlaylist(roshni.getPlaylist("jCole"));
        aditi.likePlaylist(aditi.getPlaylist("drake"));

        roshni.dislikePlaylist(roshni.getPlaylist("travisScott"));

        System.out.println(roshni.getPlaylist("jCole"));
        System.out.println(roshni.getPlaylist("jCole").getSongs());

        System.out.println(roshni.getPlaylist("jCole").topAndWorstSong());

        roshni.sharePlaylist(aditi, 1);
        System.out.println(aditi.getLibrary());

        System.out.println(roshni.getPlaylist("jCole").getSongs());
        System.out.println(roshni.getPlaylist("jCole").getDuration());
        System.out.println(roshni.getPlaylist("jCole").getDateCreated());
        System.out.println(roshni.getPlaylist("jCole").getSongs());
        System.out.println(myEyes.toString());
        System.out.println(myEyes.getDuration());

        roshni.playSong(workOut);
        System.out.println(roshni);
        roshni.pauseSong();
        System.out.println(roshni);

        System.out.println(roshni.getLibrary());
        roshni.removePlaylist("jCole");
        System.out.println(roshni.removePlaylist("liked"));
        System.out.println(roshni.getLibrary());
        aditi.sharePlaylist(roshni, 2);
        System.out.println(roshni.getLibrary());
        roshni.removePlaylist("drake");
        System.out.println(roshni.getLibrary());

    }
}
