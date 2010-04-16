/*
 * Created on Mar 31, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.keyboard.mapping;

import java.awt.Rectangle;
import java.io.*;

import org.fest.util.VisibleForTesting;

import static java.awt.event.KeyEvent.*;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JOptionPane.*;
import static javax.swing.KeyStroke.getKeyStroke;

import static org.fest.keyboard.mapping.CharMapping.newCharMapping;
import static org.fest.util.Strings.*;

/**
 * Understands the application's main window.
 *
 * @author Alex Ruiz
 */
public class MainFrame extends javax.swing.JFrame {

  private static final long serialVersionUID = 1L;

  private static final String TAB_OUT_ACTION_KEY = "tabOut";

  private final CharMappingFileFactory fileFactory;
  private AboutDialog aboutDialog;

  /**
   * Creates a new </code>{@link MainFrame}</code>.
   */
  public MainFrame() {
    this(new CharMappingFileFactory());
  }

  @VisibleForTesting
  MainFrame(CharMappingFileFactory fileFactory) {
    this.fileFactory = fileFactory;
    initComponents();
    addTabOutActionToMappingTable();
    setIconImage(new javax.swing.ImageIcon(getClass().getResource("/fest16.png")).getImage()); // NOI18N
  }

  private void addTabOutActionToMappingTable() {
    mappingTable.getInputMap(WHEN_FOCUSED).put(getKeyStroke(VK_TAB, 0), TAB_OUT_ACTION_KEY);
    mappingTable.getActionMap().put(TAB_OUT_ACTION_KEY, new TabOutAction());
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    saveMappingFileChooser = new javax.swing.JFileChooser();
    tableScrollPane = new javax.swing.JScrollPane();
    mappingTable = new javax.swing.JTable();
    charLabel = new javax.swing.JLabel();
    charTextField = new javax.swing.JTextField();
    menuBar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    createMappingFileMenu = new javax.swing.JMenuItem();
    helpMenu = new javax.swing.JMenu();
    aboutMenuItem = new javax.swing.JMenuItem();

    saveMappingFileChooser.setAcceptAllFileFilterUsed(false);
    saveMappingFileChooser.setDialogTitle("Save As Mapping File");
    saveMappingFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
    saveMappingFileChooser.setFileFilter(new TextFileFilter());
    saveMappingFileChooser.setName("saveMappingFileChooser"); // NOI18N

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("FEST Keyboard Mapping Tool");
    setMinimumSize(new java.awt.Dimension(260, 240));
    setName("mainFrame"); // NOI18N

    mappingTable.setModel(new BasicCharMappingTableModel());
    mappingTable.setName("mappingTable"); // NOI18N
    mappingTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    mappingTable.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        keyPressedOnMappingTable(evt);
      }
    });
    tableScrollPane.setViewportView(mappingTable);

    charLabel.setDisplayedMnemonic('E');
    charLabel.setLabelFor(charTextField);
    charLabel.setText("Enter the character to map:");

    charTextField.setDocument(new MaxLengthDocument());
    charTextField.setName("charTextField"); // NOI18N
    charTextField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        charEntered(evt);
      }
    });

    fileMenu.setMnemonic('F');
    fileMenu.setText("File");

    createMappingFileMenu.setMnemonic('S');
    createMappingFileMenu.setText("Save As Mapping File");
    createMappingFileMenu.setEnabled(false);
    createMappingFileMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveAsMappingFile(evt);
      }
    });
    fileMenu.add(createMappingFileMenu);

    menuBar.add(fileMenu);

    helpMenu.setMnemonic('H');
    helpMenu.setLabel("Help");

    aboutMenuItem.setMnemonic('A');
    aboutMenuItem.setText("About");
    aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        showAboutWindow(evt);
      }
    });
    helpMenu.add(aboutMenuItem);

    menuBar.add(helpMenu);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
          .addComponent(charTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
          .addComponent(charLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(charLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(charTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void charEntered(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_charEntered
    try {
      addMapping(newCharMapping(evt));
    } catch (MappingNotFoundError ignored) {}
  }//GEN-LAST:event_charEntered

  private void saveAsMappingFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMappingFile
    int selection = saveMappingFileChooser.showSaveDialog(this);
    if (selection != APPROVE_OPTION) return;
    File toSave = saveMappingFileChooser.getSelectedFile();
    try {
      fileFactory.createMappingFile(toSave, mappingTableModel());
      showFileSaveActionSuccessMessage(toSave);
    } catch (IOException e) {
      showSaveFileActionFailedMessage(e.getMessage());
    }
  }//GEN-LAST:event_saveAsMappingFile

  private void keyPressedOnMappingTable(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressedOnMappingTable
    if (evt.getKeyCode() != VK_DELETE) return;
    if (mappingTable.getSelectedRowCount() == 0) return;
    deleteSelectedRows();
  }//GEN-LAST:event_keyPressedOnMappingTable

  private void showAboutWindow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAboutWindow
    if (aboutDialog == null) aboutDialog = new AboutDialog(this, true);
    aboutDialog.setLocationRelativeTo(this);
    aboutDialog.setVisible(true);
  }//GEN-LAST:event_showAboutWindow

  private void showFileSaveActionSuccessMessage(File file) {
    String message = concat("File ", quote(file.getName()), " successfully saved.");
    showMessageDialog(this, message, "Success", INFORMATION_MESSAGE);
  }

  private void showSaveFileActionFailedMessage(String cause) {
    String message = concat("Unable to save file: [", cause, "]");
    showMessageDialog(this, message, "Error", ERROR_MESSAGE);
  }
  
  private void addMapping(CharMapping mapping) {
    mappingTableModel().addOrReplace(mapping);
    selectAndScrollToLastRow();
    updateUI();
  }

  private void deleteSelectedRows() {
    int selectedRow = mappingTable.getSelectedRow();
    BasicCharMappingTableModel model = mappingTableModel();
    while (selectedRow != -1) {
      model.removeRow(selectedRow);
      selectedRow = mappingTable.getSelectedRow();
    }
    updateUI();
  }

  private void selectAndScrollToLastRow() {
    int lastRowIndex = mappingTableModel().lastRowIndex();
    if (lastRowIndex >= 0) {
      scrollToRow(lastRowIndex);
      mappingTable.setRowSelectionInterval(lastRowIndex, lastRowIndex);
    }
  }

  private void scrollToRow(int row) {
    Rectangle rect = mappingTable.getCellRect(row, 0, true);
    mappingTable.scrollRectToVisible(rect);
  }

  private BasicCharMappingTableModel mappingTableModel() {
    return (BasicCharMappingTableModel)mappingTable.getModel();
  }

  private void updateUI() {
    createMappingFileMenu.setEnabled(mappingTable.getRowCount() > 0);
  }

  void giveFocusToCharTextField() {
    charTextField.requestFocusInWindow();
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem aboutMenuItem;
  private javax.swing.JLabel charLabel;
  private javax.swing.JTextField charTextField;
  private javax.swing.JMenuItem createMappingFileMenu;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenu helpMenu;
  private javax.swing.JTable mappingTable;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JFileChooser saveMappingFileChooser;
  private javax.swing.JScrollPane tableScrollPane;
  // End of variables declaration//GEN-END:variables
}
