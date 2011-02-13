(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

;.;. Work is either fun or drudgery. It depends on your attitude. I like
;.;. fun. -- Barrett
(fact
 (solve "AA" ["A"]) => {:answer "" :by-way-of ["A"]}
 (solve "ABA" ["A" "B"]) => {:answer "" :by-way-of ["A" "B"]}
 (solve "AB" ["A" "X"]) => {:answer "B" :by-way-of ["A"]})


