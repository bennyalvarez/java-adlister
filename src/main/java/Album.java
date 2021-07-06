import java.io.Serializable;

public class Album implements Serializable {

    private long id;
    private String artist;
    private String name;
    private int releaseDate;
    private double sales;
    private String genre;

    public Album(){ }

    public Album(long id, String author, String name, int releaseDate, float sales, String genre) {

    }

    public Album(long id, String bruno_mars, String s, int i1, String s1) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
