# Tree construction
Unless otherwise stated, all code samples require a prior `import pine._`.

## DSL
Pine offers a DSL that allows to create trees in terms of immutable objects:

```scala
val a = tag.A
  .href("http://github.com/")
  .set(Text("GitHub"))

a.toHtml  // <a href="http://github.com/">GitHub</a>
```

The bindings are derived from the MDN documentation. For all attributes, we provide getters and setters. `set()` replaces the children of a node.

## Macros
Pine defines a couple of compile-time macros for increased comfort or performance.

### Inline HTML
Inline HTML can include placeholders referring to Scala values:

```scala
val url   = "http://github.com/"
val title = "GitHub"
val root  = html"""<a href=$url>$title</a>"""

root.toHtml  // <a href="http://github.com/">GitHub</a>
```

A placeholder may also reference `Seq[Node]` values:

```scala
val spans = Seq(
  html"<span>test</span>",
  html"<span>test2</span>"
)

val div = html"<div>$spans</div>"
div.toHtml  // <div><span>test</span><span>test2</span></div>
```

### External HTML
For loading external HTML files during compile-time, a constant file name must be passed:

```scala
val tpl = html("test.html")
tpl.toHtml  // <div>...</div>
```

## Runtime HTML parser
Pine provides an HTML parser backed by the DOM in JavaScript, but uses its own parser for other back ends.

```scala
val html = """<div id="a"><span>42</span></div>"""
val node = HtmlParser.fromString(html)
node.toHtml == html  // true
```

HTML code is parsed during compile-time and then translated to an immutable tree. This reduces any runtime overhead. HTML can be specified inline or loaded from external files.

The parser has the following limitations:

- The `DOCTYPE` tag is ignored
- The input is expected to be valid HTML5

The parser supports the complete set of more than 2100 HTML entities such as `&quot;` as well as numeric ones (`&#34;`). These entities can be decoded using the function `HtmlHelpers.decodeEntity`.

## XML
XML has slightly different semantics with regards to self-closing tags. The following example is valid XML, but would yield a parse error when parsed as HTML:

```xml
<item><link></link></item>
```

Also, the typical XML header `<?xml` is not valid HTML. In order to parse documents in the XML mode, use `XmlParser` or the `xml` string interpolator, respectively:

```scala
XmlParser.fromString("""<item><link></link></item>""")
```

```scala
xml"""
  <?xml version="1.0" encoding="UTF-8"?>
  <rss version="2.0"
    xmlns:atom="http://www.w3.org/2005/Atom"
    xmlns:dc="http://purl.org/dc/elements/1.1/">
    <channel>
      <atom:link type="application/rss+xml" />
    </channel>
  </rss>
"""
```

As per the XML specification, Pine supports only the following four entities:

* `&apos;` (`'`)
* `&lt;` (`<`)
* `&gt;` (`>`)
* `&amp;` (`&`)

The underlying data structures are the same for both HTML and XML trees. Pine strives for simplicity and performance at the cost of implementing only a subset of XML's features. Please refer to [scala-xml](https://github.com/scala/scala-xml) for a more complete implementation.

At the moment, we are aware of the following parser limitations:

- The XML header is optional and its attributes are ignored. The input is expected to be in UTF-8 regardless of the specified character set.
- [DTDs](https://docstore.mik.ua/orelly/web2/xhtml/ch15_03.htm) are not supported. Therefore, additional entity or element declarations cannot be defined.
- Processing instructions (other than `<?xml ... ?>`) are not supported
- CDATA tags are not supported (see issue #37)

## Conversion
Some functions return `Tag[_]` when the tag type cannot be statically determined. A more concrete type is useful if you want to access element-specific attributes, like `href` on anchor nodes. You can use `as` to convert a tag to its correct type:

```scala
val tag = html"<div></div>"
val div = tag.as[tag.Div]
```

Unlike `asInstanceOf`, this function ensures that the conversion is well-defined.

## Custom tags
So far, we have used elements from the `tag` namespace. For each HTML element, Pine defines a type and an empty instance, i.e. without attributes and children. If you want to support a new element such as `<custom-type>`, you could define it as follows:

```scala
type CustomType = "custom-type"
val  CustomType = Tag("CustomType")
```

The feature we use here is called a literal type which is provided by the Typelevel Scala compiler.

Additionally, you can define methods to access attributes conveniently:

```scala
implicit class TagAttributesCustomType(tag: Tag[CustomType]) {
  def myValue: Option[String] = tag.attr("my-value").map(_.toString)
  def myValue(value: String): Tag[CustomType] = tag.setAttr("my-value", value)
}
```

Now, you can access and modify your custom HTML element while preserving type-safety:

```scala
val tag = html"""<custom-type my-value="value"></custom-type>"""
val ct  = tag.as[CustomType]
ct.myValue                   // Some(value)
ct.myValue("value2").toHtml  // <custom-type my-value="value2"></custom-type>
```

Note that the type definition above is optional and you could also write the literal type directly:

```scala
val ct2 = tag.as["custom-type"]
```

## Rendering
A node defines two rendering methods:

- **HTML:** `toHtml` is defined on every node and will return the tree as an HTML5 string. If the root node is an `<html>` tag, the `DOCTYPE` will be included as well.
* **XML:** `toXml` returns the tree as an XML 1.0 string. It always includes the XML header, specifying the encoding as UTF-8.
- **DOM:** `toDom` is only available in JavaScript; it renders the tree as a browser node, which can be inserted into the DOM
