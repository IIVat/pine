package pl.metastack.metaweb

import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import pl.metastack.metaweb.diff._

trait Js[T <: tree.Tag] { type X <: dom.html.Element }

trait DiffSupportLowPrio {
  implicit object JsTag extends Js[tree.Tag] { override type X = dom.html.Element }
}

object Js extends DiffSupportLowPrio {
  implicit object JsA extends Js[tag.A] { override type X = dom.html.Anchor }
  implicit object JsB extends Js[tag.B] { override type X = dom.html.Span }
  implicit object JsApplet extends Js[tag.Applet] { override type X = dom.html.Applet }
  implicit object JsArea extends Js[tag.Area] { override type X = dom.html.Area }
  implicit object JsAudio extends Js[tag.Audio] { override type X = dom.html.Audio }
  implicit object JsBR extends Js[tag.Br] { override type X = dom.html.BR }
  implicit object JsBase extends Js[tag.Base] { override type X = dom.html.Base }
  implicit object JsBaseFont extends Js[tag.Basefont] { override type X = dom.html.BaseFont }
  implicit object JsBody extends Js[tag.Body] { override type X = dom.html.Body }
  implicit object JsButton extends Js[tag.Button] { override type X = dom.html.Button }
  implicit object JsCanvas extends Js[tag.Canvas] { override type X = dom.html.Canvas }
  // implicit object JsCollection extends Js[tag.Col] { override type X = dom.html.Collection }
  implicit object JsDD extends Js[tag.Dd] { override type X = dom.html.DD }
  implicit object JsDList extends Js[tag.Dl] { override type X = dom.html.DList }
  implicit object JsDT extends Js[tag.Dt] { override type X = dom.html.DT }
  implicit object JsDataList extends Js[tag.Datalist] { override type X = dom.html.DataList }
  implicit object JsDirectory extends Js[tag.Dir] { override type X = dom.html.Directory }
  implicit object JsDiv extends Js[tag.Div] { override type X = dom.html.Div }
  implicit object JsElement extends Js[tag.HTMLTag] { override type X = dom.html.Element }
  implicit object JsEmbed extends Js[tag.Embed] { override type X = dom.html.Embed }
  implicit object JsFieldSet extends Js[tag.Fieldset] { override type X = dom.html.FieldSet }
  implicit object JsForm extends Js[tag.Form] { override type X = dom.html.Form }
  implicit object JsFrame extends Js[tag.Frame] { override type X = dom.html.Frame }
  implicit object JsFrameSet extends Js[tag.Frameset] { override type X = dom.html.FrameSet }
  implicit object JsH1 extends Js[tag.H1] { override type X = dom.html.Heading }
  implicit object JsH2 extends Js[tag.H2] { override type X = dom.html.Heading }
  implicit object JsH3 extends Js[tag.H3] { override type X = dom.html.Heading }
  implicit object JsH4 extends Js[tag.H4] { override type X = dom.html.Heading }
  implicit object JsH5 extends Js[tag.H5] { override type X = dom.html.Heading }
  implicit object JsH6 extends Js[tag.H6] { override type X = dom.html.Heading }
  implicit object JsHR extends Js[tag.Hr] { override type X = dom.html.HR }
  implicit object JsHead extends Js[tag.Head] { override type X = dom.html.Head }
  implicit object JsHtml extends Js[tag.Html] { override type X = dom.html.Html }
  implicit object JsI extends Js[tag.I] { override type X = dom.html.Span }
  implicit object JsIFrame extends Js[tag.Iframe] { override type X = dom.html.IFrame }
  implicit object JsImage extends Js[tag.Img] { override type X = dom.html.Image }
  implicit object JsInput extends Js[tag.Input] { override type X = dom.html.Input }
  implicit object JsIsIndex extends Js[tag.Isindex] { override type X = dom.html.IsIndex }
  implicit object JsLabel extends Js[tag.Label] { override type X = dom.html.Label }
  implicit object JsLegend extends Js[tag.Legend] { override type X = dom.html.Legend }
  implicit object JsLi extends Js[tag.Li] { override type X = dom.html.LI }
  implicit object JsLink extends Js[tag.Link] { override type X = dom.html.Link }
  implicit object JsMapJS extends Js[tag.Map] { override type X = dom.html.Map }
  implicit object JsMenu extends Js[tag.Menu] { override type X = dom.html.Menu }
  implicit object JsMeta extends Js[tag.Meta] { override type X = dom.html.Meta }
  implicit object JsOList extends Js[tag.Ol] { override type X = dom.html.OList }
  implicit object JsObject extends Js[tag.Object] { override type X = dom.html.Object }
  implicit object JsOptGroup extends Js[tag.Optgroup] { override type X = dom.html.OptGroup }
  implicit object JsOpt extends Js[tag.Option] { override type X = dom.html.Option }
  implicit object JsParagraph extends Js[tag.P] { override type X = dom.html.Paragraph }
  implicit object JsParam extends Js[tag.Param] { override type X = dom.html.Param }
  implicit object JsPre extends Js[tag.Pre] { override type X = dom.html.Pre }
  implicit object JsProgress extends Js[tag.Progress] { override type X = dom.html.Progress }
  implicit object JsScript extends Js[tag.Script] { override type X = dom.html.Script }
  implicit object JsSelect extends Js[tag.Select] { override type X = dom.html.Select }
  implicit object JsSource extends Js[tag.Source] { override type X = dom.html.Source }
  implicit object JsSpan extends Js[tag.Span] { override type X = dom.html.Span }
  implicit object JsStrong extends Js[tag.Strong] { override type X = dom.html.Span }
  implicit object JsStrike extends Js[tag.Strike] { override type X = dom.html.Span }
  implicit object JsStyle extends Js[tag.Style] { override type X = dom.html.Style }
  implicit object JsTable extends Js[tag.Table] { override type X = dom.html.Table }
  implicit object JsTableRow extends Js[tag.Tr] { override type X = dom.html.TableRow }
  implicit object JsTableDataCell extends Js[tag.Td] { override type X = dom.html.TableDataCell }
  implicit object JsTableHeadCell extends Js[tag.Th] { override type X = dom.html.TableHeaderCell }
  implicit object JsTextArea extends Js[tag.Textarea] { override type X = dom.html.TextArea }
  implicit object JsTitle extends Js[tag.Title] { override type X = dom.html.Title }
  implicit object JsTrack extends Js[tag.Track] { override type X = dom.html.Track }
  implicit object JsUl extends Js[tag.Ul] { override type X = dom.html.UList }
  implicit object JsVideo extends Js[tag.Video] { override type X = dom.html.Video }
}

trait DiffSupport {
  implicit class NodeRefExtensions[T <: tree.Tag](nodeRef: NodeRef[T]) {
    def onEnter(f: String => Diff)(implicit js: Js[T], ev: T <:< tag.Input): DomDiff =
      nodeRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(DOM.get(nodeRef).asInstanceOf[dom.html.Input].value)
        else Diff.Noop
      }

    def dragEnd(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondragend = _)
    def keyDown(implicit js: Js[T]): DomEvent[dom.KeyboardEvent] =
      new DomEvent(DOM.get(nodeRef).onkeydown = _)
    def dragOver(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondragover = _)
    def keyUp(implicit js: Js[T]): DomEvent[dom.KeyboardEvent] =
      new DomEvent(DOM.get(nodeRef).onkeyup = _)
    def reset(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onreset = _)
    def mouseUp(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onmouseup = _)
    def dragStart(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondragstart = _)
    def drag(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondrag = _)
    def mouseOver(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onmouseover = _)
    def dragLeave(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondragleave = _)
    def pause(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onpause = _)
    def mouseDown(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onmousedown = _)
    def seeked(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onseeked = _)
    def click(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onclick = _)
    def waiting(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onwaiting = _)
    def durationChange(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).ondurationchange = _)
    def blur(implicit js: Js[T]): DomEvent[dom.FocusEvent] =
      new DomEvent(DOM.get(nodeRef).onblur = _)
    def emptied(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onemptied = _)
    def seeking(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onseeking = _)
    def canPlay(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).oncanplay = _)
    def stalled(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onstalled = _)
    def mouseMove(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onmousemove = _)
    def rateChange(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onratechange = _)
    def loadStart(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onloadstart = _)
    def dragEnter(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondragenter = _)
    def submit(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onsubmit = _)
    // def progress(implicit js: Js[T]): DomEvent[scalajs.js.Any] =
    //   new DomEvent(DOM.get(nodeRef).onprogress = _)
    def dblClick(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).ondblclick = _)
    def contextMenu(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).oncontextmenu = _)
    def change(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onchange = _)
    def loadedMetadata(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onloadedmetadata = _)
    def play(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onplay = _)
    def playing(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onplaying = _)
    def canPlayThrough(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).oncanplaythrough = _)
    def abort(implicit js: Js[T]): DomEvent[dom.UIEvent] =
      new DomEvent(DOM.get(nodeRef).onabort = _)
    def readyStateChange(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onreadystatechange = _)
    def keyPress(implicit js: Js[T]): DomEvent[dom.KeyboardEvent] =
      new DomEvent(DOM.get(nodeRef).onkeypress = _)
    def loadedData(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onloadeddata = _)
    def suspend(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onsuspend = _)
    def focus(implicit js: Js[T]): DomEvent[dom.FocusEvent] =
      new DomEvent(DOM.get(nodeRef).onfocus = _)
    def timeUpdate(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).ontimeupdate = _)
    def select(implicit js: Js[T]): DomEvent[dom.UIEvent] =
      new DomEvent(DOM.get(nodeRef).onselect = _)
    def drop(implicit js: Js[T]): DomEvent[dom.DragEvent] =
      new DomEvent(DOM.get(nodeRef).ondrop = _)
    def mouseOut(implicit js: Js[T]): DomEvent[dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onmouseout = _)
    def ended(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onended = _)
    def scroll(implicit js: Js[T]): DomEvent[dom.UIEvent] =
      new DomEvent(DOM.get(nodeRef).onscroll = _)
    def mouseWheel(implicit js: Js[T]): DomEvent[dom.WheelEvent] =
      new DomEvent(DOM.get(nodeRef).onmousewheel = _)
    def volumeChange(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).onvolumechange = _)
    def input(implicit js: Js[T]): DomEvent[dom.Event] =
      new DomEvent(DOM.get(nodeRef).oninput = _)
  }
}
