/*
 * Created on May 16, 2010
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

import org.apache.maven.artifact.handler.ArtifactHandler;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.tools.ant.taskdefs.Javac;
import org.fest.util.VisibleForTesting;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.fest.javafx.maven.JavaFxJarsInclusion.javaFxJarsInclusion;
import static org.fest.util.Strings.concat;
import static org.fest.util.Strings.quote;

/**
 * Understands the base class for the JavaFX compiler Mojos.
 *
 * @author Alex Ruiz
 * @author Johannes Schneider
 */
public abstract class AbstractJavaFxcMojo extends AbstractMojo {

  private final Overwrites overwriteUtilities = new Overwrites(getLog());

  /**
   * A list of exclusion filters for the compiler.
   * @parameter
   */
  @VisibleForTesting Set<String> overwrites = new HashSet<String>();

  /**
   * The current Maven project.
   * @parameter expression="${project}"
   * @readonly
   */
  @VisibleForTesting MavenProject project;

  /**
   * Set to <code>true</code> to include debugging information in the compiled class files.
   * @parameter expression="${javafx.compiler.debug}" default-value="true"
   */
  @VisibleForTesting boolean debug = true;

  /**
   * Sets whether to show source locations where deprecated APIs are used.
   * @parameter expression="${javafx.compiler.showDeprecation}" default-value="false"
   */
  @VisibleForTesting boolean deprecation;

  /**
   * The source files character encoding.
   * @parameter expression="${javafx.compiler.encoding}" default-value="UTF-8"
   */
  @VisibleForTesting String encoding;

  /**
   * Indicates whether the build will continue even if there are compilation errors; defaults to <code>true</code>.
   * @parameter expression="${javafx.compiler.failOnError}" default-value="true"
   */
  @VisibleForTesting boolean failOnError = true;

  /**
   * Allows running the compiler in a separate process. If <code>false</code> it uses the built in compiler, while if
   * <code>true</code> it will use an executable.
   * @parameter expression="${javafx.compiler.fork}" default-value="false"
   */
  @VisibleForTesting boolean fork;

  /**
   * Sets the executable of the compiler to use when fork is true.
   * @parameter expression="${javafx.compiler.executable}"
   */
  @VisibleForTesting String forkExecutable;

  /**
   * Set to <code>true</code> to optimize the compiled code using the compiler's optimization methods.
   * @parameter expression="${javafx.compiler.optimize}" default-value="false"
   */
  @VisibleForTesting boolean optimize;

  /**
   * If set to <code>true</code> the JavaFX jars are automatically added to the classpath for compilation
   * @parameter expression="${javafx.compiler.automatically.add.javafx.jars}" default-value="true"
   */
  @VisibleForTesting boolean automaticallyAddJfxJars = true;

  /**
   * The -source argument for the JavaFX compiler.
   * @parameter expression="${javafx.compiler.source}" default-value="1.6"
   */
  @VisibleForTesting String source;

  /**
   * The -target argument for the JavaFX compiler.
   * @parameter expression="${javafx.compiler.target}" default-value="1.6"
   */
  @VisibleForTesting String target;

  /**
   * Set to <code>true</code> to show messages about what the compiler is doing.
   * @parameter expression="${javafx.compiler.verbose}" default-value="false"
   */
  @VisibleForTesting boolean verbose;

  /**
   * Set to <code>true</code> to show compiler warnings related to unchecked operations ("-Xlint:unchecked").
   * @parameter expression="${javafx.compiler.unchecked}" default-value="true"
   */
  @VisibleForTesting boolean unchecked;

  /**
   * The maximum memory size.
   * @parameter expression="${javafx.compiler.memorymaximumsize}" default-value="256m"
   */
  @VisibleForTesting String memoryMaximumSize;

  /**
   * The location of the JavaFX home directory. If a value is not set, this goal will try to obtained from the
   * environment variable "JAVAFX_HOME".
   * @parameter expression="${javafx.home}"
   */
  @VisibleForTesting String javaFxHome;

  @VisibleForTesting JavaFxcMojoValidator validator = new JavaFxcMojoValidator();
  @VisibleForTesting JavaFxHome javaFxHomeRef = new JavaFxHome();
  @VisibleForTesting JavaFxcFactory javaFxcFactory = new JavaFxcFactory();
  @VisibleForTesting JavaFxcSetup javaFxcSetup = new JavaFxcSetup();
  @VisibleForTesting AntTaskExecutor javaFxcExecutor = new AntTaskExecutor();

  protected boolean isJavaProject() {
    if ( project == null ) return false;
    ArtifactHandler artifactHandler = project.getArtifact().getArtifactHandler();
    return "java".equals(artifactHandler.getLanguage());
  }

  void compile() throws MojoExecutionException {
    validator.validate(this);
    File javaFXHomeFolder = null;
    // TODO if the classpath problem is solved, add that condition
    // if (automaticallyAddFxJars) {
      String verifiedJavaFxHome = javaFxHomeRef.verify(javaFxHome);
      getLog().info(concat("JavaFX home is ", quote(verifiedJavaFxHome)));
      javaFXHomeFolder = javaFxHomeRef.reference(verifiedJavaFxHome);
    // }
    overwriteUtilities.deleteOverwrites(outputDirectory(), overwritesAsArray());
    JavaFxJarsInclusion javaFxJarsInclusion = javaFxJarsInclusion(automaticallyAddJfxJars);
    Javac javaFxc = javaFxcFactory.createJavaFxc(javaFXHomeFolder, javaFxJarsInclusion);
    javaFxcSetup.setUpJavaFxc(javaFxc, this, javaFXHomeFolder, javaFxJarsInclusion);
    javaFxcExecutor.execute(javaFxc);
  }

  private String[] overwritesAsArray() {
    return overwrites.toArray(new String[overwrites.size()]);
  }

  abstract List<String> classpathElements();
  abstract File outputDirectory();
  abstract File sourceDirectory();
}
