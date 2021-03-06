/*
 * Created on Oct 27, 2009
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
package org.fest.assertions;

import org.junit.*;
import org.junit.Assert;

/**
 * Tests for <code>{@link Condition#Condition(String)}</code>.
 *
 * @author Alex Ruiz
 */
public class Condition_constructorWithDescription_Test {

  @Test
  public void should_set_description_passed_in_constructor() {
    MyCondition c = new MyCondition("Hello World");
    Assert.assertEquals("Hello World", c.description());
  }

  private static class MyCondition extends Condition<Integer> {

    public MyCondition(String description) {
      super(description);
    }

    @Override   public boolean matches(Integer value) {
      return false;
    }

  }

}
