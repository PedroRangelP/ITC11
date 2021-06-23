(:~ XPath ~:)
(:~ 1. Retrieve the name of all the pubs in the Condesa Area ~:)
(:~ pubs/pub[area="Condesa"]/pname ~:)

(:~ 2. Retrieve the names of all beers sold at the Celtic’s pub ~:)
(:~ pubs/pub[pname="Celtic's"]/beer/bname ~:)

(:~ 3. Retrieve the names of all customers over 25 years of age ~:)
(:~ pubs/costumer[age>25]/cname ~:)

(:~ 4. Retrieve the name of all male customers over 25 years of age ~:)
(:~ pubs/costumer[gender="Male" and age>25]/cname ~:)

(:~ 5. Retrieve the prices of the Guinness beer at all pubs ~:)
(:~ //beer[bname="Guinness"]/@price ~:)


(:~ XQuery ~:)
(:~ 1. Retrieve the names of all blond beers sold at the Celtic’s pub ~:)
(:~ for $beer in pubs/pub[pname="Celtic's"]/beer
where $beer/color="Blond"
return $beer/bname ~:)

(:~ 2. Retrieve the names of all customers who frequent the Nada pub. ~:)
(:~ for $costumer in //costumer
let $pub := id($costumer/@frequents)
where $pub[pname="Nada"]
return $costumer/cname ~:)

(:~ 3. Retrieve the names of all customers who frequent pubs in the Polanco area. ~:)
(:~ for $costumer in //costumer
let $pub := id($costumer/@frequents)
where $pub[area="Polanco"]
return $costumer/cname ~:)

(:~ 4. Retrieve the areas where Irish beer is sold. ~:)
for $pub in //pub
where $pub/beer[country="Ireland"]
return $pub/area