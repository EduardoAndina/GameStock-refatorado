package gamestock.view;

import gamestock.model.Venda;
import gamestock.service.VendaService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class TelaVenda extends javax.swing.JPanel {

    private final VendaService service;

    public TelaVenda() {
        initComponents();

        service = new VendaService();

        tableVendas.setGridColor(new java.awt.Color(44, 62, 80));

        javax.swing.table.JTableHeader header = tableVendas.getTableHeader();
        header.setBackground(new java.awt.Color(44, 62, 80));
        header.setForeground(java.awt.Color.WHITE);
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

        tableVendas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        tableVendas.setForeground(java.awt.Color.BLACK);

        atualizarTabela();

        txtBuscarPorJogoeCliente.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

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
                String busca = txtBuscarPorJogoeCliente.getText().trim();
                List<Venda> lista;
                if (busca.isEmpty()) {
                    lista = service.listar();
                } else {
                    lista = service.buscar(busca);
                }
                atualizarTabela(lista);
            }
        });
    }

    private void atualizarTabela() {
        List<Venda> lista = service.listar();
        atualizarTabela(lista);
    }

    private void atualizarTabela(List<Venda> lista) {
        String[] colunas = {"ID", "ID Jogo", "Nome do Jogo", "Categoria", "Qtd Vendida", "Valor Pago", "Cliente", "Telefone"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        if (lista != null) {
            for (Venda v : lista) {
                tabela.addRow(new Object[]{
                    v.getId(),
                    v.getIdJogo(),
                    v.getNomeJogo(),
                    v.getCategoria(),
                    v.getQuantidadeVendida(),
                    v.getValorPago(),
                    v.getNomeCliente(),
                    v.getTelefoneCliente()
                });
            }
        }

        tableVendas.setModel(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarPorJogoeCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));

        jPanel1.setBackground(new java.awt.Color(27, 58, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 900));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciador de Vendas");

        txtBuscarPorJogoeCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarPorJogoeCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorJogoeCliente)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarPorJogoeCliente))
                .addGap(1300, 1300, 1300))
        );

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableVendas);

        jPanel3.setBackground(new java.awt.Color(27, 58, 80));

        jButton14.setBackground(new java.awt.Color(52, 152, 219));
        jButton14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Atualizar");
        jButton14.setBorder(null);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(76, 175, 80));
        btnCadastrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(null);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(214, 69, 69));
        btnExcluir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(188, 188, 188))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroVenda cadastro = new TelaCadastroVenda();
        cadastro.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableVendas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda para excluir.");
            return;
        }

        int id = Integer.parseInt(tableVendas.getValueAt(linha, 0).toString());
        String cliente = tableVendas.getValueAt(linha, 6).toString();

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir a venda de \"" + cliente + "\"?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            service.excluir(id);
            JOptionPane.showMessageDialog(this, "Venda excluída com sucesso!");
            atualizarTabela();
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        TelaEditarVenda te = new TelaEditarVenda();
        te.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVendas;
    private javax.swing.JTextField txtBuscarPorJogoeCliente;
    // End of variables declaration//GEN-END:variables
}
