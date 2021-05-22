package biz.ganttproject.app

import javafx.scene.control.Skin
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import javafx.scene.control.skin.TreeTableViewSkin

/**
 * @author dbarashev@bardsoftware.com
 */
class GPTreeTableView<T>(rootItem: TreeItem<T>) : TreeTableView<T>(rootItem) {
  init {
    columnResizePolicy = CONSTRAINED_RESIZE_POLICY;
    stylesheets.add("/biz/ganttproject/lib/fx/TreeTable.css")
    styleClass.add("gp-tree-table-view")
  }
  override fun createDefaultSkin(): Skin<*>? {
    return GPTreeTableViewSkin(this)
  }

  val headerHeight: Double
  get() = (skin as GPTreeTableViewSkin<T>).headerHeight
}

class GPTreeTableViewSkin<T>(control: GPTreeTableView<T>) : TreeTableViewSkin<T>(control) {
  val headerHeight: Double
  get() = tableHeaderRow.height
}