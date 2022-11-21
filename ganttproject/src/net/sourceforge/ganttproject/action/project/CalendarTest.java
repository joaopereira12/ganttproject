/*
GanttProject is an opensource project management tool.
Copyright (C) 2005-2011 GanttProject Team

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
package net.sourceforge.ganttproject.action.project;

import net.sourceforge.ganttproject.GPLogger;
import net.sourceforge.ganttproject.IGanttProject;
import net.sourceforge.ganttproject.action.GPAction;
import net.sourceforge.ganttproject.gui.ProjectUIFacade;
import net.sourceforge.ganttproject.gui.UIUtil;

import java.awt.event.ActionEvent;

public class CalendarTest extends GPAction {
    private ProjectUIFacade myProjectUiFacade;
    private IGanttProject myProject;

    CalendarTest(IGanttProject project, ProjectUIFacade projectUiFacade) {
        super("project.calendar");
        myProject = project;
        myProjectUiFacade = projectUiFacade;
    }

    private CalendarTest(IGanttProject project, ProjectUIFacade projectUiFacade, IconSize iconSize) {
        super("project.calendar", iconSize.asString());
        myProject = project;
        myProjectUiFacade = projectUiFacade;
    }

    @Override
    public GPAction withIcon(IconSize iconSize) {
        return new CalendarTest(myProject, myProjectUiFacade, iconSize);
    }

    @Override
    protected String getIconFilePrefix() {
        return "open_";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (calledFromAppleScreenMenu(e)) {
            return;
        }
        try {
            myProjectUiFacade.openProject(myProject);
        } catch (Exception ex) {
            GPLogger.log(ex);
        }
    }

    public OpenProjectAction asToolbarAction() {
        OpenProjectAction result = new OpenProjectAction(myProject, myProjectUiFacade);
        result.setFontAwesomeLabel(UIUtil.getFontawesomeLabel(result));
        return result;
    }
}
