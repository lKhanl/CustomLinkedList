

public class Song {
    private String songName;
    Song next;

    public Song(String songName) {
        this.songName = songName;
        this.next = null;
    }

    public String getSongName() {
        return songName;
    }


}
