import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.RenderingHints;

public class BouncingDigits extends JPanel implements Runnable {

    // --- Window setup ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing 6 & 7");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            BouncingDigits panel = new BouncingDigits();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            Thread t = new Thread(panel);
            t.setDaemon(true);
            t.start();
        });
    }

    // --- Constants ---
    static final int W = 680;
    static final int H = 420;
    static final float GRAVITY   = 0.55f;
    static final float DAMPING   = 0.68f;
    static final float MIN_VY    = 3.5f;
    static final float DIGIT_SIZE = 180f;  // bounding height of each digit
    static final float FLOOR_Y   = H - 36f;

    // Colour palettes (pairs: main, dim)
    static final Color[][] PALETTES = {
        { new Color(0x00e5ff), new Color(0x00b8d4) },
        { new Color(0xe040fb), new Color(0xaa00ff) },
        { new Color(0x69ff47), new Color(0x00b686) },
        { new Color(0xff6d00), new Color(0xff9100) },
        { new Color(0xff4081), new Color(0xf50057) },
        { new Color(0xffea00), new Color(0xffd600) },
    };

    // --- Ball state ---
    static class Ball {
        float  xFrac;          // horizontal centre as fraction of W
        float  y;              // top-left y of digit bounding box
        float  vy;
        int    bounces  = 0;
        int    palIdx;
        float  squish   = 1f;  // x scale (>1 = wider)
        int    squishT  = 0;   // frames remaining in squish animation
        int    startDelay;
        boolean started = false;

        Ball(float xFrac, int palIdx, int startDelay) {
            this.xFrac      = xFrac;
            this.palIdx     = palIdx;
            this.startDelay = startDelay;
            this.y          = FLOOR_Y - DIGIT_SIZE;
        }
    }

    Ball b6 = new Ball(0.28f, 0, 0);
    Ball b7 = new Ball(0.62f, 2, 18);
    int  frame        = 0;
    int  totalBounces = 0;

    // --- Swing setup ---
    public BouncingDigits() {
        setPreferredSize(new Dimension(W, H));
        setBackground(new Color(0x0a0a0f));
    }

    // --- Game loop ---
    @Override
    public void run() {
        while (true) {
            update();
            repaint();
            try { Thread.sleep(16); } catch (InterruptedException e) { break; }
        }
    }

    void update() {
        frame++;
        for (Ball b : new Ball[]{ b6, b7 }) {
            if (!b.started) {
                if (frame >= b.startDelay) {
                    b.started = true;
                    b.vy      = -(MIN_VY + 8f);
                    b.y       = FLOOR_Y - DIGIT_SIZE;
                }
                continue;
            }
            b.vy += GRAVITY;
            b.y  += b.vy;

            // Squish animation
            if (b.squishT > 0) {
                b.squishT--;
                float t = 1f - b.squishT / 8f;
                b.squish = 1f + 0.22f * (float) Math.sin(Math.PI * t);
            } else {
                b.squish = 1f;
            }

            // Floor collision
            if (b.y >= FLOOR_Y - DIGIT_SIZE) {
                b.y  = FLOOR_Y - DIGIT_SIZE;
                float speed = Math.abs(b.vy);
                b.vy       = -Math.max(speed * DAMPING, MIN_VY);
                b.bounces++;
                totalBounces++;
                b.palIdx  = (b.palIdx + 1) % PALETTES.length;
                b.squishT = 8;
            }
        }
    }

    // --- Rendering ---
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,      RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,    RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,         RenderingHints.VALUE_RENDER_QUALITY);

        // Background
        g2.setColor(new Color(0x0a0a0f));
        g2.fillRect(0, 0, W, H);

        // Digits
        if (b6.started) drawDigit(g2, b6, true);
        if (b7.started) drawDigit(g2, b7, false);

        // Floor glow line
        drawFloor(g2);

        // HUD
        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        g2.setColor(new Color(0x444444));
        String hud = String.format("BOUNCES: %05d", totalBounces);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(hud, (W - fm.stringWidth(hud)) / 2, H - 8);
    }

    void drawDigit(Graphics2D g2, Ball b, boolean isSix) {
        float cx    = b.xFrac * W;          // horizontal centre
        float baseY = b.y + DIGIT_SIZE;     // bottom of digit (pivot for squish)
        Color col   = PALETTES[b.palIdx][0];
        float s     = DIGIT_SIZE;

        // Shadow ellipse on floor
        float distFrac = Math.max(0, 1f - Math.abs(b.vy) / 14f);
        float alpha    = 0.15f + 0.25f * distFrac;
        float eW       = s * 0.28f * b.squish;
        g2.setColor(new Color(col.getRed(), col.getGreen(), col.getBlue(),
                              (int)(alpha * 255)));
        g2.fill(new Ellipse2D.Float(cx - eW, FLOOR_Y - 5, eW * 2, 10));

        // Apply squish transform around base centre
        AffineTransform old = g2.getTransform();
        g2.translate(cx, baseY);
        g2.scale(b.squish, 1f / b.squish);
        g2.translate(-cx, -baseY);

        // Stroke style
        BasicStroke stroke = new BasicStroke(s * 0.09f,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke);

        // Glow layers (paint 3x with decreasing alpha to fake glow)
        for (int layer = 3; layer >= 0; layer--) {
            if (layer == 0) {
                g2.setColor(col);
            } else {
                float glowAlpha = 0.12f * layer;
                g2.setColor(new Color(col.getRed(), col.getGreen(), col.getBlue(),
                                      (int)(glowAlpha * 255)));
                BasicStroke wide = new BasicStroke(s * 0.09f + layer * 4f,
                        BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g2.setStroke(wide);
            }

            Path2D path = isSix ? buildSix(cx, b.y, s) : buildSeven(cx, b.y, s);
            g2.draw(path);
        }

        g2.setTransform(old);
    }

    // --- Digit paths (Bezier, same math as canvas version) ---

    Path2D buildSix(float cx, float topY, float s) {
        // origin at (cx - s*0.38, topY) — matches canvas: drawSix offset
        float ox = cx - s * 0.38f;
        float oy = topY;
        Path2D p = new Path2D.Float();
        p.moveTo(ox + s*0.6f,  oy);
        p.curveTo(ox + s*0.1f,  oy,
                  ox - s*0.05f, oy + s*0.3f,
                  ox + s*0.05f, oy + s*0.5f);
        p.curveTo(ox + s*0.15f, oy + s*0.7f,
                  ox + s*0.4f,  oy + s*0.75f,
                  ox + s*0.55f, oy + s*0.62f);
        p.curveTo(ox + s*0.72f, oy + s*0.48f,
                  ox + s*0.7f,  oy + s*0.25f,
                  ox + s*0.52f, oy + s*0.18f);
        p.curveTo(ox + s*0.3f,  oy + s*0.1f,
                  ox + s*0.08f, oy + s*0.22f,
                  ox + s*0.08f, oy + s*0.45f);
        return p;
    }

    Path2D buildSeven(float cx, float topY, float s) {
        float ox = cx - s * 0.36f;
        float oy = topY;
        float sw = s * 0.72f;   // seven uses 0.72*s width
        Path2D p = new Path2D.Float();
        p.moveTo(ox,           oy);
        p.lineTo(ox + sw*1f,   oy);
        p.curveTo(ox + sw*1f,  oy,
                  ox + sw*0.94f, oy + s*0.15f,
                  ox + sw*0.76f, oy + s*0.32f);
        p.curveTo(ox + sw*0.53f, oy + s*0.52f,
                  ox + sw*0.31f, oy + s*0.68f,
                  ox + sw*0.25f, oy + s*1.0f);
        return p;
    }

    void drawFloor(Graphics2D g2) {
        // Cyan glowing line at FLOOR_Y — 3 layers to fake a glow
        int[] alphas = { 20, 60, 200 };
        int[] widths = {  6,  3,   1 };
        for (int i = 0; i < 3; i++) {
            g2.setColor(new Color(0, 229, 255, alphas[i]));
            g2.setStroke(new BasicStroke(widths[i]));
            g2.drawLine((int)(W * 0.05f), (int) FLOOR_Y,
                        (int)(W * 0.95f), (int) FLOOR_Y);
        }
    }
}