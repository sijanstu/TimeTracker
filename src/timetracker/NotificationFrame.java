package timetracker;

import java.awt.*;

/**
 * @author Sijan Bhandari
 */
public class NotificationFrame extends javax.swing.JFrame {

    /**
     * Creates new form Notification
     */
    ColorChange colorChange = new ColorChange();
    static boolean isRunning = false;

    public NotificationFrame() {
            initComponents();
            this.setAlwaysOnTop(true);
            this.setOpacity(0.8f);
            this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            this.setLocation(0, 0);
            this.setBackground(new Color(255, 255, 255, 0));
            this.setVisible(true);
            int fontSize = (int) (this.getHeight() * 0.1);
            button.setFont(new Font("Tahoma", Font.PLAIN, fontSize / 2));
            colorChange.start();
            isRunning=true;
    }
    private boolean isStopped = false;

    class ColorChange extends Thread {

        public void run() {
            while (!isStopped) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int r = (int) (Math.random() * 255);
                int g = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                button.setBackground(new Color(r, g, b));
                button.setColorHover(new Color(r, g, b));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.CardLayout());

        button.setBackground(new java.awt.Color(0, 102, 102));
        button.setText("You're coding for too long, It's time to take some break;");
        button.setColorHover(new java.awt.Color(102, 0, 0));
        button.setFont(new java.awt.Font("Arial Unicode MS", 1, 36)); // NOI18N
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        jPanel1.add(button, "card2");

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        isStopped = true;
        isRunning = false;
        dispose();
    }//GEN-LAST:event_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (isRunning) {
            System.out.println("Already exists");
            
        }else{
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
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationFrame().setVisible(true);
            }
        });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover button;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
