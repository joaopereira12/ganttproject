/*
GanttProject is an opensource project management tool.
Copyright (C) 2005-2011 GanttProject team

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 3
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.sourceforge.ganttproject.gui;

import java.io.IOException;
import java.security.GeneralSecurityException;

import biz.ganttproject.core.option.GPOptionGroup;

import net.sourceforge.ganttproject.IGanttProject;
import net.sourceforge.ganttproject.document.Document;
import net.sourceforge.ganttproject.document.Document.DocumentException;
import net.sourceforge.ganttproject.task.Task;
import net.sourceforge.ganttproject.task.TaskManager;

public interface ProjectUIFacade {
  void saveProject(IGanttProject project);

  void saveProjectAs(IGanttProject project);

  void saveProjectToGDrive(IGanttProject project) throws IOException, GeneralSecurityException;

  void listEvents(IGanttProject project, TaskManager tasks);

  public boolean ensureProjectSaved(IGanttProject project);

  void openProject(IGanttProject project) throws IOException, DocumentException;

  void openProject(Document document, IGanttProject project) throws IOException, DocumentException;

  void createProject(IGanttProject project);

  GPOptionGroup[] getOptionGroups();
}
