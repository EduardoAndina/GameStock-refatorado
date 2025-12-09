package gamestock.view;

import gamestock.model.Funcionario;
import gamestock.service.FuncionarioService;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class TelaFuncionario extends javax.swing.JPanel {

    private final FuncionarioService service;

    public TelaFuncionario() {
        initComponents();

        service = new FuncionarioService();

        tableFuncionario.setGridColor(new java.awt.Color(44, 62, 80));

        javax.swing.table.JTableHeader header = tableFuncionario.getTableHeader();
        header.setBackground(new java.awt.Color(44, 62, 80));
        header.setForeground(java.awt.Color.WHITE);
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

        tableFuncionario.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        tableFuncionario.setForeground(java.awt.Color.BLACK);

        atualizarTabela();

        txtBuscarFuncionario.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

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
                String busca = txtBuscarFuncionario.getText().trim();
                List<Funcionario> lista;
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
        List<Funcionario> lista = null;
        try {
            lista = service.listar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar funcionários: " + e.getMessage());
        }

        atualizarTabela(lista);
    }

    private void atualizarTabela(List<Funcionario> lista) {
        String[] colunas = {"ID", "Nome", "Usuário", "Senha"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        if (lista != null) {
            for (Funcionario f : lista) {
                tabela.addRow(new Object[]{
                    f.getId(),
                    f.getNome(),
                    f.getUsuario(),
                    f.getSenha()
                });
            }
        }
        tableFuncionario.setModel(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarFuncionario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        bntExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFuncionario = new javax.swing.JTable();

        setBackground(new java.awt.Color(34, 34, 34));

        jPanel1.setBackground(new java.awt.Color(27, 58, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 900));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciador de Funcionários");

        txtBuscarFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarFuncionario)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarFuncionario))
                .addGap(1300, 1300, 1300))
        );

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

        jButton15.setBackground(new java.awt.Color(76, 175, 80));
        jButton15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Cadastrar");
        jButton15.setBorder(null);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bntExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(188, 188, 188))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableFuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGap(62, 62, 62)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        TelaCadastroFuncionario cadastro = new TelaCadastroFuncionario();
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed
        int linha = tableFuncionario.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir.");
            return;
        }

        int id = Integer.parseInt(tableFuncionario.getValueAt(linha, 0).toString());
        String nome = tableFuncionario.getValueAt(linha, 1).toString();

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
            service.excluir(id);
            JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
            atualizarTabela();
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_bntExcluirActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        TelaEditarFuncionario te = new TelaEditarFuncionario();
        te.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntExcluir;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFuncionario;
    private javax.swing.JTextField txtBuscarFuncionario;
    // End of variables declaration//GEN-END:variables
}
