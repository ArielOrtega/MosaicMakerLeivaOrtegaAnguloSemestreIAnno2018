/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ImageManipulation.UploadImage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Pablo
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        getContentPane().setBackground(new Color(180, 180, 180));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelSource = new javax.swing.JPanel();
        btn_Load = new javax.swing.JButton();
        tfd_row = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_blocks = new javax.swing.JLabel();
        tfd_blocksNew = new javax.swing.JTextField();
        lbl_blocks2 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MosaicMaker");

        JPanelSource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout JPanelSourceLayout = new javax.swing.GroupLayout(JPanelSource);
        JPanelSource.setLayout(JPanelSourceLayout);
        JPanelSourceLayout.setHorizontalGroup(
            JPanelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1027, Short.MAX_VALUE)
        );
        JPanelSourceLayout.setVerticalGroup(
            JPanelSourceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        btn_Load.setBackground(new java.awt.Color(102, 102, 255));
        btn_Load.setFont(new java.awt.Font("Open Sans", 1, 11)); // NOI18N
        btn_Load.setForeground(new java.awt.Color(204, 204, 204));
        btn_Load.setText("Load Picture");
        btn_Load.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LoadMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbl_blocks.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lbl_blocks.setForeground(new java.awt.Color(102, 102, 255));
        lbl_blocks.setText("Blocks to split");

        lbl_blocks2.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lbl_blocks2.setForeground(new java.awt.Color(102, 102, 255));
        lbl_blocks2.setText("Blocks to split");

        lbl_title.setFont(new java.awt.Font("Amatic", 1, 54)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(102, 102, 255));
        lbl_title.setText("Mosaic Maker");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Load)
                                .addGap(39, 39, 39)
                                .addComponent(lbl_blocks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfd_row, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(lbl_blocks2)
                                .addGap(18, 18, 18)
                                .addComponent(tfd_blocksNew, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JPanelSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_title)
                        .addGap(532, 532, 532))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Load)
                        .addComponent(tfd_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_blocks))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_blocks2)
                        .addComponent(tfd_blocksNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPanelSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LoadMouseClicked
        // TODO add your handling code here:
//here eliminar tfd_column
            try {
                if(tfd_row.getText().length()==0 || tfd_blocksNew.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Fill the blocks to split field first","Error...", JOptionPane.ERROR_MESSAGE);
                }else{
                    int rows = Integer.parseInt(tfd_row.getText());
                    int rows2 = Integer.parseInt(tfd_blocksNew.getText());
                    File fileImage;
                    ImageIcon image;
                    int resultado;
                    UploadImage uploadWindow = new UploadImage();
                    FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
                    uploadWindow.jFileChooser.setFileFilter(filtro);
                    resultado = uploadWindow.jFileChooser.showOpenDialog(null);
                    if (JFileChooser.APPROVE_OPTION == resultado) {
                        fileImage = uploadWindow.jFileChooser.getSelectedFile();
                        JPanelSource.removeAll();
                        JPanelSource.setLayout(new FlowLayout());
                        
                        int columns = Integer.parseInt(tfd_row.getText());
                        JPanelSource.add(new Paneles(fileImage, rows, rows2));
                        JPanelSource.revalidate();
                        
                    }else if(JFileChooser.CANCEL_OPTION == resultado){
                        JOptionPane.showMessageDialog(null, "Cancelled","",JOptionPane.OK_OPTION);
                    }
                }
            }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Use only numbers in the field","Error...", JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error uploading image 1002 " + ex);
            }
//^here
    }//GEN-LAST:event_btn_LoadMouseClicked

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelSource;
    private javax.swing.JButton btn_Load;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_blocks;
    private javax.swing.JLabel lbl_blocks2;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextField tfd_blocksNew;
    private javax.swing.JTextField tfd_row;
    // End of variables declaration//GEN-END:variables
}
