/*
 * Created on Jan 28, 2010
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
package org.fest.javafx.maven;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.junit.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

import static java.io.File.separator;
import static java.lang.Thread.currentThread;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.util.Files.*;
import static org.fest.util.Strings.concat;

/**
 * Tests for <code>{@link JavaFxcClassLoaderFactory#createClassLoader(org.apache.tools.ant.types.Path)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 * @author Johannes Schneider
 */
public class JavaFxcClassLoaderFactory_createClassLoader_Test {

  private JavaFxcClassLoaderFactory classLoaderFactory;
  private File tempFileDir;
  private File tempFile;

  @Before
  public void setUp() {
    classLoaderFactory = new JavaFxcClassLoaderFactory();
    tempFileDir = newTemporaryFolder();
    tempFile = newFile(concat(tempFileDir.getPath(), separator, System.currentTimeMillis() + ".txt" ) );
    assertThat(tempFileDir.exists()).isTrue();
    assertThat(tempFile.getParentFile()).isEqualTo(tempFileDir);
  }

  @After
  public void tearDown() {
    tempFile.delete();
    delete(tempFileDir);
  }

  @Test
  public void should_create_ClassLoader_with_URLs_from_given_path() throws MalformedURLException {
    ClassLoader classLoader = classLoaderFactory.createClassLoader(path());
    assertThat(classLoader).isInstanceOf(URLClassLoader.class);
    URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
    assertThat(urlClassLoader.getURLs()).containsOnly(tempFile.toURI().toURL());
    assertThat(urlClassLoader.getParent()).isSameAs(currentThread().getContextClassLoader());
  }

  private Path path() {
    FileSet files = new FileSet();
    files.setDir(tempFileDir);
    files.createInclude().setName(concat("**/", tempFile.getName()));
    Path path = new Path(new Project());
    path.addFileset(files);
    return path;
  }
}
