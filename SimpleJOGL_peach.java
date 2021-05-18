package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Font;

import java.io.File;
import java.io.IOException;

/**
 * SimpleJOGL_peach.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class SimpleJOGL_peach implements GLEventListener {

    Texture tex;
    TextRenderer text;

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new SimpleJOGL_peach());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);
        // Enable VSync
        gl.setSwapInterval(1);
        gl.glEnable(GL.GL_TEXTURE_2D); //activate texture mapping for 2D
        try {
//load textures here
            tex = TextureIO.newTexture(new File("castle.png"), true);

        } catch (IOException ex) {
            System.err.println(ex);
        }

        // Setup the drawing area and shading mode
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.

        text = new TextRenderer(new Font("Viner Hand ITC", Font.ROMAN_BASELINE, 50));

        // Setup the drawing area and shading mode
        gl.glClearColor(178 / 255f, 223 / 255f, 244 / 255f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(0.0f, -0.5f, -8.0f);
        gl.glTranslatef(0.0f, -2.5f, -6.3f);

        gl.glTranslatef(-7.0f, 5.0f, 0.0f);
        //--------------------------------------------------------------------------------------------------------------------------
  //first cloud   
        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        float numPoints3 = 50;
        float Radius3 = 1f;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();
        gl.glTranslatef(1.8f, 0.2f, 1.3f);

        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();

        gl.glTranslatef(1.0f, -0.2f, -0.3f);

        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------
  //seconed could 
        gl.glTranslatef(6.0f, 4.3f, -6.5f);

        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();

        gl.glTranslatef(0.8f, -1.3f, 4.3f);

        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();

        gl.glTranslatef(2.0f, 1.3f, -4.3f);

        gl.glColor3f(230 / 255f, 242 / 255f, 238 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------

        //sun
        gl.glTranslatef(3.5f, -1.0f, 3.8f);

        gl.glColor3f(223 / 255f, 217 / 255f, 0 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();

        gl.glTranslatef(2.0f, 1.3f, -3.9f);

        gl.glColor3f(255 / 255f, 228 / 255f, 74 / 255.0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < numPoints3; i++) {
            double Angle = i * (2.0 * Math.PI / numPoints3);
            //2.0*PI==360 
            double X = Math.cos(Angle) * Radius3;
            double Y = Math.sin(Angle) * Radius3;
            gl.glVertex2d(X, Y);
        }
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------

        //sea
        gl.glTranslatef(-9.0f, -6.2f, 3.9f);
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(59 / 255f, 144 / 255f, 245 / 255f);    // Set the current drawing color to light blue
        gl.glVertex3f(-9.0f, 1.0f, 4.8f);  // Top Left
        gl.glColor3f(50 / 255f, 161 / 255f, 249 / 255f);
        gl.glVertex3f(9.0f, 1.0f, 4.8f);   // Top Right
        gl.glColor3f(44 / 255f, 173 / 255f, 252 / 255f);
        gl.glVertex3f(9.0f, -2.0f, 4.8f);  // Bottom Right
        gl.glColor3f(40 / 255f, 181 / 255f, 254 / 255f);
        gl.glVertex3f(-9.0f, -2.0f, 4.8f); // Bottom Left
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------

        // sand
        gl.glTranslatef(-3.0f, -3.5f, 0.0f);
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(255 / 255f, 234 / 255f, 197 / 255f);    // Set the current drawing color to light blue
        gl.glVertex3f(-9.0f, 1.5f, 4.8f);  // Top Left
        gl.glVertex3f(9.0f, 1.5f, 4.8f);   // Top Right
        gl.glVertex3f(9.0f, -1.8f, 4.8f);  // Bottom Right
        gl.glVertex3f(-9.0f, -1.8f, 4.8f); // Bottom Left
        // Done Drawing The Quad
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------

        // Flush all drawing operations to the graphics card
       //the ship
        gl.glTranslatef(-3.9f, 5.0f, 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(201 / 255f, 43 / 255f, 0 / 255.0f);    // Set the current drawing color to light blue
        gl.glVertex3f(1.0f, -0.5f, 1.0f);  // Top Left
        gl.glVertex3f(2.0f, 0.4f, 1.0f);   // Top Right
        // gl.glVertex3f(0.0f, 0.4f, 0.0f);  // Bottom Right
        gl.glVertex3f(-2.5f, 0.3f, 1.0f); // Bottom Left
        gl.glVertex3f(-1.3f, -0.5f, 1.0f);  // Top Left
        gl.glEnd();

        // Move the "drawing cursor" around
        gl.glTranslatef(-2.5f, 0.6f, 0.0f);

        // Drawing The Left Side of Sail Using Triangles
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(163 / 255f, 198 / 255f, 46 / 255f);
        gl.glVertex3f(0.9f, 0.5f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 2.0f, 0.0f);
        // Finished Drawing The Left Side of Sail
        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------------------------
        gl.glTranslatef(0.1f, 0.0f, 0.0f);
        // Drawing The Boat Line Using Lines
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(188 / 255f, 124 / 255f, 30 / 255f);
        gl.glVertex3f(1.68f, 2.0f, 0.0f);//1
        gl.glVertex3f(1.5f, 2.0f, 0.0f);
        gl.glVertex3f(1.5f, -0.1f, 0.0f);
        gl.glVertex3f(1.68f, -0.1f, 0.0f);
        gl.glEnd();

        // Move the "drawing cursor" to another position
        gl.glTranslatef(0.1f, 0.0f, 0.0f);

        // Drawing The Right Side of Sail Using Triangles
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(163 / 255f, 198 / 255f, 46 / 255f);
        gl.glVertex3f(1.75f, 0.0f, 0.0f);
        gl.glVertex3f(1.75f, 2.0f, 0.0f);
        gl.glVertex3f(3.0f, 0.5f, 0.0f);
        gl.glEnd();
        gl.glTranslatef(-1.82f, -0.6f, 0.0f);

        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0 / 255f, 123 / 255f, 198 / 255f);
        gl.glVertex3f(0.8f, 0.0f, 0.0f);
        gl.glVertex3f(1.75f, 0.0f, 0.0f);
        gl.glEnd();

        gl.glTranslatef(0.25f, -0.3f, 0.0f);

        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0 / 255f, 123 / 255f, 198 / 255f);
        gl.glVertex3f(0.7f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glEnd();

        gl.glTranslatef(4.4f, 0.0f, 0.0f);

        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0 / 255f, 123 / 255f, 198 / 255f);
        gl.glVertex3f(0.7f, 0.0f, 0.0f);
        gl.glVertex3f(1.5f, 0.0f, 0.0f);
        gl.glEnd();

        gl.glTranslatef(-2.5f, -0.3f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0 / 255f, 123 / 255f, 198 / 255f);
        gl.glVertex3f(-1.356f, 0.0f, 0.0f);
        gl.glVertex3f(3.95f, 0.0f, 0.0f);
        gl.glEnd();
//--------------------------------------------------------------------------------------------------------------------------

        //brid 
        gl.glTranslatef(3.0f, 3.5f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(48 / 255f, 62 / 255f, 67 / 255f);
        gl.glVertex3f(-0.4f, 0.59f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        //  gl.glTranslatef(0.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(48 / 255f, 62 / 255f, 67 / 255f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.6f, 0.5f, 0.0f);
        gl.glEnd();

        gl.glTranslatef(0.55f, 0.5f, 0.0f);

        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(48 / 255f, 62 / 255f, 67 / 255f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.6f, 0.5f, 0.0f);

        gl.glEnd();

        gl.glTranslatef(0.57f, -0.5f, 0.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(48 / 255f, 62 / 255f, 67 / 255f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.4f, 0.59f, 0.0f);

        gl.glEnd();
        //--------------------------------------------------------------------------------------------------------
        //tex 

        // gl.glTranslatef(6.5f, 0.0f, 0.0f);
        text.beginRendering(drawable.getWidth(), drawable.getHeight());
        text.setColor(230 / 255f, 200 / 255f, 135 / 255f, 0.8f); //RGBA
        text.draw("Hello Summer", 120, 60);
        text.endRendering();

        //-----------------------------------------------------------------------
        //   tex.disable();
        gl.glTranslatef(6.0f, -7.0f, 9.9f);
        gl.glColor3f(255 / 255f, 255 / 255f, 255 / 255f);

        tex.bind();
        tex.enable();
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(0, 0);
        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(1, 0);
        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(1, 1);
        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(0, 1);
        gl.glEnd();
        tex.disable();

        gl.glFlush();

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
