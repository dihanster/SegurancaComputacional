/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 04 - Modos de Cifra
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        txtIV.setVisible(false);
        lblIV.setVisible(false);
    }
    
    public int[] stringToBinaryArray (String s) {
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0')
                a[i] = 0;
            else
                a[i] = 1;
        }
        return a;
    }
    
    public Integer[] stringToBinaryIntegerArray (String s){
        int val = Integer.parseInt(s);
        Integer[] array = new Integer[8];
        int i = 7;
        
        while(i > -1){
            array[i] = val % 10;
            val = val/10;
            i--;   
        }
        return array;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radBtnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtArq = new javax.swing.JTextField();
        combModoCifra = new javax.swing.JComboBox<>();
        btnAcao = new javax.swing.JButton();
        btnProcArq = new javax.swing.JButton();
        lblArq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdBtnCifrar = new javax.swing.JRadioButton();
        rdBtnDecifrar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        lblIV = new javax.swing.JLabel();
        txtIV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArq.setToolTipText("Imagem deve ser *.bmp");

        combModoCifra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECB", "CBC", "Counter" }));
        combModoCifra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combModoCifraActionPerformed(evt);
            }
        });

        btnAcao.setText(">");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnProcArq.setText("Procurar");
        btnProcArq.setToolTipText("Imagem deve ser *.bmp");
        btnProcArq.setActionCommand("Procurar");
        btnProcArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcArqActionPerformed(evt);
            }
        });

        lblArq.setText("Arquivo:");

        jLabel2.setText("Modo de Cifra:");

        radBtnGroup.add(rdBtnCifrar);
        rdBtnCifrar.setText("Cifrar");

        radBtnGroup.add(rdBtnDecifrar);
        rdBtnDecifrar.setText("Decifrar");

        jLabel1.setText("Chave:");

        txtChave.setToolTipText("Número binário de 8 bits");

        lblIV.setText("IV:");

        txtIV.setToolTipText("Número binário de 8 bits");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblArq)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtArq, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnProcArq))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combModoCifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdBtnCifrar)
                                .addGap(8, 8, 8)
                                .addComponent(rdBtnDecifrar))
                            .addComponent(txtChave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblIV)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAcao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIV, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcArq)
                    .addComponent(lblArq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combModoCifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rdBtnCifrar)
                    .addComponent(rdBtnDecifrar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAcao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        
        if(((!rdBtnCifrar.isSelected()) && (!rdBtnDecifrar.isSelected()))||(txtArq.getText().compareTo("")==0)||
                (txtChave.getText().compareTo("")==0))
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos necessários para a operação!");
            return;
        }
        
        SDES cipher = new SDES();
        String entrada = txtArq.getText().replace("\\", "\\\\");
        int chave = Integer.parseInt(txtChave.getText());
        
        switch((String)combModoCifra.getSelectedItem()){
            case "ECB":
            {    
                EletronicCodeBlockBook modo = new EletronicCodeBlockBook();
                if(rdBtnCifrar.isSelected()){
                    try {
                        modo.cifrar(entrada, chave, cipher);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        modo.decifrar(entrada, chave, cipher);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            case "CBC":
            {    
                CipherBlockChaining modo = new CipherBlockChaining();
                if(rdBtnCifrar.isSelected()){
                    try {
                        modo.cifrar(entrada, chave, cipher, this.stringToBinaryIntegerArray(txtIV.getText()));
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        modo.decifrar(entrada, chave, cipher, this.stringToBinaryIntegerArray(txtIV.getText()));
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            case "Counter":
            {    
                if(txtIV.getText().compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"Preencha o valor de IV!");
                }
                Counter modo = new Counter();
                if(rdBtnCifrar.isSelected()){
                    try {
                        modo.cifrar(entrada, chave, cipher);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        modo.decifrar(entrada, chave, cipher);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnProcArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcArqActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Procurando uma Imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de imagem (*.bmp)", "bmp");
        fileChooser.setFileFilter(filtro);
        if(fileChooser.showOpenDialog(this) == fileChooser.APPROVE_OPTION)
        {
            File arquivo = fileChooser.getSelectedFile();
            txtArq.setText(arquivo.getPath());
            txtArq.setEditable(false);
        }        
    }//GEN-LAST:event_btnProcArqActionPerformed

    private void combModoCifraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combModoCifraActionPerformed
        if(((String)combModoCifra.getSelectedItem()).compareTo("CBC")==0)
        {
            txtIV.setVisible(true);
            lblIV.setVisible(true);
        }
        else
        {
            txtIV.setVisible(false);
            lblIV.setVisible(false);
        }
    }//GEN-LAST:event_combModoCifraActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnProcArq;
    private javax.swing.JComboBox<String> combModoCifra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArq;
    private javax.swing.JLabel lblIV;
    private javax.swing.ButtonGroup radBtnGroup;
    private javax.swing.JRadioButton rdBtnCifrar;
    private javax.swing.JRadioButton rdBtnDecifrar;
    private javax.swing.JTextField txtArq;
    private javax.swing.JTextField txtChave;
    private javax.swing.JTextField txtIV;
    // End of variables declaration//GEN-END:variables
}
