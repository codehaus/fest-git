/*
 * Created on Jun 9, 2008
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
package org.fest.swing.driver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.test.core.CommonAssertions.failWhenExpectingException;

import org.junit.Test;

/**
 * Tests for <code>{@link CommonValidations#validateCellWriter(Object)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class CommonValidations_validateCellWriter_Test {

  @Test
  public void should_not_throw_error_if_cellWriter_is_not_null() {
    CommonValidations.validateCellWriter(new Object());
  }

  @Test
  public void shouldthrow_error_if_cellWriter_is_null() {
    try {
      CommonValidations.validateCellWriter(null);
      failWhenExpectingException();
    } catch (NullPointerException e) {
      assertThat(e.getMessage()).isEqualTo("Cell writer should not be null");
    }
  }
}
