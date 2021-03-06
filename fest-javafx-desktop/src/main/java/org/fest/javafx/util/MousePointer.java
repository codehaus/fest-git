/*
 * Created on May 27, 2010
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
package org.fest.javafx.util;

import java.awt.MouseInfo;

/**
 * Understands utility methods related to the mouse pointer.
 *
 * @author Alex Ruiz
 */
public final class MousePointer {

  /**
   * Returns the coordinates of the mouse pointer on the screen.
   * @return the coordinates of the mouse pointer on the screen.
   */
  public static Point mousePointerOnScreen() {
    java.awt.Point location = MouseInfo.getPointerInfo().getLocation();
    return new Point(location.x, location.y);
  }

  private MousePointer() {}
}
