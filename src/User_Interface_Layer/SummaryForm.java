/*
 * File Name: SummaryForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Data_Source_Layer.PropertyInventory;
import Data_Source_Layer.UserInfo;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryForm extends InteractionForm {
    public SummaryForm() {
        myInventory = new PropertyInventory();
    }

    private PropertyInventory myInventory;
    private UserInfo myUserInfo;

    public void showSummary() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JButton jButton1;
        JScrollPane jScrollPane1;
        JScrollPane jScrollPane2;
        JScrollPane jScrollPane3;
        JTextArea jTextArea1;
        JTextArea jTextArea2;
        JTextArea jTextArea3;
    }
}