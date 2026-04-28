// AudioPlayer.java
public class AudioPlayer implements MediaPlayer {
    private String title;

    public AudioPlayer(String title) {
        this.title = (title == null || title.trim().isEmpty()) ? "Unknown Audio" : title;
    }

    @Override
    public void play() {
        System.out.println("AudioPlayer is playing audio: " + title);
    }

    @Override
    public void pause() {
        System.out.println("AudioPlayer has paused.");
    }

    @Override
    public void stop() {
        System.out.println("AudioPlayer has stopped.");
    }
}