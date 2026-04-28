// Main.java
public class Main {
    public static void main(String[] args) {
        MediaPlayer audio = new AudioPlayer("Blinding Lights");
        MediaPlayer video = new VideoPlayer("Inception Trailer");
        MediaPlayer stream = new StreamingPlayer("Live NBA Finals Commentary");

        audio.play();
        audio.pause();
        audio.stop();

        System.out.println();

        video.play();
        video.pause();
        video.stop();

        System.out.println();

        stream.play();
        stream.pause();
        stream.stop();
    }
}

