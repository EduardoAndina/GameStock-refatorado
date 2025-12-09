package gamestock.view;

import gamestock.service.JogoService;
import gamestock.model.Jogo;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TelaEditarJogo extends javax.swing.JFrame {

    public TelaEditarJogo() {
        initComponents();

        JTableHeader header = tableJogo.getTableHeader();
        header.setBackground(new Color(40, 40, 40));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        tableJogo.setBackground(new Color(30, 30, 30));
        tableJogo.setForeground(Color.WHITE);
        tableJogo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tableJogo.setRowHeight(25);
        tableJogo.setGridColor(new Color(60, 60, 60));
        tableJogo.setShowHorizontalLines(true);
        tableJogo.setShowVerticalLines(false);

        tableJogo.setSelectionBackground(new Color(70, 130, 180));
        tableJogo.setSelectionForeground(Color.WHITE);
        tableJogo.setFocusable(false);

        txtBuscarJogo.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                buscar();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                buscar();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                buscar();
            }

            private void buscar() {
                String busca = txtBuscarJogo.getText().trim();
                if (busca.isEmpty()) {
                    tableJogo.setModel(montarTabela());
                } else {
                    tableJogo.setModel(montarTabelaBusca(busca));
                }
            }
        });
    }

    private DefaultTableModel montarTabela() {
        String[] colunas = {"ID", "Nome", "Categoria", "Plataforma", "Preço", "Quantidade"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        JogoService service = new JogoService();
        List<Jogo> lista = service.listarJogos();

        for (Jogo j : lista) {
            tabela.addRow(new Object[]{
                j.getId(),
                j.getNome(),
                j.getCategoria(),
                j.getPlataforma(),
                j.getPreco(),
                j.getQuantidade()
            });
        }
        return tabela;
    }

    private DefaultTableModel montarTabelaBusca(String busca) {
        String[] colunas = {"ID", "Nome", "Categoria", "Plataforma", "Preço", "Quantidade"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        JogoService service = new JogoService();
        List<Jogo> lista = service.buscarPorNome(busca);

        for (Jogo j : lista) {
            tabela.addRow(new Object[]{
                j.getId(),
                j.getNome(),
                j.getCategoria(),
                j.getPlataforma(),
                j.getPreco(),
                j.getQuantidade()
            });
        }
        return tabela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        bntSelecionarJogo = new javax.swing.JButton();
        txtNomeJogo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        tableJogo = new javax.swing.JTable();
        txtBuscarJogo = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        bntAtualizar = new javax.swing.JButton();
        txtIdJogo = new javax.swing.JTextField();
        cbPlataforma = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setForeground(new java.awt.Color(245, 245, 245));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pesquisar Jogo aqui:");

        txtPreco.setBackground(new java.awt.Color(255, 255, 255));
        txtPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPreco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Categoria");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Preço");

        txtCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        bntSelecionarJogo.setBackground(new java.awt.Color(51, 152, 219));
        bntSelecionarJogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntSelecionarJogo.setForeground(new java.awt.Color(255, 255, 255));
        bntSelecionarJogo.setText("Selecionar Jogo");
        bntSelecionarJogo.setBorder(null);
        bntSelecionarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSelecionarJogoActionPerformed(evt);
            }
        });

        txtNomeJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeJogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Id Jogo");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nome Jogo");

        tableJogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JScrollPane.setViewportView(tableJogo);

        txtBuscarJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarJogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        txtBuscarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarJogoActionPerformed(evt);
            }
        });

        txtQuantidade.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        bntAtualizar.setBackground(new java.awt.Color(51, 152, 219));
        bntAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        bntAtualizar.setText("Atualizar");
        bntAtualizar.setBorder(null);
        bntAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAtualizarActionPerformed(evt);
            }
        });

        txtIdJogo.setEditable(false);
        txtIdJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtIdJogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        cbPlataforma.setBackground(new java.awt.Color(255, 255, 255));
        cbPlataforma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPlataforma.setForeground(new java.awt.Color(0, 0, 0));
        cbPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xbox", "Nintendo Switch", "Playstation" }));
        cbPlataforma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Plataforma");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Quantidade");

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));
        jPanel2.setForeground(new java.awt.Color(30, 30, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 49));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atualizar Jogo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarJogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntSelecionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSelecionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bntAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void bntSelecionarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSelecionarJogoActionPerformed
        int linhaSelecionada = tableJogo.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um jogo na tabela primeiro.");
        } else {
            String id = tableJogo.getValueAt(linhaSelecionada, 0).toString();
            String nome = tableJogo.getValueAt(linhaSelecionada, 1).toString();
            String categoria = tableJogo.getValueAt(linhaSelecionada, 2).toString();
            String plataforma = tableJogo.getValueAt(linhaSelecionada, 3).toString();
            String preco = tableJogo.getValueAt(linhaSelecionada, 4).toString();
            String quantidade = tableJogo.getValueAt(linhaSelecionada, 5).toString();

            txtIdJogo.setText(id);
            txtNomeJogo.setText(nome);
            txtCategoria.setText(categoria);
            txtPreco.setText(preco);
            txtQuantidade.setText(quantidade);
        }
    }//GEN-LAST:event_bntSelecionarJogoActionPerformed

    private void bntAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAtualizarActionPerformed
        try {
            Jogo jogoAtualizado = new Jogo();
            jogoAtualizado.setId(Integer.parseInt(txtIdJogo.getText()));
            jogoAtualizado.setNome(txtNomeJogo.getText());
            jogoAtualizado.setCategoria(txtCategoria.getText());
            jogoAtualizado.setPlataforma((String) cbPlataforma.getSelectedItem());
            jogoAtualizado.setPreco(Double.parseDouble(txtPreco.getText()));
            jogoAtualizado.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

            JogoService service = new JogoService();
            boolean sucesso = service.atualizar(jogoAtualizado);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Jogo atualizado com sucesso!");
                tableJogo.setModel(montarTabela());
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma atualização realizada.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_bntAtualizarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        tableJogo.setModel(montarTabela());
        JScrollPane.setViewportView(tableJogo);
    }//GEN-LAST:event_formWindowGainedFocus

    private void txtBuscarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarJogoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton bntAtualizar;
    private javax.swing.JButton bntSelecionarJogo;
    private javax.swing.JComboBox<String> cbPlataforma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tableJogo;
    private javax.swing.JTextField txtBuscarJogo;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtIdJogo;
    private javax.swing.JTextField txtNomeJogo;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
