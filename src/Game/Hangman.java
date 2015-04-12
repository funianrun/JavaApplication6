/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 *
 */
public class Hangman extends javax.swing.JFrame {
    
    protected static final Insets   bottomInsets    = new Insets(10, 10, 10, 10);
    protected static final Insets   normalInsets    = new Insets(10, 10, 0, 10);
    protected static final Insets   spacingInsets   = new Insets(20, 10, 0, 10);
 
    
    private int             numberOfGuesses;
    private int             wrongGuesses;
 
    private List<Character>   unguessedLetters;
 
    private String          currentWord;
    private String          hiddenWord;
 
    public static int maximumWrongGuesses = 7;
    HangmanModel model;
    private int             randomInt = -1;;
    private List<String>  words = new ArrayList<String>();;
    private Random          random = new Random();
    private String       word;
    public JPanel outsidePanel;
    public JPanel panel;
    
    private List<JLabel>          wordText;
    
    /**
     * Creates new form Hangman
     */
    public Hangman() {
        words.add("computer");
        words.add("spatula");
        words.add("monkeys");
        words.add("oregano");
        words.add("soupcon");
        word = getWord();
        
        outsidePanel = new JPanel();
        outsidePanel.setLayout(new FlowLayout());
        panel = new JPanel();
        // panel.setBackground(Color.YELLOW);
        panel.setLayout(new GridBagLayout());
        outsidePanel.add(panel);
        this.numberOfGuesses = 0;
        this.wrongGuesses = 0;
        this.maximumWrongGuesses = 7;
        this.unguessedLetters = resetLettersGuessed();
        this.currentWord = word;
        this.hiddenWord = getHiddenWord();
        this.words = new ArrayList<String>();
        this.wordText = new ArrayList<JLabel>();
        
        this.model = model;
        initComponents();
        
        
        
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Gallows gallows = new Gallows();
        Figure figure = new Figure();
         
        Color color1 = Color.BLUE;
        Color color2 = Color.BLUE;
        g.setColor(color1);
        gallows.paintComponent(g);
         
       
        switch (wrongGuesses) {
        case 7:
            color2 = Color.red;
            figure.drawNoose(g, color2);
        case 6:
            figure.drawRightLeg(g, color2);
        case 5:
            figure.drawLeftLeg(g, color2);
        case 4:
            figure.drawRightArm(g, color2);
        case 3:
            figure.drawLeftArm(g, color2);
        case 2:
            figure.drawBody(g, color2);
        case 1:
            figure.drawHead(g, color2);
        }
    
    }
    public void init() {
        
        
            this.numberOfGuesses = 0;
        this.wrongGuesses = 0;
        this.maximumWrongGuesses = maximumWrongGuesses;
        this.unguessedLetters = resetLettersGuessed();
        word = getWord();
        this.currentWord = word;
        this.hiddenWord = getHiddenWord();
        updatePartControl();
       
        
        
        
        }
    
    /*public void resetPartControl() {
        lettersUsed.setText(getUnguessedLetters());
        //guessesText.setText(model.getNumberOfGuesses());
 
        removePhraseControl(panel);
        //int gridy = phraseGridy;
        createPhraseControl(panel,);
        panel.validate();
    }
 
    private void removePhraseControl(JPanel panel) {
        for (int i = wordText.size() - 1; i >= 0; i--) {
            JLabel label = wordText.get(i);
            panel.remove(label);
            wordText.remove(i);
        }
    }
 
    private void createPhraseControl(JPanel panel) {
        words = getHiddenWordList();
        for (int i = 0; i < words.size(); i++) {
            JLabel label = new JLabel(words.get(i));
            Font newFont = new Font("Courier New", Font.BOLD, 24);
            label.setFont(newFont);
            label.setHorizontalAlignment(JLabel.CENTER);
            addComponent(panel, label, 0, 2, 1, bottomInsets,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
            wordText.add(label);
        }
    }
 
    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }
    */
    private List<Character> resetLettersGuessed() {
        List<Character> unguessedLetters = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            Character c = (char) (i + 'A');
            unguessedLetters.add(c);
        }
        return unguessedLetters;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secretWordLabel = new javax.swing.JLabel();
        secretWordText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lettersUsed = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        guessField = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        resetGameButton = new javax.swing.JButton();
        customGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        secretWordLabel.setText("Secret Word:");

        jLabel1.setText("Letter's Used:");

        jLabel3.setText("Guess:");

        guessField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessFieldActionPerformed(evt);
            }
        });

        guessButton.setText("Guess");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        resetGameButton.setText("Reset Game");
        resetGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetGameButtonActionPerformed(evt);
            }
        });

        customGameButton.setText("Custom Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secretWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetGameButton))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customGameButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(secretWordText, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(lettersUsed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(guessButton)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secretWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secretWordText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lettersUsed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetGameButton)
                    .addComponent(customGameButton))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guessFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guessFieldActionPerformed

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        String letter = guessField.getText();
        if ((letter.length() == 1) && (isPossibleLetter(letter))) {
            guessLetter(letter);
             repaint();
             updatePartControl();
            guessField.setText("");
            guessField.requestFocusInWindow();
            if (isDead()) {
                    JOptionPane.showMessageDialog(outsidePanel,
                            "You died.  The phrase was\n"
                                    + currentWord,
                            "Death", JOptionPane.ERROR_MESSAGE);
                    init();
                }
            else if (isSolved()) {
                    JOptionPane.showMessageDialog(outsidePanel,
                            "You guessed the phrase!\n"
                                    + currentWord,
                            "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    init();
                }
            
       }
        else {
           guessField.requestFocusInWindow();
           }
        
    }//GEN-LAST:event_guessButtonActionPerformed

    private void resetGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetGameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetGameButtonActionPerformed

    public boolean isDead() {
        return wrongGuesses >= maximumWrongGuesses;
    }
 
    public boolean isSolved() {
        boolean isSolved = true;
 
        for (int i = 0; isSolved && i < hiddenWord.length(); i++) {
            char c = hiddenWord.charAt(i);
            if (c == '_') {
                isSolved = false;
            }
        }
 
        return isSolved;
    }
    
    public void guessLetter(String letter) {
        String l = letter.toLowerCase();
        String u = letter.toUpperCase();
 
        StringBuilder builder = new StringBuilder();
        boolean incorrectGuess = true;
        for (int i = 0; i < currentWord.length(); i++) {
            String s = currentWord.substring(i, i + 1);
            if (l.equals(s.toLowerCase())) {
                builder.append(s);
                incorrectGuess = false;
            } else {
                builder.append(hiddenWord.charAt(i));
            }
        }
 
        numberOfGuesses++;
 
        if (incorrectGuess) {
            wrongGuesses++;
        }
 
        Character c = u.charAt(0);
        unguessedLetters.remove(c);
 
        hiddenWord = builder.toString();
    }
    
    public boolean isPossibleLetter(String letter) {
        String u = letter.toUpperCase();
        Character c = u.charAt(0);
        return unguessedLetters.contains(c);
    }
    
    public void updatePartControl() {
        lettersUsed.setText(getUnguessedLetters());
        //guessesText.setText(model.getNumberOfGuesses());
 
        words = getHiddenWordList();
        for (int i = 0; i < words.size(); i++) {
            //JLabel label = wordText.get(i);
            secretWordText.setText(words.get(i));
        }
    }
    public String getUnguessedLetters() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unguessedLetters.size(); i++) {
            builder.append(unguessedLetters.get(i));
            if (i < (unguessedLetters.size() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hangman().setVisible(true);
            }
        });
    }
    
    public String getWord() {
        int nextInt = randomInt;
        while (nextInt == randomInt) {
            nextInt = random.nextInt(words.size());
        }
        this.randomInt = nextInt;
 
        this.word = words.get(randomInt);
        return word;
    }
    public String getHiddenWord() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
                builder.append("_");
            }
        
        return builder.toString();
    }
    public List<String> getHiddenWordList() {
        List<String> lines = new ArrayList<String>();
 
        int size = 12;
        String s = hiddenWord;
 
        while (s.length() > size) {
            int pos = 0;
            while (pos >= 0 && pos < size) {
                pos = s.indexOf(" ", pos + 1);
            }
            if (pos >= 0) {
                String t = s.substring(0, pos);
                lines.add(expandHiddenWord(t));
                s = s.substring(pos + 1);
            } else {
                break;
            }
        }
 
        lines.add(expandHiddenWord(s));
 
        return lines;
    }
    private String expandHiddenWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(word.charAt(i));
            if (i < (word.length() - 1)) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customGameButton;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lettersUsed;
    private javax.swing.JButton resetGameButton;
    private javax.swing.JLabel secretWordLabel;
    private javax.swing.JLabel secretWordText;
    // End of variables declaration//GEN-END:variables
}
