package com.mycompany.chatapp;

public class item_recep extends javax.swing.JLayeredPane {

    public item_recep(String message, String infos) {
        initComponents();
        chatBulle.setText(message);
        infoChat.setText(infos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chatBulle = new com.mycompany.chatapp.Chat();
        infoChat = new javax.swing.JLabel();

        chatBulle.setEditable(false);
        chatBulle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chatBulle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chatBulle.setBgColor(new java.awt.Color(173, 174, 255));

        infoChat.setText("pseudo | heure");

        setLayer(chatBulle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(infoChat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatBulle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addComponent(infoChat))
                .addGap(14, 14, 14))
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
    // End of variables declaration//GEN-END:variables
}
