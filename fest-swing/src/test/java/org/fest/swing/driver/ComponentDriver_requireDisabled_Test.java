/*
 * Created on Jul 19, 2009
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
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.test.core.CommonAssertions.failWhenExpectingException;

import org.junit.Test;

/**
 * Tests for <code>{@link ComponentDriver#requireDisabled(java.awt.Component)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ComponentDriver_requireDisabled_Test extends ComponentDriver_TestCase {

  @Test
  public void should_pass_if_Component_is_not_enabled() {
    disableButton();
    driver.requireDisabled(window.button);
  }

  @Test
  public void should_fail_if_Component_is_enabled() {
    try {
      driver.requireDisabled(window.button);
      failWhenExpectingException();
    } catch (AssertionError e) {
      assertThat(e.getMessage()).contains("property:'enabled'")
                                .contains("expected:<false> but was:<true>");
    }
  }
}
