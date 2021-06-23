(:~ Xpath ~:)
(:~ /UNIVERSITY/STU[PROG="ISC" and CAMPUS="London"]/SNAME ~:)

(:~ XQuery ~:)
for $stu in //STU
let $cur := id($stu/GRADE/@CID)
where $cur[CNAME="Theory of computation"]
return $stu/SNAME