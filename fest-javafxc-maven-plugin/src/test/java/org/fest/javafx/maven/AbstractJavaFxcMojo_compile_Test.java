/*
 * Created on Jan 24, 2010
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

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.tools.ant.taskdefs.Javac;
import org.fest.mocks.EasyMockTemplate;
import org.junit.*;

import java.io.File;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.fest.javafx.maven.JavaFxJarsInclusion.AUTOMATIC;
import static org.fest.util.Files.temporaryFolder;

/**
 * Tests for <code>{@link AbstractJavaFxcMojo#compile()}</code>.
 *
 * @author Alex Ruiz
 */
public class AbstractJavaFxcMojo_compile_Test {

  private JavaFxcMojoValidator validator;
  private JavaFxHome javaFxHome;
  private JavaFxcFactory javaFxcFactory;
  private JavaFxcSetup javaFxcSetup;
  private AntTaskExecutor javaFxcExecutor;
  private AbstractJavaFxcMojoStub javaFxcMojo;

  @Before
  public void setUp() {
    validator = createMock(JavaFxcMojoValidator.class);
    javaFxHome = createMock(JavaFxHome.class);
    javaFxcFactory = createMock(JavaFxcFactory.class);
    javaFxcSetup = createMock(JavaFxcSetup.class);
    javaFxcExecutor = createMock(AntTaskExecutor.class);
    javaFxcMojo = new AbstractJavaFxcMojoStub();
    configureMojo();
  }

  private void configureMojo() {
    javaFxcMojo.validator = validator;
    javaFxcMojo.javaFxHomeRef = javaFxHome;
    javaFxcMojo.javaFxcFactory = javaFxcFactory;
    javaFxcMojo.javaFxcSetup = javaFxcSetup;
    javaFxcMojo.javaFxcExecutor = javaFxcExecutor;
    File temporaryFolder = temporaryFolder();
    javaFxcMojo.sourceDirectory = temporaryFolder;
    javaFxcMojo.outputDirectory = temporaryFolder;
    javaFxcMojo.setLog(new LogStub());
  }

  @Test
  public void should_create_and_execute_JavaFX_compiler_Ant_task() {
    final String verifiedJavaFXHome = "c:\\javafx";
    final File javaFXHomeDir = new File("mock");
    final Javac javaFxc = new Javac();
    new EasyMockTemplate(javaFxHome, javaFxcFactory, javaFxcSetup, javaFxcExecutor) {
      @Override protected void expectations() throws MojoExecutionException {
        validator.validate(javaFxcMojo);
        expectLastCall().once();
        expect(javaFxHome.verify(javaFxcMojo.javaFxHome)).andReturn(verifiedJavaFXHome);
        expect(javaFxHome.reference(verifiedJavaFXHome)).andReturn(javaFXHomeDir);
        expect(javaFxcFactory.createJavaFxc(javaFXHomeDir, AUTOMATIC)).andReturn(javaFxc);
        javaFxcSetup.setUpJavaFxc(javaFxc, javaFxcMojo, javaFXHomeDir, AUTOMATIC);
        expectLastCall().once();
        javaFxcExecutor.execute(javaFxc);
        expectLastCall().once();
      }

      @Override protected void codeToTest() throws MojoExecutionException {
        javaFxcMojo.compile();
      }
    }.run();
  }
}
