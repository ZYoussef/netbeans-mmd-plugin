/*
 * Copyright 2016 Igor Maznitsa.
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
package com.igormaznitsa.mindmap.swing.panel.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class KeyShortcutTest {
  
  @Test
  public void testDoesShortcutConflict() {
    final KeyShortcut shortcut = new KeyShortcut("some", KeyEvent.VK_0, KeyEvent.SHIFT_MASK);
    assertFalse(shortcut.doesConflictWith(null));
    assertFalse(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_MASK)));
    assertFalse(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.SHIFT_MASK | KeyEvent.CTRL_MASK)));
    assertFalse(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK)));
    assertFalse(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK)));
    assertTrue(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_MASK | KeyEvent.CTRL_MASK)));
    assertTrue(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_MASK)));
    assertTrue(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK)));
    assertTrue(shortcut.doesConflictWith(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_DOWN_MASK)));
  }
  
}
