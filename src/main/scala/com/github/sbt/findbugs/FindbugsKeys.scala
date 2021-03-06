/*
 * This file is part of sbt-findbugs
 *
 * Copyright (c) Joachim Hofer & contributors
 * All rights reserved.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.github.sbt.findbugs

import java.io.File

import com.github.sbt.findbugs.settings.FindbugsEffort.FindBugsEffort
import com.github.sbt.findbugs.settings.FindbugsPriority.FindBugsPriority
import com.github.sbt.findbugs.settings.FindbugsReport._
import sbt._

import scala.xml.Node

object FindbugsKeys extends FindbugsKeys

trait FindbugsKeys {
  val findbugs = taskKey[Unit]("Run FindBugs analysis")

  val findbugsReportPath = settingKey[Option[File]]("Output path for FindBugs reports")

  val findbugsAnalyzedPath = taskKey[Seq[File]]("The path to the classes to be analyzed")
  val findbugsAuxiliaryPath =
    taskKey[Seq[File]]("The path to the classes not to be analyzed but referenced by analyzed ones")

  val findbugsReportType = settingKey[Option[FindBugsReport]]("Type of report to create")
  val findbugsPriority = settingKey[FindBugsPriority]("Priority of bugs shown")
  val findbugsEffort = settingKey[FindBugsEffort]("Effort put into bug finding. ")
  val findbugsOnlyAnalyze = settingKey[Option[Seq[String]]]("Whitelist of packages/classes that should be analyzed")
  val findbugsMaxMemory = settingKey[Int]("Maximum memory to allocate to FindBugs (in MB)")
  val findbugsAnalyzeNestedArchives = settingKey[Boolean]("Whether FindBugs should analyze nested archives or not")

  val findbugsSortReportByClassNames =
    settingKey[Boolean]("Whether the reported bug instances should be sorted by class name or not")

  val findbugsIncludeFilters =
    settingKey[Option[Node]]("Filter file XML content defining which bug instances to include in the static analysis")

  val findbugsExcludeFilters =
    settingKey[Option[Node]]("Filter file XML content defining which bug instances to exclude in the static analysis.")

  // type aliases for auto import
  // scalastyle:off field.name
  val FindbugsEffort: settings.FindbugsEffort.type = settings.FindbugsEffort
  val FindbugsPriority: settings.FindbugsPriority.type = settings.FindbugsPriority
  val FindbugsReport: settings.FindbugsReport.type = settings.FindbugsReport
  // scalastyle:on
}
