package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Panels extends JPanel{
    public static int rowQuantity, columnQuantity, rowQuantity2, columnQuantity2, //here
            getSelectedX, getSelectedY, xSelected, ySelected, 
            widthPanel=500, heightPanel=500;
    public static BufferedImage[][] images; //= new BufferedImage[rowQuantity][columnQuantity]; //here
    public static BufferedImage[][] mosaicImages; //= new BufferedImage[rowQuantity][columnQuantity]; //here
    BufferedImage mainImage;
    File imageSource;
    
/**
    //Frame que agrega los dos paneles
    public Paneles(File fileImage) throws IOException { 
        this.fileImage= fileImage;
        JOptionPane.showMessageDialog(null, fileImage.toString());
        mainImage = ImageIO.read(new FileInputStream(fileImage.getName()));
       //repaint();

    }
**/
    
    public Panels(){
        //JFrame this = new JFrame();

        MosaicPanel panel2 = new MosaicPanel();
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5) );//adds margin to panel
        //new MyDropTargetListener(panel); 

        this.add(panel2, BorderLayout.EAST);
        add(new JToolBar.Separator(new Dimension(100, 500)), BorderLayout.CENTER);

        try {
            this.add(new SourcePanel(), BorderLayout.WEST);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    Panels(File file, int rowQuant, int columnQuant){
       
        //setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(new SourcePanel(), BorderLayout.WEST);
        add(new JToolBar.Separator(new Dimension(100, 500)), BorderLayout.CENTER);
        add(new MosaicPanel(), BorderLayout.EAST);
        
        //JButton btnSave= new JButton("Save");
        //btnSave.setMaximumSize(new Dimension(5, 5));
        //add(btnSave, BorderLayout.SOUTH);
        
        //pack();
        //imagenPrincipal = ImageIO.read(getClass().getResourceAsStream("/assets/paisaje.jpg"));
        imageSource = file;
//        rowQuantity = rowQuant;
//        columnQuantity = columnQuant;
        rowQuantity = rowQuant;
        columnQuantity = rowQuant;
        rowQuantity2 = columnQuant;
        columnQuantity2 = columnQuant;
        images = new BufferedImage[rowQuantity][columnQuantity];
        mosaicImages = new BufferedImage[rowQuantity2][columnQuantity2];
    }
    
    
    //Panel origen
    public class SourcePanel extends JPanel implements MouseListener {

        private final List<Rectangle> cells;
        private int cellWidth = 0, cellHeight = 0;

        public SourcePanel() {
            cells = new ArrayList<>(rowQuantity * columnQuantity);
            addMouseListener(this);
            setMaximumSize(new Dimension(widthPanel, heightPanel));
            
        }
        

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        public void invalidate() {
            cells.clear();
            super.invalidate();
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                revalidate();
            try {
                //imagenPrincipal = ImageIO.read(getClass().getResourceAsStream("/ImageManipulation/11aa.png"));
                //imagenPrincipal = ImageIO.read(imageSource);
                if(imageSource==null){
                    mainImage = ImageIO.read(getClass().getResourceAsStream("/ImageManipulation/11aa.png"));
                }else{
                    mainImage = ImageIO.read(imageSource);
                }
                
                mainImage = getScaledInstance(mainImage, widthPanel, heightPanel, false);
                
                int width = getWidth();
                int height = getHeight();
                cellWidth = width / rowQuantity;
                cellHeight = height / columnQuantity;
                
                if (cells.isEmpty()) {
                    for (int row = 0; row < rowQuantity; row++) {
                        for (int col = 0; col < columnQuantity; col++) {
                            
                            //Crea una matriz
                            Rectangle cell = new Rectangle(
                                    row * (width / rowQuantity),
                                    col * (height / columnQuantity),
                                    cellWidth,
                                    cellHeight);
                            cells.add(cell);
                            
                            //Divide imagen original
                            
                            BufferedImage imagen = mainImage.getSubimage(row * (width / rowQuantity), col * (height / columnQuantity), cellWidth, cellHeight);
                            images[row][col] = (BufferedImage) imagen;
                            
                            
                            //Pinta la imagen original
                            g2d.drawImage(images[row][col], row * (width / rowQuantity), col * (height / columnQuantity), null);
                            //imagenes[row][col]= (BufferedImage)images[row][col];
                            //repaint();
                        
                        }
                    }
                }
                //Dibuja la matriz de Rectangulos
                g2d.setColor(Color.BLACK);
                cells.forEach((cell) -> {
                    g2d.draw(cell);
                });
               
                revalidate();
                g.dispose();
                g2d.dispose();
            } catch (IOException ex) {
                System.out.println("-- "+ex.getMessage());
                Logger.getLogger(Panels.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }

        //@Override
        public void mouseClicked(MouseEvent e) {
      
            int xOffset = 0;
            getSelectedX = (e.getX() - xOffset) / cellWidth;
            int yOffset = 0;
            getSelectedY = (e.getY() - yOffset) / cellHeight;
            //System.out.println("Cordenadas panel1\nColumn "+ getSelectedX + " Row " + getSelectedY);
            
            Clip clip;
            try{
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/Sounds/clickSound.wav")));
                clip.start();
                
            }catch(Exception ce){
            
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
             
        }
    }//Fin panel1
    
    //Panel vacio
    public class MosaicPanel extends JPanel implements MouseListener {

        private final List<Rectangle> cells = new ArrayList<>(rowQuantity2 * columnQuantity2); //here
        private JPopupMenu rightClickMenu = new JPopupMenu();
        private Graphics2D g2d;
        private int cellWidth = 0, cellHeight = 0;

        
        public MosaicPanel() { 
            setBorder(new LineBorder(Color.BLACK));
            this.addMouseListener(this);
            setMaximumSize(new Dimension(widthPanel, heightPanel));
        
        //Flip Horizontally
        JMenuItem menuItem = new JMenuItem("Flip horizontally");
        menuItem.addActionListener((ActionEvent e) -> {
            flipImageH();
            });
        rightClickMenu.add(menuItem);
        
        //Flip Horizontally
        menuItem = new JMenuItem("Flip vertically");
        menuItem.addActionListener((ActionEvent e) -> {
            flipImageV();
            });
        rightClickMenu.add(menuItem);        
        
        // Rotate
        menuItem = new JMenuItem("Rotate");
        menuItem.addActionListener((ActionEvent e) -> {
            rotateImage();
            });
        rightClickMenu.add(menuItem); 
        
        //Delete
        menuItem = new JMenuItem("Delete");
        menuItem.addActionListener((ActionEvent e) -> {  
            deleteCell();
            });
        rightClickMenu.add(menuItem);         
        
        }
        
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            for (int row = 0; row < rowQuantity2; row++) { //here
                for (int col = 0; col < columnQuantity2; col++) { //here

                    cellWidth = getWidth() / rowQuantity2;//here
                    cellHeight = getHeight() / columnQuantity2;//here

                    //Creo una matriz
                    Rectangle cell = new Rectangle(
                            row * (getWidth() / rowQuantity2),//here
                            col * (getHeight() / columnQuantity2),//here
                            cellWidth,
                            cellHeight);
                    cells.add(cell);
                    
                    //Pinta las nuevas images
                    g2d.drawImage(mosaicImages[row][col], row * (width / rowQuantity2), col * (height / columnQuantity2),cellWidth,cellHeight, null); //here
                }
                
            }           
           
            //Pinta la matriz
            g2d.setColor(Color.BLACK);
            cells.forEach((cell) -> {
                g2d.draw(cell);
            });
            //g2d.dispose();
        }
        public void rotateImage(){
                        
            BufferedImage bi = (BufferedImage) mosaicImages[xSelected][ySelected];             
            AffineTransform at = new AffineTransform();
            at.rotate(Math.toRadians(90), bi.getWidth(null)/2, bi.getHeight()/2);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            bi = op.filter(bi, null);
            mosaicImages[xSelected][ySelected]= bi;
            repaint();

        }
        
        public void flipImageH(){
            
            BufferedImage bi = (BufferedImage) mosaicImages[xSelected][ySelected];
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-bi.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            bi = op.filter(bi, null);
            mosaicImages[xSelected][ySelected]= bi;
            repaint();            
        }
        
        public void flipImageV(){
            
            BufferedImage bi = (BufferedImage) mosaicImages[xSelected][ySelected];
            AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
            tx.translate(0, -bi.getHeight(null));
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            bi = op.filter(bi, null);
            mosaicImages[xSelected][ySelected]= bi;
            repaint();             
        }
        
        public void deleteCell(){
            
            mosaicImages[xSelected][ySelected]=null;
            repaint();
            
        }
        
        @Override
        public void invalidate() {
            cells.clear();
            super.invalidate();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }


        @Override
        public void mouseClicked(MouseEvent e) {

            int xOffset = 0;
            xSelected = (e.getX() - xOffset) / cellWidth;
            int yOffset = 0;
            ySelected = (e.getY() - yOffset) / cellHeight;
            
            System.out.println("Cordenadas panel2\nColumn " + xSelected + " Row " + ySelected);
            
            //Obtener imagen 
            //imgCell = images[getSelectedX][getSelectedY];
            //Pegar imagen
            mosaicImages[xSelected][ySelected]= (BufferedImage)images[getSelectedX][getSelectedY];
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //Muestra menu click derecho
            if (e.isPopupTrigger()) {
                rightClickMenu.show(e.getComponent(),
                        e.getX(), e.getY());
                
            int xOffset = 0;
            xSelected = (e.getX() - xOffset) / cellWidth;
            int yOffset = 0;
            ySelected = (e.getY() - yOffset) / cellHeight;
               
            }      
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }


    }//Fin panel2    
    
    public BufferedImage getScaledInstance(BufferedImage img,
            int targetWidth,
            int targetHeight,
            //Object hint,
            boolean higherQuality) {
        int type = (img.getTransparency() == Transparency.OPAQUE)
                ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage) img;
        int w, h;
        if (higherQuality) {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        } else {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }

        do {
            if (higherQuality && w > targetWidth) {
                w /= 2;
                if (w < targetWidth) {
                    w = targetWidth;
                }
            }

            if (higherQuality && h > targetHeight) {
                h /= 2;
                if (h < targetHeight) {
                    h = targetHeight;
                }
            }

            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();

            ret = tmp;
        } while (w != targetWidth || h != targetHeight);

        return ret;
    }
    
    public void saveAnImage() throws IOException {
        int cellWidth, cellHeight;
        int type;
        try {
            //Convertir matriz a arreglo de images
            
            //if(rowQuantity!=0){
                BufferedImage[] mosaicArray = new BufferedImage[rowQuantity2 * columnQuantity2];
            int cont = 0;

            for (int i = 0; i < rowQuantity2; i++) {
                for (int j = 0; j < columnQuantity2; j++) {
                    mosaicArray[cont] = mosaicImages[i][j];
                    cont++;
                }
            }

            type = mosaicArray[0].getType();
            cellWidth = mosaicArray[0].getWidth();
            cellHeight = mosaicArray[0].getHeight();

            //Imagen final
            BufferedImage finalImg = new BufferedImage(cellWidth * rowQuantity2, cellHeight * columnQuantity2, type);
            int num = 0;
            
            for (int i = 0; i < rowQuantity2; i++) {
                for (int j = 0; j < columnQuantity2; j++) {
                    finalImg.createGraphics().drawImage(mosaicArray[num], cellWidth * i, cellHeight * j, null);
                    num++;
                }
            }
            
            //}

            
            //Guardar en directorio
            JFileChooser jFile = new JFileChooser();
            jFile.showSaveDialog(null);
            Path pth = jFile.getSelectedFile().toPath();
            JOptionPane.showMessageDialog(null, pth.toString());
            
            //ImageDataSerializable mds= new ImageDataSerializable();
            //mds.writeObject(pth.toString());
            
            JOptionPane.showMessageDialog(this, "Imaged was saved","",JOptionPane.INFORMATION_MESSAGE );
            ImageIO.write(finalImg, "png", new File(pth.toString() + ".png"));
            
            
            
        } catch (NullPointerException npe) {
            //JOptionPane.showMessageDialog(null," Incomplete cells ", "", JOptionPane.WARNING_MESSAGE);
        //} catch (IOException ioe) {
            //JOptionPane.showMessageDialog(null, "Can't save image!", "Error", JOptionPane.ERROR_MESSAGE);
        //}
            
        }
    }
}
