package tools;

/**
 * 3/15/2022 - 9:17 AM
 *
 * @author simon
 */
public enum Images {
    LOGO("assets/tankyLogo.png"),
    ICON("assets/tankyIcon.png");

    private final String path;

    Images(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
