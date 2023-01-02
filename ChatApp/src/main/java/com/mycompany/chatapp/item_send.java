package com.mycompany.chatapp;

public class item_send extends javax.swing.JLayeredPane {

    public item_send(String message, String infos) {
        initComponents();
        chatBulle.setText(message);
        infoChat.setText(infos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        infoChat = new javax.swing.JLabel();
        chatBulle = new com.mycompany.chatapp.Chat();

        infoChat.setText("pseudo | heure");

        chatBulle.setEditable(false);
        chatBulle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chatBulle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chatBulle.setBgColor(new java.awt.Color(134, 177, 204));

        setLayer(infoChat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(chatBulle, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoChat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(chatBulle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatBulle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.chatapp.Chat chatBulle;
    private javax.swing.JLabel infoChat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
