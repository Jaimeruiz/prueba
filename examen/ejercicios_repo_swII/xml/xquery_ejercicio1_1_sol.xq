for $book in doc("xquery_ejercicio1.xml")/bib/book
order by xs:decimal($book/price) descending
return $book/title