/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo da Tela
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package model;

import criptografia.AES;
import criptografia.CBC;
import criptografia.Counter;
import criptografia.ECB;
import criptografia.NovoAES;
import criptografia.RC4;
import criptografia.SDES;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rede.Cliente;
import rede.Conexao;
import rede.Servidor;

public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    private Cliente cliente;
    private Servidor servidor;
    private int key;

    public Tela() {
        initComponents();
        combModoCifra.setVisible(true);
        lblModo.setVisible(true);
        lblTam.setVisible(false);
        txtTam.setVisible(false);

        this.cliente = new Cliente();
        this.key = 12;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public Cliente getCliente()
    {
        return this.cliente;
    }
    
    public void setKey(int key)
    {
        this.key = key;
    }
    
    public int getKey()
    {
        return this.key;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combModoCifra = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConversa = new javax.swing.JTextArea();
        combEncriptador = new javax.swing.JComboBox<>();
        btnEnviarMensagem = new javax.swing.JButton();
        txtMensagem = new javax.swing.JTextField();
        txtIP = new javax.swing.JTextField();
        btnIP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblModo = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblTam = new javax.swing.JLabel();
        txtTam = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        combModoCifra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CBC", "CTR", "ECB", " " }));

        txtConversa.setColumns(20);
        txtConversa.setRows(5);
        jScrollPane1.setViewportView(txtConversa);

        combEncriptador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SDES", "RC4", "AES" }));
        combEncriptador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combEncriptadorActionPerformed(evt);
            }
        });

        btnEnviarMensagem.setBackground(new java.awt.Color(51, 0, 51));
        btnEnviarMensagem.setForeground(new java.awt.Color(204, 204, 204));
        btnEnviarMensagem.setText("Enviar");
        btnEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMensagemActionPerformed(evt);
            }
        });

        btnIP.setBackground(new java.awt.Color(51, 0, 51));
        btnIP.setForeground(new java.awt.Color(204, 204, 204));
        btnIP.setText(">");
        btnIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIPActionPerformed(evt);
            }
        });

        jLabel1.setText("IP:");

        jLabel2.setText("Digite aqui:");

        jLabel3.setText("Encriptador:");

        lblModo.setText("Modo de cifra:");

        jLabel5.setText("Segredo:");

        lblTam.setText("Tamanho:");

        btnSair.setBackground(new java.awt.Color(255, 51, 51));
        btnSair.setForeground(new java.awt.Color(204, 204, 204));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTam, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combEncriptador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(lblModo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combModoCifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSair)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtChave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEnviarMensagem))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIP)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIP)
                    .addComponent(jLabel1)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarMensagem)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combEncriptador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combModoCifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblModo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTam)
                    .addComponent(txtTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addMessage(String mes, String who) {
        txtConversa.setText(txtConversa.getText().concat(who + " diz:\n" + mes + "\n\n"));
        //txtConversa.setCaretPosition(txtConversa.getDocument().getLength());
    }

    public void descriptMessage(String msg) throws Exception {
        /*if (this.txtChave.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Defina a chave para criptografia/descriptografia!");
            return;
        }*/

        //Adiciona a mensagem a minha caixa de texto
        String plainText = "";
        if (((String) combEncriptador.getSelectedItem()).compareTo("SDES") == 0) {
            switch ((String) combModoCifra.getSelectedItem()) {
                case "CBC":
                    CBC cifradorCBC = new CBC();
                    Integer iv[] = {1, 0, 0, 0, 1, 1, 0, 1};
                    plainText = cifradorCBC.decifraMensagem(msg, this.getKey(), new SDES(), iv);
                    break;
                case "CTR":
                    Counter cifradorCTR = new Counter();
                     {
                        try {
                            plainText = cifradorCTR.decifrarMensagem(msg, this.getKey(), new SDES());
                        } catch (IOException ex) {
                            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "ECB":
                    ECB cifradorECB = new ECB();
                     {
                        try {
                            plainText = cifradorECB.decifrarMensagem(msg, this.getKey(), new SDES());
                        } catch (IOException ex) {
                            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }
        } else if (((String) combEncriptador.getSelectedItem()).compareTo("RC4") == 0) {
            if (this.txtTam.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Defina o tamanho da chave para criptografia/descriptografia!");
                return;
            }
            RC4 cifradorRC4 = new RC4();
            try {
                int tam = Integer.parseInt(txtTam.getText());
                int cont = 0;
                for (int i = 0; i < tam; i++){
                    cont += Math.pow(2, i);
                }
                if (cont < Integer.parseInt(txtChave.getText())) {
                    JOptionPane.showMessageDialog(null, "Escolha um tamanho maior de chave");
                    return;
                }             
                plainText = new String(cifradorRC4.cifrar(msg.getBytes("windows-1252"), cifradorRC4.intToBinary(Integer.parseInt(txtChave.getText()), tam)), "windows-1252");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else { /*Eh o AES*/
            NovoAES cifradorAES = new NovoAES();
            String IV = "AAAAAAAAAAAAAAAA";
            plainText = cifradorAES.decrypt(msg, this.getKey());
            //plainText = "a";
            //System.out.println("recebeur" + AES.decrypt(msg.getBytes("windows-1252"), this.getKey(), IV));
        }
        this.addMessage(plainText, "Correspondente");
    }

    private void combEncriptadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combEncriptadorActionPerformed
        if (combEncriptador.getSelectedItem().toString().compareTo("SDES") == 0) {
            combModoCifra.setVisible(true);
            lblModo.setVisible(true);
            lblTam.setVisible(false);
            txtTam.setVisible(false);
        } else if (combEncriptador.getSelectedItem().toString().compareTo("RC4") == 0) {
            combModoCifra.setVisible(false);
            lblModo.setVisible(false);
            lblTam.setVisible(true);
            txtTam.setVisible(true);
        }
        else { //AES
            combModoCifra.setVisible(false);
            lblModo.setVisible(false);
            lblTam.setVisible(false);
            txtTam.setVisible(false);
        }
    }//GEN-LAST:event_combEncriptadorActionPerformed


    private void btnEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensagemActionPerformed

        //Verifica se todos os dados estão preenchidos
        if (this.cliente.getSocket() == null) {
            JOptionPane.showMessageDialog(null, "Conecte-se com alguém para conversar!");
            return;
        }

        if (this.txtChave.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Defina a chave para criptografia/descriptografia!");
            return;
        }

        //Adiciona a mensagem a minha caixa de texto
        this.addMessage(txtMensagem.getText(), "Você");

        if (!txtMensagem.getText().equals("Sair")) {
            String cipherText = txtMensagem.getText();
            if (((String) combEncriptador.getSelectedItem()).compareTo("SDES") == 0) {
                switch ((String) combModoCifra.getSelectedItem()) {
                    case "CBC":
                        CBC cifradorCBC = new CBC();
                        Integer iv[] = {1, 0, 0, 0, 1, 1, 0, 1};
                        cipherText = cifradorCBC.cifraMensagem(txtMensagem.getText(), this.getKey(), new SDES(), iv);
                        break;
                    case "CTR":
                        Counter cifradorCTR = new Counter();
                         {
                            try {
                                cipherText = cifradorCTR.cifraMensagem(txtMensagem.getText(), this.getKey(), new SDES());
                            } catch (IOException ex) {
                                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case "ECB":
                        ECB cifradorECB = new ECB();
                         {
                            try {
                                cipherText = cifradorECB.cifrarMensagem(txtMensagem.getText(), this.getKey(), new SDES());
                            } catch (IOException ex) {
                                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                }
        } else if (((String) combEncriptador.getSelectedItem()).compareTo("RC4") == 0) {
                if (this.txtTam.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Defina o tamanho da chave para criptografia/descriptografia!");
                    return;
                }
                RC4 cifradorRC4 = new RC4();
                try {
                    int tam = Integer.parseInt(txtTam.getText());
                    int cont = 0;
                    for (int i = 0; i < tam; i++){
                        cont += Math.pow(2, i);
                    }
                    if (cont < Integer.parseInt(txtChave.getText())) {
                        JOptionPane.showMessageDialog(null, "Escolha um tamanho maior de chave");
                        return;
                    }             
                    cipherText = new String(cifradorRC4.cifrar(txtMensagem.getText().getBytes("windows-1252"), cifradorRC4.intToBinary(Integer.parseInt(txtChave.getText()), tam)), "windows-1252");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else { /*Eh o AES*/
                NovoAES cifradorAES = new NovoAES();
                String IV = "AAAAAAAAAAAAAAAA";
                try {
                    cipherText = (cifradorAES.encrypt(txtMensagem.getText(), this.getKey()));
                    //cipherText = new String(teste);
                    System.out.println("vai enviar" + cipherText);
                } catch (Exception ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                System.out.println("Tela vai enviar: " + cipherText);
                this.cliente.enviarMensagem(cipherText);
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.cliente.sair();
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtMensagem.setText("");
    }//GEN-LAST:event_btnEnviarMensagemActionPerformed

    private void btnIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIPActionPerformed
        try {
            //System.out.println("Clicou no botão para conectar\naqui...");
            this.cliente.conectar(txtIP.getText());
            txtConversa.setText("");
            this.cliente.enviarY();
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIPActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        try {
            this.cliente.sair();
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtConversa.setText("Fim de Conversa\n");
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Tela a = new Tela();
                Conexao con = new Conexao();
                con.setTela(a);
                con.start();

                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarMensagem;
    private javax.swing.JButton btnIP;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> combEncriptador;
    private javax.swing.JComboBox<String> combModoCifra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblTam;
    private javax.swing.JTextField txtChave;
    private javax.swing.JTextArea txtConversa;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtTam;
    // End of variables declaration//GEN-END:variables
}
