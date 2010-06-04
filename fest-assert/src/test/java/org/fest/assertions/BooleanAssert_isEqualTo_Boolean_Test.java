/*
 * Created on Apr 24, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.fest.test.ExpectedFailure.expectAssertionError;

import org.fest.test.CodeToTest;
import org.junit.Test;

/**
 * Tests for <code>{@link BooleanAssert#isEqualTo(boolean)}</code>.
 *
 * @author Ansgar Konermann
 * @author Alex Ruiz
 */
public class BooleanAssert_isEqualTo_Boolean_Test implements Assert_isEqualTo_TestCase {

  @Test
  public void should_pass_if_actual_and_expected_are_equal() {
    new BooleanAssert(false).isEqualTo(FALSE);
  }

  @Test
  public void should_fail_if_actual_and_expected_are_not_equal() {
    expectAssertionError("expected:<true> but was:<false>").on(new CodeToTest() {
      public void run() {
        new BooleanAssert(false).isEqualTo(TRUE);
      }
    });
  }

  @Test
  public void should_fail_and_display_description_of_assertion_if_actual_and_expected_are_not_equal() {
    expectAssertionError("[A Test] expected:<true> but was:<false>").on(new CodeToTest() {
      public void run() {
        new BooleanAssert(false).as("A Test")
                                .isEqualTo(TRUE);
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_if_actual_and_expected_are_not_equal() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new BooleanAssert(false).overridingErrorMessage("My custom message")
                                .isEqualTo(TRUE);
      }
    });
  }

  @Test
  public void should_fail_with_custom_message_ignoring_description_of_assertion_if_actual_and_expected_are_not_equal() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        new BooleanAssert(false).as("A Test")
                                .overridingErrorMessage("My custom message")
                                .isEqualTo(TRUE);
      }
    });
  }
}
