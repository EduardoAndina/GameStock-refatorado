package gamestock.view;

import gamestock.model.Jogo;
import gamestock.service.JogoService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaJogo extends javax.swing.JPanel {

    private final JogoService service;

    public TelaJogo() {
        initComponents();

        service = new JogoService();

        atualizarTabela();

        tableJogo.setGridColor(new java.awt.Color(44, 62, 80));

        javax.swing.table.JTableHeader header = tableJogo.getTableHeader();
        header.setBackground(new java.awt.Color(44, 62, 80));
        header.setForeground(java.awt.Color.WHITE);
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

        tableJogo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        tableJogo.setForeground(java.awt.Color.BLACK);

        atualizarTabela();

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
                    atualizarTabela();
                } else {
                    atualizarTabela(service.buscarPorNome(busca));
                }
            }
        });
    }

    private void atualizarTabela() {
        List<Jogo> lista = service.listarJogos();
        atualizarTabela(lista);
    }

    private void atualizarTabela(List<Jogo> lista) {
        String[] colunas = {"ID", "Nome", "Categoria", "Plataforma", "Preço", "Quantidade"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

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

        tableJogo.setModel(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarJogo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJogo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bntEditar = new javax.swing.JButton();
        bntCadastrar = new javax.swing.JButton();
        bntExcluir = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));

        jPanel1.setBackground(new java.awt.Color(27, 58, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 900));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciar Jogos");

        txtBuscarJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarJogo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtBuscarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarJogo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarJogo))
                .addGap(1300, 1300, 1300))
        );

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
        jScrollPane1.setViewportView(tableJogo);

        jPanel2.setBackground(new java.awt.Color(27, 58, 80));

        bntEditar.setBackground(new java.awt.Color(52, 152, 219));
        bntEditar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bntEditar.setForeground(new java.awt.Color(255, 255, 255));
        bntEditar.setText("Atualizar");
        bntEditar.setBorder(null);
        bntEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarActionPerformed(evt);
            }
        });

        bntCadastrar.setBackground(new java.awt.Color(76, 175, 80));
        bntCadastrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bntCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        bntCadastrar.setText("Cadastrar");
        bntCadastrar.setBorder(null);
        bntCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarActionPerformed(evt);
            }
        });

        bntExcluir.setBackground(new java.awt.Color(214, 69, 69));
        bntExcluir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bntExcluir.setForeground(new java.awt.Color(255, 255, 255));
        bntExcluir.setText("Excluir");
        bntExcluir.setBorder(null);
        bntExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(bntCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bntExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(188, 188, 188))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarActionPerformed
        TelaCadastroJogo cadastro = new TelaCadastroJogo();
        cadastro.setVisible(true);
    }//GEN-LAST:event_bntCadastrarActionPerformed

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed
        int linha = tableJogo.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um jogo para excluir.");
            return;
        }

        int id = Integer.parseInt(tableJogo.getValueAt(linha, 0).toString());
        String nome = tableJogo.getValueAt(linha, 1).toString();

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir \"" + nome + "\"?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            service.excluirJogo(id);
            JOptionPane.showMessageDialog(this, "Jogo excluído com sucesso!");
            atualizarTabela();
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_bntExcluirActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
        TelaEditarJogo te = new TelaEditarJogo();
        te.setVisible(true);
    }//GEN-LAST:event_bntEditarActionPerformed

    private void txtBuscarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarJogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarJogoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCadastrar;
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton bntExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJogo;
    private javax.swing.JTextField txtBuscarJogo;
    // End of variables declaration//GEN-END:variables
}
