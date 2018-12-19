package BtnTypes;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class TeleportBtn extends Button{
    public Color telepornColor;
    public TeleportBtn teleportTo;
    public int xPos;
    public int yPos;

    public TeleportBtn(Color telepornColor, TeleportBtn teleportTo, int xPos, int yPos) {
        this.telepornColor = telepornColor;
        this.teleportTo = teleportTo;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public TeleportBtn(String text, Color telepornColor, TeleportBtn teleportTo, int xPos, int yPos) {
        super(text);
        this.telepornColor = telepornColor;
        this.teleportTo = teleportTo;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public TeleportBtn(String text, Node graphic, Color telepornColor, TeleportBtn teleportTo, int xPos, int yPos) {
        super(text, graphic);
        this.telepornColor = telepornColor;
        this.teleportTo = teleportTo;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Color getTelepornColor() {
        return telepornColor;
    }

    public void setTelepornColor(Color telepornColor) {
        this.telepornColor = telepornColor;
    }

    public TeleportBtn getTeleportTo() {
        return teleportTo;
    }

    public void setTeleportTo(TeleportBtn teleportTo) {
        this.teleportTo = teleportTo;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
