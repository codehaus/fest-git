/*
 * Created on Jun 18, 2007
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
 * Copyright @2007-2010 the original author or authors.
 */
package org.fest.assertions;

/**
 * Tests for:
 * <ul>
 * <li><code>{@link IntAssert#as(Description)}</code></li>
 * <li><code>{@link IntAssert#as(String)}</code></li>
 * <li><code>{@link IntAssert#describedAs(Description)}</code></li>
 * <li><code>{@link IntAssert#describedAs(String)}</code></li>
 * </ul>
 *
 * @author Yvonne Wang
 * @author David DIDIER
 */
public class IntAssert_description_Test extends GenericAssert_description_TestCase<Integer> {

  @Override protected IntAssert assertionToTest() {
    return new IntAssert(8);
  }
}
