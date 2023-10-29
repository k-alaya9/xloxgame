import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateGUI {
    private State state;
    private int currentX;
    private int currentY;
    private JButton[][] buttons;
    private JFrame frame;

    public StateGUI(State state) {
        this.state = state;
        this.currentX = 0;
        this.currentY = 0;
        createGUI();
        addListeners();
    }

    private void createGUI() {
        frame = new JFrame("State GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(state.getArrayOfBlocks().length, state.getArrayOfBlocks().length));

        buttons = new JButton[state.getArrayOfBlocks().length][state.getArrayOfBlocks().length];

        for (int i = 0; i < state.getArrayOfBlocks().length; i++) {
            for (int j = 0; j < state.getArrayOfBlocks().length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setEnabled(false);
                frame.add(buttons[i][j]);
            }
        }

        frame.pack();
        frame.setVisible(true);

        // Enable the initial pointer position
        buttons[currentX][currentY].setEnabled(true);
        updateButtonState();
    }

    private void addListeners() {
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    moveUp();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    moveDown();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    moveLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    moveRight();
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    move();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        frame.setFocusable(true);
        frame.requestFocus();
    }
    private void moveUp() {
        if (currentX > 0) {
            buttons[currentX][currentY].setEnabled(false);
            currentX--;
            buttons[currentX][currentY].setEnabled(true);
            updateButtonState();
            repaintGrid();
        }
    }

    private void moveDown() {
        if (currentX < state.getArrayOfBlocks().length - 1) {
            buttons[currentX][currentY].setEnabled(false);
            currentX++;
            buttons[currentX][currentY].setEnabled(true);
            updateButtonState();
            repaintGrid();
        }
    }

    private void moveLeft() {
        if (currentY > 0) {
            buttons[currentX][currentY].setEnabled(false);
            currentY--;
            buttons[currentX][currentY].setEnabled(true);
            updateButtonState();
            repaintGrid();
        }
    }

    private void moveRight() {
        if (currentY < state.getArrayOfBlocks()[currentX].length - 1) {
            buttons[currentX][currentY].setEnabled(false);
            currentY++;
            buttons[currentX][currentY].setEnabled(true);
            updateButtonState();
            repaintGrid();
        }
    }
    private void repaintGrid() {
        for (int i = 0; i < state.getArrayOfBlocks().length; i++) {
            for (int j = 0; j < state.getArrayOfBlocks().length; j++) {
                if (state.getArrayOfBlocks()[i][j].getBlockState() == BlockState.Black) {
                    buttons[i][j].setBackground(Color.BLACK);
                } else if (state.getArrayOfBlocks()[i][j].getBlockState() == BlockState.White) {
                    buttons[i][j].setBackground(Color.WHITE);
                } else {
                    buttons[i][j].setBackground(null);
                }
            }
        }
    }
    private void updateButtonState() {
        for (int i = 0; i < state.getArrayOfBlocks().length; i++) {
            for (int j = 0; j < state.getArrayOfBlocks().length; j++) {
                if (i == currentX && j == currentY) {
                    buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
                    buttons[i][j].setBackground(Color.GREEN); // Change the background color of the current block
                } else {
                    buttons[i][j].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
                    if (state.getArrayOfBlocks()[i][j].getBlockState() == BlockState.Black) {
                        buttons[i][j].setBackground(Color.BLACK);
                    } else if (state.getArrayOfBlocks()[i][j].getBlockState() == BlockState.White) {
                        buttons[i][j].setBackground(Color.WHITE);
                    } else {
                        buttons[i][j].setBackground(null);
                    }
                }
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));
            }
        }
    }
    private void move() {
        state.move(currentX, currentY);
        repaintGrid();
    }



}