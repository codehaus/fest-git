/*
 * Created on Feb 14, 2008
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
 * Copyright @2008-2010 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ArrayFactory.floatArray;

import org.junit.BeforeClass;

/**
 * Tests for <code>{@link FloatArrayAssert#isEmpty()}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FloatArrayAssert_isEmpty_Test extends GroupAssert_isEmpty_TestCase<float[]> {

  private static float[] empty;
  private static float[] notEmpty;

  @BeforeClass
  public static void setUpOnce() {
    empty = new float[0];
    notEmpty = floatArray(6f, 8f);
  }

  @Override protected FloatArrayAssert assertionsFor(float[] actual) {
    return new FloatArrayAssert(actual);
  }

  @Override protected float[] emptyGroup() {
    return empty;
  }

  @Override protected float[] notEmptyGroup() {
    return notEmpty;
  }
}
