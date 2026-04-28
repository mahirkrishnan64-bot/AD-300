// StreamingPlayer.java
public class StreamingPlayer implements MediaPlayer {
    private String title;

    public StreamingPlayer(String title) {
        this.title = (title == null || title.trim().isEmpty()) ? "Unknown Stream" : title;
    }

    @Override
    public void play() {
        System.out.println("StreamingPlayer is streaming: " + title);
    }

    @Override
    public void pause() {
        System.out.println("StreamingPlayer has paused.");
    }

    @Override
    public void stop() {
        System.out.println("StreamingPlayer has stopped.");
    }
}