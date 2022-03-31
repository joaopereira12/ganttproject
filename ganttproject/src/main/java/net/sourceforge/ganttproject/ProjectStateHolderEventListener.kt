/*
Copyright 2022 BarD Software s.r.o., Anastasiia Postnikova

This file is part of GanttProject, an open-source project management tool.

GanttProject is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

GanttProject is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with GanttProject.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.sourceforge.ganttproject

import biz.ganttproject.app.Barrier
import biz.ganttproject.app.BarrierEntrance
import net.sourceforge.ganttproject.ProjectEventListener.Stub
import net.sourceforge.ganttproject.storage.ProjectStateStorage
import net.sourceforge.ganttproject.storage.ProjectStateStorageFactory

/**
 * Holds the current state of a Gantt project, updating it on events.
 *
 * @param storageFactory - factory for generating a project state storage.
 */
class ProjectStateHolderEventListener(private val storageFactory: ProjectStateStorageFactory) : Stub() {
  private var stateStorage: ProjectStateStorage? = null

  override fun projectOpened(barrierRegistry: BarrierEntrance?, barrier: Barrier<IGanttProject>?) {
    stateStorage = storageFactory.getStorage()
    // ...
  }

  override fun projectClosed() {
    // ...
    stateStorage?.shutdown()
  }
}