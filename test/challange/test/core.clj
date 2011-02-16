(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

;.;. FAIL at (NO_SOURCE_FILE:1)
;.;.     Expected: #{"" "AA" "ABA" "B"}
;.;.       Actual: #{"AA" "ABA" "B"}
(fact 
 (solve "AA" ["A"]) => #{"" "AA"}
 (solve "ABA" ["A" "B"]) => #{"" "AA" "B" "ABA"}
 (solve "AB" ["A" "X"]) => #{"B" "AB"})


