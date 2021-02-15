import java.awt.Graphics;
import java.util.Random;

public class Mouth extends Rectangle
{
    private Random numGen = new Random();
    private int mouthGen = numGen.nextInt(4);

    private String faceStatus;
    public String getFaceStatus() { return faceStatus; }
    public void setFaceStatus(String newFaceStatus) { faceStatus = newFaceStatus; }

    public Mouth(int facePositionX, int facePositionY, int faceWidth, int faceHeight)
    {
        int mouthWidth = (2 * faceWidth) / 3;
        int mouthHeight = faceHeight / 3;
        int mouthPositionX = facePositionX + (faceWidth / 6);
        int mouthPositionY = facePositionY + (3 * faceHeight) / 5;

        setPositionX(mouthPositionX);
        setPositionY(mouthPositionY);
        setWidth(mouthWidth);
        setHeight(mouthHeight);

        if (mouthGen == 0) { faceStatus = "Smile"; }
        else if (mouthGen == 1) { faceStatus = "Frown"; }
        else if (mouthGen == 2) { faceStatus = "Straight"; }
        else { faceStatus = "O Face"; }
    }
    
    public void paintComponent(Graphics g)
    {
        if (faceStatus.equals("Smile")) { g.drawArc(getPositionX(), getPositionY() - (getHeight() / 2), getWidth(), getHeight(), 180, 180); }
        else if (faceStatus.equals("Frown")) { g.drawArc(getPositionX(), getPositionY(), getWidth(), getHeight(), 0, 180); }
        else if (faceStatus.equals("Stright")) { g.drawLine(getPositionX(), getPositionY(), getPositionX() + getWidth(), getPositionY()); }
        else { g.drawArc(getPositionX(), getPositionY(), getWidth(), getHeight(), 180, 360); } // O Face
    }
}