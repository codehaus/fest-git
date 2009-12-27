/*
 * Created on Dec 26, 2009
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
 * Copyright @2009 the original author or authors.
 */
package org.fest.swing.fixture;

import javax.swing.JTree;

/**
 * Understands functional testing of single nodes, referenced by their row indices, in <code>{@link JTree}</code>s:
 * <ul>
 * <li>user input simulation</li>
 * <li>state verification</li>
 * <li>property value query</li>
 * </ul>
 *
 * @author Alex Ruiz
 *
 * @since 1.2
 */
public class JTreeRowFixture implements JTreeNodeFixture {

  /** The row index of the node. */
  public final int index;

  /**
   * Creates a new </code>{@link JTreeRowFixture}</code>.
   * @param index the given row index.
   */
  public JTreeRowFixture(int index) {
    this.index = index;
  }
}
