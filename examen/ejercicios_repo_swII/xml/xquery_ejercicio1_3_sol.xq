<authors>{
  for $x in distinct-values(doc("xquery_ejercicio1.xml")/bib/book/author)
  return <author>
    <name>{$x}</name>
    <count>{count(doc("xquery_ejercicio1.xml")/bib/book[author=$x])}</count>
  </author>
}</authors>