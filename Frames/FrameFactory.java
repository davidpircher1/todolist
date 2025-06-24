package Frames;

public class FrameFactory {
    public Frame create(String FrameType) {
        return switch (FrameType) {
            case "main" -> new MainFrame("To Do List");
            case "add" -> new AddFrame("To Do List - Add");
            default -> null; // wrong frame name
        };
    }
}
