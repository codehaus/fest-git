/*
 * Created on 2010-4-16
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
 * Copyright @2007-2010 the original author or authors.
 */

package org.fest.assertions;

public class FloatAssert_satisfies_Test extends GenericAssert_satisfies_TestBase<Float> {

  @Override
  protected GenericAssert<Float> createInstanceFromOne() {
    return new FloatAssert(1.0f);
  }

  @Override
  protected GenericAssert<Float> createInstanceFromNullReference() {
    return new FloatAssert(null);
  }
}