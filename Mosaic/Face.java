import java.util.Random;
import java.awt.Graphics;

public class Face extends Oval
{
    private Eye leftEye;
    private Eye rightEye;
    private Mouth mouth;

    private String mouthType;
    public String getMouthType() { return mouthType; }
    public void setMouthType(String newMouthType) { mouth.setFaceStatus(newMouthType); }

    public Face(int panelWidth, int panelHeight, int faceType)
    {
        super(0, 0, panelWidth, panelHeight);

        leftEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "L");
        rightEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "R");
        mouth = new Mouth(getPositionX(), getPositionY(), getWidth(), getHeight(), faceType);

        mouthType = mouth.getFaceStatus();
    }

    public void paintComponent(Graphics g)
    {
        g.drawOval(getPositionX(), getPositionY(), getWidth() - 1, getHeight() - 1);
        mouth.paintComponent(g);
        leftEye.paintComponent(g);
        rightEye.paintComponent(g);
    }
    /*
    public String toString()
    {
        return String.format("PositionX = %d - PositionY = %d - Width = %d - Height = %d - %s", 
        getPositionX(), getPositionY(), getWidth(), getHeight(), getMouthType());
    }
    */
}

class Eye extends Oval
{
    public Eye(int facePositionX, int facePositionY, int faceWidth, int faceHeight, String whichEye)
    {
        int eyeHeight = faceHeight / 4;  // Original size = 6
        int eyeWidth = faceWidth / 10;   // Original size = 6
        int leftEyePositionX = facePositionX - (eyeWidth / 2) + (faceWidth / 2) - eyeWidth;
        int rightEyePositionX = facePositionX - (eyeWidth / 2) + (faceWidth / 2) + eyeWidth;
        int eyePositionY = facePositionY + (faceHeight / 5);

        if (whichEye.equals("L") || whichEye.equals("l"))
        {
            setPositionX(leftEyePositionX);
            setPositionY(eyePositionY);
            setWidth(eyeWidth);
            setHeight(eyeHeight);
        }

        else
        {  
            setPositionX(rightEyePositionX);
            setPositionY(eyePositionY);
            setWidth(eyeWidth);
            setHeight(eyeHeight);
        }
    }

    public void paintComponent(Graphics g)
    {
        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}

class Mouth extends Rectangle
{
    private String faceStatus;
    public String getFaceStatus() { return faceStatus; }
    public void setFaceStatus(String newFaceStatus) { faceStatus = newFaceStatus; }

    public Mouth(int facePositionX, int facePositionY, int faceWidth, int faceHeight, int faceType)
    {
        int mouthWidth = (2 * faceWidth) / 3;
        int mouthHeight = faceHeight / 3;
        int mouthPositionX = facePositionX + (faceWidth / 6);
        int mouthPositionY = facePositionY + (3 * faceHeight) / 5;

        setPositionX(mouthPositionX);
        setPositionY(mouthPositionY);
        setWidth(mouthWidth);
        setHeight(mouthHeight);

        if (faceType == 0) { faceStatus = "Smile"; }
        else if (faceType == 1) { faceStatus = "Frown"; }
        else if (faceType == 2) { faceStatus = "Straight"; }
        else { faceStatus = "O Face"; }
    }
    
    public void paintComponent(Graphics g)
    {
        if (faceStatus.equals("Smile")) { g.drawArc(getPositionX(), getPositionY() - (getHeight() / 2), getWidth(), getHeight(), 180, 180); }
        else if (faceStatus.equals("Frown")) { g.drawArc(getPositionX(), getPositionY(), getWidth(), getHeight(), 0, 180); }
        else if (faceStatus.equals("Straight")) { g.drawLine(getPositionX(), getPositionY(), getPositionX() + getWidth(), getPositionY()); }
        else { g.drawArc(getPositionX(), getPositionY(), getWidth(), getHeight(), 180, 360); } // O Face
    }
}