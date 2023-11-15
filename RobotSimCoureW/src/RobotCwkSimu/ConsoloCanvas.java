package RobotCwkSimu;

public class ConsoloCanvas {
    private char[][] canvas;
    
    public ConsoloCanvas(int width, int height, String studentID) {
        canvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    canvas[i][j] = '#';
                } else if (j == 0 || j == width - 1) {
                    canvas[i][j] = '#';
                } else {
                    canvas[i][j] = ' ';
                }
            }
        }
        int idPosition = (width - studentID.length()) / 2;
        for (int i = 0; i < studentID.length(); i++) {
            canvas[0][idPosition + i] = studentID.charAt(i);
        }
    }
    
    public void showIt(int x, int y, char character) {
        if (x >= 1 && x < canvas[0].length - 1 && y >= 1 && y < canvas.length - 1) {
            canvas[y][x] = character;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                result.append(canvas[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }
}