import java.awt.Graphics;
import java.util.Random;

public class Face extends Oval
{
    private Eye leftEye;
    private Eye rightEye;
    private Mouth mouth;

    private String mouthType;
    public String getMouthType() { return mouthType; }
    public void setMouthType(String newMouthType) { mouth.setFaceStatus(newMouthType); }

    private Random numGen = new Random();

    public Face()
    {
        setPositionX(numGen.nextInt(550) + 10);
        setPositionY(numGen.nextInt(550) + 10);
        setWidth(numGen.nextInt(150) + 50);
        setHeight(numGen.nextInt(150) + 50);

        leftEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "L");
        rightEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "R");
        mouth = new Mouth(getPositionX(), getPositionY(), getWidth(), getHeight());

        mouthType = mouth.getFaceStatus();
    }
    public Face(int frameWidth, int frameHeight)
    {
        setPositionX(numGen.nextInt(frameWidth) + 10);
        setPositionY(numGen.nextInt(frameHeight - 200) + 10);
        setWidth(numGen.nextInt(150) + 50);
        setHeight(numGen.nextInt(150) + 50);

        leftEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "L");
        rightEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "R");
        mouth = new Mouth(getPositionX(), getPositionY(), getWidth(), getHeight());

        mouthType = mouth.getFaceStatus();
    }

    public Face(int positionX, int positionY, int width, int height, int frameWidth, int frameHeight)
    {
        super(positionX, positionY, width, height);

        leftEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "L");
        rightEye = new Eye(getPositionX(), getPositionY(), getWidth(), getHeight(), "R");
        mouth = new Mouth(getPositionX(), getPositionY(), getWidth(), getHeight());

        mouthType = mouth.getFaceStatus();
    }

    public void paintComponent(Graphics g)
    {
        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
        mouth.paintComponent(g);
        leftEye.paintComponent(g);
        rightEye.paintComponent(g);
    }

    public String toString()
    {
        return String.format("PositionX = %d - PositionY = %d - Width = %d - Height = %d - %s", 
        getPositionX(), getPositionY(), getWidth(), getHeight(), getMouthType());
    }
}