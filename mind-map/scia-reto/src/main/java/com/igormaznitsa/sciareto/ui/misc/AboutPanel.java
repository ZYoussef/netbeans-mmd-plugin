/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.sciareto.ui.misc;

import com.igormaznitsa.mindmap.model.logger.Logger;
import com.igormaznitsa.mindmap.model.logger.LoggerFactory;
import java.net.URI;
import java.util.Properties;
import com.igormaznitsa.mindmap.model.MindMap;
import com.igormaznitsa.mindmap.plugins.api.MindMapPlugin;
import com.igormaznitsa.sciareto.Main;
import com.igormaznitsa.sciareto.ui.UiUtils;

public final class AboutPanel extends javax.swing.JPanel implements JHtmlLabel.LinkListener {

  private static final long serialVersionUID = -3231534203788095969L;

  private static final Logger LOGGER = LoggerFactory.getLogger(AboutPanel.class);
  
  public AboutPanel() {
    initComponents();

    final String pluginAPIVersion = MindMapPlugin.API.toString();
    final String formatVersion = MindMap.FORMAT_VERSION;

    final Properties props = new Properties();
    props.setProperty("plugin.api", pluginAPIVersion); //NOI18N
    props.setProperty("format.version", formatVersion); //NOI18N
    props.setProperty("ideversion", Main.IDE_VERSION.toString()); //NOI18N
    props.setProperty("ideversion", Main.IDE_VERSION.toString()); //NOI18N

    this.textLabel.replaceMacroses(props);
    this.textLabel.addLinkListener(this);
    this.textLabel.setShowLinkAddressInTooltip(true);
  }

  @Override
  public void onLinkActivated(final JHtmlLabel source, final String href) {
    try{
      UiUtils.browseURI(new URI(href), false);
    }catch(Exception ex){
      LOGGER.error("Can't process link in 'About'", ex); //NOI18N
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    labelIcon = new javax.swing.JLabel();
    textLabel = new com.igormaznitsa.sciareto.ui.misc.JHtmlLabel();
    donateButton1 = new com.igormaznitsa.sciareto.ui.misc.DonateButton();

    setLayout(new java.awt.GridBagLayout());

    labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo64x64.png"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
    add(labelIcon, gridBagConstraints);

    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/igormaznitsa/nbmindmap/i18n/Bundle"); // NOI18N
    textLabel.setText(bundle.getString("AboutText")); // NOI18N
    textLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    textLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(0, 16, 16, 16);
    add(textLabel, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    add(donateButton1, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private com.igormaznitsa.sciareto.ui.misc.DonateButton donateButton1;
  private javax.swing.JLabel labelIcon;
  private com.igormaznitsa.sciareto.ui.misc.JHtmlLabel textLabel;
  // End of variables declaration//GEN-END:variables
}
