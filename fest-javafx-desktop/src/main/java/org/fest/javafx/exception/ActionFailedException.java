/*
 * Created on May 5, 2010
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
package org.fest.javafx.exception;

/**
 * Understands an error occurred when simulation of user input fails.
 *
 * @author Yvonne Wang
 */
public class ActionFailedException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a new <code>{@link ActionFailedException}</code>.
   * @param message the detail message.
   * @return the created exception.
   */
  public static ActionFailedException actionFailure(String message) {
    return new ActionFailedException(message);
  }
  
  /**
   * Creates a new <code>{@link ActionFailedException}</code>.
   * @param message the detail message.
   * @param cause the cause of the error.
   * @return the created exception.
   */
  public static ActionFailedException actionFailure(String message, Throwable cause) {
    return new ActionFailedException(message, cause);
  }

  private ActionFailedException(String message) {
    super(message);
  }

  private ActionFailedException(String message, Throwable cause) {
    super(message, cause);
  }
}
