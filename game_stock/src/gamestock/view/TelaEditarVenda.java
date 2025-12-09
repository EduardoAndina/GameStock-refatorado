package gamestock.view;

import gamestock.controller.VendaController;
import gamestock.model.Venda;
import gamestock.service.VendaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class TelaEditarVenda extends javax.swing.JFrame {

    private VendaController controller;

    public TelaEditarVenda() {
        initComponents();
        controller = new VendaController(new VendaService(), null);
        configurarTabela();
        configurarBusca();
    }

    private void configurarTabela() {
        JTableHeader header = tableVenda.getTableHeader();
        header.setBackground(new Color(40, 40, 40));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        tableVenda.setBackground(new Color(30, 30, 30));
        tableVenda.setForeground(Color.WHITE);
        tableVenda.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tableVenda.setRowHeight(25);
        tableVenda.setGridColor(new Color(60, 60, 60));
        tableVenda.setShowHorizontalLines(true);
        tableVenda.setShowVerticalLines(false);
        tableVenda.setSelectionBackground(new Color(70, 130, 180));
        tableVenda.setSelectionForeground(Color.WHITE);
        tableVenda.setFocusable(false);

        atualizarTabela();
    }

    private void configurarBusca() {
        txtBuscarVenda.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
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
                String busca = txtBuscarVenda.getText().trim();
                if (busca.isEmpty()) {
                    atualizarTabela();
                } else {
                    atualizarTabela(busca);
                }
            }
        });
    }

    private void atualizarTabela() {
        tableVenda.setModel(montarTabela(controller.listarVendas()));
    }

    private void atualizarTabela(String busca) {
        tableVenda.setModel(montarTabela(controller.buscarPorJogoOuCliente(busca)));
    }

    private DefaultTableModel montarTabela(List<Venda> lista) {
        String[] colunas = {"ID", "ID Jogo", "Nome do Jogo", "Categoria", "Quantidade", "Valor Pago", "Nome Cliente", "Telefone"};
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
        for (Venda v : lista) {
            tabela.addRow(new Object[]{
                v.getId(), v.getIdJogo(), v.getNomeJogo(), v.getCategoria(),
                v.getQuantidadeVendida(), v.getValorPago(), v.getNomeCliente(), v.getTelefoneCliente()
            });
        }
        return tabela;
    }

    private Venda lerVendaDaTela() {
        try {
            int id = Integer.parseInt(txtIdVenda.getText().trim());
            int idJogo = Integer.parseInt(txtIdJogo.getText().trim());
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            double valorPago = Double.parseDouble(txtPreco.getText().trim());

            return new Venda(id, idJogo, txtNomeJogo.getText().trim(),
                    txtCategoria.getText().trim(), quantidade, valorPago,
                    txtNomeCliente.getText().trim(), txtTelefoneCliente.getText().trim());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preencha os campos numéricos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void limparCampos() {
        txtIdVenda.setText("");
        txtIdJogo.setText("");
        txtNomeJogo.setText("");
        txtCategoria.setText("");
        txtQuantidade.setText("");
        txtPreco.setText("");
        txtNomeCliente.setText("");
        txtTelefoneCliente.setText("");
    }

    private void selecionarVenda() {
        int linha = tableVenda.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela primeiro.");
            return;
        }

        txtIdVenda.setText(tableVenda.getValueAt(linha, 0).toString());
        txtIdJogo.setText(tableVenda.getValueAt(linha, 1).toString());
        txtNomeJogo.setText(tableVenda.getValueAt(linha, 2).toString());
        txtCategoria.setText(tableVenda.getValueAt(linha, 3).toString());
        txtQuantidade.setText(tableVenda.getValueAt(linha, 4).toString());
        txtPreco.setText(tableVenda.getValueAt(linha, 5).toString());
        txtNomeCliente.setText(tableVenda.getValueAt(linha, 6).toString());
        txtTelefoneCliente.setText(tableVenda.getValueAt(linha, 7).toString());
    }

    private void atualizarVenda() {
        Venda venda = lerVendaDaTela();
        if (venda == null) {
            return;
        }

        try {
            controller.atualizarVenda(venda);
            JOptionPane.showMessageDialog(this, "Venda atualizada com sucesso!");
            limparCampos();
            atualizarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
        txtNomeCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefoneCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        tableVenda = new javax.swing.JTable();
        txtBuscarVenda = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        bntRegistrarVenda = new javax.swing.JButton();
        txtIdVenda = new javax.swing.JTextField();
        txtIdJogo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jLabel2.setText("Pesquisar Venda aqui:");

        txtPreco.setEditable(false);
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
        jLabel3.setText("Id Venda");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome do Jogo");

        txtCategoria.setEditable(false);
        txtCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        bntSelecionarJogo.setBackground(new java.awt.Color(51, 152, 219));
        bntSelecionarJogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntSelecionarJogo.setForeground(new java.awt.Color(255, 255, 255));
        bntSelecionarJogo.setText("Selecionar Venda");
        bntSelecionarJogo.setBorder(null);
        bntSelecionarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSelecionarJogoActionPerformed(evt);
            }
        });

        txtNomeJogo.setEditable(false);
        txtNomeJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeJogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoria");

        txtNomeCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtNomeCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomeCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome do Cliente");

        txtTelefoneCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefoneCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelefoneCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefone do Cliente");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Quantidade");

        tableVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        JScrollPane.setViewportView(tableVenda);

        txtBuscarVenda.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        txtQuantidade.setEditable(false);
        txtQuantidade.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        bntRegistrarVenda.setBackground(new java.awt.Color(51, 152, 219));
        bntRegistrarVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntRegistrarVenda.setForeground(new java.awt.Color(255, 255, 255));
        bntRegistrarVenda.setText("Atualizar");
        bntRegistrarVenda.setBorder(null);
        bntRegistrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRegistrarVendaActionPerformed(evt);
            }
        });

        txtIdVenda.setEditable(false);
        txtIdVenda.setBackground(new java.awt.Color(255, 255, 255));
        txtIdVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        txtIdJogo.setEditable(false);
        txtIdJogo.setBackground(new java.awt.Color(255, 255, 255));
        txtIdJogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Id Jogo");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Valor Pago");

        jPanel2.setBackground(new java.awt.Color(30, 30, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Atualizar Venda");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtBuscarVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntSelecionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(bntRegistrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntSelecionarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bntRegistrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void bntSelecionarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSelecionarJogoActionPerformed
        selecionarVenda();
    }//GEN-LAST:event_bntSelecionarJogoActionPerformed

    private void bntRegistrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRegistrarVendaActionPerformed
        atualizarVenda();
    }//GEN-LAST:event_bntRegistrarVendaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        atualizarTabela();
        JScrollPane.setViewportView(tableVenda);
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(TelaEditarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton bntRegistrarVenda;
    private javax.swing.JButton bntSelecionarJogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tableVenda;
    private javax.swing.JTextField txtBuscarVenda;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtIdJogo;
    private javax.swing.JTextField txtIdVenda;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeJogo;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
