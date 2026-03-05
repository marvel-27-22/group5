import java.util.Random;

abstract class MediaItem {
    protected String title;
    protected int duration;
    protected String artist;

    public MediaItem(String title, int duration, String artist) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    public abstract void play();
    public abstract String getMediaType();

    public String getDurationFormatted() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + getDurationFormatted());
        System.out.println("Type: " + getMediaType());
    }
}

class Song extends MediaItem {
    private String album;
    private String genre;
    private String lyrics;

    public Song(String title, int duration, String artist, String album, String genre, String lyrics) {
        super(title, duration, artist);
        this.album = album;
        this.genre = genre;
        this.lyrics = lyrics;
    }

    public void play() {
        System.out.println("Playing song: " + title + " by " + artist);
    }

    public String getMediaType() {
        return "Audio";
    }

    public void showLyrics() {
        System.out.println("Lyrics for " + title + ": " + lyrics);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Album: " + album);
        System.out.println("Genre: " + genre);
    }
}

class Video extends MediaItem {
    private String resolution;
    private String director;

    public Video(String title, int duration, String artist, String resolution, String director) {
        super(title, duration, artist);
        this.resolution = resolution;
        this.director = director;
    }

    public void play() {
        System.out.println("Playing video: " + title + " in " + resolution);
    }

    public String getMediaType() {
        return "Video";
    }

    public void setResolution(String res) {
        this.resolution = res;
    }

    public void showCredits() {
        System.out.println("Director: " + director + " | Artist: " + artist);
    }
}

class Podcast extends MediaItem {
    private String host;
    private int episodeNumber;
    private String topic;

    public Podcast(String title, int duration, String artist, String host, int episodeNumber, String topic) {
        super(title, duration, artist);
        this.host = host;
        this.episodeNumber = episodeNumber;
        this.topic = topic;
    }

    public void play() {
        System.out.println("Playing podcast: " + title + " - Episode " + episodeNumber);
    }

    public String getMediaType() {
        return "Podcast";
    }

    public void showEpisodeInfo() {
        System.out.println("Host: " + host + " | Topic: " + topic);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Episode: " + episodeNumber + " | Host: " + host);
    }
}

abstract class Playlist {
    protected String name;
    protected MediaItem[] mediaItems;
    protected int itemCount;

    public Playlist(String name, int size) {
        this.name = name;
        this.mediaItems = new MediaItem[size];
        this.itemCount = 0;
    }

    public void addItem(MediaItem item) {
        if (itemCount < mediaItems.length) {
            mediaItems[itemCount] = item;
            itemCount++;
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < itemCount) {
            for (int i = index; i < itemCount - 1; i++) {
                mediaItems[i] = mediaItems[i + 1];
            }
            itemCount--;
        }
    }

    public abstract void shuffle();

    public void playAll() {
        System.out.println("Playing Playlist: " + name);
        for (int i = 0; i < itemCount; i++) {
            mediaItems[i].play();
        }
    }

    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += mediaItems[i].duration;
        }
        return total;
    }
}

class MusicPlaylist extends Playlist {
    public MusicPlaylist(String name, int size) {
        super(name, size);
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < itemCount; i++) {
            int randomIndex = rand.nextInt(itemCount);
            MediaItem temp = mediaItems[randomIndex];
            mediaItems[randomIndex] = mediaItems[i];
            mediaItems[i] = temp;
        }
        System.out.println("Music playlist shuffled.");
    }
}

class VideoPlaylist extends Playlist {
    private boolean autoplayNext;

    public VideoPlaylist(String name, int size, boolean autoplayNext) {
        super(name, size);
        this.autoplayNext = autoplayNext;
    }

    public void setAutoplay(boolean value) {
        this.autoplayNext = value;
    }

    public void shuffle() {
        System.out.println("Video playlist shuffled.");
    }

    @Override
    public void playAll() {
        if (autoplayNext) {
            System.out.println("Autoplay is ON.");
        }
        super.playAll();
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        System.out.println("=== MEDIA PLAYER SYSTEM TEST ===\n");

        Song song1 = new Song("Nchi ya Mababu", 245, "Diamond Platnumz", "A Boy from Tandale", "Bongo Flava", "Lyrics...");
        Song song2 = new Song("Jeje", 312, "Harmonize", "Afro East", "Bongo Flava", "Lyrics...");
        Video video1 = new Video("Tanzania Travel", 1800, "Travel Channel", "4K", "John Smith");
        Podcast podcast1 = new Podcast("Tech Talk", 2700, "SUZA Weekly", "James Brown", 42, "AI in Africa");

        System.out.println("--- Testing Individual Items ---");
        song1.displayInfo();
        song1.play();
        System.out.println();

        System.out.println("--- Testing Playlists ---");
        MusicPlaylist myMusic = new MusicPlaylist("My Jams", 5);
        myMusic.addItem(song1);
        myMusic.addItem(song2);
        myMusic.playAll();
        
        myMusic.shuffle();
        myMusic.playAll();

        System.out.println("\n=== END OF TEST ===");
    }
}