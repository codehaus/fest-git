/*
 * Created on Aug 8, 2008
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
 * Copyright @2008-2010 the original author or authors.
 */
package org.fest.swing.gestures;

import static org.fest.swing.edt.GuiActionRunner.execute;

import javax.swing.JComboBox;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiTask;

/**
 * Shows/hides the drop-down menu of a <code>{@link JComboBox}</code>.
 *
 * @author Alex Ruiz
 *
 * @since 1.3
 */
final class JComboBoxSetPopupVisibleTask {

  @RunsInEDT
  static void setPopupVisible(final JComboBox comboBox, final boolean visible) {
    execute(new GuiTask() {
      @Override protected void executeInEDT() {
        comboBox.setPopupVisible(visible);
      }
    });
  }

  private JComboBoxSetPopupVisibleTask() {}
}