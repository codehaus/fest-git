/*
 * Created on Aug 2, 2009
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
 * Copyright @2009-2010 the original author or authors.
 */
package org.fest.swing.fixture;

import org.junit.*;

/**
 * Tests for <code>{@link WindowFixture#WindowFixture(java.awt.Window)}</code>.
 *
 * @author Alex Ruiz
 */
public class WindowFixture_constructorWithWindow_Test extends WindowFixture_TestCase {

  private ConcreteWindowFixture fixture;

  @After public void tearDown() {
    if (fixture != null) fixture.cleanUp();
  }

  @Test
  public void should_create_WindowFixture_with_given_Window() {
    fixture = new ConcreteWindowFixture(window);
    assertThatContainsExistingHierarchy(fixture);
    assertThatFixtureHandlesWindow(fixture, window);
  }
}
