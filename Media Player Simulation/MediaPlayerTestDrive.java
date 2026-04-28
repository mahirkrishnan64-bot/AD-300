// MediaPlayerTestDrive.java
public class MediaPlayerTestDrive {
    public static void main(String[] args) {
        System.out.println("Normal Test Cases:");
        MediaPlayer p1 = new AudioPlayer("Song A");
        MediaPlayer p2 = new VideoPlayer("Movie Clip");
        MediaPlayer p3 = new StreamingPlayer("Twitch Stream");

        p1.play();
        p2.play();
        p3.play();

        System.out.println("\nEdge Test Cases:");
        MediaPlayer e1 = new AudioPlayer("");
        MediaPlayer e2 = new VideoPlayer("   ");
        MediaPlayer e3 = new StreamingPlayer(null);

        e1.play();
        e2.play();
        e3.play();
    }
}