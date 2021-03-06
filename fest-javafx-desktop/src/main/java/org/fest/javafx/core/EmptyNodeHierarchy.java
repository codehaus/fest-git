/*
 * Created on May 31, 2010
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
 * Copyright @2010 the original author or authors.
 */
package org.fest.javafx.core;

import static java.util.Collections.emptyList;
import static org.fest.javafx.util.Sequences.emptySequence;

import java.util.Collection;
import javafx.scene.Node;
import javafx.scene.Scene;

import com.sun.javafx.runtime.sequence.Sequence;

/**
 * Understands an empty <code>{@link NodeHierarchy}</code>.
 *
 * @author Alex Ruiz
 */
class EmptyNodeHierarchy implements NodeHierarchy {

  @Override public Sequence<? extends Node> contents() {
    return emptySequence(Node.class);
  }

  @Override public Collection<Scene> roots() {
    return emptyList();
  }

  @Override public Sequence<? extends Node> childrenOf(Node parent) {
    return emptySequence(Node.class);
  }
}
