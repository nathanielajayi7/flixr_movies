package app.flix.free;

public class VideoPlayerConfig {
    //Minimum Video you want to buffer while Playing
    public static final int MIN_BUFFER_DURATION = 1000;
    //Max Video you want to buffer during PlayBack
    public static final int MAX_BUFFER_DURATION = 500;
    //Min Video you want to buffer before start Playing it
    public static final int MIN_PLAYBACK_START_BUFFER = 2000;
    //Min video You want to buffer when user resumes video
    public static final int MIN_PLAYBACK_RESUME_BUFFER = 500;
    public static final String DEFAULT_VIDEO_URL =
	"https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/360/Big_Buck_Bunny_360_10s_10MB.mp4";
	}
