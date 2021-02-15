import java.awt.Graphics;

public class Eye extends Oval
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