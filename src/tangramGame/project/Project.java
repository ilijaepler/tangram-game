package tangramGame.project;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.sun.opengl.util.BufferUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.IntBuffer;

public class Project extends GLCanvas implements GLEventListener, KeyListener, MouseListener {

    // create multiple checkboxes
    private JCheckBox lightOnOff;
    private JCheckBox ambientLighting;
    private JCheckBox diffuseLighting;
    private JCheckBox specularLighting;
    private JCheckBox ambientLight;

    // create multiple buttons
    private JButton removeButton;
    private JButton addButton;
    private JButton finishButton;
    private JButton helpButton;
    private JButton quitButton;
    private JButton resetButton;

    // used to display either text, images, or both
    private JLabel label;

    // the main gui where all the component like label, button,
    // and checkboxes are added to
    private JFrame frame;

    // initialize our camera
    private Camera camera;

    // initialize the canvas for the window
    private GLCanvas canvas;
    private FPSAnimator animator;
    private int windowWidth = 640;
    private int windowHeight = 520;
    private static final String TITLE = "Tangram game";
    private static final int FPS = 60;

    // allows us to access the opengl utility library like volume, all the
    // projection,
    // scaling, etc.
    private GLU glu;

    // render bitmapped java 2d text into an opengl window with high performance
    private TextRenderer textRenderer;
    private TextRenderer textMatch;

    // initialize a name ID for picking the shapes
    private int nameId = 0;

    // number of matched shapes on the blueprint
    private int matchedShapes = 0;

    // boolean for checking if the shape is matched
    private boolean triangle1isMatched = false;
    private boolean trapezium1isMatched = false;
    private boolean trapezium2isMatched = false;
    private boolean trapezium3isMatched = false;
    private boolean trapezium4isMatched = false;
    private boolean trapezium5isMatched = false;
    private boolean rhombus1isMatched = false;
    private boolean triangle8isMatched = false;
    private boolean triangle2isMatched = false;
    private boolean triangle3isMatched = false;
    private boolean triangle4isMatched = false;
    private boolean rhombusNarrow1isMatched = false;
    private boolean rhombusNarrow2isMatched = false;
    private boolean triangle5isMatched = false;
    private boolean triangle6isMatched = false;
    private boolean rhombusNarrow3isMatched = false;
    private boolean triangle7isMatched = false;
    private boolean trapezium6isMatched = false;
    private boolean hexagon1isMatched = false;
    private boolean trapezium7isMatched = false;
    private boolean trapezium8isMatched = false;

    // id for the palette shape inserted into the blueprint
    private int triangle1_idn = 0;
    private int trapezium1_idn = 0;
    private int trapezium2_idn = 0;
    private int trapezium3_idn = 0;
    private int trapezium4_idn = 0;
    private int trapezium5_idn = 0;
    private int rhombus1_idn = 0;
    private int triangle8_idn = 0;
    private int triangle2_idn = 0;
    private int triangle3_idn = 0;
    private int triangle4_idn = 0;
    private int rhombusNarrow1_idn = 0;
    private int rhombusNarrow2_idn = 0;
    private int triangle5_idn = 0;
    private int triangle6_idn = 0;
    private int rhombusNarrow3_idn = 0;
    private int triangle7_idn = 0;
    private int trapezium6_idn = 0;
    private int hexagon1_idn = 0;
    private int trapezium7_idn = 0;
    private int trapezium8_idn = 0;

    // blueprint shapes borderline colors
    private float triangle1Red = 0f;
    private float triangle1Green = 0f;
    private float triangle1Blue = 0f;

    private float trapezium1Red = 0f;
    private float trapezium1Green = 0f;
    private float trapezium1Blue = 0f;

    private float trapezium2Red = 0f;
    private float trapezium2Green = 0f;
    private float trapezium2Blue = 0f;

    private float trapezium3Red = 0f;
    private float trapezium3Green = 0f;
    private float trapezium3Blue = 0f;

    private float trapezium4Red = 0f;
    private float trapezium4Green = 0f;
    private float trapezium4Blue = 0f;

    private float trapezium5Red = 0f;
    private float trapezium5Green = 0f;
    private float trapezium5Blue = 0f;

    private float rhombus1Red = 0f;
    private float rhombus1Green = 0f;
    private float rhombus1Blue = 0f;

    private float triangle8Red = 0f;
    private float triangle8Green = 0f;
    private float triangle8Blue = 0f;

    private float triangle2Red = 0f;
    private float triangle2Green = 0f;
    private float triangle2Blue = 0f;

    private float triangle3Red = 0f;
    private float triangle3Green = 0f;
    private float triangle3Blue = 0f;

    private float triangle4Red = 0f;
    private float triangle4Green = 0f;
    private float triangle4Blue = 0f;

    private float rhombusNarrow1Red = 0f;
    private float rhombusNarrow1Green = 0f;
    private float rhombusNarrow1Blue = 0f;

    private float rhombusNarrow2Red = 0f;
    private float rhombusNarrow2Green = 0f;
    private float rhombusNarrow2Blue = 0f;

    private float triangle5Red = 0f;
    private float triangle5Green = 0f;
    private float triangle5Blue = 0f;

    private float triangle6Red = 0f;
    private float triangle6Green = 0f;
    private float triangle6Blue = 0f;

    private float rhombusNarrow3Red = 0f;
    private float rhombusNarrow3Green = 0f;
    private float rhombusNarrow3Blue = 0f;

    private float triangle7Red = 0f;
    private float triangle7Green = 0f;
    private float triangle7Blue = 0f;

    private float trapezium6Red = 0f;
    private float trapezium6Green = 0f;
    private float trapezium6Blue = 0f;

    private float hexagon1Red = 0f;
    private float hexagon1Green = 0f;
    private float hexagon1Blue = 0f;

    private float trapezium7Red = 0f;
    private float trapezium7Green = 0f;
    private float trapezium7Blue = 0f;

    private float trapezium8Red = 0f;
    private float trapezium8Green = 0f;
    private float trapezium8Blue = 0f;

    // initialize the position of the shapes on the blueprint

    // triangle 1 blueprint coordinates
    private float triangle1X = 0f;
    private float triangle1Y = -0.25f;
    private float triangle1Z = 0f;

    // trapezium 1 blueprint coordinates
    private float trapezium1X = -0.17f;
    private float trapezium1Y = 0.1f;
    private float trapezium1Z = 0f;

    // trapezium 2 blueprint coordinates
    private float trapezium2X = -0.05f;
    private float trapezium2Y = 0.3f;
    private float trapezium2Z = 0f;

    // trapezium 3 blueprint coordinates
    private float trapezium3X = -0.1f;
    private float trapezium3Y = -0.38f;
    private float trapezium3Z = 0f;

    // trapezium 4 blueprint coordinates
    private float trapezium4X = -1.4f;
    private float trapezium4Y = 0.45f;
    private float trapezium4Z = 0f;

    // trapezium 5 blueprint coordinates
    private float trapezium5X = -0.015f;
    private float trapezium5Y = -2.3f;
    private float trapezium5Z = 0f;

    // rhombus 1 blueprint coordinates
    private float rhombus1X = -0.65f;
    private float rhombus1Y = -1.1f;
    private float rhombus1Z = 0f;

    // triangle 8 blueprint coordinates
    private float triangle8X = -0.5f;
    private float triangle8Y = 2f;
    private float triangle8Z = 0f;

    // triangle 2 blueprint coordinates
    private float triangle2X = 0.63f;
    private float triangle2Y = -0.4f;
    private float triangle2Z = 0f;

    // triangle 3 blueprint coordinates
    private float triangle3X = -0.53f;
    private float triangle3Y = -0.78f;
    private float triangle3Z = 0f;

    // triangle 4 blueprint coordinates
    private float triangle4X = 0f;
    private float triangle4Y = -0.78f;
    private float triangle4Z = 0f;

    // narrow rhombus 1 blueprint coordinates
    private float rhombusNarrow1X = 2f;
    private float rhombusNarrow1Y = 2.5f;
    private float rhombusNarrow1Z = 0f;

    // narrow rhombus 2 blueprint coordinates
    private float rhombusNarrow2X = 2.7f;
    private float rhombusNarrow2Y = 1f;
    private float rhombusNarrow2Z = 2.7f;

    // triangle 5 blueprint coordinates
    private float triangle5X = -2.2f;
    private float triangle5Y = -3f;
    private float triangle5Z = 0f;

    // triangle 6 blueprint coordinates
    private float triangle6X = -0.8f;
    private float triangle6Y = -4f;
    private float triangle6Z = 0f;

    // narrow rhombus 3 blueprint coordinates
    private float rhombusNarrow3X = -0.02f;
    private float rhombusNarrow3Y = 0.5f;
    private float rhombusNarrow3Z = 0f;

    // triangle 7 blueprint coordinates
    private float triangle7X = 0.6f;
    private float triangle7Y = -0.5f;
    private float triangle7Z = 0f;

    // trapezium 6 blueprint coordinates
    private float trapezium6X = 0.7f;
    private float trapezium6Y = 0.45f;
    private float trapezium6Z = 0f;

    // hexagon 1 blueprint coordinates
    private float hexagon1X = -0.75f;
    private float hexagon1Y = 1.25f;
    private float hexagon1Z = 0f;

    // trapezium 7 blueprint coordinates
    private float trapezium7X = 3.1f;
    private float trapezium7Y = -1.5f;
    private float trapezium7Z = 0f;

    // trapezium 8 blueprint coordinates
    private float trapezium8X = -3.5f;
    private float trapezium8Y = 3.7f;
    private float trapezium8Z = 0f;

    // scales for the shapes which are added to the blueprint
    private float scaleTriangle1 = 0.8f;
    private float scaleTrapezium1 = 0.8f;
    private float scaleTrapezium2 = 0.8f;
    private float scaleTrapezium3 = 0.8f;
    private float scaleTrapezium4 = 0.8f;
    private float scaleTrapezium5 = 0.8f;
    private float scaleRhombus1 = 0.8f;
    private float scaleTriangle8 = 0.8f;
    private float scaleTriangle2 = 0.8f;
    private float scaleTriangle3 = 0.8f;
    private float scaleTriangle4 = 0.8f;
    private float scaleRhombusNarrow1 = 0.8f;
    private float scaleRhombusNarrow2 = 0.8f;
    private float scaleTriangle5 = 0.8f;
    private float scaleTriangle6 = 0.8f;
    private float scaleRhombusNarrow3 = 0.8f;
    private float scaleTriangle7 = 0.8f;
    private float scaleTrapezium6 = 0.8f;
    private float scaleHexagon1 = 0.8f;
    private float scaleTrapezium7 = 0.8f;
    private float scaleTrapezium8 = 0.8f;

    // rotations
    private float rotateDelta = 1f;

    // rotations for the shapes which are added to the blueprint
    private float rotateTriangle1 = 0f;
    private float rotateTrapezium1 = 0f;
    private float rotateTrapezium2 = 0f;
    private float rotateTrapezium3 = 0f;
    private float rotateTrapezium4 = 0f;
    private float rotateTrapezium5 = 0f;
    private float rotateRhombus1 = 0f;
    private float rotateTriangle8 = 0f;
    private float rotateTriangle2 = 0f;
    private float rotateTriangle3 = 0f;
    private float rotateTriangle4 = 0f;
    private float rotateRhombusNarrow1 = 0f;
    private float rotateRhombusNarrow2 = 0f;
    private float rotateTriangle5 = 0f;
    private float rotateTriangle6 = 0f;
    private float rotateRhombusNarrow3 = 0f;
    private float rotateTriangle7 = 0f;
    private float rotateTrapezium6 = 0f;
    private float rotateHexagon1 = 0f;
    private float rotateTrapezium7 = 0f;
    private float rotateTrapezium8 = 0f;

    // rotation values for the blueprint
    private float rotateBlueprintTriangle1 = 90f;
    private float rotateBlueprintTrapezium1 = 210f;
    private float rotateBlueprintTrapezium2 = 90f;
    private float rotateBlueprintTrapezium3 = 270f;
    private float rotateBlueprintTrapezium4 = -28f;
    private float rotateBlueprintTrapezium5 = 30f;
    private float rotateBlueprintRhombus1 = 90f;
    private float rotateBlueprintTriangle8 = -45f;
    private float rotateBlueprintTriangle2 = 90f;
    private float rotateBlueprintTriangle3 = 270f;
    private float rotateBlueprintTriangle4 = 270f;
    private float rotateBlueprintRhombusNarrow1 = 30f;
    private float rotateBlueprintRhombusNarrow2 = 30f;
    private float rotateBlueprintTriangle5 = -30f;
    private float rotateBlueprintTriangle6 = -30f;
    private float rotateBlueprintRhombusNarrow3 = 118f;
    private float rotateBlueprintTriangle7 = -90f;
    private float rotateBlueprintTrapezium6 = -90f;
    private float rotateBlueprintHexagon1 = 90f;
    private float rotateBlueprintTrapezium7 = -30f;
    private float rotateBlueprintTrapezium8 = 30f;

    // initialize a variable to traverse through the blueprint
    private int traverse = 0;

    // initialize a constant value for scaling the shape in the blueprint (increase/decrease)
    private float scaleDelta = 0.1f;

    // initialize the colors for the trapezium
    private float trapeziumRed = 1f;
    private float trapeziumGreen = 0f;
    private float trapeziumBlue = 0f;

    // initialize the colors for the square
    private float squareRed = 0.8f;
    private float squareGreen = 0.4f;
    private float squareBlue = 0f;

    // initialize the colors for the triangle
    private float triangleRed = 0f;
    private float triangleGreen = 1f;
    private float triangleBlue = 0f;

    // initialize the colors for the hexagon
    private float hexagonRed = 1f;
    private float hexagonGreen = 1f;
    private float hexagonBlue = 0f;

    // initialize the colors for the rhombus
    private float rhombusRed = 0f;
    private float rhombusGreen = 0f;
    private float rhombusBlue = 1f;

    // initialize the colors for the narrow rhombus
    private float rhombusNarrowRed = 0.8f;
    private float rhombusNarrowGreen = 0.7f;
    private float rhombusNarrowBlue = 0.55f;

    // shapes on the palette
    private final static int TRIANGLE = 22;
    private final static int RHOMBUS = 23;
    private final static int SQUARE = 24;
    private final static int HEXAGON = 25;
    private final static int RHOMBUS_NARROW = 26;
    private final static int TRAPEZIUM = 27;

    // initialize the id for where the shapes will be placed
    private final static int TRIANGLE_1_ID = 1;
    private final static int TRAPEZIUM_1_ID = 2;
    private final static int TRAPEZIUM_2_ID = 3;
    private final static int TRAPEZIUM_3_ID = 4;
    private final static int TRAPEZIUM_4_ID = 5;
    private final static int TRAPEZIUM_5_ID = 6;
    private final static int RHOMBUS_1_ID = 7;
    private final static int TRIANGLE_8_ID = 8;
    private final static int TRIANGLE_2_ID = 9;
    private final static int TRIANGLE_3_ID = 10;
    private final static int TRIANGLE_4_ID = 11;
    private final static int RHOMBUS_NARROW_1_ID = 12;
    private final static int RHOMBUS_NARROW_2_ID = 13;
    private final static int TRIANGLE_5_ID = 14;
    private final static int TRIANGLE_6_ID = 15;
    private final static int RHOMBUS_NARROW_3_ID = 16;
    private final static int TRIANGLE_7_ID = 17;
    private final static int TRAPEZIUM_6_ID = 18;
    private final static int HEXAGON_1_ID = 19;
    private final static int TRAPEZIUM_7_ID = 20;
    private final static int TRAPEZIUM_8_ID = 21;

    // initialize variable for the shapes on the palette.
    // Note: This is used when we want to add shapes into the blueprint
    private final static int TRIANGLE_ID = 28;
    private final static int RHOMBUS_ID = 29;
    private final static int SQUARE_ID = 30;
    private final static int HEXAGON_ID = 31;
    private final static int RHOMBUS_NARROW_ID = 32;
    private final static int TRAPEZIUM_ID = 33;

    private final static String[] shape = {" ", "TRIANGLE_1", "TRAPEZIUM_1", "TRAPEZIUM_2", "TRAPEZIUM_3", "TRAPEZIUM_4", "TRAPEZIUM_5", "RHOMBUS_1", "TRIANGLE_8", "TRIANGLE_2", "TRIANGLE_3", "TRIANGLE_4", "RHOMBUS_NARROW_1", "RHOMBUS_NARROW_2", "TRIANGLE_5", "TRIANGLE_6", "RHOMBUS_NARROW_3", "TRIANGLE_7", "TRAPEZIUM_6", "HEXAGON_1", "TRAPEZIUM_7", "TRAPEZIUM_8", // shapes on the blueprint
            "TRIANGLE", "RHOMBUS", "SQUARE", "HEXAGON", "RHOMBUS_NARROW", "TRAPEZIUM"}; // shapes on the palette.

    // total number of shapes (n+1) - because we start looping from 1
    private final static int TOTAL_NUM_OF_SHAPES = 22;

    // size of buffer to store in memory, information about the selected object (shape)
    private static final int BUFFSIZE = 512;
    private IntBuffer selectBuffer;

    // used in selecting the object we want to draw on the blueprint,
    // by getting the X & Y coordinate (by a mousePressed)
    private boolean inSelectionMode = false;
    private int xCursor = 0;
    private int yCursor = 0;

    private float aspect; // calculate the aspect ratio for the blueprint
    private float aspectP; // aspect ratio for the palette

    private boolean gameFinished = false;
    private boolean newGame = true;

    public Project() {
        // get the opengl profile context
        GLProfile profile = GLProfile.getDefault();

        // specified a set of opengl capabilities that a rendering context must support
        GLCapabilities caps = new GLCapabilities(profile);
        caps.setAlphaBits(8);
        caps.setDepthBits(24);
        caps.setDoubleBuffered(true); // needed for reducing flicking and having a smooth animation
        caps.setStencilBits(8); // used to mask pixels in an image to product special effect

        SwingUtilities.invokeLater(() -> {

            // create the opengl rendering canvas
            canvas = new GLCanvas();
            canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            canvas.addGLEventListener(this);
            canvas.addKeyListener(this);
            canvas.addMouseListener((java.awt.event.MouseListener) this);
            canvas.setFocusable(true); // gets the focus of the component
            canvas.requestFocus(); // allows the user enter data via keyboard
            canvas.requestFocusInWindow(); // ensures the windows gains the focus once launched

            // initialize the FPSAnimator by call the FPSAnimator constructor,
            // canvas, FPS, if we want to use a fixed rate scheduling
            animator = new FPSAnimator(canvas, FPS, true);

            // initialize the object by calling the JFrame constructor
            frame = new JFrame();

            // initialize the button and set it's preferred dimensions
            removeButton = new JButton("Remove");
            addButton = new JButton("Add");
            finishButton = new JButton("Finish");
            quitButton = new JButton("Quit");
            helpButton = new JButton("Help");
            resetButton = new JButton("Reset");

            removeButton.setPreferredSize(new Dimension(100, 20));
            addButton.setPreferredSize(new Dimension(100, 20));
            finishButton.setPreferredSize(new Dimension(100, 20));
            quitButton.setPreferredSize(new Dimension(100, 20));
            helpButton.setPreferredSize(new Dimension(100, 20));
            resetButton.setPreferredSize(new Dimension(100, 20));

            // initialize the JLabel text
            label = new JLabel("Click on the help button to read the game instructions.");

            // add the checkboxes
            lightOnOff = new JCheckBox("Turn Light ON/OFF", true);
            ambientLighting = new JCheckBox("Ambient Light", false);
            specularLighting = new JCheckBox("Specular Light", false);
            diffuseLighting = new JCheckBox("Diffused Light", false);
            ambientLight = new JCheckBox("Global Ambient Light", false);

            // initialized a layout for the buttons (2,2) grid
            JPanel bottom = new JPanel();
            bottom.setLayout(new GridLayout(2, 2));

            // create a panel for the first row
            JPanel row1 = new JPanel();
            row1.add(removeButton);
            row1.add(addButton);
            row1.add(ambientLight);
            row1.add(lightOnOff);
            row1.add(ambientLighting);
            row1.add(diffuseLighting);
            row1.add(specularLighting);
            bottom.add(row1);

            // create a panel for the second row
            JPanel row2 = new JPanel();
            row2.add(label);
            row2.add(helpButton);
            row2.add(finishButton);
            row2.add(resetButton);
            row2.add(quitButton);
            bottom.add(row2);

            // add the layout to the frame
            frame.add(bottom, BorderLayout.SOUTH);

            // set the components to false, so once we click on it
            // an action can be performed
            ambientLight.setFocusable(false);
            lightOnOff.setFocusable(false);
            ambientLighting.setFocusable(false);
            diffuseLighting.setFocusable(false);
            specularLighting.setFocusable(false);

            addButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == addButton) {
                    //assist us in knowing which shape to be drawn
                    if (traverse == 1) {
                        triangle1_idn = nameId;
                        System.out.println(triangle1_idn);
                    } else if (traverse == 2) {
                        trapezium1_idn = nameId;
                        System.out.println(trapezium1_idn);
                    } else if (traverse == 3) {
                        trapezium2_idn = nameId;
                        System.out.println(trapezium2_idn);
                    } else if (traverse == 4) {
                        trapezium3_idn = nameId;
                        System.out.println(trapezium3_idn);
                    } else if (traverse == 5) {
                        trapezium4_idn = nameId;
                        System.out.println(trapezium4_idn);
                    } else if (traverse == 6) {
                        trapezium5_idn = nameId;
                        System.out.println(trapezium5_idn);
                    } else if (traverse == 7) {
                        rhombus1_idn = nameId;
                        System.out.println(rhombus1_idn);
                    } else if (traverse == 8) {
                        triangle8_idn = nameId;
                        System.out.println(triangle8_idn);
                    } else if (traverse == 9) {
                        triangle2_idn = nameId;
                        System.out.println(triangle2_idn);
                    } else if (traverse == 10) {
                        triangle3_idn = nameId;
                        System.out.println(triangle3_idn);
                    } else if (traverse == 11) {
                        triangle4_idn = nameId;
                        System.out.println(triangle4_idn);
                    } else if (traverse == 12) {
                        rhombusNarrow1_idn = nameId;
                        System.out.println(rhombusNarrow1_idn);
                    } else if (traverse == 13) {
                        rhombusNarrow2_idn = nameId;
                        System.out.println(rhombusNarrow2_idn);
                    } else if (traverse == 14) {
                        triangle5_idn = nameId;
                        System.out.println(triangle5_idn);
                    } else if (traverse == 15) {
                        triangle6_idn = nameId;
                        System.out.println(triangle6_idn);
                    } else if (traverse == 16) {
                        rhombusNarrow3_idn = nameId;
                        System.out.println(rhombusNarrow3_idn);
                    } else if (traverse == 17) {
                        triangle7_idn = nameId;
                        System.out.println(triangle7_idn);
                    } else if (traverse == 18) {
                        trapezium6_idn = nameId;
                        System.out.println(trapezium6_idn);
                    } else if (traverse == 19) {
                        hexagon1_idn = nameId;
                        System.out.println(hexagon1_idn);
                    } else if (traverse == 20) {
                        trapezium7_idn = nameId;
                        System.out.println(trapezium7_idn);
                    } else if (traverse == 21) {
                        trapezium8_idn = nameId;
                        System.out.println(trapezium8_idn);
                    }
                }

                addButton.setFocusable(false);
            });

            removeButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == removeButton) {
                    if (traverse == 1) {
                        triangle1_idn = 0;
                    } else if (traverse == 2) {
                        trapezium1_idn = 0;
                    } else if (traverse == 3) {
                        trapezium2_idn = 0;
                    } else if (traverse == 4) {
                        trapezium3_idn = 0;
                    } else if (traverse == 5) {
                        trapezium4_idn = 0;
                    } else if (traverse == 6) {
                        trapezium5_idn = 0;
                    } else if (traverse == 7) {
                        rhombus1_idn = 0;
                    } else if (traverse == 8) {
                        triangle8_idn = 0;
                    } else if (traverse == 9) {
                        triangle2_idn = 0;
                    } else if (traverse == 10) {
                        triangle3_idn = 0;
                    } else if (traverse == 11) {
                        triangle4_idn = 0;
                    } else if (traverse == 12) {
                        rhombusNarrow1_idn = 0;
                    } else if (traverse == 13) {
                        rhombusNarrow2_idn = 0;
                    } else if (traverse == 14) {
                        triangle5_idn = 0;
                    } else if (traverse == 15) {
                        triangle6_idn = 0;
                    } else if (traverse == 16) {
                        rhombusNarrow3_idn = 0;
                    } else if (traverse == 17) {
                        triangle7_idn = 0;
                    } else if (traverse == 18) {
                        trapezium6_idn = 0;
                    } else if (traverse == 19) {
                        hexagon1_idn = 0;
                    } else if (traverse == 20) {
                        trapezium7_idn = 0;
                    } else if (traverse == 21) {
                        trapezium8_idn = 0;
                    }
                }
                removeButton.setFocusable(false);
            });

            finishButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == finishButton) {
                    gameFinished = true;
                }
                finishButton.setFocusable(false);
            });

            helpButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == helpButton) {

                    JOptionPane.showMessageDialog(frame, "Instructions: \n" +
                                    "W - traverse through the blueprint\n" +
                                    "A - reduce the scale of the shape inserted into the blueprint\n" +
                                    "S - increase the scale of the shape inserted into the blueprint\n" +
                                    "R - positive rotation of the shape inserted into the blueprint \n" +
                                    "T - negative rotation of the shape inserted into the blueprint \n" +
                                    "Add Button - after selecting a shape from the palette, you can add it to the selected blueprint shape by the Add button\n" +
                                    "Remove Button - after selecting a shape from the palette, you can remove it from the selected blueprint shape by the Remove button\n" + "Finish Button - after the game finished, by pressing on the finish button, you can see your results\n" +
                                    "Reset Button - reset a game game\n" +
                                    "Quit Button - quit from the game \n" +
                                    "Light - you can enable/disable different light models by checking/unchecking  the light chekboxes (global ambient light, ambient, diffuse and specular)\n"
                            , "Help", JOptionPane.INFORMATION_MESSAGE);
                }

                helpButton.setFocusable(false);
            });


            quitButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == quitButton) {
                    animator.stop();
                    System.exit(0);
                }
                quitButton.setFocusable(false);
            });

            resetButton.addActionListener(e -> {

                // determine which button was click on
                if (e.getSource() == resetButton) {
                    //TODO: start a new game
                    newGame = true;
                    gameFinished = false;
                }
                resetButton.setFocusable(false);
            });

            frame.getContentPane().add(canvas);
            frame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    new Thread(() -> {
                        if (animator.isStarted()) {
                            animator.stop();
                            System.exit(0);
                        }
                    }).start();
                }
            });

            // initialize our camera
            camera = new Camera();

            // set the camera position
            camera.lookAt(-5, 0, 3, /* look from camera (XYZ)*/
                    0, 0, 0, /* look at the origin*/
                    0, 1, 0); /* positive Y up vector (roll of the camera)*/

            // initialize the amount of the shape and the size while increase it
            camera.setScale(20);

            // set the title of the frame, make it visible and start the animator
            frame.setTitle(TITLE);
            // it causes the window size to fit the preferred size and layouts of the
            // component
            frame.pack();
            frame.setVisible(true);
            animator.start();
        });

    }

    // This method contains the logic used for drawing graphical elements using OpenGL API.
    // If you want to draw something to the window that was created, we'll specify it here.
    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2(); // get opengl context

        // when we want to render something to all pixels in our window, we'll
        // clear both the color and depth buffer.
        // GL_COLOR_BUFFER_BIT: when you draw something on the screen (letter ma)
        // 						then draw something transparent, the first paint is
        // 						drawn to the back-buffer causing the memory of the
        // 						back-buffer to contain more pixels
        // GL_DEPTH_BUFFER_BIT: Decides if the geometry you rendered is closer to the
        // 						viewer than geometry you render previously.
        // 						Remove or clear any hidden geometry
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        if (inSelectionMode) {
            // allow the user pick a mode/shape from the palette
            pickModels(drawable);
        } else {
            // perform normal rendering
            palette(drawable); // add the palette
            drawBlueprint(drawable); // draws the blueprint
        }

        // adds the camera
        camera.apply(gl);

        lights(gl);

        // check if the global ambient light should be turned on or off
        float[] zeros = {0, 0, 0, 1};
        float[] globalAmbient = {0.1f, 0.1f, 0.1f, 1};
        if (ambientLight.isSelected()) {
            gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, globalAmbient, 0);
        } else {
            gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, zeros, 0);
        }

        // add a bit off specular light to make the objects drawn shine a bit
        //gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, globalAmbient, 0);

        // check if the game is finished
        if(gameFinished){
            printResult(drawable);
            if(matchedShapes==21){
                triangle1Blue = 1f;
                trapezium1Blue = 1f;
                trapezium2Blue = 1f;
                trapezium3Blue = 1f;
                trapezium4Blue = 1f;
                trapezium5Blue = 1f;
                rhombus1Blue = 1f;
                triangle8Blue = 1f;
                triangle2Blue = 1f;
                triangle3Blue = 1f;
                triangle4Blue = 1f;
                rhombusNarrow1Blue = 1f;
                rhombusNarrow2Blue = 1f;
                triangle5Blue = 1f;
                triangle6Blue = 1f;
                rhombusNarrow3Blue = 1f;
                triangle7Blue = 1f;
                trapezium6Blue = 1f;
                hexagon1Blue = 1f;
                trapezium7Blue = 1f;
                trapezium8Blue = 1f;
            }
        }

        // print the matched shape, once we've inserted it properly
        if(!gameFinished){
            printMatch(drawable);
        }

        // initialization of our variables & reset the game if the user decides to
        if (newGame) {
            newGame();
            newGame = false;
        }

    }

    private void pickModels(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // start picking objects from the screen
        startPicking(drawable);

        // enable the user pick objects from the palette and draw them to the screen
        palettePicking(drawable);

        // Add different shapes that were selected onto the blueprint
        gl.glPushName(TRIANGLE_ID);
        paletteTriangle(drawable);
        gl.glPopName();

        gl.glPushName(RHOMBUS_ID);
        paletteRhombus(drawable);
        gl.glPopName();

        gl.glPushName(SQUARE_ID);
        paletteSquare(drawable);
        gl.glPopName();

        gl.glPushName(HEXAGON_ID);
        paletteHexagon(drawable);
        gl.glPopName();

        gl.glPushName(RHOMBUS_NARROW_ID);
        paletteRhombusNarrow(drawable);
        gl.glPopName();

        gl.glPushName(TRAPEZIUM_ID);
        paletteTrapezium(drawable);
        gl.glPopName();

        gl.glPopMatrix();

        // grabs what was selected from the palette
        endPicking(drawable);
    }

    // picking objects from the palette
    public void palettePicking(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // convert camera space into screen space
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPushMatrix();
        gl.glLoadIdentity();

        int[] viewport = new int[4];
        float[] projectionMatrix = new float[16];

        gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
        viewport[0] = 0;
        viewport[1] = 0;
        viewport[2] = windowWidth / 3;
        viewport[3] = windowHeight;

        gl.glGetFloatv(GL2.GL_PROJECTION_MATRIX, projectionMatrix, 0);

        // define the picked region
        glu.gluPickMatrix((double) xCursor,
                (double) (viewport[3] - yCursor),
                1.0,
                1.0,
                viewport,
                0);

        gl.glMultMatrixf(projectionMatrix, 0);
        gl.glOrtho((float) -10 / 2,
                (float) 10 / 2,
                (-10 * aspectP) / 2,
                (10 * aspectP) / 2,
                1, 11);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(-1, 2, 5.0,
                0.0, 0.0, 0.0,
                0.0, 1.0, 0.0);
    }

    private void startPicking(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // determine which primitive are draw into some region of the window
        selectBuffer = BufferUtil.newIntBuffer(BUFFSIZE);
        gl.glSelectBuffer(BUFFSIZE, selectBuffer);
        gl.glRenderMode(GL2.GL_SELECT); // switches to selection mode
        gl.glInitNames(); // makes an empty name stack
        gl.glMatrixMode(GL2.GL_MODELVIEW); // restore model view
    }

    // grab what was picked from the palette
    private void endPicking(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // restore original projection matrix
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPopMatrix();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glFlush();

        // return to normal rendering mode and process hits
        int numHits = gl.glRenderMode(GL2.GL_RENDER);
        processHits(drawable, numHits);
        inSelectionMode = false;
    }

    // help in picking the shape, by storing the id closest to what was click on
    public void processHits(GLAutoDrawable drawable, int numHits) {

        GL2 gl = drawable.getGL().getGL2();

        if (numHits == 0) {
            return; // no hits to process
        }

        int selectedNameId = 0;
        float smallestZ = -1.0f;
        boolean isFirstLoop = true;
        int offset = 0;

        // iterate though the hit records, saving the smallest z value
        // and the name ID associated with it
        for (int i = 0; i < numHits; i++) {
            int numNames = selectBuffer.get(offset);
            offset++;

            // get the minZ and maxZ which are taken from the Z buffer
            float minZ = getDepth(offset);
            offset++;

            // store the smallest z value
            if (isFirstLoop) {
                smallestZ = minZ;
                isFirstLoop = false;
            } else {
                if (minZ < smallestZ) {
                    smallestZ = minZ;
                }
            }

            float maxZ = getDepth(offset);
            offset++;

            for (int j = 0; j < numNames; j++) {
                nameId = selectBuffer.get(offset);
                System.out.println(idToString(nameId) + "\n");

                if (j == (numNames - 1)) { // if the last one (the top elemnt on the stack)
                    if (smallestZ == minZ) { // is this the smallest min z
                        selectedNameId = nameId;
                    }
                }
                offset++;
            }
        }
    }

    // convert the id to string
    private String idToString(int nameID) {
        if (nameID == TRIANGLE_1_ID) {
            return "triangle 1";
        } else if (nameID == TRAPEZIUM_1_ID) {
            return "trapezium 1";
        } else if (nameID == TRAPEZIUM_2_ID) {
            return "trapezium 2";
        } else if (nameID == TRAPEZIUM_3_ID) {
            return "trapezium 3";
        } else if (nameID == TRAPEZIUM_4_ID) {
            return "trapezium 4";
        } else if (nameID == TRAPEZIUM_5_ID) {
            return "trapezium 5";
        } else if (nameID == RHOMBUS_1_ID) {
            return "rhombus 1";
        } else if (nameID == TRIANGLE_8_ID) {
            return "triangle 8";
        } else if (nameID == TRIANGLE_2_ID) {
            return "triangle 2";
        } else if (nameID == TRIANGLE_3_ID) {
            return "triangle 3";
        } else if (nameID == TRIANGLE_4_ID) {
            return "triangle 4";
        } else if (nameID == RHOMBUS_NARROW_1_ID) {
            return "rhombus narrow 1";
        } else if (nameID == RHOMBUS_NARROW_2_ID) {
            return "rhombus narrow 2";
        } else if (nameID == TRIANGLE_5_ID) {
            return "triangle 5";
        } else if (nameID == TRIANGLE_6_ID) {
            return "triangle 6";
        } else if (nameID == RHOMBUS_NARROW_3_ID) {
            return "rhombus narrow 3";
        } else if (nameID == TRIANGLE_7_ID) {
            return "triangle 7";
        } else if (nameID == TRAPEZIUM_6_ID) {
            return "trapezium 6";
        } else if (nameID == HEXAGON_1_ID) {
            return "hexagon 1";
        } else if (nameID == TRAPEZIUM_7_ID) {
            return "trapezium 7";
        } else if (nameID == TRAPEZIUM_8_ID) {
            return "trapezium 8";
        } else if (nameID == SQUARE_ID) {
            return "palette_square";
        } else if (nameID == TRIANGLE_ID) {
            return "palette_triangle";
        } else if (nameID == RHOMBUS_ID) {
            return "palette_rhombus";
        } else if (nameID == RHOMBUS_NARROW_ID) {
            return "palette_rhombus_narrow";
        } else if (nameID == TRAPEZIUM_ID) {
            return "palette_trapezium";
        } else if (nameID == HEXAGON_ID) {
            return "palette_hexagon";
        } else {
            return "nameID: " + nameID;
        }
    }

    private float getDepth(int offset) {
        long depth = (long) selectBuffer.get(offset);
        return (1.0f + ((float) depth / 0x7fffffff)); // a float between 0 and 1
    }

    private void lights(GL2 gl) {
        gl.glColor3d(0.5, 0.5, 0.5);

        // initialize the parameters for the color when the light is off
        float[] zeros = {0, 0, 0, 1};

        // specifying the material parameters for the lighting model
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, zeros, 0);

        if (lightOnOff.isSelected()) {
            gl.glDisable(GL2.GL_LIGHTING);
        } else {
            gl.glEnable(GL2.GL_LIGHTING);
        }

        // initializing an array to store the values for different lights
        float[] ambient = {0.1f, 0.1f, 0.1f, 1};
        float[] diffuse = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] specular = {1.0f, 1.0f, 1.0f, 1.0f};

        // check if the ambient light is selected
        if (ambientLighting.isSelected()) {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, ambient, 0);
            gl.glEnable(GL2.GL_LIGHT0);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zeros, 0);
            gl.glDisable(GL2.GL_LIGHT0);
        }

        // check if the diffused light is selected
        if (diffuseLighting.isSelected()) {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, diffuse, 0);
            gl.glEnable(GL2.GL_LIGHT1);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zeros, 0);
            gl.glDisable(GL2.GL_LIGHT1);
        }

        // check if the specular light is selected
        if (specularLighting.isSelected()) {
            float[] shininess = {5.0f};
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, specular, 0);
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, shininess, 0);
            gl.glEnable(GL2.GL_LIGHT2);
        } else {
            gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, zeros, 0);
            gl.glDisable(GL2.GL_LIGHT2);
        }
    }

    private void newGame() {
        traverse = 0;

        rotateTriangle1 = 0f;
        rotateTrapezium1 = 0f;
        rotateTrapezium2 = 0f;
        rotateTrapezium3 = 0f;
        rotateTrapezium4 = 0f;
        rotateTrapezium5 = 0f;
        rotateRhombus1 = 0f;
        rotateTriangle8 = 0f;
        rotateTriangle2 = 0f;
        rotateTriangle3 = 0f;
        rotateTriangle4 = 0f;
        rotateRhombusNarrow1 = 0f;
        rotateRhombusNarrow2 = 0f;
        rotateTriangle5 = 0f;
        rotateTriangle6 = 0f;
        rotateRhombusNarrow3 = 0f;
        rotateTriangle7 = 0f;
        rotateTrapezium6 = 0f;
        rotateHexagon1 = 0f;
        rotateTrapezium7 = 0f;
        rotateTrapezium8 = 0f;

        scaleTriangle1 = 0.8f;
        scaleTrapezium1 = 0.8f;
        scaleTrapezium2 = 0.8f;
        scaleTrapezium3 = 0.8f;
        scaleTrapezium4 = 0.8f;
        scaleTrapezium5 = 0.8f;
        scaleRhombus1 = 0.8f;
        scaleTriangle8 = 0.8f;
        scaleTriangle2 = 0.8f;
        scaleTriangle3 = 0.8f;
        scaleTriangle4 = 0.8f;
        scaleRhombusNarrow1 = 0.8f;
        scaleRhombusNarrow2 = 0.8f;
        scaleTriangle5 = 0.8f;
        scaleTriangle6 = 0.8f;
        scaleRhombusNarrow3 = 0.8f;
        scaleTriangle7 = 0.8f;
        scaleTrapezium6 = 0.8f;
        scaleHexagon1 = 0.8f;
        scaleTrapezium7 = 0.8f;
        scaleTrapezium8 = 0.8f;

        triangle1_idn = 0;
        trapezium1_idn = 0;
        trapezium2_idn = 0;
        trapezium3_idn = 0;
        trapezium4_idn = 0;
        trapezium5_idn = 0;
        rhombus1_idn = 0;
        triangle8_idn = 0;
        triangle2_idn = 0;
        triangle3_idn = 0;
        triangle4_idn = 0;
        rhombusNarrow1_idn = 0;
        rhombusNarrow2_idn = 0;
        triangle5_idn = 0;
        triangle6_idn = 0;
        rhombusNarrow3_idn = 0;
        triangle7_idn = 0;
        trapezium6_idn = 0;
        hexagon1_idn = 0;
        trapezium7_idn = 0;
        trapezium8_idn = 0;

        triangle1Red = 0;
        trapezium1Red = 0;
        trapezium2Red = 0;
        trapezium3Red = 0;
        trapezium4Red = 0;
        trapezium5Red = 0;
        rhombus1Red = 0;
        triangle8Red = 0;
        triangle2Red = 0;
        triangle3Red = 0;
        triangle4Red = 0;
        rhombusNarrow1Red = 0;
        rhombusNarrow2Red = 0;
        triangle5Red = 0;
        triangle6Red = 0;
        rhombusNarrow3Red = 0;
        triangle7Red = 0;
        trapezium6Red = 0;
        hexagon1Red = 0;
        trapezium7Red = 0;
        trapezium8Red = 0;

        triangle1Blue = 0;
        trapezium1Blue = 0;
        trapezium2Blue = 0;
        trapezium3Blue = 0;
        trapezium4Blue = 0;
        trapezium5Blue = 0;
        rhombus1Blue = 0;
        triangle8Blue = 0;
        triangle2Blue = 0;
        triangle3Blue = 0;
        triangle4Blue = 0;
        rhombusNarrow1Blue = 0;
        rhombusNarrow2Blue = 0;
        triangle5Blue = 0;
        triangle6Blue = 0;
        rhombusNarrow3Blue = 0;
        triangle7Blue = 0;
        trapezium6Blue = 0;
        hexagon1Blue = 0;
        trapezium7Blue = 0;
        trapezium8Blue = 0;

        matchedShapes = 0;
        triangle1isMatched = false;
        trapezium1isMatched = false;
        trapezium2isMatched = false;
        trapezium3isMatched = false;
        trapezium4isMatched = false;
        trapezium5isMatched = false;
        rhombus1isMatched = false;
        triangle8isMatched = false;
        triangle2isMatched = false;
        triangle3isMatched = false;
        triangle4isMatched = false;
        rhombusNarrow1isMatched = false;
        rhombusNarrow2isMatched = false;
        triangle5isMatched = false;
        triangle6isMatched = false;
        rhombusNarrow3isMatched = false;
        triangle7isMatched = false;
        trapezium6isMatched = false;
        hexagon1isMatched = false;
        trapezium7isMatched = false;
        trapezium8isMatched = false;
    }

    // set the position of the camera for the blueprint
    private void setObserver() {
        glu.gluLookAt(0, 0f, -10f,
                0, 0, 0,
                0, 1, 0);
    }

    private void drawBlueprint(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();

        // defines the characteristics of our camera such as the clipping plane, point of view
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); // set the current matrix to the identity matrix

        // set the window scene
        gl.glViewport(0, 0, windowWidth, windowHeight);

        // calculate the aspect ratio
        aspect = (float) windowHeight / ((float) windowWidth);

        // define the orthogonal view
        gl.glOrtho((float) -10 / 2,
                (float) 10 / 2,
                (-10 * aspect) / 2,
                (10 * aspect) / 2,
                0, 100);

        // define the position orientation of the camera
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        // add the texture to the background
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        drawBlueprintTriangle1(drawable);
        drawBlueprintTrapezium1(drawable);
        drawBlueprintTrapezium2(drawable);
        drawBlueprintTrapezium3(drawable);
        drawBlueprintTrapezium4(drawable);
        drawBlueprintTrapezium5(drawable);
        drawBlueprintRhombus1(drawable);
        drawBlueprintTriangle8(drawable);
        drawBlueprintTriangle2(drawable);
        drawBlueprintTriangle3(drawable);
        drawBlueprintTriangle4(drawable);
        drawBlueprintRhombusNarrow1(drawable);
        drawBlueprintRhombusNarrow2(drawable);
        drawBlueprintTriangle5(drawable);
        drawBlueprintTriangle6(drawable);
        drawBlueprintRhombusNarrow3(drawable);
        drawBlueprintTriangle7(drawable);
        drawBlueprintTrapezium6(drawable);
        drawBlueprintHexagon1(drawable);
        drawBlueprintTrapezium7(drawable);
        drawBlueprintTrapezium8(drawable);

        // get the shape that was selected by the user from the palette
        // and draw it on the blueprint
        addTriangle1Shape(drawable, triangle1_idn);
        addTrapezium1Shape(drawable, trapezium1_idn);
        addTrapezium2Shape(drawable, trapezium2_idn);
        addTrapezium3Shape(drawable, trapezium3_idn);
        addTrapezium4Shape(drawable, trapezium4_idn);
        addTrapezium5Shape(drawable, trapezium5_idn);
        addRhombus1Shape(drawable, rhombus1_idn);
        addTriangle8Shape(drawable, triangle8_idn);
        addTriangle2Shape(drawable, triangle2_idn);
        addTriangle3Shape(drawable, triangle3_idn);
        addTriangle4Shape(drawable, triangle4_idn);
        addRhombusNarrow1Shape(drawable, rhombusNarrow1_idn);
        addRhombusNarrow2Shape(drawable, rhombusNarrow2_idn);
        addTriangle5Shape(drawable, triangle5_idn);
        addTriangle6Shape(drawable, triangle6_idn);
        addRhombusNarrow3Shape(drawable, rhombusNarrow3_idn);
        addTriangle7Shape(drawable, triangle7_idn);
        addTrapezium6Shape(drawable, trapezium6_idn);
        addHexagon1Shape(drawable, hexagon1_idn);
        addTrapezium7Shape(drawable, trapezium7_idn);
        addTrapezium8Shape(drawable, trapezium8_idn);
    }

    private void addTriangle1Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslatef(triangle1X, triangle1Y, triangle1Z);
        gl.glRotatef(rotateTriangle1, 0, 0, 1);
        gl.glTranslatef(-triangle1X, -triangle1Y, -triangle1Z);
        gl.glScalef(scaleTriangle1, scaleTriangle1, scaleTriangle1);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium1Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium1X, trapezium1Y, trapezium1Z);
        gl.glRotatef(rotateTrapezium1, 0, 0, 1);
        gl.glTranslated(-trapezium1X, -trapezium1Y, -trapezium1Z);
        gl.glScalef(scaleTrapezium1, scaleTrapezium1, scaleTrapezium1);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium2Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium2X, trapezium2Y, trapezium2Z);
        gl.glRotatef(rotateTrapezium2, 0, 0, 1);
        gl.glTranslated(-trapezium2X, -trapezium2Y, -trapezium2Z);
        gl.glScalef(scaleTrapezium2, scaleTrapezium2, scaleTrapezium2);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium3Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium3X, trapezium3Y, trapezium3Z);
        gl.glRotatef(rotateTrapezium3, 0, 0, 1);
        gl.glTranslated(-trapezium3X, -trapezium3Y, -trapezium3Z);
        gl.glScalef(scaleTrapezium3, scaleTrapezium3, scaleTrapezium3);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium4Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium4X, trapezium4Y, trapezium4Z);
        gl.glRotatef(rotateTrapezium4, 0, 0, 1);
        gl.glTranslated(-trapezium4X, -trapezium4Y, -trapezium4Z);
        gl.glScalef(scaleTrapezium4, scaleTrapezium4, scaleTrapezium4);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium5Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium5X, trapezium5Y, trapezium5Z);
        gl.glRotatef(rotateTrapezium5, 0, 0, 1);
        gl.glTranslated(-trapezium5X, -trapezium5Y, -trapezium5Z);
        gl.glScalef(scaleTrapezium5, scaleTrapezium5, scaleTrapezium5);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addRhombus1Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(rhombusRed, rhombusGreen, rhombusBlue);
        gl.glTranslated(rhombus1X, rhombus1Y, rhombus1Z);
        gl.glRotatef(rotateRhombus1, 0, 0, 1);
        gl.glTranslated(-rhombus1X, -rhombus1Y, -rhombus1Z);
        gl.glScalef(scaleRhombus1, scaleRhombus1, scaleRhombus1);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle8Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle8X, triangle8Y, triangle8Z);
        gl.glRotatef(rotateTriangle8, 0, 0, 1);
        gl.glTranslated(-triangle8X, -triangle8Y, -triangle8Z);
        gl.glScalef(scaleTriangle8, scaleTriangle8, scaleTriangle8);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle2Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle2X, triangle2Y, triangle2Z);
        gl.glRotatef(rotateTriangle2, 0, 0, 1);
        gl.glTranslated(-triangle2X, -triangle2Y, -triangle2Z);
        gl.glScalef(scaleTriangle2, scaleTriangle2, scaleTriangle2);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle3Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle3X, triangle3Y, triangle3Z);
        gl.glRotatef(rotateTriangle3, 0, 0, 1);
        gl.glTranslated(-triangle3X, -triangle3Y, -triangle3Z);
        gl.glScalef(scaleTriangle3, scaleTriangle3, scaleTriangle3);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle4Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle4X, triangle4Y, triangle4Z);
        gl.glRotatef(rotateTriangle4, 0, 0, 1);
        gl.glTranslated(-triangle4X, -triangle4Y, -triangle4Z);
        gl.glScalef(scaleTriangle4, scaleTriangle4, scaleTriangle4);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addRhombusNarrow1Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(rhombusNarrowRed, rhombusNarrowGreen, rhombusNarrowBlue);
        gl.glTranslated(rhombusNarrow1X, rhombusNarrow1Y, rhombusNarrow1Z);
        gl.glRotatef(rotateRhombusNarrow1, 0, 0, 1);
        gl.glTranslated(-rhombusNarrow1X, -rhombusNarrow1Y, -rhombusNarrow1Z);
        gl.glScalef(scaleRhombusNarrow1, scaleRhombusNarrow1, scaleRhombusNarrow1);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addRhombusNarrow2Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(rhombusNarrowRed, rhombusNarrowGreen, rhombusNarrowBlue);
        gl.glTranslated(rhombusNarrow2X, rhombusNarrow2Y, rhombusNarrow2Z);
        gl.glRotatef(rotateRhombusNarrow2, 0, 0, 1);
        gl.glTranslated(-rhombusNarrow2X, -rhombusNarrow2Y, -rhombusNarrow2Z);
        gl.glScalef(scaleRhombusNarrow2, scaleRhombusNarrow2, scaleRhombusNarrow2);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle5Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle5X, triangle5Y, triangle5Z);
        gl.glRotatef(rotateTriangle5, 0, 0, 1);
        gl.glTranslated(-triangle5X, -triangle5Y, -triangle5Z);
        gl.glScalef(scaleTriangle5, scaleTriangle5, scaleTriangle5);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle6Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle6X, triangle6Y, triangle6Z);
        gl.glRotatef(rotateTriangle6, 0, 0, 1);
        gl.glTranslated(-triangle6X, -triangle6Y, -triangle6Z);
        gl.glScalef(scaleTriangle6, scaleTriangle6, scaleTriangle6);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addRhombusNarrow3Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(rhombusNarrowRed, rhombusNarrowGreen, rhombusNarrowBlue);
        gl.glTranslated(rhombusNarrow3X, rhombusNarrow3Y, rhombusNarrow3Z);
        gl.glRotatef(rotateRhombusNarrow3, 0, 0, 1);
        gl.glTranslated(-rhombusNarrow3X, -rhombusNarrow3Y, -rhombusNarrow3Z);
        gl.glScalef(scaleRhombusNarrow3, scaleRhombusNarrow3, scaleRhombusNarrow3);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTriangle7Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue);
        gl.glTranslated(triangle7X, triangle7Y, triangle7Z);
        gl.glRotatef(rotateTriangle7, 0, 0, 1);
        gl.glTranslated(-triangle7X, -triangle7Y, -triangle7Z);
        gl.glScalef(scaleTriangle7, scaleTriangle7, scaleTriangle7);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium6Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium6X, trapezium6Y, trapezium6Z);
        gl.glRotatef(rotateTrapezium6, 0, 0, 1);
        gl.glTranslated(-trapezium6X, -trapezium6Y, -trapezium6Z);
        gl.glScalef(scaleTrapezium6, scaleTrapezium6, scaleTrapezium6);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addHexagon1Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(hexagonRed, hexagonGreen, hexagonBlue);
        gl.glTranslated(hexagon1X, hexagon1Y, hexagon1Z);
        gl.glRotatef(rotateHexagon1, 0, 0, 1);
        gl.glTranslated(-hexagon1X, -hexagon1Y, -hexagon1Z);
        gl.glScalef(scaleHexagon1, scaleHexagon1, scaleHexagon1);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium7Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium7X, trapezium7Y, trapezium7Z);
        gl.glRotatef(rotateTrapezium7, 0, 0, 1);
        gl.glTranslated(-trapezium7X, -trapezium7Y, -trapezium7Z);
        gl.glScalef(scaleTrapezium7, scaleTrapezium7, scaleTrapezium7);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    private void addTrapezium8Shape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue);
        gl.glTranslated(trapezium8X, trapezium8Y, trapezium8Z);
        gl.glRotatef(rotateTrapezium8, 0, 0, 1);
        gl.glTranslated(-trapezium8X, -trapezium8Y, -trapezium8Z);
        gl.glScalef(scaleTrapezium8, scaleTrapezium8, scaleTrapezium8);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        addShape(drawable, nameID);

        gl.glPopMatrix();
    }

    // adds the shape into the blueprint (the one that was click on)
    public void addShape(GLAutoDrawable drawable, int nameID) {
        GL2 gl = drawable.getGL().getGL2();

        switch (nameID) {
            case TRIANGLE_ID:
                Shapes.triangle(gl);
                break;

            case TRAPEZIUM_ID:
                Shapes.trapezium(gl);
                break;

            case RHOMBUS_ID:
                Shapes.rhombus(gl);
                break;

            case RHOMBUS_NARROW_ID:
                Shapes.rhombusNarrow(gl);
                break;

            case HEXAGON_ID:
                Shapes.hexagon(gl);
                break;

            case SQUARE_ID:
                Shapes.square(gl);
                break;

        }
    }

    private void drawBlueprintTriangle1(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle1Red, triangle1Green, triangle1Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle1X, triangle1Y, triangle1Z);
        gl.glRotatef(rotateBlueprintTriangle1, 0, 0, 1);
        gl.glTranslatef(-triangle1X, -triangle1Y, -triangle1Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium1(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium1Red, trapezium1Green, trapezium1Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium1X, trapezium1Y, trapezium1Z);
        gl.glRotatef(rotateBlueprintTrapezium1, 0, 0, 1);
        gl.glTranslatef(-trapezium1X, -trapezium1Y, -trapezium1Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium2(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium2Red, trapezium2Green, trapezium2Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium2X, trapezium2Y, trapezium2Z);
        gl.glRotatef(rotateBlueprintTrapezium2, 0, 0, 1);
        gl.glTranslatef(-trapezium2X, -trapezium2Y, -trapezium2Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium3(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium3Red, trapezium3Green, trapezium3Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium3X, trapezium3Y, trapezium3Z);
        gl.glRotatef(rotateBlueprintTrapezium3, 0, 0, 1);
        gl.glTranslatef(-trapezium3X, -trapezium3Y, -trapezium3Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium4(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium4Red, trapezium4Green, trapezium4Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium4X, trapezium4Y, trapezium4Z);
        gl.glRotatef(rotateBlueprintTrapezium4, 0, 0, 1);
        gl.glTranslatef(-trapezium4X, -trapezium4Y, -trapezium4Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium5(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium5Red, trapezium5Green, trapezium5Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium5X, trapezium5Y, trapezium5Z);
        gl.glRotatef(rotateBlueprintTrapezium5, 0, 0, 1);
        gl.glTranslatef(-trapezium5X, -trapezium5Y, -trapezium5Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintRhombus1(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(rhombus1Red, rhombus1Green, rhombus1Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(rhombus1X, rhombus1Y, rhombus1Z);
        gl.glRotatef(rotateBlueprintRhombus1, 0, 0, 1);
        gl.glTranslatef(-rhombus1X, -rhombus1Y, -rhombus1Z);
        Shapes.rhombus(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle8(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle8Red, triangle8Green, triangle8Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle8X, triangle8Y, triangle8Z);
        gl.glRotatef(rotateBlueprintTriangle8, 0, 0, 1);
        gl.glTranslatef(-triangle8X, -triangle8Y, -triangle8Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }


    private void drawBlueprintTriangle2(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle2Red, triangle2Green, triangle2Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle2X, triangle2Y, triangle2Z);
        gl.glRotatef(rotateBlueprintTriangle2, 0, 0, 1);
        gl.glTranslatef(-triangle2X, -triangle2Y, -triangle2Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle3(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle3Red, triangle3Green, triangle3Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle3X, triangle3Y, triangle3Z);
        gl.glRotatef(rotateBlueprintTriangle3, 0, 0, 1);
        gl.glTranslatef(-triangle3X, -triangle3Y, -triangle3Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle4(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle4Red, triangle4Green, triangle4Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle4X, triangle4Y, triangle4Z);
        gl.glRotatef(rotateBlueprintTriangle4, 0, 0, 1);
        gl.glTranslatef(-triangle4X, -triangle4Y, -triangle4Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintRhombusNarrow1(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(rhombusNarrow1Red, rhombusNarrow1Green, rhombusNarrow1Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(rhombusNarrow1X, rhombusNarrow1Y, rhombusNarrow1Z);
        gl.glRotatef(rotateBlueprintRhombusNarrow1, 0, 0, 1);
        gl.glTranslatef(-rhombusNarrow1X, -rhombusNarrow1Y, -rhombusNarrow1Z);
        Shapes.rhombusNarrow(gl, 0.6, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintRhombusNarrow2(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(rhombusNarrow2Red, rhombusNarrow2Green, rhombusNarrow2Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(rhombusNarrow2X, rhombusNarrow2Y, rhombusNarrow2Z);
        gl.glRotatef(rotateBlueprintRhombusNarrow2, 0, 0, 1);
        gl.glTranslatef(-rhombusNarrow2X, -rhombusNarrow2Y, -rhombusNarrow2Z);
        Shapes.rhombusNarrow(gl, 0.6, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle5(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle5Red, triangle5Green, triangle5Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle5X, triangle5Y, triangle5Z);
        gl.glRotatef(rotateBlueprintTriangle5, 0, 0, 1);
        gl.glTranslatef(-triangle5X, -triangle5Y, -triangle5Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle6(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle6Red, triangle6Green, triangle6Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle6X, triangle6Y, triangle6Z);
        gl.glRotatef(rotateBlueprintTriangle6, 0, 0, 1);
        gl.glTranslatef(-triangle6X, -triangle6Y, -triangle6Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintRhombusNarrow3(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(rhombusNarrow3Red, rhombusNarrow3Green, rhombusNarrow3Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(rhombusNarrow3X, rhombusNarrow3Y, rhombusNarrow3Z);
        gl.glRotatef(rotateBlueprintRhombusNarrow3, 0, 0, 1);
        gl.glTranslatef(-rhombusNarrow3X, -rhombusNarrow3Y, -rhombusNarrow3Z);
        Shapes.rhombusNarrow(gl, 0.6, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTriangle7(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(triangle7Red, triangle7Green, triangle7Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(triangle7X, triangle7Y, triangle7Z);
        gl.glRotatef(rotateBlueprintTriangle7, 0, 0, 1);
        gl.glTranslatef(-triangle7X, -triangle7Y, -triangle7Z);
        Shapes.triangle(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium6(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium6Red, trapezium6Green, trapezium6Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium6X, trapezium6Y, trapezium6Z);
        gl.glRotatef(rotateBlueprintTrapezium6, 0, 0, 1);
        gl.glTranslatef(-trapezium6X, -trapezium6Y, -trapezium6Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintHexagon1(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(hexagon1Red, hexagon1Green, hexagon1Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(hexagon1X, hexagon1Y, hexagon1Z);
        gl.glRotatef(rotateBlueprintHexagon1, 0, 0, 1);
        gl.glTranslatef(-hexagon1X, -hexagon1Y, -hexagon1Z);
        Shapes.hexagon(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium7(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium7Red, trapezium7Green, trapezium7Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium7X, trapezium7Y, trapezium7Z);
        gl.glRotatef(rotateBlueprintTrapezium7, 0, 0, 1);
        gl.glTranslatef(-trapezium7X, -trapezium7Y, -trapezium7Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void drawBlueprintTrapezium8(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glColor3f(trapezium8Red, trapezium8Green, trapezium8Blue);
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
        gl.glLineWidth(2);
        gl.glTranslatef(trapezium8X, trapezium8Y, trapezium8Z);
        gl.glRotatef(rotateBlueprintTrapezium8, 0, 0, 1);
        gl.glTranslatef(-trapezium8X, -trapezium8Y, -trapezium8Z);
        Shapes.trapezium(gl, 0.5, false);
        gl.glPopMatrix();
    }

    private void palette(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Apply a subsequent matrix operation to the ModelView matrix stack

        gl.glMatrixMode(GL2.GL_MODELVIEW); // converts local coordinates into world space
        gl.glLoadIdentity(); // reset the value

        gl.glMatrixMode(GL2.GL_PROJECTION); // add perspective to the current operation
        gl.glLoadIdentity();

        // create a window target and draw on it; meaning that you can't just draw anywhere
        // (0,0) -> lower left of the viewport rectangle in pixel
        // (w,h) -> upper right of the viewport rectangle in pixel
        gl.glViewport(0, 0, windowWidth / 3, windowHeight);

        // calculate the aspect ratio for the palette
        aspectP = (float) windowHeight / ((float) windowWidth / 3);

        // used in 2d-games, objects close or far appear the same
        gl.glOrtho((float) -10 / 2, // left vertical clipping plane
                (float) 10 / 2, // right vertical clipping plane
                (-10 * aspectP) / 2, // bottom horizontal clipping plane
                (10 * aspectP) / 2, // top horizontal clipping plane
                1, // near depth clipping plane
                11); // farther clipping plane

        // used for modeling transformation - equivalent to positioning and
        // orienting the model to be drawn
        gl.glMatrixMode(GL2.GL_MODELVIEW);

        // draw the palette background
        paletteBackground(drawable);
        gl.glLoadIdentity();

        // setting the position for the camera (palette)
        glu.gluLookAt(0, 0, 5.0,  // look from camera XYZ
                0.0, 0.0, 0.0,  // look at origin
                0.0, 1.0, 0.0); // positive Y up vector

        //
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        // draw the shapes
        paletteSquare(drawable);
        paletteTriangle(drawable);
        paletteHexagon(drawable);
        paletteRhombus(drawable);
        paletteRhombusNarrow(drawable);
        paletteTrapezium(drawable);
    }

    private void paletteTrapezium(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(trapeziumRed, trapeziumGreen, trapeziumBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-1.3f, -4, 0);
        Shapes.trapezium(gl, 1, false); // add the narrow rhombus
        gl.glPopMatrix();
    }

    private void paletteRhombusNarrow(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(rhombusNarrowRed, rhombusNarrowGreen, rhombusNarrowBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-1.3f, -2, 0);
        Shapes.rhombusNarrow(gl, 1, false); // add the narrow rhombus
        gl.glPopMatrix();
    }

    private void paletteRhombus(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(rhombusRed, rhombusGreen, rhombusBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-1.3f, 1.5, 0);
        Shapes.rhombus(gl, 1, false); // add the rhombus
        gl.glPopMatrix();
    }

    private void paletteHexagon(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(hexagonRed, hexagonGreen, hexagonBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-1.3f, 0, 0);
        Shapes.hexagon(gl, 0.8, false); // add the hexagon
        gl.glPopMatrix();
    }

    private void paletteTriangle(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(triangleRed, triangleGreen, triangleBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-3.5f, 1.5, 0);
        Shapes.triangle(gl, 1, false); // add the triangle
        gl.glPopMatrix();
    }

    // draw the cube on the palette
    private void paletteSquare(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f(squareRed, squareGreen, squareBlue); // add the color

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glPushMatrix();
        gl.glTranslated(-3.5f, 0, 0);
        Shapes.square(gl, 1, false); // add the square
        gl.glPopMatrix();
    }


    private void paletteBackground(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2(); // get the opengl graphic context
        gl.glPushMatrix(); // push the current matrix down the stack

        gl.glTranslated(-1.5f, -1f, -10f); // (x,y,z)
        gl.glScalef(3.5f, 5, 0);
        gl.glColor3f(0.28f, 0.82f, 0.8f);

        // draw the square 2x
        Shapes.square(gl, 2, true);

        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glEnd(); // flag that we are done applying the texture

        gl.glPopMatrix(); // removes the current matrix from the stack
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

    }

    // Called immediately after the OpenGL context is initialized.
    // It can be used to perform one-time initialization.
    @Override
    public void init(GLAutoDrawable drawable) {

        // get the opengl graphics context
        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.95f, 0.95f, 1f, 0);

        // enable the depth buffer to represent depth information
        // of objects in 3d space
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_LIGHTING); // enable light calculation
        gl.glEnable(GL2.GL_LIGHT0); // initialize the values for the light (1, 1, 1, 1) -> RGBA
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glEnable(GL2.GL_COLOR_MATERIAL); // to track the current color material

        gl.glLightModeli(GL2.GL_LIGHT_MODEL_TWO_SIDE, 1); // turn one two-sided lighting
        gl.glMateriali(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 100); // turn on lighting with shinyness

        // set the values of individual light sources parameters
        float[] ambient = {0.1f, 0.1f, 0.1f, 1};
        float[] diffuse = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] specular = {1.0f, 1.0f, 1.0f, 1.0f};

        // get the lights from different light sources
        // parameters:
        // 	first -> the light source: which light to be configured
        //  second-> the properties to be set (ambient, specular, and diffused)
        //  third -> the number of values for the properties (RGBA -> 0.0f - 1.0f)
        //  fourth -> intensity
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT2, GL2.GL_SPECULAR, specular, 0);

        // other initializations
        gl.glClearDepth(1.0f); // set clear depth value to farthest
        gl.glEnable(GL2.GL_DEPTH_TEST); // enable depth testing
        gl.glDepthFunc(GL2.GL_LEQUAL); // set the type of depth test to do
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // set the best perspective correction
        gl.glShadeModel(GL2.GL_SMOOTH); // blend colors nicely and smoothes out lighting

        // specify the polygon to be applied both for the front and back facing polygon
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        glu = GLU.createGLU(gl); // get GL utilities

        // initialize the font to use for rendering our text
        textRenderer = new TextRenderer(new Font("SansSerif", Font.PLAIN, 12));
        textMatch = new TextRenderer(new Font("SansSerif", Font.BOLD, 20));
    }

    // It’s called by the object of the GLAutoDrawable interface during the first repaint
    // after the component has been resized. It’s called whenever the position
    // of the component on the window is changed.
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        windowWidth = width;
        windowHeight = height;
    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {

            // on the left click of the mouse, grab the coordinates and set
            // inSelectionMode to true
            case MouseEvent.BUTTON1: {
                xCursor = e.getX();
                yCursor = e.getY();
                inSelectionMode = true;
                break;
            }
			/*
			 * right-click on the mouse
			case MouseEvent.BUTTON3: {

			}*/

        }
    }

    // change the color of the shape in focus while traversing through all the shapes on the blueprint
    public void colorShape(int traverse) {
        switch (traverse) {
            case TRIANGLE_1_ID:
                triangle1Red = 1f;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_1_ID:
                triangle1Red = 0;
                trapezium1Red = 1f;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_2_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 1f;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_3_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 1f;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_4_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 1f;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_5_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 1f;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case RHOMBUS_1_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 1f;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_8_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 1f;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_2_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 1f;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_3_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 1f;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_4_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 1f;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case RHOMBUS_NARROW_1_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 1f;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case RHOMBUS_NARROW_2_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 1f;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_5_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 1f;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_6_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 1f;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case RHOMBUS_NARROW_3_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 1f;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRIANGLE_7_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 1f;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_6_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 1f;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case HEXAGON_1_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 1f;
                trapezium7Red = 0;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_7_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 1f;
                trapezium8Red = 0;
                break;
            case TRAPEZIUM_8_ID:
                triangle1Red = 0;
                trapezium1Red = 0;
                trapezium2Red = 0;
                trapezium3Red = 0;
                trapezium4Red = 0;
                trapezium5Red = 0;
                rhombus1Red = 0;
                triangle8Red = 0;
                triangle2Red = 0;
                triangle3Red = 0;
                triangle4Red = 0;
                rhombusNarrow1Red = 0;
                rhombusNarrow2Red = 0;
                triangle5Red = 0;
                triangle6Red = 0;
                rhombusNarrow3Red = 0;
                triangle7Red = 0;
                trapezium6Red = 0;
                hexagon1Red = 0;
                trapezium7Red = 0;
                trapezium8Red = 1f;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            // traverse through the blueprint
            case KeyEvent.VK_W:
                traverse++;
                colorShape(traverse);

                if (traverse == TOTAL_NUM_OF_SHAPES) {
                    traverse = 0;
                }
                break;


            // A - reduce the scale of the shape inserted into the blueprint
            case KeyEvent.VK_A:

                if(traverse == 1) {
                    if(scaleTriangle1 >= 0.1) { // prevent the shape from getting too small
                        scaleTriangle1 -= scaleDelta;
                    }
                }else if (traverse == 2) {
                    if(scaleTrapezium1 >= 0.1) { // prevent the shape from getting too small
                        scaleTrapezium1 -= scaleDelta;
                    }
                }else if (traverse == 3) {
                    if(scaleTrapezium2 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium2 -= scaleDelta;
                    }
                }else if (traverse == 4) {
                    if(scaleTrapezium3 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium3 -= scaleDelta;
                    }
                }else if (traverse == 5) {
                    if(scaleTrapezium4 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium4 -= scaleDelta;
                    }
                }else if (traverse == 6) {
                    if(scaleTrapezium5 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium5 -= scaleDelta;
                    }
                }else if (traverse == 7) {
                    if(scaleRhombus1 >= 0.1) {  // prevent the shape from getting too small
                        scaleRhombus1 -= scaleDelta;
                    }
                }else if (traverse == 8) {
                    if(scaleTriangle8 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle8 -= scaleDelta;
                    }
                }else if (traverse == 9) {
                    if(scaleTriangle2 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle2 -= scaleDelta;
                    }
                }else if (traverse == 10) {
                    if(scaleTriangle3 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle3 -= scaleDelta;
                    }
                }else if (traverse == 11) {
                    if(scaleTriangle4 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle4 -= scaleDelta;
                    }
                }else if (traverse == 12) {
                    if(scaleRhombusNarrow1 >= 0.1) {  // prevent the shape from getting too small
                        scaleRhombusNarrow1 -= scaleDelta;
                    }
                }else if (traverse == 13) {
                    if(scaleRhombusNarrow2 >= 0.1) {  // prevent the shape from getting too small
                        scaleRhombusNarrow2 -= scaleDelta;
                    }
                }else if (traverse == 14) {
                    if(scaleTriangle5 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle5 -= scaleDelta;
                    }
                }else if (traverse == 15) {
                    if(scaleTriangle6 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle6 -= scaleDelta;
                    }
                }else if (traverse == 16) {
                    if(scaleRhombusNarrow3 >= 0.1) {  // prevent the shape from getting too small
                        scaleRhombusNarrow3 -= scaleDelta;
                    }
                }else if (traverse == 17) {
                    if(scaleTriangle7 >= 0.1) {  // prevent the shape from getting too small
                        scaleTriangle7 -= scaleDelta;
                    }
                }else if (traverse == 18) {
                    if(scaleTrapezium6 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium6 -= scaleDelta;
                    }
                }else if (traverse == 19) {
                    if(scaleHexagon1 >= 0.1) {  // prevent the shape from getting too small
                        scaleHexagon1 -= scaleDelta;
                    }
                }else if (traverse == 20) {
                    if(scaleTrapezium7 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium7 -= scaleDelta;
                    }
                }else if (traverse == 21) {
                    if(scaleTrapezium8 >= 0.1) {  // prevent the shape from getting too small
                        scaleTrapezium8 -= scaleDelta;
                    }
                }

                break;

            // S - increase the scale of the shape inserted into the blueprint
            case KeyEvent.VK_S:

                if(traverse == 1) {
                    if(scaleTriangle1 <= 1.5) { // prevent the shape from getting too big
                        scaleTriangle1 += scaleDelta;
                    }
                }else if (traverse == 2) {
                    if(scaleTrapezium1 <= 1.5) { // prevent the shape from getting too big
                        scaleTrapezium1 += scaleDelta;
                    }
                }else if (traverse == 3) {
                    if(scaleTrapezium2 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium2 += scaleDelta;
                    }
                }else if (traverse == 4) {
                    if(scaleTrapezium3 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium3 += scaleDelta;
                    }
                }else if (traverse == 5) {
                    if(scaleTrapezium4 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium4 += scaleDelta;
                    }
                }else if (traverse == 6) {
                    if(scaleTrapezium5 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium5 += scaleDelta;
                    }
                }else if (traverse == 7) {
                    if(scaleRhombus1 <= 1.5) {  // prevent the shape from getting too big
                        scaleRhombus1 += scaleDelta;
                    }
                }else if (traverse == 8) {
                    if(scaleTriangle8 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle8 += scaleDelta;
                    }
                }else if (traverse == 9) {
                    if(scaleTriangle2 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle2 += scaleDelta;
                    }
                }else if (traverse == 10) {
                    if(scaleTriangle3 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle3 += scaleDelta;
                    }
                }else if (traverse == 11) {
                    if(scaleTriangle4 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle4 += scaleDelta;
                    }
                }else if (traverse == 12) {
                    if(scaleRhombusNarrow1 <= 1.5) {  // prevent the shape from getting too big
                        scaleRhombusNarrow1 += scaleDelta;
                    }
                }else if (traverse == 13) {
                    if(scaleRhombusNarrow2 <= 1.5) {  // prevent the shape from getting too big
                        scaleRhombusNarrow2 += scaleDelta;
                    }
                }else if (traverse == 14) {
                    if(scaleTriangle5 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle5 += scaleDelta;
                    }
                }else if (traverse == 15) {
                    if(scaleTriangle6 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle6 += scaleDelta;
                    }
                }else if (traverse == 16) {
                    if(scaleRhombusNarrow3 <= 1.5) {  // prevent the shape from getting too big
                        scaleRhombusNarrow3 += scaleDelta;
                    }
                }else if (traverse == 17) {
                    if(scaleTriangle7 <= 1.5) {  // prevent the shape from getting too big
                        scaleTriangle7 += scaleDelta;
                    }
                }else if (traverse == 18) {
                    if(scaleTrapezium6 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium6 += scaleDelta;
                    }
                }else if (traverse == 19) {
                    if(scaleHexagon1 <= 1.5) {  // prevent the shape from getting too big
                        scaleHexagon1 += scaleDelta;
                    }
                }else if (traverse == 20) {
                    if(scaleTrapezium7 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium7 += scaleDelta;
                    }
                }else if (traverse == 21) {
                    if(scaleTrapezium8 <= 1.5) {  // prevent the shape from getting too big
                        scaleTrapezium8 += scaleDelta;
                    }
                }

                break;

            // R - rotate the shape inserted into the blueprint
            case KeyEvent.VK_R:

                if(traverse == 1) {
                    rotateTriangle1 += rotateDelta;
                }else if (traverse == 2) {
                    rotateTrapezium1 += rotateDelta;
                }else if (traverse == 3) {
                    rotateTrapezium2 += rotateDelta;
                }else if (traverse == 4) {
                    rotateTrapezium3 += rotateDelta;
                }else if (traverse == 5) {
                    rotateTrapezium4 += rotateDelta;
                }else if (traverse == 6) {
                    rotateTrapezium5 += rotateDelta;
                }else if (traverse == 7) {
                    rotateRhombus1 += rotateDelta;
                }else if (traverse == 8) {
                    rotateTriangle8 += rotateDelta;
                }else if (traverse == 9) {
                    rotateTriangle2 += rotateDelta;
                }else if (traverse == 10) {
                    rotateTriangle3 += rotateDelta;
                }else if (traverse == 11) {
                    rotateTriangle4 += rotateDelta;
                }else if (traverse == 12) {
                    rotateRhombusNarrow1 += rotateDelta;
                }else if (traverse == 13) {
                    rotateRhombusNarrow2 += rotateDelta;
                }else if (traverse == 14) {
                    rotateTriangle5 += rotateDelta;
                }else if (traverse == 15) {
                    rotateTriangle6 += rotateDelta;
                }else if (traverse == 16) {
                    rotateRhombusNarrow3 += rotateDelta;
                }else if (traverse == 17) {
                    rotateTriangle7 += rotateDelta;
                }else if (traverse == 18) {
                    rotateTrapezium6 += rotateDelta;
                }else if (traverse == 19) {
                    rotateHexagon1 += rotateDelta;
                }else if (traverse == 20) {
                    rotateTrapezium7 += rotateDelta;
                }else if (traverse == 21) {
                    rotateTrapezium8 += rotateDelta;
                }

                break;

            // T - rotate in negative direction the shape inserted into the blueprint
            case KeyEvent.VK_T:

                if(traverse == 1) {
                    rotateTriangle1 -= rotateDelta;
                }else if (traverse == 2) {
                    rotateTrapezium1 -= rotateDelta;
                }else if (traverse == 3) {
                    rotateTrapezium2 -= rotateDelta;
                }else if (traverse == 4) {
                    rotateTrapezium3 -= rotateDelta;
                }else if (traverse == 5) {
                    rotateTrapezium4 -= rotateDelta;
                }else if (traverse == 6) {
                    rotateTrapezium5 -= rotateDelta;
                }else if (traverse == 7) {
                    rotateRhombus1 -= rotateDelta;
                }else if (traverse == 8) {
                    rotateTriangle8 -= rotateDelta;
                }else if (traverse == 9) {
                    rotateTriangle2 -= rotateDelta;
                }else if (traverse == 10) {
                    rotateTriangle3 -= rotateDelta;
                }else if (traverse == 11) {
                    rotateTriangle4 -= rotateDelta;
                }else if (traverse == 12) {
                    rotateRhombusNarrow1 -= rotateDelta;
                }else if (traverse == 13) {
                    rotateRhombusNarrow2 -= rotateDelta;
                }else if (traverse == 14) {
                    rotateTriangle5 -= rotateDelta;
                }else if (traverse == 15) {
                    rotateTriangle6 -= rotateDelta;
                }else if (traverse == 16) {
                    rotateRhombusNarrow3 -= rotateDelta;
                }else if (traverse == 17) {
                    rotateTriangle7 -= rotateDelta;
                }else if (traverse == 18) {
                    rotateTrapezium6 -= rotateDelta;
                }else if (traverse == 19) {
                    rotateHexagon1 -= rotateDelta;
                }else if (traverse == 20) {
                    rotateTrapezium7 -= rotateDelta;
                }else if (traverse == 21) {
                    rotateTrapezium8 -= rotateDelta;
                }

                break;

            // once the user clicks on the escape key, we can stop the animator and close the game window
            case KeyEvent.VK_ESCAPE:
                System.out.println("Animator stopped!\nWindow closed.");
                animator.stop();
                System.exit(0);
                break;
        }

    }

    // display text on the window
    public void writeText(String text, int x, int y) {
        textMatch.beginRendering(windowWidth, windowHeight);
        textMatch.setColor(0.3f, 0.3f, 0.5f, 1);
        textMatch.draw(text, x, y);
        textMatch.endRendering();
    }

    // display the matched shape once it's done
    public void printMatch(GLAutoDrawable drawable) {
        String correctMatchText = "Well Done! Correct shape, rotation and scaling";
        int xTextLocation = (int)(windowWidth/4f);
        int yTextLocation = windowHeight-500;

        // check if the shape is matched while we traverse through the blueprint (full of different shapes)
        if(traverse == 1) {
            // check if the shape is valid or no
            if(triangle1_idn>27){
                if(shape[1].equals(shape[triangle1_idn-27])) {

                    // check if the scaling is appropriate
                    boolean isTriangle1ScaleValid = scaleCheck(scaleTriangle1).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle1RotationValid = rotationCheck(1, rotateTriangle1).equals("correct");
                    System.out.println("isTriangle1ScaleValid: " + isTriangle1ScaleValid);
                    System.out.println("isTriangle1RotationValid: " + isTriangle1RotationValid);
                    if(isTriangle1ScaleValid && isTriangle1RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle1isMatched){
                            matchedShapes++;
                            triangle1isMatched = true;
                        }
                    }
                }
            }

        }

        if(traverse == 2) {
            // check if the shape is valid or no
            if(trapezium1_idn>32){
                if(shape[2].equals(shape[trapezium1_idn-31])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium1ScaleValid = scaleCheck(scaleTrapezium1).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium1RotationValid = rotationCheck(2, rotateTrapezium1).equals("correct");
                    System.out.println("isTrapezium1ScaleValid: " + isTrapezium1ScaleValid);
                    System.out.println("isTrapezium1RotationValid: " + isTrapezium1RotationValid);
                    if(isTrapezium1ScaleValid && isTrapezium1RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium1isMatched){
                            matchedShapes++;
                            trapezium1isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 3) {
            // check if the shape is valid or no
            if(trapezium2_idn>32){
                if(shape[3].equals(shape[trapezium2_idn-30])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium2ScaleValid = scaleCheck(scaleTrapezium2).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium2RotationValid = rotationCheck(3, rotateTrapezium2).equals("correct");
                    System.out.println("isTrapezium2ScaleValid: " + isTrapezium2ScaleValid);
                    System.out.println("isTrapezium2RotationValid: " + isTrapezium2RotationValid);
                    if(isTrapezium2ScaleValid && isTrapezium2RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium2isMatched){
                            matchedShapes++;
                            trapezium2isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 4) {
            // check if the shape is valid or no
            if(trapezium3_idn>32){
                if(shape[4].equals(shape[trapezium3_idn-29])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium3ScaleValid = scaleCheck(scaleTrapezium3).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium3RotationValid = rotationCheck(4, rotateTrapezium3).equals("correct");
                    System.out.println("isTrapezium3ScaleValid: " + isTrapezium3ScaleValid);
                    System.out.println("isTrapezium3RotationValid: " + isTrapezium3RotationValid);
                    if(isTrapezium3ScaleValid && isTrapezium3RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium3isMatched){
                            matchedShapes++;
                            trapezium3isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 5) {
            // check if the shape is valid or no
            if(trapezium4_idn>32){
                if(shape[5].equals(shape[trapezium4_idn-28])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium4ScaleValid = scaleCheck(scaleTrapezium4).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium4RotationValid = rotationCheck(5, rotateTrapezium4).equals("correct");
                    System.out.println("isTrapezium4ScaleValid: " + isTrapezium4ScaleValid);
                    System.out.println("isTrapezium4RotationValid: " + isTrapezium4RotationValid);
                    if(isTrapezium4ScaleValid && isTrapezium4RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium4isMatched){
                            matchedShapes++;
                            trapezium4isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 6) {
            // check if the shape is valid or not
            if(trapezium5_idn>32){
                if(shape[6].equals(shape[trapezium5_idn-27])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium5ScaleValid = scaleCheck(scaleTrapezium5).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium5RotationValid = rotationCheck(6, rotateTrapezium5).equals("correct");
                    System.out.println("isTrapezium5ScaleValid: " + isTrapezium5ScaleValid);
                    System.out.println("isTrapezium5RotationValid: " + isTrapezium5RotationValid);
                    if(isTrapezium5ScaleValid && isTrapezium5RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium5isMatched){
                            matchedShapes++;
                            trapezium5isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 7) {
            // check if the shape is valid or not
            if(rhombus1_idn>28){
                if(shape[7].equals(shape[rhombus1_idn-22])) {

                    // check if the scaling is appropriate
                    boolean isRhombus1ScaleValid = scaleCheck(scaleRhombus1).equals("appropriate");

                    // check if the rotation matches
                    boolean isRhombus1RotationValid = rotationCheck(7, rotateRhombus1).equals("correct");
                    System.out.println("isRhombus1ScaleValid: " + isRhombus1ScaleValid);
                    System.out.println("isRhombus1RotationValid: " + isRhombus1RotationValid);
                    if(isRhombus1ScaleValid && isRhombus1RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!rhombus1isMatched){
                            matchedShapes++;
                            rhombus1isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 8) {
            // check if the shape is valid or not
            if(triangle8_idn>27){
                System.out.println("shape[8] " + shape[8]);
                System.out.println("shape[triangle8_idn-20] "+shape[triangle8_idn-20]);
                if(shape[8].equals(shape[triangle8_idn-20])) {

                    // check if the scaling is appropriate
                    boolean isTriangle8ScaleValid = scaleCheck(scaleTriangle8).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle8RotationValid = rotationCheck(8, rotateTriangle8).equals("correct");
                    System.out.println("isTriangle8ScaleValid: " + isTriangle8ScaleValid);
                    System.out.println("isRhombus1RotationValid: " + isTriangle8RotationValid);
                    if(isTriangle8ScaleValid && isTriangle8RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle8isMatched){
                            matchedShapes++;
                            triangle8isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 9) {
            // check if the shape is valid or not
            if(triangle2_idn>27){
                if(shape[9].equals(shape[triangle2_idn-19])) {

                    // check if the scaling is appropriate
                    boolean isTriangle2ScaleValid = scaleCheck(scaleTriangle2).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle2RotationValid = rotationCheck(9, rotateTriangle2).equals("correct");
                    System.out.println("isTriangle2ScaleValid: " + isTriangle2ScaleValid);
                    System.out.println("isTriangle2RotationValid: " + isTriangle2RotationValid);
                    if(isTriangle2ScaleValid && isTriangle2RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle2isMatched){
                            matchedShapes++;
                            triangle2isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 10) {
            // check if the shape is valid or not
            if(triangle3_idn>27){
                if(shape[10].equals(shape[triangle3_idn-18])) {

                    // check if the scaling is appropriate
                    boolean isTriangle3ScaleValid = scaleCheck(scaleTriangle3).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle3RotationValid = rotationCheck(10, rotateTriangle3).equals("correct");
                    System.out.println("isTriangle3ScaleValid: " + isTriangle3ScaleValid);
                    System.out.println("isTriangle3RotationValid: " + isTriangle3RotationValid);
                    if(isTriangle3ScaleValid && isTriangle3RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle3isMatched){
                            matchedShapes++;
                            triangle3isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 11) {
            // check if the shape is valid or not
            if(triangle4_idn>27){
                if(shape[11].equals(shape[triangle4_idn-17])) {

                    // check if the scaling is appropriate
                    boolean isTriangle4ScaleValid = scaleCheck(scaleTriangle4).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle4RotationValid = rotationCheck(11, rotateTriangle4).equals("correct");
                    System.out.println("isTriangle4ScaleValid: " + isTriangle4ScaleValid);
                    System.out.println("isTriangle4RotationValid: " + isTriangle4RotationValid);
                    if(isTriangle4ScaleValid && isTriangle4RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle4isMatched){
                            matchedShapes++;
                            triangle4isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 12) {
            // check if the shape is valid or not
            if(rhombusNarrow1_idn>31){
                if(shape[12].equals(shape[rhombusNarrow1_idn-20])) {

                    // check if the scaling is appropriate
                    boolean isRhombusNarrow1ScaleValid = scaleCheck(scaleRhombusNarrow1).equals("appropriate");

                    // check if the rotation matches
                    boolean isRhombusNarrow1RotationValid = rotationCheck(12, rotateRhombusNarrow1).equals("correct");
                    System.out.println("isRhombusNarrow1ScaleValid: " + isRhombusNarrow1ScaleValid);
                    System.out.println("isRhombusNarrow1RotationValid: " + isRhombusNarrow1RotationValid);
                    if(isRhombusNarrow1ScaleValid && isRhombusNarrow1RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!rhombusNarrow1isMatched){
                            matchedShapes++;
                            rhombusNarrow1isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 13) {
            // check if the shape is valid or not
            if(rhombusNarrow2_idn>31){
                if(shape[13].equals(shape[rhombusNarrow2_idn-19])) {

                    // check if the scaling is appropriate
                    boolean isRhombusNarrow2ScaleValid = scaleCheck(scaleRhombusNarrow2).equals("appropriate");

                    // check if the rotation matches
                    boolean isRhombusNarrow2RotationValid = rotationCheck(13, rotateRhombusNarrow2).equals("correct");
                    System.out.println("isRhombusNarrow2ScaleValid: " + isRhombusNarrow2ScaleValid);
                    System.out.println("isRhombusNarrow2RotationValid: " + isRhombusNarrow2RotationValid);
                    if(isRhombusNarrow2ScaleValid && isRhombusNarrow2RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!rhombusNarrow2isMatched){
                            matchedShapes++;
                            rhombusNarrow2isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 14) {
            // check if the shape is valid or not
            if(triangle5_idn>27){
                if(shape[14].equals(shape[triangle5_idn-14])) {

                    // check if the scaling is appropriate
                    boolean isTriangle5ScaleValid = scaleCheck(scaleTriangle5).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle5RotationValid = rotationCheck(14, rotateTriangle5).equals("correct");
                    System.out.println("isTriangle5ScaleValid: " + isTriangle5ScaleValid);
                    System.out.println("isTriangle5RotationValid: " + isTriangle5RotationValid);
                    if(isTriangle5ScaleValid && isTriangle5RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle5isMatched){
                            matchedShapes++;
                            triangle5isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 15) {
            // check if the shape is valid or not
            if(triangle6_idn>27){
                if(shape[15].equals(shape[triangle6_idn-13])) {

                    // check if the scaling is appropriate
                    boolean isTriangle6ScaleValid = scaleCheck(scaleTriangle6).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle6RotationValid = rotationCheck(15, rotateTriangle6).equals("correct");
                    System.out.println("isTriangle6ScaleValid: " + isTriangle6ScaleValid);
                    System.out.println("isTriangle6RotationValid: " + isTriangle6RotationValid);
                    if(isTriangle6ScaleValid && isTriangle6RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle6isMatched){
                            matchedShapes++;
                            triangle6isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 16) {
            // check if the shape is valid or not
            if(rhombusNarrow3_idn>31){
                if(shape[16].equals(shape[rhombusNarrow3_idn-16])) {

                    // check if the scaling is appropriate
                    boolean isRhombusNarrow3ScaleValid = scaleCheck(scaleRhombusNarrow3).equals("appropriate");

                    // check if the rotation matches
                    boolean isRhombusNarrow3RotationValid = rotationCheck(16, rotateRhombusNarrow3).equals("correct");
                    System.out.println("isRhombusNarrow3ScaleValid: " + isRhombusNarrow3ScaleValid);
                    System.out.println("isRhombusNarrow3RotationValid: " + isRhombusNarrow3RotationValid);
                    if(isRhombusNarrow3ScaleValid && isRhombusNarrow3RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!rhombusNarrow3isMatched){
                            matchedShapes++;
                            rhombusNarrow3isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 17) {
            // check if the shape is valid or not
            if(triangle7_idn>27){
                if(shape[17].equals(shape[triangle7_idn-11])) {

                    // check if the scaling is appropriate
                    boolean isTriangle7ScaleValid = scaleCheck(scaleTriangle7).equals("appropriate");

                    // check if the rotation matches
                    boolean isTriangle7RotationValid = rotationCheck(17, rotateTriangle7).equals("correct");
                    System.out.println("isTriangle7ScaleValid: " + isTriangle7ScaleValid);
                    System.out.println("isTriangle7RotationValid: " + isTriangle7RotationValid);
                    if(isTriangle7ScaleValid && isTriangle7RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!triangle7isMatched){
                            matchedShapes++;
                            triangle7isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 18) {
            // check if the shape is valid or not
            if(trapezium6_idn>32){
                if(shape[18].equals(shape[trapezium6_idn-15])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium6ScaleValid = scaleCheck(scaleTrapezium6).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium6RotationValid = rotationCheck(18, rotateTrapezium6).equals("correct");
                    System.out.println("isTrapezium6ScaleValid: " + isTrapezium6ScaleValid);
                    System.out.println("isTrapezium6RotationValid: " + isTrapezium6RotationValid);
                    if(isTrapezium6ScaleValid && isTrapezium6RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium6isMatched){
                            matchedShapes++;
                            trapezium6isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 19) {
            // check if the shape is valid or not
            if(hexagon1_idn>30){
                if(shape[19].equals(shape[hexagon1_idn-12])) {

                    // check if the scaling is appropriate
                    boolean isHexagon1ScaleValid = scaleCheck(scaleHexagon1).equals("appropriate");

                    // check if the rotation matches
                    boolean isHexagon1RotationValid = rotationCheck(19, rotateHexagon1).equals("correct");
                    System.out.println("isHexagon1ScaleValid: " + isHexagon1ScaleValid);
                    System.out.println("isHexagon1RotationValid: " + isHexagon1RotationValid);
                    if(isHexagon1ScaleValid && isHexagon1RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!hexagon1isMatched){
                            matchedShapes++;
                            hexagon1isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 20) {
            // check if the shape is valid or not
            if(trapezium7_idn>32){
                if(shape[20].equals(shape[trapezium7_idn-13])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium7ScaleValid = scaleCheck(scaleTrapezium7).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium7RotationValid = rotationCheck(20, rotateTrapezium7).equals("correct");
                    System.out.println("isTrapezium7ScaleValid: " + isTrapezium7ScaleValid);
                    System.out.println("isTrapezium7RotationValid: " + isTrapezium7RotationValid);
                    if(isTrapezium7ScaleValid && isTrapezium7RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium7isMatched){
                            matchedShapes++;
                            trapezium7isMatched = true;
                        }
                    }
                }
            }
        }

        if(traverse == 21) {
            // check if the shape is valid or not
            if(trapezium8_idn>32){
                if(shape[21].equals(shape[trapezium8_idn-12])) {

                    // check if the scaling is appropriate
                    boolean isTrapezium8ScaleValid = scaleCheck(scaleTrapezium8).equals("appropriate");

                    // check if the rotation matches
                    boolean isTrapezium8RotationValid = rotationCheck(21, rotateTrapezium8).equals("correct");
                    System.out.println("isTrapezium8ScaleValid: " + isTrapezium8ScaleValid);
                    System.out.println("isTrapezium8RotationValid: " + isTrapezium8RotationValid);
                    if(isTrapezium8ScaleValid && isTrapezium8RotationValid) {
                        // Implement a function to write the above
                        writeText(correctMatchText, xTextLocation, yTextLocation);
                        if(!trapezium8isMatched){
                            matchedShapes++;
                            trapezium8isMatched = true;
                        }
                    }
                }
            }
        }

    }

    // display the whole result once we click the finish button
    public void printResult(GLAutoDrawable drawable){
        String result = "RESULT: " + matchedShapes + "/21 shapes matched correctly.";
        int xTextLocation = (int)(windowWidth/4f);
        int yTextLocation = windowHeight-500;
        writeText(result, xTextLocation, yTextLocation);
    }

    // checks the rotation for each of the shape if it's valid or not
    public String rotationCheck(int shape, float angle) {

        // shapes #:
        // 1 - triangle1
        // 2 - trapezium1
        // 3 - trapezium2
        //  ...

        String text = ""; // check if the rotation is correct or not.
        if(shape == 1) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTriangle1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }

        }

        if(shape == 2) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTrapezium1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 3) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTrapezium2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 4) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTrapezium3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 5) {
            System.out.println(angle);
            if(angle > 0){
                if((360 - angle) == rotateBlueprintTrapezium4){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium4){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 6) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTrapezium5){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium5){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 7) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintRhombus1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintRhombus1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 8) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTriangle8){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle8){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 9) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTriangle2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 10) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTriangle3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 11) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTriangle4){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle4){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 12) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintRhombusNarrow1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintRhombusNarrow1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 13) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintRhombusNarrow2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintRhombusNarrow2){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 14) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTriangle5){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle5){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 15) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTriangle6){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle6){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 16) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintRhombusNarrow3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintRhombusNarrow3){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 17) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTriangle7){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTriangle7){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 18) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTrapezium6){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium6){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 19) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintHexagon1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintHexagon1){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 20) {
            System.out.println(angle);
            if(angle > 0){
                if((angle - 360) == rotateBlueprintTrapezium7){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium7){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        if(shape == 21) {
            System.out.println(angle);
            if(angle < 0){
                if((360 + angle) == rotateBlueprintTrapezium8){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }else{
                if(angle == rotateBlueprintTrapezium8){
                    text = "correct";
                }else{
                    text = "incorrect";
                }
            }
        }

        return text;
    }

    // checks if the left shape is matched with the shape drawn on the blueprint
    public String scaleCheck(double scale) {
        double scaling = Math.round(scale * 100.0) / 100.0;

        String text;
        if(scaling == 1.0) {
            text = "appropriate";
        }else {
            text = "not appropriate";
        }
        return text;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
