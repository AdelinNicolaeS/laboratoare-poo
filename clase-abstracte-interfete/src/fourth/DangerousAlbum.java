package fourth;

public class DangerousAlbum extends Album {

    boolean isPrime(int n) {
        if(n <= 1) return false;
        int div;
        for(div = 2; div <= n/2; div++) {
            if(n%div == 0) return false;
        }
        return true;
    }
    @Override
    public void addSong(Song song) {
        if(isPrime(song.getId())) {
            this.songs.add(song);
        }
    }
}
