// VideoPlayer.java
public class VideoPlayer implements MediaPlayer {
    private String title;

    public VideoPlayer(String title) {
        this.title = (title == null || title.trim().isEmpty()) ? "Unknown Video" : title;
    }

    @Override
    public void play() {
        System.out.println("VideoPlayer is playing video: " + title);
    }

    @Override
    public void pause() {
        System.out.println("VideoPlayer has paused.");
    }

    @Override
    public void stop() {
        System.out.println("VideoPlayer has stopped.");
    }
}