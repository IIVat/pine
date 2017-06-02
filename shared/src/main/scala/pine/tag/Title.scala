package pine.tag

import pine._

/**
 * The <em>HTML Title Element</em> (<strong>&lt;title&gt;</strong>) defines the title of the document, shown in a browser's title bar or on the page's tab. It can only contain text and any contained tags are not interpreted.
 */
case class Title(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Title
  override def tagName = "title"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Title = Title(attributes, children)
}