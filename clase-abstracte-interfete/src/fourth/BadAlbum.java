package fourth;

public class BadAlbum extends Album {
    boolean isPalindrom(int n) {
        int m = n, inv = 0, rest;
        while(n > 0) {
            rest = n%10;
            n = n/10;
            inv = inv * 10 + rest;
        }
        return (m == inv);
    }

    @Override
    public void addSong(Song song) {
        if(isPalindrom(song.getId()) && song.getName().length() == 3) {
            this.songs.add(song);
        }
    }
}
