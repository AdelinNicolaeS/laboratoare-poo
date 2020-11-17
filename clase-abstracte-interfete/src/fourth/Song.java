package fourth;

public class Song {
    private String name;
    private String composer;
    private int id;

    public Song(String name, int id, String composer) {
        this.name = name;
        this.composer = composer;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
