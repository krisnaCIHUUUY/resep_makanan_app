package views; // sesuaikan dengan package kamu

import java.awt.*;
import javax.swing.*;

public class RoundedPanel extends JPanel {
    private int cornerRadius = 15;

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
        setOpaque(false);
    }


    @Override
protected void paintComponent(Graphics g) {
    // Jangan panggil super.paintComponent(g) jika kita ingin kontrol penuh warna background
    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // 1. Gambar Background yang melengkung
    graphics.setColor(getBackground()); // Mengambil warna yang diset di NetBeans
    graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

    // 2. Gambar Border (Garis tepi)
    // Gunakan warna foreground atau warna spesifik untuk garis
    graphics.setColor(getForeground());
    graphics.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
}
}
