/*
 * Created on Jun 6, 2009
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
package org.fest.swing.core;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.fest.assertions.Assertions.assertThat;

import java.awt.Component;

import org.fest.mocks.EasyMockTemplate;
import org.junit.Test;

/**
 * Tests for <code>{@link AbstractComponentMatcher#requireShowingMatches(Component)}</code>.
 *
 * @author Alex Ruiz
 */
public class AbstractComponentMatcher_requireShowingMatches_Test {

  @Test
  public void should_always_match_if_requireShowing_is_false() {
    AbstractComponentMatcher matcher = new ConcreteComponentMatcher(false);
    Component c = mockComponent();
    assertThat(matcher.requireShowingMatches(c)).isTrue();
  }

  @Test
  public void should_match_if_requireShowing_is_true_and_Component_is_showing() {
    final AbstractComponentMatcher matcher = new ConcreteComponentMatcher(true);
    final Component c = mockComponent();
    new EasyMockTemplate(c) {
      protected void expectations() {
        expect(c.isShowing()).andReturn(true);
      }

      protected void codeToTest() {
        assertThat(matcher.requireShowingMatches(c)).isTrue();
      }
    }.run();
  }

  @Test
  public void should_not_match_if_requireShowing_is_true_and_Component_is_not_showing() {
    final AbstractComponentMatcher matcher = new ConcreteComponentMatcher(true);
    final Component c = mockComponent();
    new EasyMockTemplate(c) {
      protected void expectations() {
        expect(c.isShowing()).andReturn(false);
      }

      protected void codeToTest() {
        assertThat(matcher.requireShowingMatches(c)).isFalse();
      }
    }.run();
  }

  private static Component mockComponent() {
    return createMock(Component.class);
  }
}
