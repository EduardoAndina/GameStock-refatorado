package gamestock.view;

import javax.swing.JOptionPane;

class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();

    }

    private void mostrarTela(javax.swing.JPanel tela) {

        tela.setSize(painelConteudo.getSize());
        painelConteudo.removeAll();
        painelConteudo.add(tela, java.awt.BorderLayout.CENTER);
        painelConteudo.revalidate();
        painelConteudo.repaint();
        tela.setSize(painelConteudo.getSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bntJogo = new javax.swing.JButton();
        bntVenda = new javax.swing.JButton();
        bntFuncionario = new javax.swing.JButton();
        bntHome = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        painelConteudo = new javax.swing.JPanel();
        painelInicial = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Stock");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamestock/imagens/gameStockLogo.png_.png"))); // NOI18N

        bntJogo.setBackground(new java.awt.Color(27, 58, 80));
        bntJogo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntJogo.setForeground(new java.awt.Color(255, 255, 255));
        bntJogo.setText("Jogos");
        bntJogo.setBorder(null);
        bntJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntJogoActionPerformed(evt);
            }
        });

        bntVenda.setBackground(new java.awt.Color(27, 58, 80));
        bntVenda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntVenda.setForeground(new java.awt.Color(255, 255, 255));
        bntVenda.setText("Vendas");
        bntVenda.setBorder(null);
        bntVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVendaActionPerformed(evt);
            }
        });

        bntFuncionario.setBackground(new java.awt.Color(27, 58, 80));
        bntFuncionario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        bntFuncionario.setText("Funcionários");
        bntFuncionario.setBorder(null);
        bntFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFuncionarioActionPerformed(evt);
            }
        });

        bntHome.setBackground(new java.awt.Color(27, 58, 80));
        bntHome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntHome.setForeground(new java.awt.Color(255, 255, 255));
        bntHome.setText("Home");
        bntHome.setBorder(null);
        bntHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntHomeActionPerformed(evt);
            }
        });

        bntSair.setBackground(new java.awt.Color(27, 58, 80));
        bntSair.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntSair.setForeground(new java.awt.Color(255, 255, 255));
        bntSair.setText("Sair");
        bntSair.setBorder(null);
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bntFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bntHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bntSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntHome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gamestock/imagens/telaprincipal_resized.png"))); // NOI18N

        javax.swing.GroupLayout painelInicialLayout = new javax.swing.GroupLayout(painelInicial);
        painelInicial.setLayout(painelInicialLayout);
        painelInicialLayout.setHorizontalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelInicialLayout.setVerticalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelConteudoLayout = new javax.swing.GroupLayout(painelConteudo);
        painelConteudo.setLayout(painelConteudoLayout);
        painelConteudoLayout.setHorizontalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelConteudoLayout.setVerticalGroup(
            painelConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntJogoActionPerformed
        mostrarTela(new TelaJogo());
    }//GEN-LAST:event_bntJogoActionPerformed

    private void bntVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVendaActionPerformed
        mostrarTela(new TelaVenda());
    }//GEN-LAST:event_bntVendaActionPerformed

    private void bntFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFuncionarioActionPerformed
        mostrarTela(new TelaFuncionario());
    }//GEN-LAST:event_bntFuncionarioActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowActivated

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        Object[] opcoes = {"Sim", "Não"};
        int confirm = JOptionPane.showOptionDialog(
                this,
                "Deseja realmente sair?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_bntSairActionPerformed

    private void bntHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntHomeActionPerformed
        mostrarTela(painelInicial);
    }//GEN-LAST:event_bntHomeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFuncionario;
    private javax.swing.JButton bntHome;
    private javax.swing.JButton bntJogo;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton bntVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelInicial;
    // End of variables declaration//GEN-END:variables
}
