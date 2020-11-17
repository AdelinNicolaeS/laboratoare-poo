package fourth;

import java.util.ArrayList;

abstract class Album {
    ArrayList<Song> songs = new ArrayList<>();
    abstract void addSong(Song song);
    void removeSong() {
        songs.remove(songs.size() - 1);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Album{");
        for(Song song : songs) {
            sb.append("Song{");
            sb.append("name='").append(song.getName()).append('\'');
            sb.append(", composer='").append(song.getComposer()).append('\'');
            sb.append(", id=").append(song.getId());
            sb.append('}');
        }
        sb.append("}");
        return sb.toString();
    }
}
